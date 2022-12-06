/**
 * This class is the observer interface
 */
public interface Observer {

  /**
   * Being call when the information of course changes
   * @param professorName the professor name of the course
   * @param assignmentNumber the assignment number of the course
   * @param weekNumber the week number of the course
   */
  public void update(String professorName, int assignmentNumber, int weekNumber);
}


