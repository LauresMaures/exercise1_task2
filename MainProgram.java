package exercise1_task2;

import java.text.*;
import java.util.*;

public class MainProgram {

    public static void main(String[] args)  { //add: throws ParseException ?
        StudiManager manager = new StudiManager();
        
        //Get data from 3 new students and save them in manager:
        for( int i = 0; i < 3; i++){
            Student newStudent = manager.getNewStudentFromCli();
            manager.addStudent(newStudent);
        }
        
        //print all students:
        manager.printAllStudents();
       
        //Sort students according to subject:
        manager.getStudentBySubject();
           

        
    }
    
}
