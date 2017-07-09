package com.nicobrest.baseapp.exception;

/**
 *        ApplicationServerErrorException class.
 *
 * @author nbrest
 */
public class ApplicationServerErrorException extends ApplicationException {

  private static final long serialVersionUID = 9L;

  public ApplicationServerErrorException(String message) {
    super(message);
  }

  public ApplicationServerErrorException(String message, Exception cause) {
    super(message, cause);
  }
}
