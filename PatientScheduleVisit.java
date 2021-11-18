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
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import javafx.scene.layout.GridPane;

public class PatientScheduleVisit extends BorderPane {
	private int width = 1500;
	private int height = 1000;
	private Button home, back, info, messages, pastVisits, scheduleVisit, backToHome;

	public PatientScheduleVisit() throws FileNotFoundException {
		Patient patient = WelcomePage.getLoggedInPatient();
		// set default background
		Image defaultBgPic = new Image("file:iu-9.jpeg", width, height, false, false);
		BackgroundImage defaultImage = new BackgroundImage(defaultBgPic, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
		Background defaultBg = new Background(defaultImage);
		
		// define vBox
		VBox tabs = new VBox();
		tabs.setPadding(new Insets(20, 0 ,20, 20));
		tabs.setPrefSize(200, 65);
		
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
				
		// set elements to borderPane
		this.setLeft(tabs);	
		this.setBackground(defaultBg);
		this.getLeft().setStyle("-fx-background-color: darkgrey");
		
		
		
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
			if (scheduleEvent.getEventType() == MouseEvent.MOUSE_CLICKED)
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
				};
			}
		}
	}
		
}
