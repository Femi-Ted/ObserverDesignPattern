/**
 * This class represent general students who enroll in the course
 */
public class GeneralStudent implements Observer, DisplayElement{
  private String professorName;
  private int assignmentNumber;
  private int weekNumber;
  private CourseInformation courseInformation;

  /**
   * Construct Student A with the course that she/he enrolls
   * @param courseInformation the course that Student A enrolls
   */
  public GeneralStudent(CourseInformation courseInformation) {
    this.courseInformation = courseInformation;
    courseInformation.registerObserver(this);
  }

  @Override
  public void update(String professorName, int assignmentNumber, int weekNumber) {
    this.professorName = professorName;
    this.assignmentNumber = assignmentNumber;
    this.weekNumber = weekNumber;
    display();
  }

  @Override
  public void display() {
    System.out.println("Inform the general student of updates\n" +
        "professorName " + professorName + "\n" +
        "assignmentNumber " + assignmentNumber + "\n" +
        "weekNumber " + weekNumber + "\n");
  }
}



