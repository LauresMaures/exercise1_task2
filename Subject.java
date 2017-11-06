
package exercise1_task2;

import exercise1_task2.CourseOfStudies;

public class Subject {
    private int semester; //has to be an integer value between 1-6
    private CourseName coursename;
    private CourseOfStudies courseOfStudies;
    
    //Default Constructor:
    Subject(){                               
        this.semester = 0;         
        this.coursename = null;
        this.courseOfStudies = null;
    }
    
    //Constructor with parameters:
    Subject(int semesterzahl, CourseName coursename, CourseOfStudies courseOfStudies){
        this.coursename = coursename;
        this.courseOfStudies = courseOfStudies;            
        if(semesterzahl > 0 && semesterzahl < 7){
            this.semester = semesterzahl;
        }
        else{
            throw new IllegalArgumentException("Es muss eine Zahl von 1-6 eingegeben werden.");
        }
    }
    //Copy Constructor:
    Subject(Subject subject){
        this(subject.semester, subject.coursename, subject.courseOfStudies);
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        if(semester > 0 && semester < 7){
            this.semester = semester;
        }
        else{
            throw new IllegalArgumentException("Es muss eine Zahl von 1-6 eingegeben werden.");
        }
    }

    public CourseName getCoursename() {
        return coursename;
    }

    public void setCoursename(CourseName kursname) {
        this.coursename = kursname;
    }

    public CourseOfStudies getCourseOfStudies() {
        return courseOfStudies;
    }

    public void setCourseOfStudies(CourseOfStudies courseOfStudies) {
        this.courseOfStudies = courseOfStudies;
    }

    @Override
    public String toString() {
        return "[ Kursname: " + coursename + ", Studiengang: " + courseOfStudies + ", Semester: " + semester + " ]";
    }
   
}
