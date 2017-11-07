package exercise1_task2;

import java.util.GregorianCalendar;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class StudentTest {
    private Student testStudent;
    
    public StudentTest() {
    }
    
    @Before
    public void studentErzeugen() {
        testStudent = new Student("Heinz", "Julian", new GregorianCalendar(1980, 21, 10), 445345, SeminarGroup.Gruppe1);
    }

    @Test
    public void testSubjectAlreadyChosen() {
        System.out.println("Test for subjectAlreadyChosen: ");
        CourseName coursename = CourseName.Datenbanken;
        Subject subject = new Subject(2, CourseName.Datenbanken, CourseOfStudies.Angewandte_Informatik);
        testStudent.chosenSubjects[0] = new Subject(subject);
        Assert.assertTrue(testStudent.subjectAlreadyChosen(coursename));
    }

    @Test
    public void testGetMatrNumber() {
        System.out.println("Test for getMatrNumber: ");
        int expResult = 445345;
        int result = testStudent.getMatrNumber();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetMatrNumber() {
        System.out.println("Test for setMatrNumber: ");
        int matrNumber = 559257;
        testStudent.setMatrNumber(matrNumber);
        Assert.assertTrue(testStudent.getMatrNumber() == matrNumber);
    }

    @Test
    public void testGetSeminarGroup() {
        System.out.println("Test for getSeminarGroup: ");
        SeminarGroup expResult = SeminarGroup.Gruppe1;
        SeminarGroup result = testStudent.getSeminarGroup();
        Assert.assertEquals(expResult, result);
    }

    @Test
    public void testSetSeminarGroup() {
        System.out.println("Test for setSeminarGroup: ");
        SeminarGroup seminarGroup = SeminarGroup.Gruppe2;
        testStudent.setSeminarGroup(seminarGroup);
        Assert.assertTrue(testStudent.getSeminarGroup().equals(seminarGroup));
    }

    @Test
    public void testToString() {
        System.out.println("Test for toString: ");
        String expected = "Heinz, Julian; Geburtsdatum= 10.10.1981; Matrikelnummer= 445345; Seminargruppe= Gruppe1";
        Assert.assertEquals(expected, testStudent.toString());
    }

    @Test
    public void testIsStudentValid() {
        System.out.println("Test for isStudentValid: ");
        boolean result = testStudent.isStudentValid();
        Assert.assertTrue(result);
    }

    @Test
    public void testStringIsValid() {
        System.out.println("Test for stringIsValid: ");
        Assert.assertTrue(testStudent.stringIsValid(testStudent.getForename()));
    }

    @Test
    public void testIsMatrNumberValid() {
        System.out.println("Test for isMatrNumberValid: ");
        boolean result = testStudent.isMatrNumberValid();
        Assert.assertTrue(result);
    }

    @Test
    public void testIsSeminarGroupValid() {
        System.out.println("Test for isSeminarGroupValid: ");
        SeminarGroup seminarGroup = SeminarGroup.Gruppe1;
        boolean result = testStudent.isSeminarGroupValid(seminarGroup);
        Assert.assertTrue(result);
    }
    
}
