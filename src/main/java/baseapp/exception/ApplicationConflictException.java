package baseapp.exception;

/**
 *        ApplicationConflictException class.
 *
 * @author nbrest
 */
public class ApplicationConflictException extends ApplicationException {

  private static final long serialVersionUID = 9L;

  public ApplicationConflictException(String message) {
    super(message);
  }

  public ApplicationConflictException(String message, Exception cause) {
    super(message, cause);
  }
}
