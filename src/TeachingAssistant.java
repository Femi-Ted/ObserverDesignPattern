/**
 * This class represent teaching assistants for the course
 */
public class TeachingAssistant implements Observer, DisplayElement{
  private String professorName;
  private int assignmentNumber;
  private int weekNumber;
  private CourseInformation courseInformation;

  /**
   * Construct Student C with the course that she/he enrolls
   * @param courseInformation the course that Student C enrolls
   */
  public TeachingAssistant(CourseInformation courseInformation) {
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
    System.out.println("Inform the teaching assistant of updates\n" +
        "professorName " + professorName + "\n" +
        "assignmentNumber " + assignmentNumber + "\n" +
        "weekNumber " + weekNumber + "\n");
  }
}
