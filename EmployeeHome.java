package application;

import java.io.FileNotFoundException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Screen;

public class EmployeeHome extends GridPane {
	
	// declare variables
	private int width = 1500;
	private int height = 1000;
	private Font titleFont;
	private Button logOut, vitals, personalInfo, physicalExamination, drNotes, makePrescription;
	private Label welcomeDr, pats, actions;
	private ListView<String> patientNames = new ListView<String>();
	
	public EmployeeHome() throws FileNotFoundException
	{
		// define font
		titleFont = new Font("Cambria", 24);
		
		Screen screen = Screen.getPrimary();
		Rectangle2D bounds = screen.getVisualBounds();
		
		// define background image
		Image defaultBgPic = new Image("file:iu-9.jpeg", width, height, false, false);
		BackgroundImage defaultImage = new BackgroundImage(defaultBgPic, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
		Background defaultBg = new Background(defaultImage);
		
		// define buttons
		logOut = new Button("Log Out");
		vitals = new Button("Vitals");
		personalInfo = new Button("Personal Information");
		physicalExamination = new Button("Physical Examination");
		drNotes = new Button("Doctor's Notes");
		makePrescription = new Button("Make Prescription");
		
		// set width of buttons
		vitals.setPrefWidth(150);
		personalInfo.setPrefWidth(150);
		physicalExamination.setPrefWidth(150);
		drNotes.setPrefWidth(150);
		makePrescription.setPrefWidth(150);

		// define labels
		welcomeDr = new Label(WelcomePage.getName());
		pats = new Label("Patients");
		actions = new Label("Please choose an action");
		
		// set font
		welcomeDr.setFont(titleFont);
				
		// get list of patients for logged in doctor
		if (WelcomePage.getLoginFlag() == 1)
		{
			System.out.println("Login flag == 1");
			System.out.println(WelcomePage.getLoggedInDoctor().getName());
			patientNames = WelcomePage.getPatientNamesInEmpDoc(WelcomePage.getLoggedInDoctor());
		}
		// get list of patients for logged in nurse
		else if (WelcomePage.getLoginFlag() == 2)
		{		
			System.out.println("Login flag == 2");
			patientNames = WelcomePage.getPatientNamesInEmpNurse(WelcomePage.getLoggedInNurse());
		}
		// get empty list when first loading gui
		else if (WelcomePage.getLoginFlag() == 3)
		{
			System.out.println("Login flag == 3");
			patientNames.getItems().addAll("John Doe", "Mary Sue", "Bob Thomas");
		}
		
		// set default selected patient when gui starts
		patientNames.getSelectionModel().select(0);
		
		System.out.println(patientNames.getSelectionModel().getSelectedItem());
		
		// save selected patients 
		WelcomePage.setPatientSelection(patientNames.getSelectionModel().getSelectedItem());
		
		// add elements to gridPane
		this.add(logOut, 0, 0);
		this.add(welcomeDr, 1, 1, 3, 1);
		this.add(pats, 1, 2);
		this.add(patientNames, 1, 3, 2, 3); //TODO - get list from patient class *hard coded right now
		this.add(actions, 1, 6);
		this.add(vitals, 1, 7, 2, 1);
		this.add(personalInfo, 1, 8, 2, 1);
		this.add(physicalExamination, 1, 9, 2, 1);
		this.add(drNotes, 1, 10, 2, 1);
		this.add(makePrescription, 1, 11, 2, 1);
		
		// adjust gridPane padding and spacing
		this.setPadding(new Insets(10, 10, 10, 10));
		this.setVgap(10);
		this.setHgap(20);
		this.setBackground(defaultBg);
		
		// link source nodes with handler objects
		logOut.setOnMouseClicked(new LogoutHandler());
		vitals.setOnMouseClicked(new VitalsHandler());
		personalInfo.setOnMouseClicked(new PersonalInfoHandler());
		physicalExamination.setOnMouseClicked(new PhysicalHandler());
		drNotes.setOnMouseClicked(new DrNotesHandler());
		makePrescription.setOnMouseClicked(new MakePrescriptionHandler());
	}
	
	// logout
	private class LogoutHandler implements EventHandler<MouseEvent>
	{
		public void handle(MouseEvent logoutEvent)
		{
			if (logoutEvent.getEventType() == MouseEvent.MOUSE_CLICKED)
			{
				// go to welcome page screen 
				LoginPane welcomePane;
				try 
				{
					welcomePane = new LoginPane();
					Scene welcomeScene = new Scene(welcomePane, 700, 1000);
					welcomeScene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
					WelcomePage.getStage().setScene(welcomeScene);
				} catch (FileNotFoundException e) 
				{
					e.printStackTrace();
				}
				
				WelcomePage.logoutEmp();
			}
		}
	}
		
	//  vitals
	private class VitalsHandler implements EventHandler<MouseEvent>
	{
		public void handle(MouseEvent vitalsEvent)
		{
			if (vitalsEvent.getEventType() == MouseEvent.MOUSE_CLICKED)
			{
				// go to vitals screen 
				Vitals newPane;
				try 
				{
					newPane = new Vitals();
					Scene newScene = new Scene(newPane, 700, 1000);
					newScene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
					WelcomePage.getStage().setScene(newScene);
				} catch (FileNotFoundException e) 
				{
					e.printStackTrace();
				}
			}
		}
	}
	
	// personal info
	private class PersonalInfoHandler implements EventHandler<MouseEvent>
	{
		public void handle(MouseEvent personalInfoEvent)
		{
			if (personalInfoEvent.getEventType() == MouseEvent.MOUSE_CLICKED)
			{
				// go to personal info screen 
				PersonalInfo newPane;
				try 
				{
					newPane = new PersonalInfo();
					Scene newScene = new Scene(newPane, 700, 1000);
					newScene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
					WelcomePage.getStage().setScene(newScene);
				} catch (FileNotFoundException e) 
				{
					e.printStackTrace();
				}
			}
		}
	}
	
	// physical examination
	private class PhysicalHandler implements EventHandler<MouseEvent>
	{
		public void handle(MouseEvent physicalEvent)
		{
			if (physicalEvent.getEventType() == MouseEvent.MOUSE_CLICKED)
			{
				// go to physical examination screen 
				PhysicalExamination newPane;
				try 
				{
					newPane = new PhysicalExamination();
					Scene newScene = new Scene(newPane, 700, 1000);
					newScene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
					WelcomePage.getStage().setScene(newScene);
				} catch (FileNotFoundException e) 
				{
					e.printStackTrace();
				}
			}
		}
	}
	
	// doctor notes
	private class DrNotesHandler implements EventHandler<MouseEvent>
	{
		public void handle(MouseEvent notesEvent)
		{
			if (notesEvent.getEventType() == MouseEvent.MOUSE_CLICKED)
			{
				// go to doctor notes screen 
				DoctorNotes newPane;
				try 
				{
					newPane = new DoctorNotes();
					Scene newScene = new Scene(newPane, 700, 1000);
					newScene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
					WelcomePage.getStage().setScene(newScene);
				} catch (FileNotFoundException e) 
				{
					e.printStackTrace();
				}
			}
		}
	}
	
	// make prescription
	private class MakePrescriptionHandler implements EventHandler<MouseEvent>
	{
		public void handle(MouseEvent prescriptionEvent)
		{
			if (prescriptionEvent.getEventType() == MouseEvent.MOUSE_CLICKED)
			{
				// go to make prescription screen 
				MakePrescription newPane;
				try 
				{
					newPane = new MakePrescription();
					Scene newScene = new Scene(newPane, 700, 1000);
					newScene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
					WelcomePage.getStage().setScene(newScene);
				} catch (FileNotFoundException e) 
				{
					e.printStackTrace();
				}
			}
		}
	}

}
