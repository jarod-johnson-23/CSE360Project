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

public class PatientMessages extends BorderPane {
	private int width = 1500;
	private int height = 1000;
	private Button back, info, messages, pastVisits, scheduleVisit, backToHome;

	public PatientMessages() throws FileNotFoundException {
		Patient patient = Main.getLoggedInPatient();
		// set default background
		Image defaultBgPic = new Image("file:iu-9.jpeg", width, height, false, false);
		BackgroundImage defaultImage = new BackgroundImage(defaultBgPic, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
		Background defaultBg = new Background(defaultImage);
		
		// define vBox
		VBox tabs = new VBox();
		tabs.setPadding(new Insets(20, 0 ,20, 20));
		tabs.setPrefSize(200, 65);
		
		info = new Button("Information");
		messages = new Button("Messages");
		pastVisits = new Button("Past Visits");
		scheduleVisit = new Button("Schedule A Visit");
		backToHome = new Button("Logout");
		
		// specify minimum size
		info.setMinSize(tabs.getPrefWidth(), tabs.getPrefHeight());
		messages.setMinSize(tabs.getPrefWidth(), tabs.getPrefHeight());
		pastVisits.setMinSize(tabs.getPrefWidth(), tabs.getPrefHeight());
		scheduleVisit.setMinSize(tabs.getPrefWidth(), tabs.getPrefHeight());
		backToHome.setMinSize(tabs.getPrefWidth(), tabs.getPrefHeight());
		
		// link source nodes with handler objects
		backToHome.setOnMouseClicked(new LogoutHandler());
		info.setOnMouseClicked(new InfoHandler());
		messages.setOnMouseClicked(new MessagesHandler());
		pastVisits.setOnMouseClicked(new PastVisitsHandler());
		scheduleVisit.setOnMouseClicked(new ScheduleVisitHandler());
		
		// add elements to tabs
		tabs.getChildren().addAll(info, messages, pastVisits, scheduleVisit, backToHome);
				
		// set elements to borderPane
		this.setLeft(tabs);	
		this.setBackground(defaultBg);
		this.getLeft().setStyle("-fx-background-color: darkgrey");
		
		
		
	}
	
	// information
		private class InfoHandler implements EventHandler<MouseEvent>
		{
			public void handle(MouseEvent infoEvent)
			{
				if (infoEvent.getEventType() == MouseEvent.MOUSE_CLICKED)
				{
					Scene infoScene = Main.getInformation();
					Main.getStage().setScene(infoScene);
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
					Scene messageScene = Main.getMessagePortal();
					Main.getStage().setScene(messageScene);
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
					Scene visitScene = Main.getPastVisits();
					Main.getStage().setScene(visitScene);
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
					Scene scheduleScene = Main.getScheduleAVisit();
					Main.getStage().setScene(scheduleScene);
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
					Scene loginScene = Main.getWelcomeLogin();
					Main.getStage().setScene(loginScene);
				}
			}
		}
		
}
