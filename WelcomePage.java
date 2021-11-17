package application;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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
	private static Scene welcomeLogin, createAccount, employeeHome, patientHome, vitals, personalInfo, physicalExam, doctorNotes, makePrescription, information, messagePortal, pastVisits, scheduleAVisit;
	
	// variables for data manipulation
	private String inputUsername;
	private String inputPassword;
	private static String nameToSave;
	private static int loginIndex = -1;
	private static Patient[] patients = new Patient[20];
	private static Patient[] practisePatients = new Patient[20];
	private static Patient[] seussPatients = new Patient[20];
	private static Nurse[] nurses = new Nurse[20];
	private static Doctor drPractise;
	private static Doctor drSeuss;
	private Doctor fakeDoctor;
	private static ObservableList<String> items = FXCollections.<String>observableArrayList();
	private static ListView<String> patientNames = new ListView<String>();
	private static List<Message> messages = new ArrayList<Message>();
	private static Patient patientLoggedIn = new Patient("", "", "", 0, "", "", "", "", "", "", null, null, null, null, "", "");
	private static Nurse nurseLoggedIn = new Nurse(null, null, null, null, null, null);
	private static Doctor doctorLoggedIn = new Doctor("Mal Practise", "#1doctor", "password", practisePatients, 100, null);
	private static int loginFlag = 3; // 0 for patient, 1 for doctor, 2 for nurse, 3 for startup
	private static Patient selectedPatientEmp;
	
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
		PatientInformation pane10 = new PatientInformation();
		PatientMessages pane11 = new PatientMessages();
		PatientPastVisits pane12 = new PatientPastVisits();
		PatientScheduleVisit pane13 = new PatientScheduleVisit();
		
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
		information = new Scene(pane10, 700, 1000);
		messagePortal = new Scene(pane11, 700, 1000);
		pastVisits = new Scene(pane12, 700, 1000);
		scheduleAVisit = new Scene(pane13, 700, 1000);
		
		
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
		information.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
		messagePortal.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
		pastVisits.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
		scheduleAVisit.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
		
		
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
			patients[i] = new Patient("-", "-", "-", 0, "-", "-", "-", "-", "-", "-", null, null, null, fakeDoctor, "-", "-");
		}
		
		for(int i = 0; i < practisePatients.length; i++) 
		{
			practisePatients[i] = new Patient("-", "-", "-", 0, "-", "-", "-", "-", "-", "-", null, null, null, drPractise, "-", "-");
			seussPatients[i] = new Patient("-", "-", "-", 0, "-", "-", "-", "-", "-", "-", null, null, null, drSeuss, "-", "-");
		}
		
		
		for(int i = 0; i < nurses.length; i++) {
			nurses[i] = new Nurse("-", "-", "-", "-", "-", null);
		}
		
		// input file initialized
		File dataFile = new File("dataFile.txt");
		Scanner scan = new Scanner(dataFile);
		String tempStr;
		String reciever;
		String sender;
		String subject;
		String body;
		int choice;
		int importIndex = 0;
		int nurseIndex = 0;

		/*
		 * Each patient object is stored line-by-line in this order:
		 * 1) A 0 to indicate it is a patient object
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
		 * Each message object is stored like so:
		 * 1) A 1 to indicate it is a message
		 * 2) The recipient of the message
		 * 3) The subject line
		 * 4) A body of text
		 * 5) The sender of the email
		 * 
		 * Each nurse object is stored like so:
		 * 1) A 2 to indicate it is a nurse
		 * 2) First name
		 * 3) Last name
		 * 4) username
		 * 5) password
		 * 6) email
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
					tempStr = scan.nextLine();
					if(tempStr.equals("null"))
						tempStr = "-";
					patients[importIndex].setFName(tempStr);
					tempStr = scan.nextLine();
					if(tempStr.equals("null"))
						tempStr = "-";
					patients[importIndex].setMName(tempStr);
					tempStr = scan.nextLine();
					if(tempStr.equals("null"))
						tempStr = "-";
					patients[importIndex].setLName(tempStr);
					patients[importIndex].setAge(Integer.parseInt(scan.nextLine()));
					tempStr = scan.nextLine();
					if(tempStr.equals("null"))
						tempStr = "-";
					patients[importIndex].setBday(tempStr);
					tempStr = scan.nextLine();
					if(tempStr.equals("null"))
						tempStr = "-";
					patients[importIndex].setGender(tempStr);
					tempStr = scan.nextLine();
					if(tempStr.equals("null"))
						tempStr = "-";
					patients[importIndex].setAddr(tempStr);
					tempStr = scan.nextLine();
					if(tempStr.equals("null"))
						tempStr = "-";
					patients[importIndex].setPhone(tempStr);
					tempStr = scan.nextLine();
					if(tempStr.equals("null"))
						tempStr = "-";
					patients[importIndex].setEmail(tempStr);
					tempStr = scan.nextLine();
					if(tempStr.equals("null"))
						tempStr = "-";
					patients[importIndex].setPharmacy(tempStr);
					if(Integer.parseInt(scan.nextLine()) == 10) {
						patients[importIndex].setDoctor(drPractise);
					} else {
						patients[importIndex].setDoctor(drSeuss);
					}
					tempStr = scan.nextLine();
					if(tempStr.equals("null"))
						tempStr = "-";
					patients[importIndex].setUsername(tempStr);
					tempStr = scan.nextLine();
					if(tempStr.equals("null"))
						tempStr = "-";
					patients[importIndex].setPassword(tempStr);
					do {
						tempStr = scan.nextLine();

						if(tempStr.equals("end") == false) {

							patients[importIndex].addIssue(tempStr);

						}
					} while(tempStr.equals("end") == false);
					if(patients[importIndex].getDoctor() == drPractise) {
						drPractise.addPatient(patients[importIndex]);
					} else if(patients[importIndex].getDoctor() == drSeuss && patients[importIndex].getFName() != null){
						drSeuss.addPatient(patients[importIndex]);
					}
					
					importIndex++;

				} else if(choice == 1) {
					reciever = scan.nextLine();
					subject = scan.nextLine();
					body = scan.nextLine();
					sender = scan.nextLine();
					int patIndex = 999;
					for(int i = 0; i < patients.length; i++) {
						if(patients[i].getFName() != null) {
							if(patients[i].concatenateNames().equalsIgnoreCase(sender)) {
								patIndex = i;
							}
						}
					}
					if(patIndex != 999) {
						messages.add(new Message(reciever, subject, body, patients[patIndex]));
					}
				} else if(choice == 2) {
					tempStr = scan.nextLine();
					if(tempStr.equals("null"))
						tempStr = null;
					nurses[nurseIndex].setFName(tempStr);
					tempStr = scan.nextLine();
					if(tempStr.equals("null"))
						tempStr = null;
					nurses[nurseIndex].setLName(tempStr);
					tempStr = scan.nextLine();
					if(tempStr.equals("null"))
						tempStr = null;
					nurses[nurseIndex].setUsername(tempStr);
					tempStr = scan.nextLine();
					if(tempStr.equals("null"))
						tempStr = null;
					nurses[nurseIndex].setPassword(tempStr);
					tempStr = scan.nextLine();
					if(tempStr.equals("null"))
						tempStr = null;
					nurses[nurseIndex].setEmail(tempStr);
					
					nurseIndex++;
				}
				
			} while(scan.hasNextLine());

		} else {
			System.out.println("Doesnt exist");
		}
		
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
	
	// get patient info scene
	public static Scene getInformation()
	{
		return information;
	}
	
	// get patient messages scene
	public static Scene getMessagePortal()
	{
		return messagePortal;
	}
	
	// get patient past visits scene
	public static Scene getPastVisits()
	{
		return pastVisits;
	}
	
	// get patient schedule a visit scene
	public static Scene getScheduleAVisit()
	{
		return scheduleAVisit;
	}
	
	
	// get patients array
	public static Patient[] getPatients()
	{
		return patients;
	}
	
	// get practise patients array
	public static Patient[] getPractisePatients()
	{
		int index1 = 0;
		for(int i = 0; i < patients.length; i++) {
			if(patients[i].getDoctor() == drPractise) {
				practisePatients[index1] = patients[i];
				index1++;
			}
		}
		return practisePatients;
	}
	
	// get seuss patients array
	public static Patient[] getSeussPatients()
	{
		int index1 = 0;
		for(int i = 0; i < patients.length; i++) {
			if(patients[i].getDoctor() == drSeuss) {
				seussPatients[index1] = patients[i];
				index1++;
			}
		}
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
		//window.setScene(welcomeLogin);
		
		if(loginIndex >= 100) {
			items.clear();
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
		Scanner parse = new Scanner(issues);
		parse.useDelimiter(",");
		
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
		
		while(parse.hasNext()) {
			patients[i].addIssue(parse.next());
		}
		
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

	// get patient names in employee home page for doctor
	public static ListView<String> getPatientNamesInEmpDoc(Doctor doctor)
	{
		// reset list
		items.clear();
		
		System.out.println("# of patients for doctor = " + doctor.getPatientArraySize());

		// add patients to list
		for (int i = 0; i < doctor.getPatients().length; i++)
		{			
			if (doctor.getPatients()[i] != null)
			{
				items.add(doctor.getPatients()[i].concatenateNames());
			}
			
		}
				
		patientNames.getItems().clear();
		patientNames.setItems(items);
		
		return patientNames;
	}
	
	// get patient names in employee home page for doctor
	public static ListView<String> getPatientNamesInEmpNurse(Nurse nurse)
	{
		// reset list
			items.clear();
			
		// add patients to list
		for (int i = 0; i < patients.length; i++)
		{
			if (patients[i].getFName() != null)
			{
				items.add(patients[i].concatenateNames());
			}
		}
		
		patientNames.setItems(items);
		
		return patientNames;
	}
	
	public static void saveData() 
	{
		try {
			FileWriter outFile = new FileWriter("dataFile.txt");
			BufferedWriter output = new BufferedWriter(outFile);
			
			for(int i = 0; i < patients.length; i++) {
				int index = 0;
				
				output.write("0\n");
				output.write(patients[i].getFName() + "\n");
				output.write(patients[i].getMName() + "\n");
				output.write(patients[i].getLName() + "\n");
				output.write(patients[i].getAge() + "\n");
				output.write(patients[i].getBday() + "\n");
				output.write(patients[i].getGender() + "\n");
				output.write(patients[i].getAddress() + "\n");
				output.write(patients[i].getPhoneNumber() + "\n");
				output.write(patients[i].getEmail() + "\n");
				output.write(patients[i].getPharmacy() + "\n");
				if(patients[i].getDoctor() == drPractise) {
					output.write("10\n");
				} else {
					output.write("20\n");
				}
				output.write(patients[i].getUsername() + "\n");
				output.write(patients[i].getPassword() + "\n");
				while(patients[i].getIssue(index) != null) {
					output.write(patients[i].getIssue(index) + "\n");
					index++;
				}
				
				output.write("end\n");
				
			}
			
			for(int i = 0; i < messages.size(); i++) {
				output.write("1\n");
				output.write(messages.get(i).getMessage_receiver() + "\n");
				output.write(messages.get(i).getSubject_line() + "\n");
				output.write(messages.get(i).getText() + "\n");
				output.write(messages.get(i).get_sender().concatenateNames() + "\n");
				
			}
			
			for(int i = 0; i < nurses.length; i++) {
				output.write("2\n");
				output.write(nurses[i].getFName() + "\n");
				output.write(nurses[i].getLName() + "\n");
				output.write(nurses[i].getUsername() + "\n");
				output.write(nurses[i].getPassword() + "\n");
				output.write(nurses[i].getEmail() + "\n");
				
			}
			
			output.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		window.close();
	}
	
	// save logged in doctor
	public static void saveLoggedInDoctor(Doctor doctor)
	{
		doctorLoggedIn = doctor;
		loginFlag = 1;
	}
	
	// save logged in nurse
	public static void saveLoggedInNurse(Nurse nurse)
	{
		nurseLoggedIn = nurse;
		loginFlag = 2;
	}
	
	// save logged in patient
	public static void saveLoggedInPatient(Patient patient)
	{
		patientLoggedIn = patient;
		loginFlag = 0;
	}
	
	// get logged in doctor
	public static Doctor getLoggedInDoctor()
	{
		return doctorLoggedIn;
	}
	
	// get logged in nurse
	public static Nurse getLoggedInNurse()
	{
		return nurseLoggedIn;
	}
	
	// get logged in patient
	public static Patient getLoggedInPatient()
	{
		return patientLoggedIn;
	}
		
	// get patient info from user name and password
	public static Patient getPatientInfo(String username, String password)
	{
		// declare variables
		Patient patient = new Patient(null, null, null, 0, null, null, null, null, null, null, null, null, null, null, null, null);

		// check patient information 
		for (int i = 0; i < patients.length; i++)
		{
			if (patients[i].getUsername().equals(username) && patients[i].getPassword().equals(password))
			{
				return patients[i];
			}
		}
		
		return patient;
		
	}
	
	// get nurse info from user name and password
	public static Nurse getNurseInfo(String username, String password)
	{
		// declare variables
		Nurse nurseTemp = new Nurse(null, null, null, null, null, null);

		// check nurse information
		for (int i = 0; i < nurses.length; i++)
		{
			if (nurses[i].getUsername().equals(username) && nurses[i].getPassword().equals(password)) 
			{
				return nurses[i];
			}
		}
		
		return nurseTemp;
	}
	
	// set login flag - 0 for patient, 1 for doctor, 2 for nurse
	public static void setLoginFlag(int flag)
	{
		loginFlag = flag;
	}
	
	// get login flag
	public static int getLoginFlag()
	{
		return loginFlag;
	}
	
	// set patient selected by doctor/nurse
	public static void setPatientSelection(String names)
	{
		// declare variables
		Doctor currentDoctor;
		Nurse currentNurse;
		
		// get doctor/nurse that is currently logged in
		if (loginFlag == 1)
		{
			currentDoctor = doctorLoggedIn;
			
			System.out.println("Current doctor = " + currentDoctor.getName());
			
			for (int i = 0; i < currentDoctor.getPatients().length; i++)
			{				
				if (currentDoctor.getPatients()[i] != null && currentDoctor.getPatients()[i].concatenateNames().equals(names))
				{
					selectedPatientEmp = currentDoctor.getPatients()[i];
				}
			}
		}
		else if (loginFlag == 2)
		{
			currentNurse = nurseLoggedIn;
			
			for (int i = 0; i < patients.length; i++)
			{
				if (patients[i] != null && patients[i].concatenateNames().equals(names))
				{
					selectedPatientEmp = patients[i];
				}
			}
			
		}
		
		
	}
	
	// get patient selected by doctor/nurse
	public static Patient getPatientSelected()
	{
		return selectedPatientEmp;
	}
	public static void setPatientNamesInEmp(ObservableList<String> itemsFromEmpPage) {
		// TODO Auto-generated method stub
		
	}
	
	public static int getLoginID() {
		return loginIndex;
	}
	
	public static Doctor getDoctor(int docIndex) {
		if(docIndex == 100) {
			return drPractise;
		} else {
			return drSeuss;
		}
	}
	
}
