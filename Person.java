
package exercise1_task2;

import java.text.DateFormat;
import java.util.GregorianCalendar;

public abstract class Person {
    private String surname;
    private String forename;
    private GregorianCalendar birthday;   
    
    public Person(){
        this.surname = "Liegener";
        this.forename = "Lui";
        this.birthday = new GregorianCalendar(1992, 6, 18);
    }
    
    public Person(String surname, String forename, GregorianCalendar birthday){
        this.surname = surname;
        this.forename = forename;
        this.birthday = birthday;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getForename() {
        return forename;
    }

    public void setForename(String forename) {
        this.forename = forename;
    }

    public GregorianCalendar getBirthday() {
        return birthday;              
    }

    public void setBirthday(GregorianCalendar birthday) {
        this.birthday = birthday;
    }

    public String printGregorianCalendarDate(){
        DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM);
        return df.format(this.birthday.getTime());
    }
    
}
