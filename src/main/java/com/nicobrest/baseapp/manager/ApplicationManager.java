package com.nicobrest.baseapp.manager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Application manager that contains the different managers for all the
 * services.
 *
 * @author nbrest
 */
public class ApplicationManager implements Runnable {

  private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationManager.class);

  @Autowired
  private DragonBallUserServiceManager dragonBallUserServiceManager;

  /**
   * Getters and Setters.
   *
   * @author nbrest
   */
  public void setDragonBallUserServiceManager(
      DragonBallUserServiceManager dragonBallUserServiceManager) {
    this.dragonBallUserServiceManager = dragonBallUserServiceManager;
  }

  /**
   * Getters and Setters.
   *
   * @author nbrest
   */
  public DragonBallUserServiceManager getDragonBallUserServiceManager() {
    return dragonBallUserServiceManager;
  }

  /**
   * Main method that runs the different managers.
   *
   * @author nbrest
   */
  public void run() {
    LOGGER.info("Starting ApplicationManager");
    dragonBallUserServiceManager.run();
  }
}