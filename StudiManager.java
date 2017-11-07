package exercise1_task2;

import java.text.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StudiManager implements StudiManagerRequirements {
    
    Scanner scanner;
    List<Student> listOfStudents;
    
    public StudiManager(){
        scanner = new Scanner(System.in);
        listOfStudents = new ArrayList<>();
    }

    @Override
    public Student getNewStudentFromCli() {
        Student newStudent = new Student();
        System.out.println("Neue_r Student_in: ");
        
        System.out.println("Bitte geben Sie Ihren Familiennamen ein: ");
        newStudent.setSurname(this.getStringFromConsole(2, 40, "Bitte geben Sie einen gueltigen Namen an."));
        
        System.out.println("Bitte geben Sie Ihren Vornamen ein: ");
        newStudent.setForename(this.getStringFromConsole(2, 30, "Bitte geben Sie einen gueltigen Namen an."));
        
        System.out.println("Bitte geben Sie Ihr Geburtsdatum in der Form 'dd mm yyyy' ein. (Ein Formatierungsbeispiel waere: 20 10 1990)");
        newStudent.setBirthday(this.getBirthdateFromConsole("Bitte geben Sie Ihr Geburtstag in der Form 'dd mm yyyy' an. (Bsp.: 20 10 1990) "));
        
        System.out.println("Bitte geben Sie Ihre Matrikelnummer ein: ");
        newStudent.setMatrNumber(this.getMatrNumberFromConsole("Bitte geben Sie eine 6-stellige, ganze Zahl an."));
        
        System.out.println("Bitte geben Sie die Seminargruppe an, der Sie zugehoerig sind: Gruppe1 oder Gruppe2");
        newStudent.setSeminarGroup(this.getSeminarGroupFromConsole("Bitte geben Sie entweder 'Gruppe1' oder 'Gruppe2' an."));
        
        //How many subjects does the student want to take:
        System.out.println("Wieviele Faecher wollen Sie belegen? (Es koennen maximal 4 Faecher gewaehlt werden.)");
        int numberOfSubjects = this.getIntFromConsole(0, 5, "Bitte geben Sie eine Zahl zwischen 0-5 an!");
        
        //save subjects in ArrayList of Student:
        for( int i = 0; i < numberOfSubjects; i++){
            System.out.println("Geben Sie das " + (i+1) + ". Fach an, das Sie belegen moechten: ");
            System.out.println("(Auswahl: Programmierung3, Datenbanken, Algorithmen_und_Datenstrukturen, Mathe3 oder Gesellschaftliche_Aspekte_der_Informatik) ");
            newStudent.chosenSubjects[i] = this.getCourseNameFromConsole("Geben Sie einen der folgenden Kurse an: Programmierung3, Datenbanken, Algorithmen_und_Datenstrukturen, Mathe3 oder Gesellschaftliche_Aspekte_der_Informatik", newStudent);
        }
        
        return newStudent;
    }

    @Override
    public void addStudent(Student student) {
        if(student.isStudentValid()){
            this.listOfStudents.add(student);
        }
    }

    @Override
    public void printAllStudents() {
        for(Student students : listOfStudents){
            System.out.println(students.toString());
        }
    }

    @Override
    public void getStudentBySubject() {
        HashMap<CourseName, List<Student>> studentsBySubject = new HashMap<CourseName, List<Student>>();
        //Lists of students with same subject:
        List<Student> studentsProg3 = new ArrayList<Student>();
        List<Student> studentsDB = new ArrayList<Student>();
        List<Student> studentsAlgData = new ArrayList<Student>();
        List<Student> studentsMath3 = new ArrayList<Student>();
        List<Student> studentsGesellAspekte = new ArrayList<Student>();
        
        //Sort students according to chosen subjects to the ArrayLists:
        for(Student student : listOfStudents){
            for(int i = 0; i < student.chosenSubjects.length; i++){
                if(student.chosenSubjects[i].getCoursename() == CourseName.Programmierung3){
                    studentsProg3.add(student);
                }
                if(student.chosenSubjects[i].getCoursename() == CourseName.Datenbanken){
                    studentsDB.add(student);
                }
                if(student.chosenSubjects[i].getCoursename() == CourseName.Algorithmen_und_Datenstrukturen){
                    studentsAlgData.add(student);
                }
                if(student.chosenSubjects[i].getCoursename() == CourseName.Mathe3){
                    studentsMath3.add(student);
                }
                if(student.chosenSubjects[i].getCoursename() == CourseName.Gesellschaftliche_Aspekte_der_Informatik){
                    studentsGesellAspekte.add(student);
                }
            }             
        }
        
        //Put ArrayLists together with the key into the HashMap:
        studentsBySubject.put(CourseName.Programmierung3, studentsProg3);
        studentsBySubject.put(CourseName.Datenbanken, studentsDB);
        studentsBySubject.put(CourseName.Algorithmen_und_Datenstrukturen, studentsAlgData);
        studentsBySubject.put(CourseName.Mathe3, studentsMath3);
        studentsBySubject.put(CourseName.Gesellschaftliche_Aspekte_der_Informatik, studentsGesellAspekte);
        
        //print out:
        if(studentsBySubject.containsKey(CourseName.Programmierung3)){
            System.out.println("Studenten, die Programmierung3 belegt haben:");
            System.out.println(studentsBySubject.get(CourseName.Programmierung3).toString());
        }
        if(studentsBySubject.containsKey(CourseName.Datenbanken)){
            System.out.println("Studenten, die Datenbanken belegt haben:");
            System.out.println(studentsBySubject.get(CourseName.Datenbanken).toString());
        }
        if(studentsBySubject.containsKey(CourseName.Algorithmen_und_Datenstrukturen)){
            System.out.println("Studenten, die Algorithmen_und_Datenstrukturen belegt haben:");
            System.out.println(studentsBySubject.get(CourseName.Algorithmen_und_Datenstrukturen).toString());
        }
        if(studentsBySubject.containsKey(CourseName.Mathe3)){
            System.out.println("Studenten, die Mathe3 belegt haben:");
            System.out.println(studentsBySubject.get(CourseName.Mathe3).toString());
        }
        if(studentsBySubject.containsKey(CourseName.Gesellschaftliche_Aspekte_der_Informatik)){
            System.out.println("Studenten, die Gesellschaftliche_Aspekte_der_Informatik belegt haben:");
            System.out.println(studentsBySubject.get(CourseName.Gesellschaftliche_Aspekte_der_Informatik).toString());
        }
    }
    
    public int getIntFromConsole(int x, int y, String errorMessage){
        boolean testInput = true;
        int input = 0;
        do{
            try{
                input = Integer.parseInt(this.scanner.nextLine());
                if(input < x || input > y){
                    System.out.println(errorMessage);
                }
                else{
                    testInput = false;
                }
            }
            catch(Exception e){
                System.out.println(errorMessage);
            }
        }
        while(testInput);
        return input;   
    }
    
    public String getStringFromConsole(int minSize, int maxSize, String errorMessage){
        String input;
        //Matcher: checks if a string contains numbers
        Pattern p = Pattern.compile("([0-9])");
        do{
            try{
                input = this.scanner.nextLine();
                Matcher m = p.matcher(input);
                if(input.length() < minSize || input.length() > maxSize || m.find()){
                    System.out.println(errorMessage);
                }
                else{
                    return input;
                }
            }
            catch(Exception e){
                System.out.println(errorMessage);
            }
        }
        while(true);
    }
    
    public SeminarGroup getSeminarGroupFromConsole(String errorMessage){
        String input;
        do{
            try{
                input = this.scanner.nextLine();
                if(this.isSeminarGroupValid(input)){
                    return SeminarGroup.valueOf(input);
                }
                else{
                    System.out.println(errorMessage);
                }
            }
            catch(Exception e){
                System.out.println(errorMessage);
            }
        }
        while(true);
    }
    
    private boolean isSeminarGroupValid(String input){
        for(SeminarGroup seminarGroup : SeminarGroup.values()){
            if(seminarGroup.name().equals(input)){
                return true;
            }
        }
        return false;
    }
    
    public int getMatrNumberFromConsole(String errorMessage){
        String input;
        do{
            try{
                input = this.scanner.nextLine();
                int tempInt = Integer.parseInt(input);
                if(this.isMatrNumberValid(tempInt)){
                    return tempInt;
                }
                else{
                    System.out.println(errorMessage);
                }
            }
            catch(Exception e){
                System.out.println(errorMessage);
            }
        }
        while(true);
    }
    
    private boolean isMatrNumberValid(int matrNumber){
        String tempString = String.valueOf(matrNumber);
        return (tempString.length() == 6);
    }
    
    public GregorianCalendar getBirthdateFromConsole(String errorMessage){
        String input;
        do{
            try{
                input = this.scanner.nextLine();
                String tempString = String.valueOf(input);
                DateFormat df = new SimpleDateFormat("dd MM yyyy");
                Date date = df.parse(tempString);
                GregorianCalendar cal = new GregorianCalendar();
                cal.setTime(date);
                return cal;
            }
            catch(Exception e){
                System.out.println(errorMessage);
            }
        }
        while(true);
    }
    
    public static String format(GregorianCalendar date){
        SimpleDateFormat df = new SimpleDateFormat("dd.mm.yyyy");
        String dateFormatted = df.format(date);
        return dateFormatted;
    }

    public Subject getCourseNameFromConsole(String errorMessage, Student student){
        String input;
        do{
            try{
                input = this.scanner.next();
                if(this.isCourseNameValid(input)){
                    Subject tempSubject = null;
                    if(input.equals(CourseName.Algorithmen_und_Datenstrukturen.name())){
                        tempSubject = new Subject(2, CourseName.Algorithmen_und_Datenstrukturen, CourseOfStudies.Angewandte_Informatik);
                    }
                    else if(input.equals(CourseName.Datenbanken.name())){
                        tempSubject = new Subject(3, CourseName.Datenbanken, CourseOfStudies.Angewandte_Informatik);
                    }
                    else if(input.equals(CourseName.Gesellschaftliche_Aspekte_der_Informatik.name())){
                        tempSubject = new Subject(1, CourseName.Gesellschaftliche_Aspekte_der_Informatik, CourseOfStudies.Angewandte_Informatik);
                    }
                    else if(input.equals(CourseName.Mathe3.name())){
                        tempSubject = new Subject(3, CourseName.Mathe3, CourseOfStudies.Umweltinformatik);
                    }
                    else if(input.equals(CourseName.Programmierung3.name())){
                        tempSubject =  new Subject(3, CourseName.Programmierung3, CourseOfStudies.Angewandte_Informatik);
                    }
                    if(student.subjectAlreadyChosen(CourseName.valueOf(input))){
                        System.out.println("Sie haben diesen Kurs bereits gewaehlt. Bitte waehlen Sie einen anderen Kurs aus.");
                        continue;
                    }
                    return tempSubject;
                }
                else{
                    System.out.println(errorMessage);
                }
            }
            catch(Exception e){
                System.out.println(errorMessage);
            }
        }
        while(true);
    }

    //Is coursename from the given enumList CourseName:
    private boolean isCourseNameValid(String input){
        for(CourseName coursename : CourseName.values()){
            if(coursename.name().equals(input)){
                return true;
            }
        }
        return false;
    }
    
}
