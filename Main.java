package application;

	
import javafx.scene.image.Image;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextFlow;

//file import
import java.io.*;
import java.util.Scanner;


public class Main extends Application {
	private static int height = 700;
	private static int width = 1000;
	private String inputUsername;
	private String inputPassword;
	private Stage window;
	private int loginIndex = -1;
	private Patient[] patients = new Patient[20];
	private Patient[] practisePatients = new Patient[20];
	private Patient[] seussPatients = new Patient[20];
	
	
	private Doctor drPractise;
	private Doctor drSeuss;
	private Doctor fakeDoctor;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			
			
			
			window = primaryStage;
			
			drPractise = new Doctor("Mal Practise", "#1doctor", "password", practisePatients, 100);
			drSeuss = new Doctor("Harold Seuss", "#2doctor", "greeneggsandham", seussPatients, 101);
			fakeDoctor = new Doctor("fakeDoctor", "fake", "doctor", patients, 200);
			
			
			//Set all patient objects to null
			for(int i = 0; i < patients.length; i++) {
				patients[i] = new Patient(null, null, null, 0, null, null, null, null, null, null, fakeDoctor, null, null);
			}
			for(int i = 0; i < practisePatients.length; i++) {
				practisePatients[i] = new Patient(null, null, null, 0, null, null, null, null, null, null, drPractise, null, null);
				seussPatients[i] = new Patient(null, null, null, 0, null, null, null, null, null, null, drSeuss, null, null);
			}
			
			//Inupt file initialized
			File dataFile = new File("dataFile.txt");
			Scanner scan = new Scanner(dataFile);
			String tempStr;
			int choice;
			int importIndex = 0;
			int stop = 0;
			
			/*
			 * Each patient object is stored line-by-line in this order:
			 * 1) A number to indicate if it is a patient object or not
			 * 2) First name
			 * 3) Middle name
			 * 4) Last name
			 * 5) Age
			 * 6) Birthday
			 * 7) gender
			 * 8) address
			 * 9) phone number
			 * 10) email
			 * 11) pharmacy
			 * 12) a integer where 10 means the doctor is Dr.practise, and 20 means Dr. Seuss
			 * 13) username
			 * 14) password
			 * 15) the rest of the lines are health concerns, the health concerns end when "end" is found
			 * 
			 */
			if(dataFile.exists()) {
				
				System.out.println("File name: " + dataFile.getName());
			    System.out.println("Writeable: " + dataFile.canWrite());
			    System.out.println("Readable " + dataFile.canRead());
			    System.out.println("File size in bytes " + dataFile.length());
				do {
					choice = Integer.parseInt(scan.nextLine());
					
					if(choice == 0) {
						stop = 0;
						tempStr = scan.nextLine();
						if(tempStr.equals("null"))
							tempStr = null;
						patients[importIndex].setFName(tempStr);
						tempStr = scan.nextLine();
						if(tempStr.equals("null"))
							tempStr = null;
						patients[importIndex].setMName(tempStr);
						tempStr = scan.nextLine();
						if(tempStr.equals("null"))
							tempStr = null;
						patients[importIndex].setLName(tempStr);
						patients[importIndex].setAge(Integer.parseInt(scan.nextLine()));
						tempStr = scan.nextLine();
						if(tempStr.equals("null"))
							tempStr = null;
						patients[importIndex].setBday(tempStr);
						tempStr = scan.nextLine();
						if(tempStr.equals("null"))
							tempStr = null;
						patients[importIndex].setGender(tempStr);
						tempStr = scan.nextLine();
						if(tempStr.equals("null"))
							tempStr = null;
						patients[importIndex].setAddr(tempStr);
						tempStr = scan.nextLine();
						if(tempStr.equals("null"))
							tempStr = null;
						patients[importIndex].setPhone(tempStr);
						tempStr = scan.nextLine();
						if(tempStr.equals("null"))
							tempStr = null;
						patients[importIndex].setEmail(tempStr);
						tempStr = scan.nextLine();
						if(tempStr.equals("null"))
							tempStr = null;
						patients[importIndex].setPharmacy(tempStr);
						if(Integer.parseInt(scan.nextLine()) == 10) {
							patients[importIndex].setDoctor(drPractise);
						} else {
							patients[importIndex].setDoctor(drSeuss);
						}
						tempStr = scan.nextLine();
						if(tempStr.equals("null"))
							tempStr = null;
						patients[importIndex].setUsername(tempStr);
						tempStr = scan.nextLine();
						if(tempStr.equals("null"))
							tempStr = null;
						patients[importIndex].setPassword(tempStr);
						do {
							tempStr = scan.nextLine();

							if(tempStr.equals("end") == false) {
								
								patients[importIndex].addIssue(tempStr);
								
							}
						} while(tempStr.equals("end") == false);
						
					} 
					if(patients[importIndex].getDoctor() == drPractise) {
						drPractise.addPatient(patients[importIndex]);
					} else {
						drSeuss.addPatient(patients[importIndex]);
					}
					
					importIndex++;
				} while(scan.hasNextLine());
							
			} else {
				System.out.println("Doesnt exist");
			}
			System.out.println(patients[0].getIssue(0));
			System.out.println(patients[0].getIssue(1));
			System.out.println(patients[0].getIssue(2));
			System.out.println(patients[0].getIssue(3));
			scan.close();
			
			
			//Font for title text
			Font titleFont = new Font("Cambria", 24);
			
