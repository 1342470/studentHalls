/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.studenthalls;

/**
 *
 * @author kylej
 */
public class Student {
    String Fname;
    String Lname;
    String gender;
    String vegan;
    String disabled;

    public Student(String Fname, String Lname, String gender, String vegan, String disabled) {
        this.Fname = Fname;
        this.Lname = Lname;
        this.gender = gender;
        this.vegan = vegan;
        this.disabled = disabled;
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
    
    
}
