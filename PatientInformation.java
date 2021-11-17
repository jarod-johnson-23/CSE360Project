package application;

import java.io.FileNotFoundException;

import javafx.collections.FXCollections;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class PatientInformation extends GridPane 
{
	// define variables
	private Font titleFont;
	private int width = 1500;
	private int height = 1000;
	private Label title, name, age, birthday, healthIssues, prevMeds, historyOfImm;
	private Button back, edit;
	
	public PatientInformation() throws FileNotFoundException
	{
		// format text to fill in labels
		Patient patient = WelcomePage.getLoggedInPatient();
		String patient_age = String.valueOf(patient.getAge());
		String healthConcernsFormatted = "";
		String prescriptionsFormatted = "";
		String vaccinesFormatted = "";
		
		// format text
		for (int i = 0; i < patient.getHealthConcerns().length; i++)
		{
			if (i == 0)
			{
				healthConcernsFormatted = healthConcernsFormatted + patient.getHealthConcerns()[i];

			}
			else if (i != 0)
			{
				healthConcernsFormatted = healthConcernsFormatted + "," + patient.getHealthConcerns()[i];
			}
		}
		
		for (int i = 0; i < patient.getPrescriptions().size(); i++)
		{
			if (i == 0)
			{
				prescriptionsFormatted = prescriptionsFormatted + patient.getSpecificPresc(i);

			}
			else if (i != 0)
			{
				prescriptionsFormatted = prescriptionsFormatted + "," + patient.getSpecificPresc(i);
			}
		}
		
		for (int i = 0; i < patient.getVaccines().length; i++)
		{
			if (i == 0)
			{
				vaccinesFormatted = vaccinesFormatted + patient.getVaccines()[i];

			}
			else if (i != 0)
			{
				vaccinesFormatted = vaccinesFormatted + "," + patient.getVaccines()[i];
			}
		}
		
		
		
		// define font
		titleFont = new Font("Cambria", 24);

		// define background image
		Image defaultBgPic = new Image("file:iu-9.jpeg", width, height, false, false);
		BackgroundImage defaultImage = new BackgroundImage(defaultBgPic, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
		Background defaultBg = new Background(defaultImage);
		
		// define title label
		title = new Label("Patient Information");
		title.setFont(titleFont);

		// define labels 
		name = new Label(patient.concatenateNames());
		age = new Label(patient_age);
		birthday = new Label(patient.getBday());
		healthIssues = new Label(healthConcernsFormatted);
		prevMeds = new Label(prescriptionsFormatted);
		historyOfImm = new Label(vaccinesFormatted);
				
		// define buttons
		back = new Button("Back");
		edit = new Button("Edit Information");
		
		// set width of buttons
		back.setPrefWidth(150);
		edit.setPrefWidth(150);
		
		// define vBox
		VBox patientInfo = new VBox();
		patientInfo.getChildren().addAll(name, age, birthday, healthIssues, prevMeds, historyOfImm, edit);
		
		// adjust vBox padding and spacing
		patientInfo.setPadding(new Insets(10, 0, 0, 0));
	    patientInfo.setSpacing(10);
	    
	    // adjust vBox color
	    patientInfo.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
		
		// add elements to gridPane
		this.add(back, 0, 0);
		this.add(title, 1, 1);
		this.add(patientInfo, 1, 2);
		
		// adjust gridPane padding and spacing
		this.setPadding(new Insets(10, 10, 10, 10));
		this.setVgap(10);
		this.setHgap(20);
		this.setBackground(defaultBg);	
		
		// link source nodes with handler objects
		back.setOnMouseClicked(new backHandler());
		edit.setOnMouseClicked(new submitHandler());
	}

	// back
	private class backHandler implements EventHandler<MouseEvent>
	{
		public void handle(MouseEvent backEvent)
		{
			if (backEvent.getEventType() == MouseEvent.MOUSE_CLICKED)
			{
				// go to patient home screen 
				PatientHome newPane;
				try 
				{
					newPane = new PatientHome();
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
	
	// submit
	private class submitHandler implements EventHandler<MouseEvent>
	{
		public void handle(MouseEvent submitEvent)
		{
			if (submitEvent.getEventType() == MouseEvent.MOUSE_CLICKED)
			{
				// TODO - check if all fields full
		
				// TODO - save prescription info in patient object and send to pharmacy
			}
		}
	}
}