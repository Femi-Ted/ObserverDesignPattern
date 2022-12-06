# Observer Design Pattern

#Introduction: the Observer Design Pattern, Courses, and Students at Northeastern University.#
As ALIGN graduate students at Northeastern University, I am sure we are all familiar with the Canvas Dashboard - our Learning Management System’s Dashboard.  

The Canvas Dashboard is the frontend access that connects us to the courses we subscribe to during any given semester; and although we are expected to register for at least one course or at most three courses per semester, we most likely don’t stay conscious that there are at least “318 undergraduate majors, 444 graduate programs, and 36 PhD disciplines” [2] most likely also being managed through Canvas, and likely subscribed to by over 27,000 students located at the different global campuses of the university.

So, the question begs… How do we get information only about the courses we register for and not bombarded by irrelevant notifications outside our choice of courses or program?  

![Screenshot 2022-12-06 at 08 01 28](https://user-images.githubusercontent.com/46625599/205961668-34c43970-ae61-4c50-8de7-2e7cd9e8df9f.png)

#Jordan, Yuki, Courses, and the Observer Design Pattern on Canvas.
For example, Jordan is registered for CS5004 and CS5800 this semester, while Yuki is registered for CS5004 and CS5008. But Jordan does not have access to CS5008 contents, neither does Yuki have access to CS5800 contents.  And I am sure neither of them get course related notifications on these courses.  

Why? Because Canvas only updates students with their course specific information.  So, if we are to check Jordan and Yuki’s respective Canvas Dashboards, we are sure that we will only see information relevant to the courses they have each subscribed to.  On one part, there would exist  general information shared by both students on the same course, for example:
•	General course information in the form of course syllabus, Instructor information etc.
•	Course contents in the form of modules, assignments, labs, projects
•	And more.
However, there are also those information which are peculiar to each student based on their respective interactions with their courses on Canvas. For example: Task grades and grade point average updates.

![Screenshot 2022-12-06 at 08 05 56](https://user-images.githubusercontent.com/46625599/205962512-abcc104f-a171-4bcb-981e-06ed2d542936.png)


#Information Dissemination in Software Design.
What I just described is not peculiar to Jordan and Yuki alone as over 27,000 students in Northeastern University depends on receiving general and specific information updates from Canvas based on their interactions with their respective campuses, programs of study, and courses.

The way these information are disseminated to each student while ensuring that they each receive only those updates relevant to them is what makes the Observer Design Pattern invaluable in object-oriented design and programming.


#The Observer Design Pattern: Subjects and Observers.
In Object-Oriented Design, the Observer Design Pattern is a behavioral design pattern that “defines a one-to-many dependency between objects so that when one object changes state, all of its dependents are notified and updated automatically” [3].  From our example of how Course updates are managed on Canvas, and from this definition, we can agree that our objects whose state we expect to change and being watched are the very courses we subscribe to, while Jordan and Yuki – the entire student body, instructors, and even application processes, - are the dependents.

![Screenshot 2022-12-06 at 08 12 51](https://user-images.githubusercontent.com/46625599/205964117-cc7dfa22-becf-4eaf-9dc0-40914698d05b.png)

#Notable Applications of the Observer Design Pattern.
So, where else would we find Observer Design Pattern implementations?  They are prominent on social media platforms and manifests as status or activity updates on those we follow. The same applies when we subscribe to video contents on video sharing or video-on-demand platforms.  In fact, even when we download apps, the updates and notifications you receive are managed using the Observer Design Pattern!  

Interestingly, the Observer Design Pattern is also central to Java.


#Java Implementation of the Observer Design Pattern.
Until Java 9, it used to be implemented through the Observer and Observable Interfaces, while still prominent in all GUI implementations in the MVC Design Pattern… specifically, in the java.util.EventListener in Swing, where button clicks activates listeners to perform certain actions dependent on the update received from the Model [6].  Other implementations of the observer pattern in core Java are listed.

#The Observer Design Pattern and Information Dissemination
Now, let’s explore the many ways we can implement the Observer Pattern by leveraging on the many relationships we can establish between the Subject and the Observer or Observers.  For this presentation, we will be borrowing terms from network communications, so we can explain the level of dependency that can exist between the Subject and the Observer or Observers. 
1.	A unicast – where one Subject and One Observer relationship or dependency exist and information moves from that one subject to only one recipient or observer [1], either as a push or pull implementation. 

An example of this type of implementation is the usual update of grade on assessed coursework submitted.  This can also be observed with the feature that allows us to re-compute GPA by editing each or all course task fields.

It is important that even when only one Subject and one Observer are involved in unicast, that their dependency remain loosely coupled, else the implementation would no longer conform to the design requirements of the Observer Pattern.

![Screenshot 2022-12-06 at 08 16 57](https://user-images.githubusercontent.com/46625599/205965103-f89109b5-ca99-4aca-bc76-58691e893c76.png)

2.	A Multicast – a One-to-Many relationship or dependency where information or update flows from one source to all recipients who show interest in receiving the update. [1].  This also can be a pull or push implementation, but the show of interest in receiving updates must still be handled through subscription.

If we go back to our Canvas example, an implementation of a multicast would be when an Announcement for CS5004 is made. This announcement is only accessible to students enrolled to CS5004.

![Screenshot 2022-12-06 at 08 18 05](https://user-images.githubusercontent.com/46625599/205965321-7dd19e41-001b-4f4d-928a-20a0039f394d.png)

So, who calls for an update? In Observer Design Pattern, there are two different ways which the Observer can become aware of a change of state in the Subject.  They are: 

By Pull implementation - a situation where the Observer plays a more active role by directly pulling data from the Subject once the Subject announces the availability of new updates.  Unfortunately, this implementation is ineffective in large deployments as it involves two steps—the first step being where the Subject notifies the Observer of new updates, and the second step where the Observer pulls the required data from the Subject.

By push implementation – where the Subject plays a dominant role and automatically pushes updates to the Observer once they are available.  Unfortunately, in this implementation, the Subject can send detailed information to the Observer (even though it may not be needed). This can result in sluggish response times when a large amount of data is sent by the Subject but is never actually used by the Observer.  The only way to prevent this is to ensure that only the required data is sent from the Subject to the Observer at managed intervals.


#The SOLID principles and The Observer Design Pattern
![Screenshot 2022-12-06 at 08 19 24](https://user-images.githubusercontent.com/46625599/205965749-4acd41cd-8574-4dcf-ac76-3342e74481867.png)

Yes, of the five SOLID principles, the Observer Design Pattern checks to conform with most prominently with three, and they are:
•	The single Responsibility Principle: since the Subject and the Observer if implemented to standard would do only one thing.
•	The Open-Close Principle: this is the most obvious of the SOLID principles adhered to because once code for the observer is written, we do not need to change it for additional observers to implement it and the observer does not need to know the implementations of the Subject, and 
•	Dependency Inversion Principle: the Observer Design Pattern follows this principle since our classes depends on interfaces or abstract classes instead of concreate classes and methods.


#What The Observer Design Pattern is Not!
![Screenshot 2022-12-06 at 08 21 05](https://user-images.githubusercontent.com/46625599/205966009-fe33b749-837f-4014-a096-0d36b0794c22.png)

We’ve reviewed what the Observer Pattern is in operation.  But what is the Observer Pattern not?  Although we mentioned that the Subject broadcasts to all registered Observer, please note that the Observer Pattern is not a true broadcast implementation in that all Observers can only access information or updates from the Subject only when they are on its list of registered or subscribed observers.   This is much different from a true broadcast that does not require a subscription model for update dissemination.

Finally, any update dissemination implementation that does not incorporate loose coupling between Subject and Observer, while Subject maintains a list of its dependent cannot be classed as implementing Observer Design Pattern.






# Course Example:
To show how Observer Pattern works, we use the course example.
The problem is that there are different kinds of students enrolled in one course. What we want is that when the information of the course changes, all students enrolled should be informed automatically.

# Design Diagram
Here is our design diagram.
<img width="1037" alt="Screen Shot 2022-12-05 at 7 56 00 PM" src="https://user-images.githubusercontent.com/113145079/205822354-c3499222-9c6f-4978-978b-4f54ec462008.png">
 
There are many ways to implement the Observer pattern but most of them include Subject and Observer interface. So here we also use these two interfaces. 

# DisplayElement interface
In addition, we use the DisplayElement interface to make sure that every time students get updated course information, the message will be shown.
  ```
public interface DisplayElement {
  public void display();
}
  ```

# Subject Interface
In the Subject interface, there are three main methods to manage its observers, which are registerObserver, removeObserber, notifyObservers. 
  ```
public interface Subject {
  public void registerObserver(Observer o);
  public void removeObserver(Observer o);
  public void notifyObservers();
}
  ```

# CourseInformation Class
The class that implements the Subject class is CourseInformation. In this class, we have three fields related to the course, which are professor name, assignment number and week number. 
  ```
public class CourseInformation implements Subject {
  private List<Observer> observers;//used to hold observers
  private String professorName;
  private int assignmentNumber;
  private int weekNumber;
 }
  ```

In addition, there is a list to hold observers. Except for those three override methods, there are 5 methods. 
The connection between some of them is that we use setInformation method to change information of course, and then the informationChanged method will be called, then the notifyObservers method will be called. In the notifyObservers method, we us¬¬e the update method to pass updated information of course to all its observers.
  ```
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
  ```
# Observer Interface
Then we talk about Observer interface, there is only one method in this interface, and every class that implements this interface must implement this method. So, every observer class will have this method. As we mentioned before, this method is used to pass updated information of course to observers.
  ```
public interface Observer {
  public void update(String professorName, int assignmentNumber, int weekNumber);
}
  ```
Now let us go ahead with three concrete classes that implement the Observer interface, which represent three different kinds of students, general students, auditors and teaching assistants.
To make this example as simple as possible, so that the Observer pattern can be understood by audiences easily, the content of these three classes is the same. So, we only explain one of them.
 
# GeneralStudent Class
We choose the GeneralStudent class as the example. In this class, we have three fields related to the course, the professor name, the assignment number and the week number. In addition, we also include the courseInformation as one field, it is because that it may be used by this class, such as removing observers. 
  ```
public class GeneralStudent implements Observer, DisplayElement{
  private String professorName;
  private int assignmentNumber;
  private int weekNumber;
  private CourseInformation courseInformation;
 }
  ```

Here we only have two simple methods in this class. One of them is updated, which is used to update its field. At the end of this method, we call display method, so we can know immediately that the student is notified when the course information change.
  ```
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
  ```
 
# CourseCenter Class
Finally, we have the CourseCenter class, which is the driver class. In this class, we create an object of CourseInformation class, named courseInformation.
We also create three different kinds of student objects, named general student, auditor, and teaching assistant. Then we change the course information twice to see what will happen. Then we remove auditors from the observer list and change the course information again to see what will happen.
 ```
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
  ```

So now we solve the problem. Thanks to the Observer Pattern.
