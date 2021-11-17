package application;

import java.io.FileNotFoundException;
import java.time.LocalDate;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
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

public class PhysicalExamination extends GridPane
{
	// define variables
	private Font titleFont;
	private int width = 1500;
	private int height = 1000;
	private Label title, patient, date, findings, signature;
	private Button back, save;
	private TextField patientBox, findingsBox, signatureBox;
	
	public PhysicalExamination() throws FileNotFoundException
	{
		// define font
		titleFont = new Font("Cambria", 24);

		// define background image
		Image defaultBgPic = new Image("file:iu-9.jpeg", width, height, false, false);
		BackgroundImage defaultImage = new BackgroundImage(defaultBgPic, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
		Background defaultBg = new Background(defaultImage);
		
		// define title label
		title = new Label("Physical Examination");
		title.setFont(titleFont);

		// define labels
		patient = new Label("Patient:");
		date = new Label("Date:");
		findings = new Label("Notes:");
		signature = new Label("Signature:");
				
		// define datePicker
		DatePicker datePicker = new DatePicker();
		
		// set current date
		datePicker.setValue(LocalDate.now());
				
		// define buttons
		back = new Button("Back");
		save = new Button("Save");
		
		// set width of buttons
		back.setPrefWidth(150);
		save.setPrefWidth(150);
		
		// define textFields
		patientBox = new TextField();
		findingsBox = new TextField();
		signatureBox = new TextField();
		
		// set minimum size of notes textField
		findingsBox.setMinHeight(200);
		findingsBox.setMinWidth(365);
		
		// define vBox
		VBox patientVBox = new VBox();
		VBox dateVBox = new VBox();
		
		// add elements to vBox
		patientVBox.getChildren().addAll(patient, patientBox);
		dateVBox.getChildren().addAll(date, datePicker);

		// adjust vBox padding and spacing
		patientVBox.setPadding(new Insets(10, 0, 0, 0));
		patientVBox.setSpacing(10);
		dateVBox.setPadding(new Insets(10, 0, 0, 0));
		dateVBox.setSpacing(10);
	    
		// define hBoxs
		HBox line1 = new HBox();
		HBox line2 = new HBox();
		HBox line3 = new HBox();
		HBox line4 = new HBox();
		HBox line5 = new HBox();
		
		// add elements to HBox
		line1.getChildren().addAll(patientVBox, dateVBox);
		line2.getChildren().addAll(findings);
		line3.getChildren().addAll(findingsBox);
		line4.getChildren().addAll(signature);
		line5.getChildren().addAll(signatureBox);
		
		// set spacing for hBoxs
		line1.setSpacing(20);
		line2.setSpacing(20);
		line3.setSpacing(20);
		line4.setSpacing(20);
		line5.setSpacing(20);
		
		// define vBox
		VBox box = new VBox();
		
		// add elements to vBox
		box.getChildren().addAll(line1, line2, line3, line4, line5);
		
		// adjust vBox padding and spacing
		box.setPadding(new Insets(10, 0, 0, 0));
	    box.setSpacing(10);
		
		// add elements to gridPane
		this.add(back, 0, 0);
		this.add(title, 1, 1);
		this.add(box, 1, 2);
		this.add(save, 1, 5);
		
		// adjust gridPane padding and spacing
		this.setPadding(new Insets(10, 10, 10, 10));
		this.setVgap(10);
		this.setHgap(20);
		this.setBackground(defaultBg);	
		
		// link source nodes with handler objects
		back.setOnMouseClicked(new backHandler());
		save.setOnMouseClicked(new saveHandler());
		
	}
	
	// back
	private class backHandler implements EventHandler<MouseEvent>
	{
		public void handle(MouseEvent backEvent)
		{
			if (backEvent.getEventType() == MouseEvent.MOUSE_CLICKED)
			{
				// go to employee home screen 
				EmployeeHome newPane;
				try 
				{
					newPane = new EmployeeHome();
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
	
	// save
	private class saveHandler implements EventHandler<MouseEvent>
	{
		public void handle(MouseEvent saveEvent)
		{
			if (saveEvent.getEventType() == MouseEvent.MOUSE_CLICKED)
			{
				// TODO - check if all fields full
		
				// TODO - save information in patient object
				

				// go to employee home screen 
				EmployeeHome newPane;
				try 
				{
					newPane = new EmployeeHome();
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
