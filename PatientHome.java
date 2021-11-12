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

public class PatientHome extends BorderPane
{
	// declare variables
	private Font titleFont;
	private Button info, messages, pastVisits, scheduleVisit, backToHome;
	private Label welcomePatient, summOnHp, summTextBox;
	private int width = 1500;
	private int height = 1000;
	
	public PatientHome() throws FileNotFoundException
	{
		// define font
		titleFont = new Font("Cambria", 24);
				
		// set patient background
		BackgroundFill patHpBgFill = new BackgroundFill(Color.WHITESMOKE, new CornerRadii(10), new Insets(100, 200, 150, 10));
		Background patHpBg = new Background(patHpBgFill);
		
		// set default background
		Image defaultBgPic = new Image("file:iu-9.jpeg", width, height, false, false);
		BackgroundImage defaultImage = new BackgroundImage(defaultBgPic, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
		Background defaultBg = new Background(defaultImage);
		
		// define vBox
		VBox tabs = new VBox();
		tabs.setPadding(new Insets(20, 0 ,20, 20));
		tabs.setPrefSize(200, 65);
		
		// define buttons
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

		// define labels
		welcomePatient = new Label("Welcome!");
		summOnHp = new Label("Summary of Last Visit:");
		summTextBox = new Label("There is no record of your last visit at Totally Normal Doctor's Office....ekrjv wlkejnr vlwkej nrvlk wjenr lvkjnwe  lkjrnvl wkej  nrlvk wj enrlv xskwjenrv");
		
		// specify label format
		welcomePatient.setFont(titleFont);
		summTextBox.setWrapText(true);
		summTextBox.setMaxWidth(550);
		
		// define vBox
		VBox mid = new VBox();
		mid.setBackground(patHpBg);
		mid.setPadding(new Insets(20, 20, 20, 20));
		mid.setSpacing(20);
		mid.getChildren().addAll(welcomePatient, summOnHp, summTextBox);
		
		// set elements in borderPane
		this.setCenter(mid);
		
		// add elements to tabs
		tabs.getChildren().addAll(info, messages, pastVisits, scheduleVisit, backToHome);
		
		// set elements to borderPane
		this.setLeft(tabs);	
		
		// set style of background
		this.getLeft().setStyle("-fx-background-color: darkgrey");
		
		// link source nodes with handler objects
		backToHome.setOnMouseClicked(new LogoutHandler());
		info.setOnMouseClicked(new InfoHandler());
		//messages.setOnMouseClicked(new MessagesHandler());
		//pastVisits.setOnMouseClicked(new PastVisitsHandler());
		//scheduleVisit.setOnMouseClicked(new ScheduleVisitHandler());
	}
	
	// information
	
	// messages
	
	// past visits
	
	// schedule a visit
	private class InfoHandler implements EventHandler<MouseEvent>
	{
		public void handle(MouseEvent infoEvent)
		{
			if (infoEvent.getEventType() == MouseEvent.MOUSE_CLICKED)
			{
				//Scene infoScene = WelcomePage.getPatientInfo();
				//WelcomePage.getStage().setScene(loginScene);
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
