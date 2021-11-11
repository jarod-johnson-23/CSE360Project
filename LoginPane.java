package application;

import java.io.FileNotFoundException;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
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
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextFlow;

public class LoginPane extends BorderPane
{
	// declare variables
	private static Scene Login;
	private Font titleFont;
	private int width = 1500;
	private int height = 1000;
	private Label title, description, label1, label2, label3, success, error;
	private TextField usernameText, passwordText;
	private Button submit, about, staff, faq, report, privacy, newAccount, forgotPassword;
	private TextFlow textFlow;
	
	public LoginPane() throws FileNotFoundException
	{
		// define font
		titleFont = new Font("Cambria", 24);
		
		// define background image 
		Image bgPic = new Image("file:iu-8.jpeg", width, height, false, false);
		BackgroundImage backImage = new BackgroundImage(bgPic, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
		Background bGround = new Background(backImage);
		
		// create square behind login info
		BackgroundFill logInBgFill = new BackgroundFill(Color.color(1, 0.7, 0.4, 0.75), new CornerRadii(30), new Insets(200, 0, 200, 0));
		Background backing = new Background(logInBgFill);
		
		// create square behind information text on main screen
		BackgroundFill textFlowBgFill = new BackgroundFill(Color.color(1, 0.7, 0.4, 0.75), new CornerRadii(30), new Insets(328, 0, 215, -50));
		Background textFlowBacking = new Background(textFlowBgFill);
		
		// define title label
		title = new Label("Welcome to the Totally Normal Doctor's Office");
		title.setFont(titleFont);
		
		// define description label
		description = new Label("Our office specializes in top of the line Pediatric care with help from Dr. Mal Practise and Dr. Harold Seuss Jr. We \"Totally\" care that you have a \"Normal\" experience at our \"Doctor's Office\"");
		description.setWrapText(true);
		description.setMaxWidth(300);
		description.setTextAlignment(TextAlignment.CENTER);
		description.setTranslateX(-27);
		description.setTranslateY(350);
		
		// define login prompt labels
		label1 = new Label("Login: ");
		label2 = new Label("Username: ");
		label3 = new Label("Password: ");
		
		// define success and error labels
		success = new Label("");
		error = new Label("");
		error.setTextFill(Color.RED);
		
		// define textFields
		usernameText = new TextField();
		usernameText.setPromptText("Enter Username");
		passwordText = new TextField();
		passwordText.setPromptText("Enter Password");
		
		// define buttons
		submit = new Button("Submit");
		submit.setPrefWidth(162);
		about = new Button("About");
		about.setPrefWidth(150);
		staff = new Button("Staff");
		staff.setPrefWidth(150);
		faq = new Button("FAQ's");
		faq.setPrefWidth(150);
		report = new Button("Report Bug");
		report.setPrefWidth(150);
		privacy = new Button("Privacy Policy");
		privacy.setPrefWidth(150);
		newAccount = new Button("Create an Account");
		newAccount.setPrefWidth(162);
		forgotPassword = new Button("Forgot Password?");
		
		// define gridPane
		GridPane grid = new GridPane();
		
		// add elements to grid
		grid.setMinSize(200, 600);
		grid.setPadding(new Insets(10, 10, 10, 10));
		grid.setVgap(10);
		grid.setHgap(20);
		grid.setAlignment(Pos.CENTER_LEFT);
		grid.add(title, 0, 0, 3, 1);
		grid.add(label1, 0, 1);
		grid.add(label2, 0, 2);
		grid.add(label3, 0, 3);
		grid.add(error,  2, 2);
		grid.add(usernameText, 1, 2);
		grid.add(passwordText, 1, 3);
		grid.add(submit, 1, 4);
		grid.add(newAccount, 1, 5);
		grid.add(success, 2, 3);
		grid.add(forgotPassword, 2, 5);
		grid.setBackground(backing);
		
		// create textFlow
		textFlow = new TextFlow();
		textFlow.getChildren().addAll(description);
		textFlow.setBackground(textFlowBacking);
		
		// define hBox for bottom buttons
		HBox bottomScreen = new HBox();
		bottomScreen.setSpacing(55);
		bottomScreen.getChildren().addAll(about, staff, faq, report, privacy);
		
		// define main borderPane
		this.setRight(textFlow);
		this.setLeft(grid);
		this.setBottom(bottomScreen);
		this.setPadding(new Insets(10));
		this.setBackground(bGround);
		
		// link source nodes with handler objects
		newAccount.setOnMouseClicked(new CreateHandler());
		submit.setOnMouseClicked(new SubmitHandler());
	}
	
	// create
	private class CreateHandler implements EventHandler<MouseEvent>
	{
		public void handle(MouseEvent createEvent)
		{
			if (createEvent.getEventType() == MouseEvent.MOUSE_CLICKED)
			{
				Scene createScene = WelcomePage.getCreateAccount();
				WelcomePage.getStage().setScene(createScene);
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
				// TODO - check user name and password
				// scene is dependent on whether doctor/nurse/patient is logging in

				Scene submitScene = WelcomePage.getEmployeeHome();
				WelcomePage.getStage().setScene(submitScene);
				
			}
		}
	}
}






