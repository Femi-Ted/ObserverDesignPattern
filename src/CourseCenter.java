/**
 * This is the driver class which represents the course center
 */
public class CourseCenter {
  public static void main(String[] args) {
    CourseInformation courseInformation = new CourseInformation();

    GeneralStudent generalStudent = new GeneralStudent(courseInformation);
    Auditor auditor = new Auditor(courseInformation);
    TeachingAssistant teachingAssistant = new TeachingAssistant(courseInformation);

    System.out.println("First Change!");
    courseInformation.setInformation("Joy", 8, 11);
    System.out.println("Second Change!");
    courseInformation.setInformation("Tom", 7, 12);

    System.out.println("Pay Attention! The auditor will be removed!\n");
    courseInformation.removeObserver(auditor);

    System.out.println("Third Change!");
    courseInformation.setInformation("Jim", 9, 5);
  }
}



