package com.nicobrest.baseapp.application;

import com.nicobrest.baseapp.manager.ApplicationManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Main app that starts the application. This class only loads the application
 * context and calls the ApplicationManager bean to run the rest of the
 * application.
 *
 * @author nbrest
 */
public class MainApp {

  private static final Logger LOGGER = LoggerFactory.getLogger(MainApp.class);

  /**
   * Starts the application.
   *
   * @author nbrest
   */
  public static void main(String[] args) {

    LOGGER.info(" *** Starting application ***");
    LOGGER.info("Working Directory: " + System.getProperty("user.dir"));
    LOGGER.info("The execution parameters are:");
    for (String arg : args) {
      LOGGER.info(arg);
    }

    System.out.println();
    ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

    LOGGER.info("Application context: Bean definitions:");
    for (String beanName : context.getBeanDefinitionNames()) {
      System.out.println("bean: " + beanName);
    }

    ApplicationManager applicationManager = (ApplicationManager) context
        .getBean("applicationManager");
    applicationManager.run();

    ((AbstractApplicationContext) context).close();

    LOGGER.info("The execution parameters are:");
    for (String arg : args) {
      LOGGER.info(arg);
    }
    LOGGER.info(" *** Closing application ***");
  }
}