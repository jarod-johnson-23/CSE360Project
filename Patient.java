package application;

import java.util.List;

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
	private List<Prescription> prescriptions;
	private String medications[] = new String[10];
	private String vaccines[] = new String[10];
	private String allergies[] = new String[10];
	private String healthConcerns[] = new String[10];
	private Doctor doctor;
	private String username;
	private String password;
	
	public Patient(String fName, String mName, String lName, int age, String birthday, String gender,
						String address, String phoneNumber, String email, String pharmacy, List<Prescription> p_list,
					    Doctor doctor, String username, String password)
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
		this.prescriptions = p_list;
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
	
	public String getIssue(int index) {
		return healthConcerns[index];
	}
	public List<Prescription> getPrescriptions()
	{
		return prescriptions;
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
		while(healthConcerns[i] != null) {
			i++;
		}
		healthConcerns[i] = iss;
	}
	
	public void setDoctor(Doctor aDoctor) {
		doctor = aDoctor;
	}
	
	public String concatenateNames()
	{
		String firstHalf = this.fName.concat(" ");
		
		String secondHalf = firstHalf.concat(this.lName);
		
		return secondHalf;
	}
	
	// other methods
		public void addPrescription(Prescription p)
		{
			prescriptions.add(p);
		}
}

