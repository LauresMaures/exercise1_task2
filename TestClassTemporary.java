
package exercise1_task2;

import garbage.GregorianCalendarUsage;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import exercise1_task2.Student;

//Test: how is an ArrayList printed? -> Important for the last print out part of the method getStudentBySubject() (print the ArrayList as part from a HashMap)
public class TestClassTemporary {

    public static void main(String[] args) {
        List<Student> liste1 = new ArrayList<Student>();
        liste1.add(new Student("Liegener", "Laura", new GregorianCalendar(1990, 20, 10), 556345, SeminarGroup.Gruppe1));
        liste1.add(new Student("Liegener", "Lui", new GregorianCalendar(1990, 18, 10), 551145, SeminarGroup.Gruppe2));
        liste1.add(new Student("Patzt", "Peter", new GregorianCalendar(1980, 20, 10), 556445, SeminarGroup.Gruppe1));
        
        System.out.println(liste1.toString());
        
    }
    
}

