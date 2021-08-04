
package com.mycompany.studenthalls;

import java.io.Serializable;

/**
 *
 * @author kylej
 */
public class Student extends Person implements Serializable{
    String Fname;
    String Lname;
    String gender;
    String vegan;
    String disabled;

    public Student(String Fname, String Lname, String gender, String vegan, String disabled, String Staff) {
        super(Fname, Lname, gender, vegan, disabled, Staff);
    }

}

