/**
 * This class is the subject interface
 */
public interface Subject {

  /**
   * Register the given observer to the subject's observer list
   * @param o the observer to be registered
   */
  public void registerObserver(Observer o);

  /**
   * Remove the given observer from the subject's observer list
   * @param o the observer to be removed
   */
  public void removeObserver(Observer o);

  /**
   * Notify all observers when the state of subject change
   */
  public void notifyObservers();
}
