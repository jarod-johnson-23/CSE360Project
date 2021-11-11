package application;


public class Patient {
	private String fName;
	private String mName;
	private String lName;
	private int age;
	private String birthday;
	private String gender;
	private String address;
	private String phoneNumber;
	private String email;
	private String pharmacy;
	private String healthIssues[] = new String[10];
	private String medications[] = new String[10];
	private String vaccines[] = new String[10];
	private String allergies[] = new String[10];
	private String healthConcerns[] = new String[10];
	private Doctor doctor;
	private String username;
	private String password;
	
	public Patient(String fName, String mName, String lName, int age, String birthday, String gender,
						String address, String phoneNumber, String email, String pharmacy, 
					    String[] healthConcerns, Doctor doctor, String username, String password)
	{
		this.fName = fName;
		this.mName= mName;
		this.lName = lName;
		this.age = age;
		this.birthday = birthday;
		this.gender = gender;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.pharmacy = pharmacy;
		this.healthConcerns = healthConcerns;
		this.doctor = doctor;
		this.username = username;
		this.password = password;
	}
	
	//Getter methods
	public String getUsername() {
		return username;
	}	
	public String getPassword() {
		return password;
	}
	public String getFName() {
		return fName;
	}
	public String getMName() {
		return mName;
	}
	public String getLName() {
		return lName;
	}
	public int getAge() {
		return age;
	}
	public String getBday() {
		return birthday;
	}
	public String getGender() {
		return gender;
	}
	public String getAddress() {
		return address;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public String getPharmacy() {
		return pharmacy;
	}
	public Doctor getDoctor() {
		return doctor;
	}
	
	//Setter methods
	public void setUsername(String u) {
		username = u;
	}
	public void setPassword(String p) {
		password = p;
	}
	public void setFName(String n) {
		fName = n;
	}	
	public void setMName(String n) {
		mName = n;
	}
	public void setLName(String n) {
		lName = n;
	}
	public void setAge(int a) {
		age = a;
	}
	public void setBday(String d) {
		birthday = d;
	}
	public void setGender(String g) {
		gender = g;
	}
	public void setAddr(String a) {
		address = a;
	}
	public void setPhone(String p) {
		phoneNumber = p;
	}
	public void setEmail(String e) {
		email = e;
	}
	public void setPharmacy(String p) {
		pharmacy = p;
	}
	public void addIssue(String iss) {
		int i = 0;
		while(healthIssues[i] != null) {
			i++;
		}
		healthIssues[i] = iss;
	}
	public void setDoctor(Doctor aDoctor) {
		doctor = aDoctor;
	}
	
}


