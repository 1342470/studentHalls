package com.mycompany.studenthalls;

import com.mycompany.studenthalls.HallList;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**GUI for the Garage application
  * based on the hostel application in Java in Two Semesters
  *@author Andy
  *@version 21 April 2018
  */

public class App extends Application
{
    private HallList hList;
    // WIDTH and HEIGHT of GUI stored as constants 
    private final int WIDTH = 1200;
    private final int HEIGHT = 1000;
    // visual components
    private Label title = new Label("Please enter your Details");
    private Label studentDetails = new Label("Student Details");
    private Label firstNameLabel = new Label("First Name");
    private TextField NameField =  new TextField();    
    private Separator sectSeparator = new Separator();
    private Label secondName = new Label("Second Name");
    private TextField secondNameField =  new TextField();
    private Separator sectSeparator2 = new Separator();
    private Label genderLable = new Label("Gender");
    private TextField genderField =  new TextField();
    private Separator sectSeparator3 = new Separator();
    private Label vegan = new Label("Vegan");
    private TextField veganField =  new TextField();    
    private Separator sectSeparator4 = new Separator();
    private Label disabledLable = new Label("Disabled?");
    private TextField disabledField =  new TextField();    
    private Separator sectSeparator5 = new Separator();
    private TextArea outputResults = new TextArea();
    private Button submit = new Button("Book room");
    
 
    public void start(Stage stage)
    {
        //this is the class to contain the bikes. The parameter represents the maximum number of bikes
        hList = new HallList(100);
        //create horizontal boxes for the student details
       HBox studentInfo = new HBox (10);

 
       // add components to HBoxe
       studentInfo.getChildren().addAll(studentDetails,firstNameLabel,NameField,sectSeparator,secondName,secondNameField,sectSeparator2,genderLable,genderField,sectSeparator3,vegan,veganField,sectSeparator4,disabledLable,disabledField,sectSeparator5,submit);
       
       
       // create VBox
       VBox root = new VBox(10);
       // add all components to VBox
       root.getChildren().addAll(studentDetails,firstNameLabel,NameField,sectSeparator,secondName,secondNameField,sectSeparator2,genderLable,genderField,sectSeparator3,vegan,veganField,sectSeparator4,disabledLable,disabledField,sectSeparator5,outputResults,submit);
       // create the scene
       Scene scene = new Scene(root, Color.web("#ffd9b3"));
        
	// set font of heading
       Font font = new Font("Vedana", 40);
       title.setFont(font);
       font = new Font("Vedana", 20);
       studentDetails.setFont(font);

       
       
 	// set alignment of HBoxes
       studentInfo.setAlignment(Pos.CENTER);
       submit.setAlignment(Pos.CENTER);

       // set alignment and Colour of  VBox 
       root.setAlignment(Pos.CENTER);
       root.setBackground(Background.EMPTY); 
       // set minimum and maximum width of components 

        
       outputResults.setMaxSize(1920, 1080);

         
       stage.setWidth(WIDTH);
       stage.setHeight(HEIGHT);    

       // call private methods for button event handlers
       submit.setOnAction(e -> addHandler());
       
       stage.setScene(scene);
		stage.setTitle("Hall room booking system");
       stage.show(); 
    
    }


    
/*
method to add a new student to one of the various rooms
*/
    private void addHandler()
    {
       
        String Fname =  NameField.getText();
        String Lname =  secondNameField.getText();
        String Gender =  genderField.getText();
        String Vegan =  veganField.getText();
        String Disabled =  disabledField.getText();
        // check for errors
        if(Fname.length()== 0 ||Lname.length()== 0 || Gender.length()== 0 || Disabled.length()== 0) 
        {
            outputResults.setText ("You must enter your Given and family name as well as stating if you are vegan and have a disability or not");
        } 
        else  // ok to add a Tenant
        {
            Student StudentRoomOwner =  new Student(Fname,Lname,Gender,Vegan,Disabled);
            hList.addRoomOwner(StudentRoomOwner);
            //clear the fields
            NameField.setText("");
            secondNameField.setText("");
            genderField.setText("");
            veganField.setText("");
            disabledField.setText("");
            outputResults.appendText(Fname + " you have been succesfully been booked in ");
            outputResults.appendText("\n\n The students booked in currently are ");
            outputResults.appendText(hList.displayVegans());
            outputResults.appendText(hList.displayDisabled());
            outputResults.appendText(hList.displayStudents());
            
        }
      
    }
    
    
    public static void main(String[] args)
    {
        launch(args);
    }

}

