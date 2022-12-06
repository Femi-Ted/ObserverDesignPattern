import java.util.ArrayList;
import java.util.List;

/**
 * This class represent the information of one course
 */
public class CourseInformation implements Subject {
  private List<Observer> observers;//used to hold observers
  private String professorName;
  private int assignmentNumber;
  private int weekNumber;

  /**
   * Construct the course information
   */
  public CourseInformation() {
    observers = new ArrayList<Observer>();
  }

  @Override
  public void registerObserver(Observer o) {
    observers.add(o);
  }

  @Override
  public void removeObserver(Observer o) {
    observers.remove(o);
  }

  @Override
  public void notifyObservers() {
    for (Observer observer : observers) {
      //all observers have update method
      observer.update(professorName, assignmentNumber, weekNumber);
    }
  }

  /**
   * notify observes when the information of the course change
   */
  public void informationChanged() {
    notifyObservers();
  }

  /**
   * change the information of the course
   * @param professorName the professor name of the course
   * @param assignmentNumber the assignment number of the course
   * @param weekNumber the week number of the course
   */
  public void setInformation(String professorName, int assignmentNumber, int weekNumber) {
    this.professorName = professorName;
    this.assignmentNumber = assignmentNumber;
    this.weekNumber = weekNumber;
    informationChanged();
  }

  /**
   * return the professor name of this course
   * @return the professor name of this course
   */
  public String getProfessorName() {
    return professorName;
  }

  /**
   * return the assignment number of this course
   * @return the assignment number of this course
   */
  public int getAssignmentNumber() {
    return assignmentNumber;
  }

  /**
   * return the week number of this course
   * @return the week number of this course
   */
  public int getWeekNumber() {
    return weekNumber;
  }
}
