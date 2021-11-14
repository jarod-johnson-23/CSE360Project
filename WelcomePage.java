package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
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
	private static String nameToSave;
	private static int loginIndex = -1;
	private static Patient[] patients = new Patient[20];
	private static Patient[] practisePatients = new Patient[20];
	private static Patient[] seussPatients = new Patient[20];
	private static Doctor drPractise;
	private static Doctor drSeuss;
	private Doctor fakeDoctor;
	private static ObservableList<String> items = FXCollections.<String>observableArrayList();
	private static ListView<String> patientNames = new ListView<String>();
		
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
			patients[i] = new Patient(null, null, null, 0, null, null, null, null, null, null, null, fakeDoctor, null, null);
			}
		
		for(int i = 0; i < practisePatients.length; i++) 
		{
			practisePatients[i] = new Patient(null, null, null, 0, null, null, null, null, null, null, null, drPractise, null, null);
			seussPatients[i] = new Patient(null, null, null, 0, null, null, null, null, null, null, null, drSeuss, null, null);
		}
		
		// input file initialized
		File dataFile = new File("dataFile.txt");
		Scanner scan = new Scanner(dataFile);
		String tempStr;
		int choice;
		int importIndex = 0;
		int stop = 0;

		/*
		 * Each patient object is stored line-by-line in this order:
		 * 1) A number to indicate if it is a patient object or not
		 * 2) First name
		 * 3) Middle name
		 * 4) Last name
		 * 5) Age
		 * 6) Birthday
		 * 7) gender
		 * 8) address
		 * 9) phone number
		 * 10) email
		 * 11) pharmacy
		 * 12) a integer where 10 means the doctor is Dr.practise, and 20 means Dr. Seuss
		 * 13) user name
		 * 14) password
		 * 15) the rest of the lines are health concerns, the health concerns end when "end" is found
		 * 
		 */
		
		if (dataFile.exists()) 
		{
			System.out.println("File name: " + dataFile.getName());
		    System.out.println("Writeable: " + dataFile.canWrite());
		    System.out.println("Readable " + dataFile.canRead());
		    System.out.println("File size in bytes " + dataFile.length());
			
		    do 
		    {
				choice = Integer.parseInt(scan.nextLine());

				if(choice == 0) {
					stop = 0;
					tempStr = scan.nextLine();
					if(tempStr.equals("null"))
						tempStr = null;
					patients[importIndex].setFName(tempStr);
					tempStr = scan.nextLine();
					if(tempStr.equals("null"))
						tempStr = null;
					patients[importIndex].setMName(tempStr);
					tempStr = scan.nextLine();
					if(tempStr.equals("null"))
						tempStr = null;
					patients[importIndex].setLName(tempStr);
					patients[importIndex].setAge(Integer.parseInt(scan.nextLine()));
					tempStr = scan.nextLine();
					if(tempStr.equals("null"))
						tempStr = null;
					patients[importIndex].setBday(tempStr);
					tempStr = scan.nextLine();
					if(tempStr.equals("null"))
						tempStr = null;
					patients[importIndex].setGender(tempStr);
					tempStr = scan.nextLine();
					if(tempStr.equals("null"))
						tempStr = null;
					patients[importIndex].setAddr(tempStr);
					tempStr = scan.nextLine();
					if(tempStr.equals("null"))
						tempStr = null;
					patients[importIndex].setPhone(tempStr);
					tempStr = scan.nextLine();
					if(tempStr.equals("null"))
						tempStr = null;
					patients[importIndex].setEmail(tempStr);
					tempStr = scan.nextLine();
					if(tempStr.equals("null"))
						tempStr = null;
					patients[importIndex].setPharmacy(tempStr);
					if(Integer.parseInt(scan.nextLine()) == 10) {
						patients[importIndex].setDoctor(drPractise);
					} else {
						patients[importIndex].setDoctor(drSeuss);
					}
					tempStr = scan.nextLine();
					if(tempStr.equals("null"))
						tempStr = null;
					patients[importIndex].setUsername(tempStr);
					tempStr = scan.nextLine();
					if(tempStr.equals("null"))
						tempStr = null;
					patients[importIndex].setPassword(tempStr);
					do {
						tempStr = scan.nextLine();

						if(tempStr.equals("end") == false) {

							patients[importIndex].addIssue(tempStr);

						}
					} while(tempStr.equals("end") == false);

				} 
				if(patients[importIndex].getDoctor() == drPractise) {
					drPractise.addPatient(patients[importIndex]);
				} else {
					drSeuss.addPatient(patients[importIndex]);
				}

				importIndex++;
			} while(scan.hasNextLine());

		} else {
			System.out.println("Doesnt exist");
		}
		System.out.println(patients[0].getIssue(0));
		System.out.println(patients[0].getIssue(1));
		System.out.println(patients[0].getIssue(2));
		System.out.println(patients[0].getIssue(3));
		scan.close();

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
	
	// get patients array
	public static Patient[] getPatients()
	{
		return patients;
	}
	
	// get practise patients array
	public static Patient[] getPractisePatients()
	{
		return practisePatients;
	}
	
	// get seuss patients array
	public static Patient[] getSeussPatients()
	{
		return seussPatients;
	}
	
	// get dr.seuss 
	public static Doctor getSeuss()
	{
		return drSeuss;
	}
	
	// get dr.practise 
	public static Doctor getPractise()
	{
		return drPractise;
	}
	
	// close GUI window
	public static void closeWindow()
	{
		window.close();
	}

	// logout from employee account
	public static void logoutEmp()
	{
		window.setScene(welcomeLogin);
		
		if(loginIndex >= 100) {
			//items.clear();
		}
		
		loginIndex = -1;
	}
	
	// logout from patient account
	public static void logoutPat()
	{
		window.setScene(welcomeLogin);
		
		loginIndex = -1;
	}
	
	// add patient to next spot in array
	public static int addPatient(String first, String middle, String last, String birth, String gen,
			String addr, String number, String emailAddr, String pharm, String issues, Doctor aDoctor, 
			String uName, String pWord) 
	{
		int i = 0;
		
		while(patients[i].getFName() != null) 
		{
			i++;
			
			if(i >= patients.length) 
			{
				return -1;
			}
		}
		
		patients[i].setFName(first);
		patients[i].setMName(middle);
		patients[i].setLName(last);
		patients[i].setBday(birth);
		patients[i].setGender(gen);
		patients[i].setAddr(addr);
		patients[i].setPhone(number);
		patients[i].setEmail(emailAddr);
		patients[i].setPharmacy(pharm);
		patients[i].setUsername(uName);
		patients[i].setPassword(pWord);
		patients[i].addIssue(issues);
		
		System.out.println(issues);
		
		patients[i].setDoctor(aDoctor);
		
		int j = 0;
		
		if(aDoctor == drPractise) 
		{
			while(practisePatients[j].getFName() != null) 
			{
				j++;
			}
			
			practisePatients[j] = patients[i];
			
			return 0;
		} 
		else 
		{
			while(seussPatients[j].getFName() != null) 
			{
				j++;
			}
			
			seussPatients[j] = patients[i];
			
			return 0;
		}
	}
	
	//function checks if the login information is  a valid username. Returning 100 means it was Dr. Practise,
	//	 returning 101 means it was Dr. Seuss, returning >=102 means it is a nurse, returning a number 0-99 means it is a patient.
	public static int checkLogin(String username, String password) {
		
		if(username.equals(drPractise.getUsername()) && password.equals(drPractise.getPassword())) 
		{
			return 100;
		} 
		else if(username.equals(drSeuss.getUsername()) && password.equals(drSeuss.getPassword())) 
		{
			return 101;
		} 
		else if(username.equals("nurseUsername") && password.equals("nursePassword")) 
		{
			return 102;
		} 
		else 
		{
			for(int i = 0; i < patients.length; i++) 
			{
				if((username.equals(patients[i].getUsername()) == true) && (password.equals(patients[i].getPassword()) == true)) 
				{
					return i;
				}
			}
		}
		
		return -1;
	}
	
	// adjust login index
	public static void changeLoginIndex(int i)
	{
		loginIndex = i;
		
	}
	
	// store current logged in patient/doctor/nurse name
	public static void saveName(String name)
	{
		nameToSave = name;
	}
	
	// get current logged in patient/doctor/nurse name
	public static String getName()
	{
		return nameToSave;
	}
	
	// add items to patient list on employee home page
	public static void addItemsToPList(String name)
	{
		items.add(name);
	}
	
	// get items from observable list containing patients on employee home page
	public static ObservableList<String> getItemsFromEmpPage()
	{
		return items;
	}
	
	// set patient names in employee home page
	public static void setPatientNamesInEmp(ObservableList<String> names)
	{
		patientNames.setItems(names);
	}
	
	// get patient names in employee home page
	public static ListView<String> getPatientNamesInEmp()
	{
		return patientNames;
	}
	
}
