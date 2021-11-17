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
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class Vitals extends GridPane 
{

	// declare variables
	private Font titleFont;
	private int width = 1500;
	private int height = 1000;
	private Label title, heartRate, weight, temp, respRate, bloodPressure;
	private Button back, submit;
	private TextField hRate, bWeight, bTemp, rRate, bPressure;
	private Patient patient;
	private String patName;
	
	public Vitals(String patName) throws FileNotFoundException
	{
		// define font
		titleFont = new Font("Cambria", 24);
		this.patName = patName;

		// define background image
		Image defaultBgPic = new Image("file:iu-9.jpeg", width, height, false, false);
		BackgroundImage defaultImage = new BackgroundImage(defaultBgPic, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
		Background defaultBg = new Background(defaultImage);
		
		// define title label
		title = new Label("Enter Vitals");
		title.setFont(titleFont);

		// define vital prompt labels
		heartRate = new Label("Heart Rate:");
		weight = new Label("Weight:");
		temp = new Label("Body Temperature:");
		respRate = new Label("Respiration Rate:");
		bloodPressure = new Label("Blood Pressure:");
		
		// define buttons
		back = new Button("Back");
		submit = new Button("Submit");
		
		// set width of buttons
		back.setPrefWidth(150);
		submit.setPrefWidth(150);
		
		// define textFields
		hRate = new TextField();
		bWeight =  new TextField();
		bTemp = new TextField();
		rRate = new TextField();
		bPressure = new TextField();
		
		// define vBox
		VBox left = new VBox();
		left.getChildren().addAll(heartRate, hRate, temp, bTemp, bloodPressure, bPressure);
		VBox right = new VBox();
		right.getChildren().addAll(weight, bWeight, respRate, rRate);
		
		// adjust vBox padding and spacing
		left.setPadding(new Insets(10, 0, 0, 0));
	    left.setSpacing(10);
	    right.setPadding(new Insets(10, 10, 10, 10));
	    right.setSpacing(10);
		
		// add elements to gridPane
		this.add(back, 0, 0);
		this.add(title, 1, 1);
		this.add(left, 1, 2);
		this.add(right, 3, 2);
		this.add(submit, 1, 7);
		
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
		
				VitalsObject newVitals = new VitalsObject(hRate.getText(), bWeight.getText(), bTemp.getText(), bPressure.getText(), patient);
				
				Scene empScene = WelcomePage.getEmployeeHome();
				WelcomePage.getStage().setScene(empScene);
				
				
			}
		}
	}
}
