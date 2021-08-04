package com.mycompany.studenthalls;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class HallList implements Serializable{

    public ArrayList<Person> StudentRooms;
    public ArrayList<Person> VeganRooms;
    public ArrayList<Person> DisabledRooms;
    public ArrayList<Person> StaffRooms;

    public final int MAX;

    public HallList(int maxRoomSize) {
        StudentRooms = new ArrayList<>();
        VeganRooms = new ArrayList<>();
        DisabledRooms = new ArrayList<>();
        StaffRooms = new ArrayList<>();
        MAX = maxRoomSize;
    }

    /**
     * allows a Student to be put into a room basted on some of their needs
     *
     * @param theRoomOwner the student that will be placed into a correct
     * respective hall
     * @return Returns true if a hall was found for that students needs
     */
    public boolean addRoomOwner(Person theRoomOwner) {
        if (!isDisabledRoomsFull() || !isStudentRoomsFull() || !isVeganRoomsFull()) {
            if(theRoomOwner.Staff.equalsIgnoreCase("yes")){
                StaffRooms.add(theRoomOwner);
            }else if (theRoomOwner.vegan.equalsIgnoreCase("yes")) {
                VeganRooms.add(theRoomOwner);
            } else if (theRoomOwner.disabled.equalsIgnoreCase("yes")) {
                DisabledRooms.add(theRoomOwner);
            } else if (theRoomOwner.vegan.equalsIgnoreCase("no") && theRoomOwner.disabled.equalsIgnoreCase("no") && theRoomOwner.Staff.equalsIgnoreCase("no")) {
                StudentRooms.add(theRoomOwner);
            } else if (theRoomOwner.vegan.equalsIgnoreCase("yes") && theRoomOwner.disabled.equalsIgnoreCase("yes")) {
                DisabledRooms.add(theRoomOwner);
            } else if (theRoomOwner.disabled.equalsIgnoreCase("yes") && theRoomOwner.Staff.equalsIgnoreCase("yes")) {
                StaffRooms.add(theRoomOwner);
            } else if (theRoomOwner.vegan.equalsIgnoreCase("yes") && theRoomOwner.Staff.equalsIgnoreCase("yes")) {
                StaffRooms.add(theRoomOwner);
            }else if (theRoomOwner.vegan.equalsIgnoreCase("yes") && theRoomOwner.Staff.equalsIgnoreCase("yes") && theRoomOwner.disabled.equalsIgnoreCase("yes")) {
                StaffRooms.add(theRoomOwner);
            }else if (theRoomOwner.vegan.equalsIgnoreCase("no") && theRoomOwner.Staff.equalsIgnoreCase("no") && theRoomOwner.disabled.equalsIgnoreCase("yes")) {
                StaffRooms.add(theRoomOwner);
            }
            return true;
        } else {
            return false;
        }
    }

    public ArrayList<Person> getStudentRooms() {
        return StudentRooms;
    }

    public ArrayList<Person> getDisabledRooms() {
        return DisabledRooms;
    }

    public ArrayList<Person> getVeganRooms() {
        return VeganRooms;
    }

    public boolean isStudentRoomsEmpty() {
        return StudentRooms.isEmpty();
    }

    public boolean isVeganRoomsEmpty() {
        return VeganRooms.isEmpty();
    }

    public boolean isDisabedRoomsEmpty() {
        return DisabledRooms.isEmpty();
    }

    public boolean isStudentRoomsFull() {
        return StudentRooms.size() == MAX;
    }

    public boolean isVeganRoomsFull() {
        return VeganRooms.size() == MAX;
    }

    public boolean isDisabledRoomsFull() {
        return DisabledRooms.size() == MAX;
    }

    public int getVeganSize() {
        int size = VeganRooms.size();

        return size;
    }

    /**
     * counts all of the student in all halls
     *
     * @return Returns the number all of the students that currently booked into
     * a room in any of the halls
     */
    public int numOfBookedStudents() {
        int total = DisabledRooms.size() + VeganRooms.size() + StudentRooms.size();
        return total;
    }

    public Person findStudentVegan(int currentPlacement) {
        if (currentPlacement < 0 || currentPlacement >= numOfBookedStudents()) {
            return null;
        } else {
            return VeganRooms.get(currentPlacement);
        }
    }

    public Person findStudentDisabled(int currentPlacement) {
        if (currentPlacement < 0 || currentPlacement >= numOfBookedStudents()) {
            return null;
        } else {
            return DisabledRooms.get(currentPlacement);
        }
    }

    public Person findStudent(int currentPlacement) {
        if (currentPlacement < 0 || currentPlacement >= numOfBookedStudents()) {
            return null;
        } else {
            return StudentRooms.get(currentPlacement);
        }
    }

    /**
     * Outputs all the studfnets in the vegan arrary
     *
     * @return Returns all the students and owners in the list in an easy to
     * read format
     */
    public String displayVegans() {
        String output = "\n";
        for (int counter = 0; counter < VeganRooms.size(); counter++) {
            output += VeganRooms.get(counter).Fname + "\t" + VeganRooms.get(counter).Lname;
            output += "\n\n";
        }
        return output;
    }

    public String displayDisabled() {
        String output = "\n";
        for (int counter = 0; counter < DisabledRooms.size(); counter++) {
            output += DisabledRooms.get(counter).Fname + "\t" + DisabledRooms.get(counter).Lname;
            output += "\n\n";
        }
        return output;
    }

    public String displayStudents() {
        String output = "\n";
        for (int counter = 0; counter < StudentRooms.size(); counter++) {
            output += StudentRooms.get(counter).Fname + "\t" + StudentRooms.get(counter).Lname;
            output += "\n\n";
        }
        return output;
    }
    
    public String displayStaff() {
        String output = "\n";
        for (int counter = 0; counter < StaffRooms.size(); counter++) {
            output += StaffRooms.get(counter).Fname + "\t" + StaffRooms.get(counter).Lname;
            output += "\n\n";
        }
        return output;
    }

    public String displayAllStudents() {
        String output = "\n";
        for (int counterVegan = 0; counterVegan < VeganRooms.size(); counterVegan++) {
            output += VeganRooms.get(counterVegan).Fname + "\t" + VeganRooms.get(counterVegan).Lname;
            output += "\n\n";
        }
        for (int counterDisabled = 0; counterDisabled < DisabledRooms.size(); counterDisabled++) {
            output += DisabledRooms.get(counterDisabled).Fname + "\t" + DisabledRooms.get(counterDisabled).Lname;
            output += "\n\n";
        }
        for (int counterStu = 0; counterStu < StudentRooms.size(); counterStu++) {
            output += StudentRooms.get(counterStu).Fname + "\t" + StudentRooms.get(counterStu).Lname;
            output += "\n\n";
        }
        for (int counter = 0; counter < StaffRooms.size(); counter++) {
            output += StaffRooms.get(counter).Fname + "\t" + StaffRooms.get(counter).Lname;
            output += "\n\n";
        }
        
        return output;
    }
    
    public void saveData() throws IOException {
      
        try {
           FileOutputStream fileOut = new FileOutputStream("./BookedData.txt");
           ObjectOutputStream out = new ObjectOutputStream(fileOut);
           out.writeObject(StudentRooms);
           out.writeObject(VeganRooms);
           out.writeObject(DisabledRooms);
           out.writeObject(StaffRooms);
           out.close();
           fileOut.close();
           System.out.printf("Data is saved in ./BookedData.txt file");
        } 
        catch (IOException myException) {
             myException.printStackTrace();
            }}
        
    
    
    public void loadData(){
    Object obj;
    Student stu;
    try {
            FileInputStream fileIn = new FileInputStream("./BookedData.txt");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            obj = in.readObject();
            stu = (Student)obj;
            in.close();
            
            fileIn.close();
            System.out.println("Deserializing Data...");
        } 
        catch (IOException i) {
            i.printStackTrace();
            return;
        } 
        catch (ClassNotFoundException c) {
            System.out.println("Student class not found");
            c.printStackTrace();
        return;
        }
    }
    
   
    }


