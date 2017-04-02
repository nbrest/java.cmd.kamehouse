package baseapp.manager;

import baseapp.model.DragonBallUser;
import baseapp.service.DragonBallUserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * DragonBallUserServiceManager that contains the first layer of autowired beans
 * (usually the service layer) and executes the methods on those beans.
 *
 * @author nbrest
 */
public class DragonBallUserServiceManager implements Runnable {

  private static final Logger LOGGER = LoggerFactory.getLogger(DragonBallUserServiceManager.class);

  @Autowired
  private DragonBallUserService dragonBallUserService;

  /**
   * Getters and Setters.
   *
   * @author nbrest
   */
  public void setDragonBallUserService(DragonBallUserService dragonBallUserService) {
    this.dragonBallUserService = dragonBallUserService;
  }

  /**
   * Getters and Setters.
   *
   * @author nbrest
   */
  public DragonBallUserService getDragonBallUserService() {
    return dragonBallUserService;
  }

  /**
   * Main method that tests the autowired beans.
   *
   * @author nbrest
   */
  public void run() {
    LOGGER.info("Starting DragonBallUserServiceManager");
    // TODO: Add methods to load data into the database by reading it both from
    // xml and json files

    executeGetAllDragonBallUsers();
    executeCreateDragonBallUsers();
    executeGetAllDragonBallUsers();
    executeUpdateDragonBallUsers();
    executeGetAllDragonBallUsers();
  }

  /**
   * Executes getAllDragonBallUsers.
   *
   * @author nbrest
   */
  private void executeGetAllDragonBallUsers() {
    LOGGER.info("executeGetAllDragonBallUsers");
    List<DragonBallUser> dragonBallUsers = dragonBallUserService.getAllDragonBallUsers();

    LOGGER.info("getAllDragonBallUsers(): " + dragonBallUsers);
    LOGGER.info("getAllDragonBallUsers.size(): " + dragonBallUsers.size());
  }

  /**
   * Executes createDragonBallUser.
   *
   * @author nbrest
   */
  private void executeCreateDragonBallUsers() {
    LOGGER.info("executeCreateDragonBallUsers");

    Map<String, String> powers = new HashMap<String, String>();
    powers.put("kamehameha", "best attack ever");
    powers.put("kaioken", null);
    powers.put("genkidama", "goku genkidama");
    DragonBallUser dragonBallUser = new DragonBallUser(null, "goku", "goku@dbz.com", 10, 10, 10,
        powers);
    dragonBallUserService.createDragonBallUser(dragonBallUser);

    powers.clear();
    powers.put("masenko", "masenko description");
    powers.put("kamehameha", "gohan kamehameha");
    dragonBallUser = new DragonBallUser(null, "gohan", "gohan@dbz.com", 20, 20, 20, powers);
    dragonBallUserService.createDragonBallUser(dragonBallUser);

    powers.clear();
    powers.put("kamehameha", "goten kamehameha");
    powers.put("fusion", "goten fusion");
    dragonBallUser = new DragonBallUser(null, "goten", "goten@dbz.com", 30, 30, 30, powers);
    dragonBallUserService.createDragonBallUser(dragonBallUser);
  }

  private void executeUpdateDragonBallUsers() {
    LOGGER.info("executeUpdateDragonBallUsers");

    Map<String, String> powers = new HashMap<String, String>();
    // set a field that contained a value to null value
    powers.put("kamehameha", null);
    // replaced a field that had null value with a value
    powers.put("kaioken", "kaioken goku REPLACED NULL WITH VALUE!");
    // updated a field that had a value with a different value
    powers.put("genkidama", "goku genkidama UPDATED FIELD THAT ALREADY HAD A VALUE!");
    // added a new field with null value
    powers.put("teleport", null);
    DragonBallUser dragonBallUser = dragonBallUserService.getDragonBallUser("goku");
    dragonBallUser.setPowers(powers);
    dragonBallUserService.updateDragonBallUser(dragonBallUser);
  }
}