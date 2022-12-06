/**
 * This class represent the auditors who enrolls in the course
 */
public class Auditor implements Observer, DisplayElement{
  private String professorName;
  private int assignmentNumber;
  private int weekNumber;
  private CourseInformation courseInformation;

  /**
   * Construct Student B with the course that she/he enrolls
   * @param courseInformation the course that Student B enrolls
   */
  public Auditor(CourseInformation courseInformation) {
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
    System.out.println("Inform the auditor of updates\n" +
        "professorName " + professorName + "\n" +
        "assignmentNumber " + assignmentNumber + "\n" +
        "weekNumber " + weekNumber + "\n");
  }
}