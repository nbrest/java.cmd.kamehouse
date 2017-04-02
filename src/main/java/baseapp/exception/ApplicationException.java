package baseapp.exception;

/**
 *        ApplicationException base exceptions class.
 *
 * @author nbrest
 */
public class ApplicationException extends RuntimeException {

  private static final long serialVersionUID = 9L;

  public ApplicationException(String message) {
    super(message);
  }

  public ApplicationException(String message, Exception cause) {
    super(message, cause);
  }
}
