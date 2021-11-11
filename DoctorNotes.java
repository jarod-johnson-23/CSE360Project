package application;

import java.io.FileNotFoundException;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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

public class DoctorNotes extends GridPane
{
	// define variables
	private Font titleFont;
	private int width = 1500;
	private int height = 1000;
	private Label title, subject, date, notes, signature;
	private Button back, submit;
	private TextField subjectBox, dateBox, notesBox, signatureBox;
	
	public DoctorNotes() throws FileNotFoundException
	{
		// define font
		titleFont = new Font("Cambria", 24);

		// define background image
		Image defaultBgPic = new Image("file:iu-9.jpeg", width, height, false, false);
		BackgroundImage defaultImage = new BackgroundImage(defaultBgPic, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
		Background defaultBg = new Background(defaultImage);
		
		// define title label
		title = new Label("Doctor's Note");
		title.setFont(titleFont);

		// define labels
		subject = new Label("Subject");
		date = new Label("Date");
		notes = new Label("Notes");
		signature = new Label("Signature");
		
		// define buttons
		back = new Button("Back");
		submit = new Button("Submit");
		
		// set width of buttons
		back.setPrefWidth(150);
		submit.setPrefWidth(150);
		
		// define textFields
		subjectBox = new TextField();
		dateBox = new TextField();
		notesBox = new TextField();
		signatureBox = new TextField();
		
		// set minimum size of notes textField
		notesBox.setMinHeight(200);
		notesBox.setMinWidth(339);
		
		// define vBox
		VBox subjectVBox = new VBox();
		VBox dateVBox = new VBox();
		
		// add elements to vBox
		subjectVBox.getChildren().addAll(subject, subjectBox);
		dateVBox.getChildren().addAll(date, dateBox);
		
		// adjust vBox padding and spacing
		subjectVBox.setPadding(new Insets(10, 0, 0, 0));
		subjectVBox.setSpacing(10);
		dateVBox.setPadding(new Insets(10, 0, 0, 0));
		dateVBox.setSpacing(10);
	    
		// define hBoxs
		HBox line1 = new HBox();
		HBox line2 = new HBox();
		HBox line3 = new HBox();
		HBox line4 = new HBox();
		HBox line5 = new HBox();
		
		// add elements to HBox
		line1.getChildren().addAll(subjectVBox, dateVBox);
		line2.getChildren().addAll(notes);
		line3.getChildren().addAll(notesBox);
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
		this.add(submit, 1, 5);
		
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
				// TODO -  check if all fields full
		
				Scene empScene = WelcomePage.getEmployeeHome();
				WelcomePage.getStage().setScene(empScene);
				
				// TODO - save information in patient object
			}
		}
	}

}