			//Background Image
			Image bgPic = new Image("file:iu-8.jpeg", width, height, false, false);
			BackgroundImage backImage = new BackgroundImage(bgPic, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
			Background bGround = new Background(backImage);
			//Default background pic for every other page
			Image defaultBgPic = new Image("file:iu-9.jpeg", width, height, false, false);
			BackgroundImage defaultImage = new BackgroundImage(defaultBgPic, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
			Background defaultBg = new Background(defaultImage);
			//Square behind login info
			BackgroundFill logInBgFill = new BackgroundFill(Color.color(1, 0.7, 0.4, 0.75), new CornerRadii(30), new Insets(200, 0, 200, 0));
			Background backing = new Background(logInBgFill);
			//Square behind information text on main screen
			BackgroundFill textFlowBgFill = new BackgroundFill(Color.color(1, 0.7, 0.4, 0.75), new CornerRadii(30), new Insets(328, 0, 215, -50));
			Background textFlowBacking = new Background(textFlowBgFill);
			//Patient homepage white background fill
			BackgroundFill patHpBgFill = new BackgroundFill(Color.WHITESMOKE, new CornerRadii(10), new Insets(100, 200, 150, 10));
			Background patHpBg = new Background(patHpBgFill);
			
			//Login screen grid
			GridPane grid = new GridPane();
			
			//Doctor Home Page
			GridPane doctorRoot = new GridPane();
			Scene doctorHp = new Scene(doctorRoot, width, height);
			doctorHp.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
			
			//Patient Home Page
			BorderPane patHp = new BorderPane();
			patHp.setBackground(defaultBg);
			Scene patientHp = new Scene(patHp, width, height);
			patientHp.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
			
			//Nurse Home Page
			BorderPane nurseRoot = new BorderPane();
			Scene nurseHp = new Scene(nurseRoot, width, height);
			nurseHp.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
			
			
			
			
			Label title = new Label("Welcome to the Totally Normal Doctor's Office");
			title.setFont(titleFont);
			Label description = new Label("Our office specializes in top of the line Pediatric care with help from Dr. Mal Practise and Dr. Harold Seuss Jr. We \"Totally\" care that you have a \"Normal\" experience at our \"Doctor's Office\"");
			description.setWrapText(true);
			description.setMaxWidth(300);
			description.setTextAlignment(TextAlignment.CENTER);
			description.setTranslateX(-27);
			description.setTranslateY(350);
			Label label1 = new Label("Login: ");
			Label label2 = new Label("Username: ");
			Label label3 = new Label("Password: ");
			Label success = new Label("");
			Label errorLabel = new Label("");
			errorLabel.setTextFill(Color.RED);
			
			TextField usernameText = new TextField();
			usernameText.setPromptText("Enter Username");
			TextField passwordText = new TextField();
			passwordText.setPromptText("Enter Password");
			
			//Buttons on bottom of login screen
			Button submit = new Button("Submit");
			submit.setPrefWidth(162);
			Button about = new Button("About");
			about.setPrefWidth(150);
			Button staff = new Button("Staff");
			staff.setPrefWidth(150);
			Button faq = new Button("FAQ's");
			faq.setPrefWidth(150);
			Button report = new Button("Report Bug");
			report.setPrefWidth(150);
			Button privacy = new Button("Privacy Policy");
			privacy.setPrefWidth(150);
			Button newAccount = new Button("Create an Account");
			newAccount.setPrefWidth(162);
			Button forgotPassword = new Button("Forgot Password?");
			
			//Login screen 
			grid.setMinSize(200, 600);
			grid.setPadding(new Insets(10, 10, 10, 10));
			grid.setVgap(10);
			grid.setHgap(20);
			grid.setAlignment(Pos.CENTER_LEFT);
			grid.add(title, 0, 0, 3, 1);
			grid.add(label1, 0, 1);
			grid.add(label2, 0, 2);
			grid.add(label3, 0, 3);
			grid.add(errorLabel,  2, 2);
			grid.add(usernameText, 1, 2);
			grid.add(passwordText, 1, 3);
			grid.add(submit, 1, 4);
			grid.add(newAccount, 1, 5);
			grid.add(success, 2, 3);
			grid.add(forgotPassword, 2, 5);
			grid.setBackground(backing);
			
			Button exit = new Button("exit");
			grid.add(exit, 0, 6);
			
			//Login Screen Text Box Layout
			TextFlow textFlow = new TextFlow();
			textFlow.getChildren().addAll(description);
			textFlow.setBackground(textFlowBacking);
			
			//Login Screen Bottom Buttons Layout
			HBox bottomScreen = new HBox();
			bottomScreen.setSpacing(55);
			bottomScreen.getChildren().addAll(about, staff, faq, report, privacy);
			
			//Login Screen Main Layout
			BorderPane root = new BorderPane();
			root.setRight(textFlow);
			root.setLeft(grid);
			root.setBottom(bottomScreen);
			root.setPadding(new Insets(10));
			root.setBackground(bGround);
			
			//Login scene
			Scene logIn = new Scene(root,width,height);
			logIn.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
							
			window.setTitle("https://www.totallyNormalDoctorsOffice.com");
			window.setScene(logIn);
			window.show();
			
			
			Button returnButton = new Button("Return");
			returnButton.setOnAction(e -> { 
				window.setScene(logIn);
				errorLabel.setText("");
			
			});
			
			Button submitInfo = new Button("Create Account");
			
			Label label10 = new Label("Create Account");
			label10.setFont(titleFont);
			Label label11 = new Label("Personal/Medical Information");
			label11.setFont(titleFont);
			Label label12 = new Label("First Name");
			Label label13 = new Label("Middle Name");
			Label label14 = new Label("Last Name");
			Label label15 = new Label("Email Address");
			Label label16 = new Label("Pharmacy");
			Label label17 = new Label("Gender");
			Label label18 = new Label("Home Address");
			Label label19 = new Label("Phone Number");
			Label label20 = new Label("Date of Birth");
			Label label21 = new Label("Medical Conditions");
			Label label22 = new Label("Username");
			Label label23 = new Label("Password");
			Label label24 = new Label("Select a Doctor");
			Label failure = new Label("");
			
			failure.setTextFill(Color.RED);
			
			TextField field12 = new TextField();
			TextField field13 = new TextField();
			TextField field14 = new TextField();
			TextField field15 = new TextField();
			TextField field16 = new TextField();
			TextField field17 = new TextField();
			TextField field18 = new TextField();
			TextField field19 = new TextField();
			TextField field20 = new TextField();
			TextField field21 = new TextField();
			TextField field22 = new TextField();
			TextField field23 = new TextField();
			
			VBox toggles = new VBox();
			final ToggleGroup doctorGroup = new ToggleGroup();
			RadioButton practise = new RadioButton("Dr. Practise");
			RadioButton seuss = new RadioButton("Dr. Seuss");
			practise.setToggleGroup(doctorGroup);
			seuss.setToggleGroup(doctorGroup);
			toggles.getChildren().addAll(practise, seuss);
			
			
			GridPane createAccount = new GridPane();
			createAccount.setPadding(new Insets(10, 10, 10, 10));
			createAccount.setVgap(10);
			createAccount.setHgap(20);
			createAccount.setBackground(defaultBg);
			
			createAccount.add(returnButton, 0, 0);
			createAccount.add(label10, 1, 1, 2, 1);
			createAccount.add(label11, 1, 2, 2, 1);
			createAccount.add(label12, 1, 3);
			createAccount.add(field12, 1, 4);
			createAccount.add(label13, 1, 5);
			createAccount.add(field13, 1, 6);
			createAccount.add(label14, 1, 7);
			createAccount.add(field14, 1, 8);
			createAccount.add(label15, 1, 9);
			createAccount.add(field15, 1, 10);
			createAccount.add(label16, 1, 11);
			createAccount.add(field16, 1, 12);
			createAccount.add(label17, 1, 13);
			createAccount.add(field17, 1, 14);
			createAccount.add(label18, 3, 3);
			createAccount.add(field18, 3, 4);
			createAccount.add(label19, 3, 5);
			createAccount.add(field19, 3, 6);
			createAccount.add(label20, 3, 7);
			createAccount.add(field20, 3, 8);
			createAccount.add(label21, 3, 9);
			createAccount.add(field21, 3, 10);
			createAccount.add(label22, 3, 11);
			createAccount.add(field22, 3, 12);
			createAccount.add(label23, 3, 13);
			createAccount.add(field23, 3, 14);
			createAccount.add(submitInfo, 3, 15, 2, 1);
			createAccount.add(failure, 3, 16);
			createAccount.add(label24, 1, 15);
			createAccount.add(toggles, 1, 16);
			
			Scene newAccountPage = new Scene(createAccount, width, height);
			newAccountPage.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
			
			Button logOut = new Button("Log Out");
			Button vitals = new Button("Vitals");
			vitals.setPrefWidth(150);
			Button personalInfo = new Button("Personal Information");
			personalInfo.setPrefWidth(150);
			Button drNotes = new Button("Doctor's Notes");
			drNotes.setPrefWidth(150);
			Button makePrescription = new Button("Make Prescription");
			makePrescription.setPrefWidth(150);
			

			Label welcomeDr = new Label("");
			welcomeDr.setFont(titleFont);
			Label pats = new Label("Patients");
			Label actions = new Label("Please choose an action");
			
			//List that holds all the doctor's patients.
			ListView<String> patientNames = new ListView<String>();
			ObservableList<String> items = FXCollections.<String>observableArrayList();
			
			doctorRoot.add(logOut, 0, 0);
			doctorRoot.add(welcomeDr, 1, 1, 3, 1);
			doctorRoot.add(pats, 1, 2);
			doctorRoot.add(patientNames, 1, 3, 2, 3);
			doctorRoot.add(actions, 1, 6);
			doctorRoot.add(vitals, 1, 7, 2, 1);
			doctorRoot.add(personalInfo, 1, 8, 2, 1);
			doctorRoot.add(drNotes, 1, 9, 2, 1);
			doctorRoot.add(makePrescription, 1, 10, 2, 1);
			doctorRoot.setPadding(new Insets(10, 10, 10, 10));
			doctorRoot.setVgap(10);
			doctorRoot.setHgap(20);
			doctorRoot.setBackground(defaultBg);
			
			
			VBox tabs = new VBox();
			tabs.setPadding(new Insets(20, 0 ,20, 20));
			tabs.setPrefSize(200, 65);
			
			//Left tab buttons on patient home page
			Button info = new Button("Information");
			info.setMinSize(tabs.getPrefWidth(), tabs.getPrefHeight());
			Button messages = new Button("Messages");
			messages.setMinSize(tabs.getPrefWidth(), tabs.getPrefHeight());
			Button pastVisits = new Button("Past Visits");
			pastVisits.setMinSize(tabs.getPrefWidth(), tabs.getPrefHeight());
			Button scheduleVisit = new Button("Schedule A Visit");
			scheduleVisit.setMinSize(tabs.getPrefWidth(), tabs.getPrefHeight());
			Button backToHome = new Button("Logout");
			backToHome.setMinSize(tabs.getPrefWidth(), tabs.getPrefHeight());
			
			Label welcomePatient = new Label();
			welcomePatient.setFont(titleFont);
			Label summOnHp = new Label("Summary of Last Visit:");
			Label summTextBox = new Label("There is no record of your last visit at Totally Normal Doctor's Office....ekrjv wlkejnr vlwkej nrvlk wjenr lvkjnwe  lkjrnvl wkej  nrlvk wj enrlv xskwjenrv");
			summTextBox.setWrapText(true);
			summTextBox.setMaxWidth(550);
			
			
			VBox mid = new VBox();
			mid.setBackground(patHpBg);
			mid.setPadding(new Insets(20, 20, 20, 20));
			mid.setSpacing(20);
			mid.getChildren().addAll(welcomePatient, summOnHp, summTextBox);
			
			patHp.setCenter(mid);
			
			tabs.getChildren().addAll(info, messages, pastVisits, scheduleVisit, backToHome);
			patHp.setLeft(tabs);		
			patHp.getLeft().setStyle("-fx-background-color: darkgrey");
			
			
			//Exit button saves input to the dataFile
			exit.setOnAction(e -> {
				try {
					FileWriter outFile = new FileWriter("dataFile.txt");
					BufferedWriter output = new BufferedWriter(outFile);
					
					
					
					for(int i = 0; i < patients.length; i++) {
						int index = 0;
						
						output.write("0\n");
						output.write(patients[i].getFName() + "\n");
						output.write(patients[i].getMName() + "\n");
						output.write(patients[i].getLName() + "\n");
						output.write(patients[i].getAge() + "\n");
						output.write(patients[i].getBday() + "\n");
						output.write(patients[i].getGender() + "\n");
						output.write(patients[i].getAddress() + "\n");
						output.write(patients[i].getPhoneNumber() + "\n");
						output.write(patients[i].getEmail() + "\n");
						output.write(patients[i].getPharmacy() + "\n");
						if(patients[i].getDoctor() == drPractise) {
							output.write("10\n");
						} else {
							output.write("20\n");
						}
						output.write(patients[i].getUsername() + "\n");
						output.write(patients[i].getPassword() + "\n");
						while(patients[i].getIssue(index) != null) {
							output.write(patients[i].getIssue(index) + "\n");
							index++;
						}
						
						output.write("end\n");
						
					}
					
					output.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
				window.close();
			});
				
			//Go back to login screen
			logOut.setOnAction(e -> {
				window.setScene(logIn);	
				errorLabel.setText("");
				success.setText("");
				if(loginIndex >= 100) {
					items.clear();
				}
				loginIndex = -1;
			});
			
			//logout of patient home page
			backToHome.setOnAction(e -> {
				window.setScene(logIn);
				errorLabel.setText("");
				success.setText("");
				loginIndex = -1;
			});
			
			//Submitting the new patient information
			submitInfo.setOnAction(e-> {
				int added;
				Doctor tempDr;
				errorLabel.setText("");
				if(practise.isSelected()) {
					tempDr = drPractise;
				} else {
					tempDr = drSeuss;
				}
				added = addPatient(field12.getText(), field13.getText(), field14.getText(), field20.getText(), 
						field17.getText(), field18.getText(), field19.getText(), field15.getText(), field16.getText(),
						field21.getText(), tempDr, field22.getText(), field23.getText());
				field12.clear();
				field13.clear();
				field14.clear();
				field15.clear();
				field16.clear();
				field17.clear();
				field18.clear();
				field19.clear();
				field20.clear();
				field21.clear();
				field22.clear();
				field23.clear();
				
				if(added == -1) {
					failure.setText("Failed to Add Account");
				}
				if(added != -1) {
					window.setScene(logIn);
					success.setText("Account Created Successfully!");
				}				
			});
			
			//Extracting Username/Password Data into inputUsername and inputPassword variables
			submit.setOnAction(e -> {
				inputUsername = usernameText.getText();
				inputPassword = passwordText.getText();
				usernameText.clear();
				passwordText.clear();
				loginIndex = checkLogin(inputUsername, inputPassword);
				if(loginIndex == -1) {
					errorLabel.setText("Incorrect Username or Password");
				} else if(loginIndex == 100 || loginIndex == 101) {
					if(loginIndex == 100) {
						welcomeDr.setText("Welcome Dr. Practise");
					} else if(loginIndex == 101) {
						welcomeDr.setText("Welcome Dr. Seuss");
					}
					if(loginIndex == 100) {
						for(int i = 0; i < practisePatients.length; i++) {
							if(practisePatients[i].getFName() != null) {
								items.add(practisePatients[i].getFName() + " " + practisePatients[i].getLName());
							}
						}
						
					} else if(loginIndex == 101) {
						for(int i = 0; i < seussPatients.length; i++) {
							if(seussPatients[i].getFName() != null) {
								items.add(seussPatients[i].getFName() + " " + seussPatients[i].getLName());
							}
						}
						
					}
					patientNames.setItems(items);
					window.setScene(doctorHp);
				} else if(loginIndex >= 102) {
					window.setScene(nurseHp);
				} else if(loginIndex >=0) {
					window.setScene(patientHp);
					welcomePatient.setText("Welcome, " + patients[loginIndex].getFName() + " " + patients[loginIndex].getLName());
				}
			});
			
			//Takes User to the create a new account page
			newAccount.setOnAction(e -> {
				window.setScene(newAccountPage);
			});
					
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	//function checks if the login information is  a valid username. Returning 100 means it was Dr. Practise,
	//	 returning 101 means it was Dr. Seuss, returning >=102 means it is a nurse, returning a number 0-99 means it is a patient.
	public int checkLogin(String username, String password) {
		
		if(username.equals(drPractise.getUsername()) && password.equals(drPractise.getPassword())) {
			return 100;
		} else if(username.equals(drSeuss.getUsername()) && password.equals(drSeuss.getPassword())) {
			return 101;
		} else if(username.equals("nurseUsername") && password.equals("nursePassword")) {
			return 102;
		} else {
			for(int i = 0; i < patients.length; i++) {
				if((username.equals(patients[i].getUsername()) == true) && (password.equals(patients[i].getPassword()) == true)) {
					return i;
				}
			}
		}
		return -1;
	}
	
	//Add a patient in the next available spot on the array.
	public int addPatient(String first, String middle, String last, String birth, String gen,
						String addr, String number, String emailAddr, String pharm, String issues, Doctor aDoctor, 
						String uName, String pWord) {
		int i = 0;
		while(patients[i].getFName() != null) {
			i++;
			if(i >= patients.length) {
				return -1;
			}
		}
		patients[i].setFName(first);
		patients[i].setMName(middle);
		patients[i].setLName(last);
		patients[i].setBday(birth);
		patients[i].setGender(gen);
		patients[i].setAddr(addr);
		patients[i].setPhone(number);
		patients[i].setEmail(emailAddr);
		patients[i].setPharmacy(pharm);
		patients[i].setUsername(uName);
		patients[i].setPassword(pWord);
		patients[i].addIssue(issues);
		System.out.println(issues);
		patients[i].setDoctor(aDoctor);
		
		int j = 0;
		
		if(aDoctor == drPractise) {
			while(practisePatients[j].getFName() != null) {
				j++;
			}
			practisePatients[j] = patients[i];
			return 0;
		} else {
			while(seussPatients[j].getFName() != null) {
				j++;
			}
			seussPatients[j] = patients[i];
			return 0;
		}
	}
}
