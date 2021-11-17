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
	private Button back, info, messages, pastVisits, scheduleVisit, backToHome, inbox, write, sent;
	private Label mTitle, from, subject, body, blank;
	private Font titleFont;
	

	public PatientMessages() throws FileNotFoundException {
		Patient patient = WelcomePage.getLoggedInPatient();
		// set default background
		Image defaultBgPic = new Image("file:iu-9.jpeg", width, height, false, false);
		BackgroundImage defaultImage = new BackgroundImage(defaultBgPic, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
		Background defaultBg = new Background(defaultImage);
		
		// set patient background
		BackgroundFill patHpBgFill = new BackgroundFill(Color.WHITESMOKE, new CornerRadii(10), new Insets(100, 200, 150, 10));
		Background whiteBg = new Background(patHpBgFill);
		
		titleFont = new Font("Cambria", 24);
		
		// define vBox
		VBox tabs = new VBox();
		tabs.setPadding(new Insets(20, 0 ,20, 20));
		tabs.setPrefSize(200, 65);
		
		VBox moreTabs = new VBox();
		moreTabs.setPadding(new Insets(50, 0, 20, -10));
		moreTabs.setPrefSize(200,  65);
		
		//define grid for center of screen
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(20, 20, 20, 20));
		grid.setBackground(whiteBg);
		
		mTitle = new Label("");
		from = new Label("From: ");
		subject = new Label("Subject: ");
		body = new Label("");
		blank = new Label("");
		body.setWrapText(true);
		body.setMaxWidth(400);
		
		info = new Button("Information");
		messages = new Button("Messages");
		pastVisits = new Button("Past Visits");
		scheduleVisit = new Button("Schedule A Visit");
		backToHome = new Button("Logout");
		inbox = new Button("Inbox");
		write = new Button("Write");
		sent = new Button("Sent");
		
		// specify minimum size
		info.setMinSize(tabs.getPrefWidth(), tabs.getPrefHeight());
		messages.setMinSize(tabs.getPrefWidth(), tabs.getPrefHeight());
		pastVisits.setMinSize(tabs.getPrefWidth(), tabs.getPrefHeight());
		scheduleVisit.setMinSize(tabs.getPrefWidth(), tabs.getPrefHeight());
		backToHome.setMinSize(tabs.getPrefWidth(), tabs.getPrefHeight());
		inbox.setMinSize(tabs.getPrefWidth(), tabs.getPrefHeight());
		write.setMinSize(tabs.getPrefWidth(), tabs.getPrefHeight());
		sent.setMinSize(tabs.getPrefWidth(), tabs.getPrefHeight());
		
		
		// link source nodes with handler objects
		backToHome.setOnMouseClicked(new LogoutHandler());
		info.setOnMouseClicked(new InfoHandler());
		messages.setOnMouseClicked(new MessagesHandler());
		pastVisits.setOnMouseClicked(new PastVisitsHandler());
		scheduleVisit.setOnMouseClicked(new ScheduleVisitHandler());
		
		mTitle.setText("Messaging Center");
		mTitle.setFont(titleFont);
		
		// add elements to tabs
		tabs.getChildren().addAll(info, messages, pastVisits, scheduleVisit, backToHome);
		moreTabs.getChildren().addAll(inbox, write, sent);
		
		grid.add(mTitle, 0, 0);
		grid.add(blank, 0, 1);
		grid.add(moreTabs, 0, 3);
		
				
		// set elements to borderPane
		this.setLeft(tabs);	
		this.setBackground(defaultBg);
		this.getLeft().setStyle("-fx-background-color: darkgrey");
		this.setCenter(grid);
		
		inbox.setOnAction(e -> {
			
		});
		
		write.setOnAction(e -> {
			
		});
		
		sent.setOnAction(e -> {
			
		});
		
	}
	
		// information
		private class InfoHandler implements EventHandler<MouseEvent>
		{
			public void handle(MouseEvent infoEvent)
			{
				if (infoEvent.getEventType() == MouseEvent.MOUSE_CLICKED)
				{
					Scene infoScene = WelcomePage.getInformation();
					WelcomePage.getStage().setScene(infoScene);
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
					Scene messageScene = WelcomePage.getMessagePortal();
					WelcomePage.getStage().setScene(messageScene);
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
					Scene visitScene = WelcomePage.getPastVisits();
					WelcomePage.getStage().setScene(visitScene);
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
					Scene scheduleScene = WelcomePage.getScheduleAVisit();
					WelcomePage.getStage().setScene(scheduleScene);
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
					Scene loginScene = WelcomePage.getWelcomeLogin();
					WelcomePage.getStage().setScene(loginScene);
				}
			}
		}
		
}
