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
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class MakePrescription extends GridPane 
{
	// define variables
	private Font titleFont;
	private int width = 1500;
	private int height = 1000;
	private Label title, patient, pharmacy, meds, dosage, dosagePerDay, notes;
	private Button back, submit;
	private TextField medsBox, notesBox;
	private ChoiceBox dosageChoices, dosagePerDayChoices;
	
	public MakePrescription() throws FileNotFoundException
	{
		// define font
		titleFont = new Font("Cambria", 24);

		// define background image
		Image defaultBgPic = new Image("file:iu-9.jpeg", width, height, false, false);
		BackgroundImage defaultImage = new BackgroundImage(defaultBgPic, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
		Background defaultBg = new Background(defaultImage);
		
		// define title label
		title = new Label("Write a Prescription");
		title.setFont(titleFont);

		// define labels 
		patient = new Label("Patient: [patient name]");
		pharmacy = new Label("Pharmacy: [pharmacy name]");
		meds = new Label("Name of Medication:");
		dosage = new Label("Dosage:");
		dosagePerDay = new Label("Dosages Per Day:");
		notes = new Label("Additional Notes:");
		
		// TODO - fill in labels with patient information
		
		// define buttons
		back = new Button("Back");
		submit = new Button("Submit");
		
		// set width of buttons
		back.setPrefWidth(150);
		submit.setPrefWidth(150);
		
		// define textFields
		medsBox = new TextField();
		notesBox = new TextField();
		
		// adjust textField sizes
		notesBox.setMinHeight(200);
		notesBox.setMinWidth(300);
		
		// define ChoiceBoxes
		dosageChoices = new ChoiceBox(FXCollections.observableArrayList("5mg", "10mg", "15mg", "20mg", "25mg", "30mg", "35mg", "40mg", "45mg", "50mg"));
		dosagePerDayChoices = new ChoiceBox(FXCollections.observableArrayList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10"));

		// set selected choice in ChoiceBoxes
		dosageChoices.getSelectionModel().selectFirst();
		dosagePerDayChoices.getSelectionModel().selectFirst();
		
		// define vBox
		VBox patientInfo = new VBox();
		patientInfo.getChildren().addAll(patient, pharmacy);
		
		// adjust vBox padding and spacing
		patientInfo.setPadding(new Insets(10, 0, 0, 0));
	    patientInfo.setSpacing(10);
		
		// add elements to gridPane
		this.add(back, 0, 0);
		this.add(title, 1, 1);
		this.add(patientInfo, 1, 2);
		this.add(meds, 1, 3);
		this.add(medsBox, 2, 3);
		this.add(dosage, 1, 4);
		this.add(dosageChoices, 2, 4);
		this.add(dosagePerDay, 1, 5);
		this.add(dosagePerDayChoices, 2, 5);
		this.add(notes, 1, 6);
		this.add(notesBox, 2, 6);
		this.add(submit, 1, 10);
		
		// adjust gridPane padding and spacing
		this.setPadding(new Insets(10, 10, 10, 10));
		this.setVgap(10);
		this.setHgap(20);
		this.setBackground(defaultBg);	
		
		// link source nodes with handler objects
		back.setOnMouseClicked(new backHandler());
		submit.setOnMouseClicked(new submitHandler());
	}

	// back
	private class backHandler implements EventHandler<MouseEvent>
	{
		public void handle(MouseEvent backEvent)
		{
			if (backEvent.getEventType() == MouseEvent.MOUSE_CLICKED)
			{
				Scene empScene = WelcomePage.getEmployeeHome();
				WelcomePage.getStage().setScene(empScene);
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
		
				Scene empScene = WelcomePage.getEmployeeHome();
				WelcomePage.getStage().setScene(empScene);
				
				// TODO - save prescription info in patient object and send to pharmacy
			}
		}
	}
}
