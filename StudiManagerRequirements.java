package exercise1_task2;

import java.util.HashMap;
import java.util.List;

public interface StudiManagerRequirements {
    Student getNewStudentFromCli(); 
    void addStudent(Student student);
    void printAllStudents(); 
    void getStudentBySubject();
}
