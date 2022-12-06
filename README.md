# Observer Design Pattern

Introduction: Courses and Students at Northeastern University.

As ALIGN graduate students at Northeastern University, I am sure we are all familiar with the Canvas Dashboard - our Learning Management System’s Dashboard.  The Canvas Dashboard is the frontend access that connects us to all the courses we register to during any given semester.




# Course Example:
To show how Observer Pattern works, we use the course example.
The problem is that there are different kinds of students enrolled in one course. What we want is that when the information of the course changes, all students enrolled should be informed automatically.

# Design Diagram
Here is our design diagram.
 
There are many ways to implement the Observer pattern but most of them include Subject and Observer interface. So here we also use these two interfaces. 

# DisplayElement interface
In addition, we use the DisplayElement interface to make sure that every time students get updated course information, the message will be shown.
public interface DisplayElement {
  public void display();
}

# Subject Interface
In the Subject interface, there are three main methods to manage its observers, which are registerObserver, removeObserber, notifyObservers. 
public interface Subject {
  public void registerObserver(Observer o);
  public void removeObserver(Observer o);
  public void notifyObservers();
}

# CourseInformation Class
The class that implements the Subject class is CourseInformation. In this class, we have three fields related to the course, which are professor name, assignment number and week number. 
public class CourseInformation implements Subject {
  private List<Observer> observers;//used to hold observers
  private String professorName;
  private int assignmentNumber;
  private int weekNumber;
 }

In addition, there is a list to hold observers. Except for those three override methods, there are 5 methods. 
The connection between some of them is that we use setInformation method to change information of course, and then the informationChanged method will be called, then the notifyObservers method will be called. In the notifyObservers method, we us¬¬e the update method to pass updated information of course to all its observers.
  public void registerObserver(Observer o) {
    observers.add(o);
  }
  public void removeObserver(Observer o) {
    observers.remove(o);
  }
  public void notifyObservers() {
    for (Observer observer : observers) {
      observer.update(professorName, assignmentNumber, weekNumber);
    }
  }
  public void informationChanged() {
    notifyObservers();
  }
  public void setInformation(String professorName, int assignmentNumber, int weekNumber) {
    this.professorName = professorName;
    this.assignmentNumber = assignmentNumber;
    this.weekNumber = weekNumber;
    informationChanged();
  }

# Observer Interface
Then we talk about Observer interface, there is only one method in this interface, and every class that implements this interface must implement this method. So, every observer class will have this method. As we mentioned before, this method is used to pass updated information of course to observers.
public interface Observer {
  public void update(String professorName, int assignmentNumber, int weekNumber);
}


Now let us go ahead with three concrete classes that implement the Observer interface, which represent three different kinds of students, general students, auditors and teaching assistants.
To make this example as simple as possible, so that the Observer pattern can be understood by audiences easily, the content of these three classes is the same. So, we only explain one of them.
 
# GeneralStudent Class
We choose the GeneralStudent class as the example. In this class, we have three fields related to the course, the professor name, the assignment number and the week number. In addition, we also include the courseInformation as one field, it is because that it may be used by this class, such as removing observers. 
public class GeneralStudent implements Observer, DisplayElement{
  private String professorName;
  private int assignmentNumber;
  private int weekNumber;
  private CourseInformation courseInformation;
 }

Here we only have two simple methods in this class. One of them is updated, which is used to update its field. At the end of this method, we call display method, so we can know immediately that the student is notified when the course information change.
public void update(String professorName, int assignmentNumber, int weekNumber) {
    this.professorName = professorName;
    this.assignmentNumber = assignmentNumber;
    this.weekNumber = weekNumber;
    display();
  }
 public void display() {
    System.out.println("Inform the general student of updates\n" +
        "professorName " + professorName + "\n" +
        "assignmentNumber " + assignmentNumber + "\n" +
        "weekNumber " + weekNumber + "\n");
  }
 
# CourseCenter Class
Finally, we have the CourseCenter class, which is the driver class. In this class, we create an object of CourseInformation class, named courseInformation.
We also create three different kinds of student objects, named general student, auditor, and teaching assistant. Then we change the course information twice to see what will happen. Then we remove auditors from the observer list and change the course information again to see what will happen.
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

So now we solve the problem. Thanks to the Observer Pattern.
