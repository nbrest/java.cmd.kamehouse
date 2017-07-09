package com.nicobrest.baseapp.exception;

/**
 *        ApplicationBadRequestException class.
 *
 * @author nbrest
 */
public class ApplicationBadRequestException extends ApplicationException {

  private static final long serialVersionUID = 9L;

  public ApplicationBadRequestException(String message) {
    super(message);
  }

  public ApplicationBadRequestException(String message, Exception cause) {
    super(message, cause);
  }
}
