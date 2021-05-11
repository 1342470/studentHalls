package com.mycompany.studenthalls;


import java.util.ArrayList;

/** Collection class to hold a list of motorbike

 *  @author Andy
 *  @version 21 April 2021
 */

public class HallList  
{
    private ArrayList<Student> StudentRooms;
    private ArrayList<Student> VeganRooms;
    private ArrayList<Student> DisabledRooms;
    public final int MAX;
        

    public HallList(int maxRoomSize)
    {
        StudentRooms = new ArrayList<>();
        VeganRooms = new ArrayList<>();
        DisabledRooms = new ArrayList<>();
        MAX = maxRoomSize;
    }
	
    /** allows a Student to be put into a room basted on some of their needs
     *  @param  theRoomOwner the student that will be placed into a correct respective hall
     *  @return Returns true if a hall was found for that students needs
     */
    
    public boolean addRoomOwner(Student theRoomOwner)
    {
        if(!isDisabledRoomsFull() || !isStudentRoomsFull() || !isVeganRoomsFull() )        {
            if(theRoomOwner.vegan.equals("yes") ){VeganRooms.add(theRoomOwner);}
                else if(theRoomOwner.disabled.equals("yes")){DisabledRooms.add(theRoomOwner);}
                    else if(theRoomOwner.vegan.equals("no") && theRoomOwner.disabled.equalsIgnoreCase("yes")){StudentRooms.add(theRoomOwner);}
        return true;
        }
        else
        {
            return false;
        }
    }
        


   /** Reports on whether or not the list is empty
     *  @return Returns true if the list is empty and false otherwise
     */
    public boolean isStudentRoomsEmpty()
    {
        return StudentRooms.isEmpty();
    }
    
        public boolean isVeganRoomsEmpty()
    {
        return VeganRooms.isEmpty();
    }
        
        public boolean isDisabedRoomsEmpty()
    {
        return DisabledRooms.isEmpty();
    }
	
    /** Reports on whether or not the list is full
     *  @return Returns true if the list is full and false otherwise
     */	
    public boolean isStudentRoomsFull()
    {
        return StudentRooms.size()== MAX;
    }
    
    public boolean isVeganRoomsFull()
    {
        return VeganRooms.size()== MAX;
    }
        
    public boolean isDisabledRoomsFull()
    {
        return DisabledRooms.size()== MAX;
    }
    
    
        
    /** counts all of the student in all halls
     *  @return Returns the number all of the students that currently booked into a room in any of the halls
     */
    public int numOfBookedStudents()
    {
        int total = DisabledRooms.size() + VeganRooms.size() + StudentRooms.size();
        return total;
    }
      
     /** Reads the student at the given position in the list
     *  @param      currentPlacement The position of the bike in the list
     *  @return     Returns the bike at the  position in the list
     *              or null if no bike at that logical position
     */
    public Student findStudentVegan(int currentPlacement)
    {
        if (currentPlacement < 0 || currentPlacement >= numOfBookedStudents()) 
        {
            return null;
        }
        else
        {
            return VeganRooms.get(currentPlacement);
        }
    }
    
    public Student findStudentDisabled(int currentPlacement)
    {
        if (currentPlacement < 0 || currentPlacement >= numOfBookedStudents()) 
        {
            return null;
        }
        else
        {
            return DisabledRooms.get(currentPlacement);
        }
    }
        
    public Student findStudent(int currentPlacement)
    {
        if (currentPlacement < 0 || currentPlacement >= numOfBookedStudents()) 
        {
            return null;
        }
        else
        {
            return StudentRooms.get(currentPlacement);
        }
    }
    
    
    
     /** Outputs all the studfnets in the vegan arrary
     *  @return     Returns all the students and owners in the list in an easy to read format
     */
    
    public String displayVegans()
    {
        System.out.println("In the vegan hall currently booked is ");
        String output = "\n";  
            for (int counter = 0; counter < VeganRooms.size(); counter++) { 
                output += VeganRooms.get(counter).Fname + "\t" + VeganRooms.get(counter).Lname;
                output += "\n\n";
      } 
        return output;
}

    public String displayDisabled()
    {
        System.out.println("In the disabled access hall currently booked in is ");
        String output = "\n";  
            for (int counter = 0; counter < DisabledRooms.size(); counter++) { 
                output += DisabledRooms.get(counter).Fname + "\t" + DisabledRooms.get(counter).Lname;
                output += "\n\n";
      } 
        return output;
}

    public String displayStudents()
    {
        System.out.println("in the non-needs hall currently booked in is ");
        String output = "\n";  
            for (int counter = 0; counter < StudentRooms.size(); counter++) { 
                output += StudentRooms.get(counter).Fname + "\t" + StudentRooms.get(counter).Lname;
                output += "\n\n";
      } 
        return output;
}
    
    public String displayAllStudents()
    {
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

        return output;
            }
    
}