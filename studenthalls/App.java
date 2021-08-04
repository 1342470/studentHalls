package com.mycompany.studenthalls;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
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
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class App extends Application implements Serializable {

    private HallList hList;
    private final int WIDTH = 1200;
    private final int HEIGHT = 1000;
    private Label title = new Label("Please enter your Details");
    private Label studentDetails = new Label("Hall bookings");
    private Label firstNameLabel = new Label("First Name");
    private TextField NameField = new TextField();
    private Separator sectSeparator = new Separator();
    private Label secondName = new Label("Second Name");
    private TextField secondNameField = new TextField();
    private Separator sectSeparator2 = new Separator();
    private Label genderLable = new Label("Gender");
    private TextField genderField = new TextField();
    private Separator sectSeparator3 = new Separator();
    private Label vegan = new Label("Vegan");
    private TextField veganField = new TextField();
    private Separator sectSeparator4 = new Separator();
    private Label disabledLable = new Label("Disabled?");
    private TextField disabledField = new TextField();
    private Separator sectSeparator5 = new Separator();
    private Label StaffLable = new Label("Staff?");
    private TextField staffField = new TextField();
    private Separator sectSeparator6 = new Separator();
    public TextArea outputResults = new TextArea();
    private Button submit = new Button("Book room");
    private Button viewResults = new Button("View number of rooms left to book");
    private Button saveData = new Button("Save data");
    private Button loadData = new Button("Load data");
    private Button showVegans = new Button("Show booked vegan catering rooms");
    private Button showDisabled = new Button("Show booked disabled caterting rooms ");
    private Button showStudents = new Button("Show standered booked rooms");
    private Button clear = new Button("Clear all text in text box");
    private Button staff = new Button("Show booked staff");
    private Button help = new Button("Help");



    /**
     * used to create the layout of the UI and all elements such as the textboxs, buttons and lables 
     * @param stage used to display all elements within boxx teh hbox and the vbox
     */
    public void start(Stage stage) {
        stage.setTitle("Student Halls room booking system");
        hList = new HallList(100);
        submit.setMaxWidth(250);
        viewResults.setMaxWidth(250);
        saveData.setMaxWidth(250);
        loadData.setMaxWidth(250);
        showVegans.setMaxWidth(250);
        showDisabled.setMaxWidth(250);
        showStudents.setMaxWidth(250);
        clear.setMaxWidth(250);
        staff.setMaxWidth(250);
        help.setMaxWidth(250);


        GridPane gridPane = new GridPane();
        gridPane.add(submit, 0, 0, 1, 1);
        gridPane.add(viewResults, 1, 0, 1, 1);
        gridPane.add(saveData,2,0,1,1 );
        gridPane.add(loadData,0,1,1,1 );
        gridPane.add(showVegans,1,1,1,1 );
        gridPane.add(showDisabled,2,1,1,1);
        gridPane.add(showStudents,0,2,1,1 );
        gridPane.add(clear,1,2,1,1 );
        gridPane.add(staff,2,2,1,1 );
        gridPane.add(help,1,3,1,1);
        
        
        hList = new HallList(100);
        HBox studentInfo = new HBox(10);
        studentInfo.getChildren().addAll(studentDetails, firstNameLabel, NameField, sectSeparator, secondName, secondNameField, sectSeparator2, genderLable, genderField, sectSeparator3, vegan, veganField, sectSeparator4, disabledLable, disabledField, sectSeparator5,StaffLable,staffField,sectSeparator6,gridPane);
        
        VBox root = new VBox(10);
        root.getChildren().addAll(studentDetails, firstNameLabel, NameField, sectSeparator, secondName, secondNameField, sectSeparator2, genderLable, genderField, sectSeparator3, vegan, veganField, sectSeparator4, disabledLable, disabledField, sectSeparator5,StaffLable,staffField,sectSeparator6, outputResults,gridPane);
        


        
       
        

        Font font = new Font("Vedana", 40);
        title.setFont(font);
        font = new Font("Vedana", 20);
        studentDetails.setFont(font);

        studentInfo.setAlignment(Pos.CENTER);
        submit.setAlignment(Pos.CENTER);

        root.setAlignment(Pos.CENTER);
        gridPane.setAlignment(Pos.CENTER);
                
                
        root.setBackground(Background.EMPTY);
        
        outputResults.setMaxSize(1920, 1080);
        outputResults.appendText("Welcome please enter the details your details in the form above, if you require anymore assistances please use the help button below, Once finished reading please press the Clear all text in text box button.");

        stage.setWidth(WIDTH);
        stage.setHeight(HEIGHT);

        submit.setOnAction(e -> addHandler());
        viewResults.setOnAction(e -> viewRemaidingRooms());
        showVegans.setOnAction(e -> outputResults.appendText("Currently in the vegan halls their are " + hList.displayVegans()));
        showDisabled.setOnAction(e -> outputResults.appendText("Currently in the Disabled halls their are " +hList.displayDisabled()));
        showStudents.setOnAction(e -> outputResults.appendText("Currently in the student halls their are " +hList.displayStudents()));
        staff.setOnAction(e -> outputResults.appendText("Currently in the staff halls their are " +hList.displayStaff()));
        clear.setOnAction(e -> outputResults.setText(""));
        help.setOnAction(e -> outputResults.setText("In order to book a room please use the form above to enter your First and Second name was well as stating you gender,if you are Vegan,Disabed, or a Staff member. For the Vegan, Disabed or Staff please enter either Yes or No in this fields. Once finsihed use the Book Room button to sumbit your deails. the View number of rooms left to book simply shows you the current amout of rooms left that are able to book. the show X rooms button show a list of all the currently booked in students/staff in the button respective rooms. The clear text button is used for if you find that the message box is getting too cluttered. Once finished reading please press the Clear all text in text box button."));
        saveData.setOnAction(e -> {
            try {
                saveData();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });;
        loadData.setOnAction(e -> {
            try {
                LoadData();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });;

        

         Scene scene = new Scene(root, Color.web("#ffd9b3"));
        stage.setScene(scene);
        stage.setMaximized(true);
        stage.show();

    }

    /**
     * method that takes user input and checks if all of fields have been filled
     * out if not it will create a new student depending on what the user inputs
     * a method in the halllist will put the created student into one of three
     * arrays basted of if they put they were vegan or were disabled. finally if
     * succesfull it will inform the user that it was succesfull and output all
     * currect students.
     */
    private void addHandler() {
        String Fname = NameField.getText();
        String Lname = secondNameField.getText();
        String Gender = genderField.getText();
        String Vegan = veganField.getText();
        String Disabled = disabledField.getText();
        String Staff = staffField.getText();
        // check for errors
        if (Fname.length() == 0 || Lname.length() == 0 || Gender.length() == 0 || Disabled.length() == 0 || Staff.length() == 0 ) {
            outputResults.setText("You must enter your Given and family name as well as stating if you are vegan, a staff member or have a disability or not");
        } else if (!(Vegan.equals("Yes") || (Vegan.equals("yes")) || (Vegan.equals("No")) || (Vegan.equals("no")))) {
            outputResults.setText("You must enter if you are vegan if you are please enter yes or no if you are not");
        }else if (!(Disabled.equals("Yes") || (Disabled.equals("yes")) || (Disabled.equals("No")) || (Disabled.equals("no")))) {
            outputResults.setText("You must enter if you have disability or not if you are please enter yes or no if you are not");
        }else if(Staff.equals("Yes") || Staff.equals("YES")){
        Employee RoomOwner = new Employee(Fname, Lname, Gender, Vegan, Disabled, Staff);
            hList.addRoomOwner(RoomOwner);
            //clear the fields
            NameField.setText("");
            secondNameField.setText("");
            genderField.setText("");
            veganField.setText("");
            disabledField.setText("");
            staffField.setText("");
            outputResults.appendText(Fname + " You have been succesfully been booked in ");
            outputResults.appendText("\n\n Booked in currently are ");
            outputResults.appendText(hList.displayVegans());
            outputResults.appendText(hList.displayDisabled());
            outputResults.appendText(hList.displayStudents());
            outputResults.appendText(hList.displayStaff());
        }
        else // ok to add a Tenant
        {
            Student StudentRoomOwner = new Student(Fname, Lname, Gender, Vegan, Disabled,Staff);
            hList.addRoomOwner(StudentRoomOwner);
            //clear the fields
            NameField.setText("");
            secondNameField.setText("");
            genderField.setText("");
            veganField.setText("");
            disabledField.setText("");
            staffField.setText("");
            outputResults.appendText(Fname + " You have been succesfully been booked in ");
            outputResults.appendText("\n\n Booked in currently are ");
            outputResults.appendText(hList.displayVegans());
            outputResults.appendText(hList.displayDisabled());
            outputResults.appendText(hList.displayStudents());
            outputResults.appendText(hList.displayStaff());
            

        }

    }

    /**
     * show how many rooms are left to book
     */
    public void viewRemaidingRooms() {

        int remained = hList.MAX - hList.numOfBookedStudents();

        String s = String.valueOf(remained);

        outputResults.appendText("the number of remainding rooms left are " + s);

    }


    /**
     * allows the all data send to the hlist to be saved to a file
     * @throws IOException
     */
    public void saveData() throws IOException {
        hList.saveData();
       outputResults.appendText("Serialized data is saved in ./BookedData.txt file");
    }
    /**
     * allows the data to be loaded from a file
     * @throws IOException 
     */
    public void LoadData() throws IOException {
       hList.loadData();
       outputResults.appendText("Data has been loaded from the BookedData.txt file");
    }

    /**
     * setter at for the ouptputresults Text area
     *
     * @param outputResults takes the value that would be set for output restuls
     */
    public void setOutputResults(TextArea outputResults) {
        this.outputResults = outputResults;
    }

    public static void main(String[] args) {
        launch(args);
    }
    


}
