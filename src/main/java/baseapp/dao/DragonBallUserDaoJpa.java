package baseapp.dao;

import baseapp.exception.ApplicationConflictException;
import baseapp.exception.ApplicationNotFoundException;
import baseapp.exception.ApplicationServerErrorException;
import baseapp.model.DragonBallUser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 * JPA DAO for the DragonBallUser test entities.
 *
 * @author nbrest
 */
public class DragonBallUserDaoJpa implements DragonBallUserDao {

  private static final Logger LOGGER = LoggerFactory.getLogger(DragonBallUserDaoJpa.class);

  @Autowired
  private EntityManagerFactory entityManagerFactory;

  /**
   * Getters and Setters.
   *
   * @author nbrest
   */
  public EntityManagerFactory getEntityManagerFactory() {

    return entityManagerFactory;
  }

  /**
   * Getters and Setters.
   *
   * @author nbrest
   */
  public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {

    this.entityManagerFactory = entityManagerFactory;
  }

  /**
   * Get the EntityManager.
   *
   * @author nbrest
   */
  public EntityManager getEntityManager() {

    return entityManagerFactory.createEntityManager();
  }

  /**
   * Inserts a DragonBallUser to the repository.
   *
   * @author nbrest
   */
  public Long createDragonBallUser(DragonBallUser dragonBallUser) {
    EntityManager em = getEntityManager();
    try {
      em.getTransaction().begin();
      em.persist(dragonBallUser);
      em.getTransaction().commit();
      em.close();
    } catch (PersistenceException pe) {
      pe.printStackTrace();
      // Iterate through the causes of the PersistenceException to identify and return
      // the correct exception.
      Throwable cause = pe;
      while (cause != null) {
        if (cause instanceof org.hibernate.exception.ConstraintViolationException) {
          throw new ApplicationConflictException(
              "ConstraintViolationException: Error inserting data", pe);
        }
        cause = cause.getCause();
      }
      throw new ApplicationServerErrorException(
          "PersistenceException in createDragonBallUser", pe);
    }
    return dragonBallUser.getId();
  }

  /**
   * Gets a DragonBallUser from the repository.
   *
   * @author nbrest
   */
  public DragonBallUser getDragonBallUser(String username) {

    EntityManager em = getEntityManager();
    DragonBallUser dragonBallUser = null;
    try {
      em.getTransaction().begin();
      Query query = em
          .createQuery("SELECT dbu from DragonBallUser dbu where dbu.username=:pUsername");
      query.setParameter("pUsername", username);
      dragonBallUser = (DragonBallUser) query.getSingleResult();
      em.getTransaction().commit();
      em.close();
    } catch (PersistenceException pe) {
      pe.printStackTrace();
      // Iterate through the causes of the PersistenceException to identify and return
      // the correct exception.
      Throwable cause = pe;
      while (cause != null) {
        if (cause instanceof javax.persistence.NoResultException) {
          throw new ApplicationNotFoundException(
              "DragonBallUser with username " + username
                  + " was not found in the repository.");
        }
        cause = cause.getCause();
      }
      throw new ApplicationServerErrorException(
          "PersistenceException in getDragonBallUser", pe);
    }
    return dragonBallUser;
  }

  /**
   * Updates a DragonBallUser on the repository.
   *
   * @author nbrest
   */
  public void updateDragonBallUser(DragonBallUser dragonBallUser) {

    LOGGER.info("Updating dragonBallUser: " + dragonBallUser);
    EntityManager em = getEntityManager();
    try {
      em.getTransaction().begin();
      DragonBallUser updatedDbUser = em.find(DragonBallUser.class,
          dragonBallUser.getId());
      if (updatedDbUser != null) {
        updatedDbUser.setAge(dragonBallUser.getAge());
        updatedDbUser.setEmail(dragonBallUser.getEmail());
        updatedDbUser.setPowerLevel(dragonBallUser.getPowerLevel());
        updatedDbUser.setStamina(dragonBallUser.getStamina());
        updatedDbUser.setUsername(dragonBallUser.getUsername());
        updatedDbUser.setPowers(dragonBallUser.getPowers());
      }
      em.getTransaction().commit();
      em.close();
      if (updatedDbUser == null) {
        throw new ApplicationNotFoundException("DragonBallUser with id "
            + dragonBallUser.getId() + " was not found in the repository.");
      }
    } catch (PersistenceException pe) {
      pe.printStackTrace();
      // Iterate through the causes of the PersistenceException to identify and return
      // the correct exception.
      Throwable cause = pe;
      while (cause != null) {
        if (cause instanceof org.hibernate.exception.ConstraintViolationException) {
          throw new ApplicationConflictException(
              "ConstraintViolationException: Error updating data", pe);
        }
        cause = cause.getCause();
      }
      throw new ApplicationServerErrorException(
          "PersistenceException in updateDragonBallUser", pe);
    }
  }

  /**
   * Deletes a DragonBallUser from the repository.
   *
   * @author nbrest
   * @return DragonBallUser
   */
  public DragonBallUser deleteDragonBallUser(Long id) {

    // find(): returns the entity from the EntityManager if its already in
    // memory. Otherwise it goes
    // to the database to find it.
    // getReference(): Returns a proxy to the real entity. Useful if you need to
    // access the primary
    // key used to look up the entity but not the other data of the object.

    EntityManager em = getEntityManager();
    DragonBallUser dbUserToRemove = null;
    try {
      em.getTransaction().begin();
      dbUserToRemove = em.find(DragonBallUser.class, id);
      if (dbUserToRemove != null) {
        em.remove(dbUserToRemove);
      }
      em.getTransaction().commit();
      em.close();
      if (dbUserToRemove == null) {
        throw new ApplicationNotFoundException("DragonBallUser with id "
            + id + " was not found in the repository.");
      }
    } catch (PersistenceException pe) {
      pe.printStackTrace();
      throw new ApplicationServerErrorException(
          "PersistenceException in deleteDragonBallUser", pe);
    }
    return dbUserToRemove;
  }

  /**
   * Gets all the DragonBallUsers from the repository.
   *
   * @author nbrest
   */
  public List<DragonBallUser> getAllDragonBallUsers() {

    EntityManager em = getEntityManager();
    List<DragonBallUser> dragonBallUsers = null;
    try {
      em.getTransaction().begin();
      dragonBallUsers = em.createQuery("from DragonBallUser",
          DragonBallUser.class).getResultList();
      em.getTransaction().commit();
      em.close();
    } catch (PersistenceException pe) {
      pe.printStackTrace();
      throw new ApplicationServerErrorException(
          "PersistenceException in getAllDragonBallUsers", pe);
    }
    return dragonBallUsers;
  }
}
