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

public class PhysicalExamination extends GridPane
{
	// define variables
	private Font titleFont;
	private int width = 1500;
	private int height = 1000;
	private Label title;
	private Button back, save;
	
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
		
		
		// define buttons
		back = new Button("Back");
		save = new Button("Save");
		
		// set width of buttons
		back.setPrefWidth(150);
		save.setPrefWidth(150);
		
		// define textFields
		
		// define vBox
		
		// adjust vBox padding and spacing
		
		// add elements to gridPane
		this.add(back, 0, 0);
		this.add(title, 1, 1);
		this.add(save, 1, 12);
		
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
				// check if all fields full - TODO
		
				Scene empScene = WelcomePage.getEmployeeHome();
				WelcomePage.getStage().setScene(empScene);
			}
		}
	}

}
