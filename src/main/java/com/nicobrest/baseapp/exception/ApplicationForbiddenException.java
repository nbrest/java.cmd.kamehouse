package com.nicobrest.baseapp.exception;

/**
 *        ApplicationForbiddenException class.
 *
 * @author nbrest
 */
public class ApplicationForbiddenException extends ApplicationException {

  private static final long serialVersionUID = 9L;

  public ApplicationForbiddenException(String message) {
    super(message);
  }

  public ApplicationForbiddenException(String message, Exception cause) {
    super(message, cause);
  }
}
