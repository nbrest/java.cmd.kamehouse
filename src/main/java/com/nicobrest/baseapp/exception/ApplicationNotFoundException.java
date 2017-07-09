package com.nicobrest.baseapp.exception;

/**
 *        ApplicationNotFoundException class.
 *
 * @author nbrest
 */
public class ApplicationNotFoundException extends ApplicationException {

  private static final long serialVersionUID = 9L;

  public ApplicationNotFoundException(String message) {
    super(message);
  }

  public ApplicationNotFoundException(String message, Exception cause) {
    super(message, cause);
  }
}
