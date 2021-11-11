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
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class PersonalInfo extends GridPane
{
	// define variables
	private Font titleFont;
	private int width = 1500;
	private int height = 1000;
	private Label title, allergies, healthConcerns, personalHistory, name, age, birthday, issues, prevMeds, immunization;
	private Button back, save;
	private TextField knownAllergies, concerns;
	
	
	public PersonalInfo() throws FileNotFoundException
	{
		// define font
		titleFont = new Font("Cambria", 24);

		// define background image
		Image defaultBgPic = new Image("file:iu-9.jpeg", width, height, false, false);
		BackgroundImage defaultImage = new BackgroundImage(defaultBgPic, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
		Background defaultBg = new Background(defaultImage);
		
		// create square behind personal history
		BackgroundFill logInBgFill = new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY);
		Background backing = new Background(logInBgFill);
		
		// define title labels
		title = new Label("Personal Health");
		title.setFont(titleFont);
		personalHistory = new Label("Personal History");
		personalHistory.setFont(titleFont);

		// define labels
		allergies = new Label("Known allergies");
		healthConcerns = new Label("Health Concerns");
		name = new Label("Name: ");
		age = new Label("Age: ");
		birthday = new Label("Birthday: ");
		issues = new Label("Issues: ");
		prevMeds = new Label("Previous Medications:");
		
		// TODO - fill in labels using patient information
		
		// define buttons
		back = new Button("Back");
		save = new Button("Save");
		
		// set width of buttons
		back.setPrefWidth(150);
		save.setPrefWidth(150);
		
		// define textFields
		knownAllergies = new TextField();
		concerns = new TextField();
		
		// define vBox
		VBox left = new VBox();
		left.getChildren().addAll(allergies, knownAllergies, healthConcerns, concerns);
		VBox right = new VBox();
		right.getChildren().addAll(name, age, birthday, issues, prevMeds);
		
		// set background color of personal history
		right.setBackground(backing);
		
		// adjust vBox padding and spacing
		left.setPadding(new Insets(10, 100, 0, 0));
	    left.setSpacing(10);
	    right.setPadding(new Insets(10, 10, 10, 10));
	    right.setSpacing(10);
	    
		// add elements to gridPane
		this.add(back, 0, 0);
		this.add(title, 1, 1);
		this.add(personalHistory, 2, 1);
		this.add(left, 1, 2);
		this.add(right, 2, 2);
		this.add(save, 1, 3);
		
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
				Scene empScene = WelcomePage.getEmployeeHome();
				WelcomePage.getStage().setScene(empScene);
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
		
				Scene empScene = WelcomePage.getEmployeeHome();
				WelcomePage.getStage().setScene(empScene);
				
				// TODO - save information in patient object
			}
		}
	}

}
