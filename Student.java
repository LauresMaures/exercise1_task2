package exercise1_task2;

import java.util.GregorianCalendar;
import exercise1_task2.Subject;

public class Student extends Person {
    private int matrNumber;
    private SeminarGroup seminarGroup;
    Subject[] chosenSubjects;
    
    Student(){             //Should this default constructor be empty?
        super("Liegener", "Laura", new GregorianCalendar(1990, 20, 10));
        this.matrNumber = 559257;
        this.seminarGroup = SeminarGroup.Gruppe1;
        this.chosenSubjects = new Subject[4];
    }
    
    Student(String surename, String forename, GregorianCalendar birthday, int matrNumber, SeminarGroup seminarGroup){
        super(surename, forename, birthday);
        this.matrNumber = matrNumber;
        this.seminarGroup = seminarGroup;
        this.chosenSubjects = new Subject[4];
    }
    
    public boolean subjectAlreadyChosen(CourseName coursename){
        for(Subject subject : this.chosenSubjects){
            if(subject.getCoursename().equals(coursename)){
                return true;
            }
        }
        return false;
    }

    public int getMatrNumber() {
        return matrNumber;
    }

    public void setMatrNumber(int matrNumber) {
        this.matrNumber = matrNumber;
    }

    public SeminarGroup getSeminarGroup() {
        return seminarGroup;
    }

    public void setSeminarGroup(SeminarGroup seminarGroup) {
        this.seminarGroup = seminarGroup;
    }

    @Override
    public String toString() {
        return (super.getSurname() + ", " + super.getForename() + "; Geburtsdatum= " + super.printGregorianCalendarDate() + "; Matrikelnummer= " + matrNumber + "; Seminargruppe= " + seminarGroup);
    }
    
    //Check if student is valid:
    //Add: check birthdate!!
    public boolean isStudentValid(){
        return (this.stringIsValid(super.getSurname()) && this.stringIsValid(super.getForename()) && this.isMatrNumberValid() && this.isSeminarGroupValid(this.seminarGroup));
    }
    
    //Check if surname and forename are valid:
    public boolean stringIsValid(String string) {
        String tempString = string;
        return (tempString != null && tempString != "" && tempString.length() > 2);
    }
    
    //Check if matrNumber is valid:
    public boolean isMatrNumberValid() {
        String tempString = String.valueOf(this.matrNumber);
        return (tempString.length() == 6);
    }
    
    //Check if seminarGroup is valid:
    public boolean isSeminarGroupValid(SeminarGroup seminarGroup) {
        switch(seminarGroup){
            case Gruppe1: return true;
            case Gruppe2: return true;
            default: return false;
        }
    }
    
}
