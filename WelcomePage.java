package application;

import java.io.FileNotFoundException;
import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class WelcomePage extends Application
{	
	// variables for GUI
	private static Stage window;
	private static Scene welcomeLogin, createAccount, employeeHome, patientHome, vitals, personalInfo, physicalExam, doctorNotes, makePrescription;
	
	// variables for data manipulation
	private String inputUsername;
	private String inputPassword;
	private int loginIndex = -1;
	private Patient[] patients = new Patient[20];
	private Patient[] practisePatients = new Patient[10];
	private Patient[] seussPatients = new Patient[10];
	private Doctor drPractise;
	private Doctor drSeuss;
	private Doctor fakeDoctor;
	
	
	
	public void start(Stage primaryStage) throws FileNotFoundException
	{		
		// GUI CODE --------------------------------------------------------------------------------------------------------------------------
		// save primary stage
		window = primaryStage;
	
		// maximize screen
		Screen screen = Screen.getPrimary();
		Rectangle2D bounds = screen.getVisualBounds();
		window.setX(bounds.getMinX());
		window.setY(bounds.getMinY());
		window.setWidth(bounds.getWidth());
		window.setHeight(bounds.getHeight());
		
		// declare panes
		LoginPane pane1 = new LoginPane();
		CreateAccount pane2 = new CreateAccount();
		EmployeeHome pane3 = new EmployeeHome();
		PatientHome pane4 = new PatientHome();
		Vitals pane5 = new Vitals();
		PersonalInfo pane6 = new PersonalInfo();
		PhysicalExamination pane7 = new PhysicalExamination();
		DoctorNotes pane8 = new DoctorNotes();
		MakePrescription pane9 = new MakePrescription();
		
		
		// add each pane to scene
		welcomeLogin = new Scene(pane1, 700, 1000);
		createAccount = new Scene(pane2, 700, 1000);
		employeeHome = new Scene(pane3, 700, 1000);
		patientHome = new Scene(pane4, 700, 1000);
		vitals = new Scene(pane5, 700, 1000);
		personalInfo = new Scene(pane6, 700, 1000);
		physicalExam = new Scene(pane7, 700, 1000);
		doctorNotes = new Scene(pane8, 700, 1000);
		makePrescription = new Scene(pane9, 700, 1000);
		
		// add css stylesheet to each scene
		welcomeLogin.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
		createAccount.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
		employeeHome.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
		patientHome.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
		vitals.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
		personalInfo.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
		physicalExam.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
		doctorNotes.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
		makePrescription.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
		
		// set title of window
		window.setTitle("https://www.totallyNormalDoctorsOffice.com");
				
		// set scene to stage
		window.setScene(welcomeLogin);
		window.show();
		
		// DATA MANIPULATION CODE --------------------------------------------------------------------------------------------------------------------------
		// define doctors
		drPractise = new Doctor("Mal Practise", "#1doctor", "password", practisePatients, 100, null);
		drSeuss = new Doctor("Harold Seuss", "#2doctor", "greeneggsandham", seussPatients, 101, null);
		fakeDoctor = new Doctor("fakeDoctor", "fake", "doctor", patients, 200, null);
		
		// set all patient objects to null
		for(int i = 0; i < patients.length; i++) 
		{
			patients[i] = new Patient(null, null, null, 0, null, null, null, null, null, null, null, null, fakeDoctor, null, null);
		}
		
		for(int i = 0; i < practisePatients.length; i++) 
		{
			practisePatients[i] = new Patient(null, null, null, 0, null, null, null, null, null, null, null, null, drPractise, null, null);
			seussPatients[i] = new Patient(null, null, null, 0, null, null, null, null, null, null, null, null, drSeuss, null, null);
		}
		
	}
	
	// main method
	public static void main(String[] args)
	{
		Application.launch(args);
	}
	
	// get primary stage
	public static Stage getStage()
	{
		return window;
	}
	
	// get welcome scene
	public static Scene getWelcomeLogin()
	{
		return welcomeLogin;
	}
	
	// get create account scene
	public static Scene getCreateAccount()
	{
		return createAccount;
	}
	
	// get employee home scene
	public static Scene getEmployeeHome()
	{
		return employeeHome;
	}
	
	// get patient home scene
	public static Scene getPatientHome()
	{
		return patientHome;
	}
	
	// get vitals scene
	public static Scene getVitals()
	{
		return vitals;
	}
	
	// get personal patient info scene 
	public static Scene getPersonalInfo()
	{
		return personalInfo;
	}
	
	// get physical exam scene
	public static Scene getPhysical()
	{
		return physicalExam;
	}
	
	// get doctor's notes scene
	public static Scene getDoctorNotes()
	{
		return doctorNotes;
	}
	
	// get make prescription scene
	public static Scene getMakePrescription()
	{
		return makePrescription;
	}

}
