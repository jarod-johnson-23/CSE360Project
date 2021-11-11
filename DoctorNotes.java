package application;

import java.io.FileNotFoundException;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

public class DoctorNotes extends GridPane
{
	// define variables
	private Font titleFont;
	private int width = 1500;
	private int height = 1000;
	private Label title;
	private Button back, submit;
	
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
		
		
		// define buttons
		back = new Button("Back");
		submit = new Button("Submit");
		
		// set width of buttons
		back.setPrefWidth(150);
		submit.setPrefWidth(150);
		
		// define textFields
		
		// define vBox
		
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
				// check if all fields full - TODO
		
				Scene empScene = WelcomePage.getEmployeeHome();
				WelcomePage.getStage().setScene(empScene);
			}
		}
	}

}
