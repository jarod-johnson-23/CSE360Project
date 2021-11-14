package application;

import java.io.FileNotFoundException;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class CreateAccount extends GridPane
{
	// declare variables 
	private Button returnButton, submitInfo;
	private Label label1, label2, label3, label4, label5, label6, label7, label8, label9, label10, label11, label12, label13, label14, label15, label16, failure;
	private TextField field1, field2, field3, field4, field5, field6, field7, field8, field9, field10, field11, field12, field13;
	private Font titleFont;
	private int width = 1500;
	private int height = 1000;
	private RadioButton practise, seuss;
	
	public CreateAccount() throws FileNotFoundException
	{	
		// define font 
		titleFont = new Font("Cambria", 24);
		
		// define default background image
		Image defaultBgPic = new Image("file:iu-9.jpeg", width, height, false, false);
		BackgroundImage defaultImage = new BackgroundImage(defaultBgPic, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
		Background defaultBg = new Background(defaultImage);
		
		// create buttons
		returnButton = new Button("Return");
		submitInfo = new Button("Create Account");
		
		// create labels
		label1 = new Label("Create Account");
		label2 = new Label("Personal/Medical Information");
		label3 = new Label("First Name");
		label4 = new Label("Middle Name");
		label5 = new Label("Last Name");
		label6 = new Label("Email Address");
		label7 = new Label("Pharmacy");
		label8 = new Label("Gender");
		label9 = new Label("Home Address");
		label10 = new Label("Phone Number");
		label11 = new Label("Date of Birth");
		label12 = new Label("Medical Conditions");
		label13 = new Label("Username");
		label14 = new Label("Password");
		label15 = new Label("Select a Doctor");
		failure = new Label("");
		
		// set title label font
		label1.setFont(titleFont);
		label2.setFont(titleFont);
		
		// set label color
		failure.setTextFill(Color.RED);
		
		// create textFields
		field1 = new TextField();
		field2 = new TextField();
		field3 = new TextField();
		field4 = new TextField();
		field5 = new TextField();
		field6 = new TextField();
		field7 = new TextField();
		field8 = new TextField();
		field9 = new TextField();
		field10 = new TextField();
		field11 = new TextField();
		field12 = new TextField();
		field13 = new TextField();
		
		// create vBox
		VBox toggles = new VBox();
		
		// create toggleGroup
		final ToggleGroup doctorGroup = new ToggleGroup();
		
		// create radio buttons
		practise = new RadioButton("Dr. Practise");
		seuss = new RadioButton("Dr. Seuss");
		
		// add radio buttons to toggle group & toggles to vBox
		practise.setToggleGroup(doctorGroup);
		seuss.setToggleGroup(doctorGroup);
		toggles.getChildren().addAll(practise, seuss);
		
		// create gridPane
		this.setPadding(new Insets(10, 10, 10, 10));
		this.setVgap(10);
		this.setHgap(20);
		this.setBackground(defaultBg);
		
		// add buttons
		this.add(returnButton, 0, 0);
		
		// add labels, fields, and toggles
		this.add(label1, 1, 1, 2, 1);
		this.add(label2, 1, 2, 2, 1);
		this.add(label3, 1, 3);
		this.add(field1, 1, 4);
		this.add(label4, 1, 5);
		this.add(field2, 1, 6);
		this.add(label5, 1, 7);
		this.add(field3, 1, 8);
		this.add(label6, 1, 9);
		this.add(field4, 1, 10);
		this.add(label7, 1, 11);
		this.add(field5, 1, 12);
		this.add(label8, 1, 13);
		this.add(field6, 1, 14);
		this.add(label9, 3, 3);
		this.add(field7, 3, 4);
		this.add(label10, 3, 5);
		this.add(field8, 3, 6);
		this.add(label11, 3, 7);
		this.add(field9, 3, 8);
		this.add(label12, 3, 9);
		this.add(field10, 3, 10);
		this.add(label13, 3, 11);
		this.add(field11, 3, 12);
		this.add(label14, 3, 13);
		this.add(field12, 3, 14);
		this.add(submitInfo, 3, 15, 2, 1);
		this.add(failure, 3, 16);
		this.add(label15, 1, 15);
		this.add(toggles, 1, 16);
		
		// link source nodes with handler objects
		returnButton.setOnMouseClicked(new ReturnHandler());
		submitInfo.setOnMouseClicked(new SubmitHandler());
	}
	
	// return
	private class ReturnHandler implements EventHandler<MouseEvent>
	{
		public void handle(MouseEvent returnEvent)
		{
			if (returnEvent.getEventType() == MouseEvent.MOUSE_CLICKED)
			{
				Scene loginScene = WelcomePage.getWelcomeLogin();
				WelcomePage.getStage().setScene(loginScene);
				
			}
		}
	}
	
	// submit
	private class SubmitHandler implements EventHandler<MouseEvent>
	{
		public void handle(MouseEvent submitEvent)
		{
			if (submitEvent.getEventType() == MouseEvent.MOUSE_CLICKED)
			{
				// declare variables
				int added;
				Doctor tempDr;
				
				// get doctors from radioButtons
				if (practise.isSelected())
				{
					tempDr = WelcomePage.getPractise();
				}
				else
				{
					tempDr = WelcomePage.getSeuss();
				}
				
				added = WelcomePage.addPatient(field1.getText(), field2.getText(), field3.getText(), field9.getText(), field6.getText(), field7.getText(), field8.getText(), field4.getText(), field5.getText(), field10.getText(), tempDr, field11.getText(), field12.getText());
				
				// display error if needed
				if (added == -1)
				{
					failure.setText("Failed to add account.");
				} 
				// move to patient home if login successful
				if (added != -1)
				{
					Scene patientScene = WelcomePage.getPatientHome();
					WelcomePage.getStage().setScene(patientScene);
				}
				
			}
		}
	}
}
