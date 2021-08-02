
package com.mycompany.studenthalls;

import java.io.Serializable;

/**
 *
 * @author kylej
 */
public class Person implements Serializable{
    String Fname;
    String Lname;
    String gender;
    String vegan;
    String disabled;
    String Staff;

    public Person(String Fname, String Lname, String gender, String vegan, String disabled, String Staff) {
        this.Fname = Fname;
        this.Lname = Lname;
        this.gender = gender;
        this.vegan = vegan;
        this.disabled = disabled;
        this.Staff = Staff;
    }

    public String getFname() {
        return Fname;
    }

    public void setFname(String Fname) {
        this.Fname = Fname;
    }

    public String getLname() {
        return Lname;
    }

    public void setLname(String Lname) {
        this.Lname = Lname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String isVegan() {
        return vegan;
    }

    public void setVegan(String vegan) {
        this.vegan = vegan;
    }

    public String isDisabled() {
        return disabled;
    }

    public void setDisabled(String disabled) {
        this.disabled = disabled;
    }
    
    public void setStaff(String Staff) {
        this.Staff = Staff;
    }
    
    
}
