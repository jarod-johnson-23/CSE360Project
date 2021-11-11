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
		
		// define hBoxs
		HBox line1 = new HBox();
		HBox line2 = new HBox();
		HBox line3 = new HBox();
		HBox line4 = new HBox();
		HBox line5 = new HBox();
		HBox line6 = new HBox();
		
		// add elements to HBox
		line1.getChildren().addAll(subject, date);
		line2.getChildren().addAll(subjectBox, dateBox);
		line3.getChildren().addAll(notes);
		line4.getChildren().addAll(notesBox);
		line5.getChildren().addAll(signature);
		line6.getChildren().addAll(signatureBox);
		
		// set spacing for HBoxs
		line1.setSpacing(20);
		line2.setSpacing(20);
		line3.setSpacing(20);
		line4.setSpacing(20);
		line5.setSpacing(20);
		line6.setSpacing(20);
		
		// define vBox
		VBox box = new VBox();
		
		// adjust vBox padding and spacing
		
		// add elements to gridPane
		this.add(back, 0, 0);
		this.add(title, 1, 1);
		this.add(submit, 1, 12);
		
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
			}
		}
	}

}
