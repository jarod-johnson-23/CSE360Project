package application;

import java.io.FileNotFoundException;
import java.time.format.DateTimeFormatter;

import javafx.collections.FXCollections;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
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
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import javafx.scene.layout.GridPane;

public class PatientPastVisits extends BorderPane {
	private int width = 1500;
	private int height = 1000;
	private Label title, selectDate, summary, summaryText;
	private Button home, back, info, messages, pastVisits, scheduleVisit, backToHome;
	private Font titleFont;
	private DatePicker datePicker;

	public PatientPastVisits() throws FileNotFoundException {
		
		Patient patient = WelcomePage.getLoggedInPatient();
		
		// define font
			titleFont = new Font("Cambria", 24);

		// set default background
		Image defaultBgPic = new Image("file:iu-9.jpeg", width, height, false, false);
		BackgroundImage defaultImage = new BackgroundImage(defaultBgPic, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
		Background defaultBg = new Background(defaultImage);
		BackgroundFill patHpBgFill = new BackgroundFill(Color.WHITESMOKE, new CornerRadii(10), new Insets(100, 200, 150, 10));
		Background whiteBg = new Background(patHpBgFill);

		// define vBox
		VBox tabs = new VBox();
		tabs.setPadding(new Insets(20, 0 ,20, 20));
		tabs.setPrefSize(200, 65);
		
		//define grid for center of screen
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(20, 20, 20, 20));
		
		// define title label
		title = new Label("Past Visits");
		title.setFont(titleFont);
		
		// define labels
		selectDate = new Label("Select Date of Last Visit: ");
		summary = new Label("Summary");
		summaryText = new Label("");
		
		// set color of summaryText
		summaryText.setBackground(whiteBg);
		
		// define DatePicker
		datePicker = new DatePicker();
		
		// define buttons
		home = new Button("Home");
		info = new Button("Information");
		messages = new Button("Messages");
		pastVisits = new Button("Past Visits");
		scheduleVisit = new Button("Schedule A Visit");
		backToHome = new Button("Logout");
		
		// specify minimum size
		home.setMinSize(tabs.getPrefWidth(), tabs.getPrefHeight());
		info.setMinSize(tabs.getPrefWidth(), tabs.getPrefHeight());
		messages.setMinSize(tabs.getPrefWidth(), tabs.getPrefHeight());
		pastVisits.setMinSize(tabs.getPrefWidth(), tabs.getPrefHeight());
		scheduleVisit.setMinSize(tabs.getPrefWidth(), tabs.getPrefHeight());
		backToHome.setMinSize(tabs.getPrefWidth(), tabs.getPrefHeight());
		
		// link source nodes with handler objects
		home.setOnMouseClicked(new HomeHandler());
		backToHome.setOnMouseClicked(new LogoutHandler());
		info.setOnMouseClicked(new InfoHandler());
		messages.setOnMouseClicked(new MessagesHandler());
		pastVisits.setOnMouseClicked(new PastVisitsHandler());
		scheduleVisit.setOnMouseClicked(new ScheduleVisitHandler());
		
		// add elements to tabs
		tabs.getChildren().addAll(home, info, messages, pastVisits, scheduleVisit, backToHome);
				
		// add elements to gridPane
		grid.add(title, 0, 0);
		grid.add(selectDate, 0, 1);
		grid.add(datePicker, 0, 2);
		grid.add(summary, 1, 1);
		grid.add(summaryText, 1, 2);
		
		// adjust gridPane padding and spacing
		grid.setPadding(new Insets(10, 10, 10, 10));
		grid.setVgap(10);
		grid.setHgap(20);
		grid.setBackground(defaultBg);
				
		// set elements to borderPane
		this.setLeft(tabs);	
		this.setBackground(defaultBg);
		this.getLeft().setStyle("-fx-background-color: darkgrey");
		this.setCenter(grid);
		
		// add listener to datePicker
		datePicker.setOnAction(action -> {
			summaryText.setText("");

			String date = datePicker.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			
			if (patient.getPatDocNoteDate(date).equals(""))
			{
				summaryText.setText("No visit on selected date.");
			}
			else
			{
				for (int i = 0; i < patient.getDocNoteArray().length; i++)
				{
					if (patient.getDocNoteArray()[i] != null && patient.getDocNoteArray()[i].getDate().equals(date))
					{
						summaryText.setText(patient.getDocNoteArray()[i].getNote());
						break;
					}
				}
			}
			
			
        });
	}
	
	// home
	private class HomeHandler implements EventHandler<MouseEvent>
	{
		public void handle(MouseEvent homeEvent)
		{
			if (homeEvent.getEventType() == MouseEvent.MOUSE_CLICKED)
			{
				// go to home screen 
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
	
	// information
	private class InfoHandler implements EventHandler<MouseEvent>
	{
		public void handle(MouseEvent infoEvent)
		{
			if (infoEvent.getEventType() == MouseEvent.MOUSE_CLICKED)
			{
				// go to information screen 
				PatientInformation newPane;
				try 
				{
					newPane = new PatientInformation();
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
	
	// messages
	private class MessagesHandler implements EventHandler<MouseEvent>
	{
		public void handle(MouseEvent messageEvent)
		{
			if (messageEvent.getEventType() == MouseEvent.MOUSE_CLICKED)
			{
				// go to messages screen 
				PatientMessages newPane;
				try 
				{
					newPane = new PatientMessages();
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
	
	// past visits
	private class PastVisitsHandler implements EventHandler<MouseEvent>
	{
		public void handle(MouseEvent visitEvent)
		{
			if (visitEvent.getEventType() == MouseEvent.MOUSE_CLICKED)
			{
				// go to past visits screen 
				PatientPastVisits newPane;
				try 
				{
					newPane = new PatientPastVisits();
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
	
	// schedule a visit
	private class ScheduleVisitHandler implements EventHandler<MouseEvent>
	{
		public void handle(MouseEvent scheduleEvent)
		{
			// go to schedule a visit screen 
			PatientScheduleVisit newPane;
			try 
			{
				newPane = new PatientScheduleVisit();
				Scene newScene = new Scene(newPane, 700, 1000);
				newScene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
				WelcomePage.getStage().setScene(newScene);
			} catch (FileNotFoundException e) 
			{
				e.printStackTrace();
			}
		}
	}
	
	
	// logout
	private class LogoutHandler implements EventHandler<MouseEvent>
	{
		public void handle(MouseEvent logoutEvent)
		{
			if (logoutEvent.getEventType() == MouseEvent.MOUSE_CLICKED)
			{
				// go to login screen 
				LoginPane newPane;
				try 
				{
					newPane = new LoginPane();
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



