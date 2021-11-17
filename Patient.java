package application;

import java.util.ArrayList;
import java.util.Arrays;
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
    private List<VitalsObject> vitals;
    private int prescrListSize;
    private String medications[] = new String[10];
    private String vaccines[] = new String[10];
    private String allergies[] = new String[10];
    private String healthConcerns[] = new String[10];
    private Doctor doctor;
    private String username;
    private String password;
    private DoctorNote[] doctorNoteArray = new DoctorNote[10];    // Array of doctor notes for patient

    // Default Constructor
    public Patient() {
        this.fName = null;
        this.mName = null;
        this.lName = null;
        this.age = 0;
        this.birthday = null;
        this.gender = null;
        this.address = null;
        this.phoneNumber = null;
        this.email = null;
        this.pharmacy = null;
        this.prescriptions = new ArrayList<Prescription>();
        this.vitals = new ArrayList<VitalsObject>();
        this.prescrListSize = 0;
        this.doctor = null;
        this.username = null;
        this.password = null;

        for (int i = 0; i < doctorNoteArray.length; i++) {
            doctorNoteArray[i] = new DoctorNote();
        }

        if  (prescriptions != null) {
            for (int i = 0; i < prescrListSize; i++) {
                prescriptions.add(null);
            }
        }
    }

    // Constructor
    public Patient(String fName, String mName, String lName, int age, String birthday, String gender,
                   String address, String phoneNumber, String email, String pharmacy, List<Prescription> p_list, List<VitalsObject> v_list,
                   Doctor doctor, String username, String password) {
        this.fName = fName;
        this.mName = mName;
        this.lName = lName;
        this.age = age;
        this.birthday = birthday;
        this.gender = gender;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.pharmacy = pharmacy;
        this.prescriptions = new ArrayList<Prescription>();
        this.vitals = new ArrayList<VitalsObject>();
        this.prescrListSize = prescriptions.size();
        this.doctor = doctor;
        this.username = username;
        this.password = password;

        for (int i = 0; i < doctorNoteArray.length; i++) {
            doctorNoteArray[i] = new DoctorNote();
        }

        for (int i = 0; i < prescrListSize; i++) {
            prescriptions.add(p_list.get(i));
        }
    }

    //---------------------------------------------------------------------------------------------------
    //GETTER METHODS

    // Gets the patients username
    public String getUsername() {
        return username;
    }

    // Gets the patients password
    public String getPassword() {
        return password;
    }

    // Gets the patients first name
    public String getFName() {
        return fName;
    }

    // Gets the patients middle name
    public String getMName() {
        return mName;
    }

    // Gets the patients last name
    public String getLName() {
        return lName;
    }

    // Gets the patients age
    public int getAge() {
        return age;
    }

    // Gets the patients birthday
    public String getBday() {
        return birthday;
    }

    // Gets the patients gender
    public String getGender() {
        return gender;
    }

    // Gets the patients address
    public String getAddress() {
        return address;
    }

    // Gets the patients phone number
    public String getPhoneNumber() {
        return phoneNumber;
    }

    // Gets the patients email
    public String getEmail() {
        return email;
    }

    // Gets the patients pharmacy
    public String getPharmacy() {
        return pharmacy;
    }

    // Gets the patients doctor
    public Doctor getDoctor() {
        return doctor;
    }

    // Gets the patients issue
    public String getIssue(int index) {
        return healthConcerns[index];
    }
    
    // Gets the health concerns
    public String[] getHealthConcerns() {
    	return healthConcerns;
    }

    // Gets the prescription list
    public List<Prescription> getPrescriptions() {
        return prescriptions;
    }

    // Gets a specific prescription from precription list
    public Prescription getSpecificPresc(int index) {
        return prescriptions.get(index);
    }

    // Gets patients prescription list size
    public int getPrescrListSize() {
        return this.prescrListSize;
    }
    
    // Get vaccine list
    public String[] getVaccines() {
    	return this.vaccines;
    }

    //---------------------------------------------------------------------------------------------------
    //SETTER METHODS

    // Sets the patients username
    public void setUsername(String u) {
        username = u;
    }

    // Sets the patients password
    public void setPassword(String p) {
        password = p;
    }

    // Sets the patients first name
    public void setFName(String n) {
        fName = n;
    }

    // Sets the patients middle name
    public void setMName(String n) {
        mName = n;
    }

    // Sets the patients last name
    public void setLName(String n) {
        lName = n;
    }

    // Sets the patients age
    public void setAge(int a) {
        age = a;
    }

    // Sets the patients birthday
    public void setBday(String d) {
        birthday = d;
    }

    // Sets the patients gender
    public void setGender(String g) {
        gender = g;
    }

    // Sets the patients address
    public void setAddr(String a) {
        address = a;
    }

    // Sets the patients phone number
    public void setPhone(String p) {
        phoneNumber = p;
    }

    // Sets the patients email
    public void setEmail(String e) {
        email = e;
    }

    // Sets the patients pharmacy
    public void setPharmacy(String p) {
        pharmacy = p;
    }

    // Sets the prescription list size
    public void setPrescrListSize(int size) {
        prescrListSize = size;
    }

    // Adds an issue to patient
    public void addIssue(String iss) {
        int i = 0;
        while (healthConcerns[i] != null) {
            i++;
        }
        healthConcerns[i] = iss;
    }

    // Sets patients doctor
    public void setDoctor(Doctor aDoctor) {
        doctor = aDoctor;
    }

    // Concatenate first and last name
    public String concatenateNames() {
        String firstHalf = this.fName.concat(" ");

        String secondHalf = firstHalf.concat(this.lName);

        return secondHalf;
    }

    //---------------------------------------------------------------------------------------------------
    // OTHER METHODS

    // Adds prescriptions to the patients prescription list
    public void addPrescription(Prescription p) {
        prescriptions.add(p);
        prescrListSize++;
    }

    // Sets the patients doctor note in their doctor note array
    public void setPatientDocNote(String subject, String date, String docNote, String signature) {
        int i = 0;
        while (i < doctorNoteArray.length) {
            if (doctorNoteArray[i].getDate() == null) {
                break;
            }
            i++;
        }
        
        doctorNoteArray[i].setDocNote(subject, date, docNote, signature);
    }

    // Gets the subject of patients doctor note
    public String getPatDocNoteSub(String date) {
        for (int i = 0; i < doctorNoteArray.length; i++) {
            if (doctorNoteArray[i].getDate() == date) {
                return this.doctorNoteArray[i].getSubject();
            }
        }
        return "";
    }

    // Gets the note of patients doctor note
    public String getPatDocNote(String date) {;
        for (int i = 0; i < doctorNoteArray.length; i++) {
            if (doctorNoteArray[i].getDate() == date) {
                return this.doctorNoteArray[i].getNote();
            }
        }
        return "";
    }

    // Gets the date of patients doctor note
    public String getPatDocNoteDate(String date) {
        for (int i = 0; i < doctorNoteArray.length; i++) {
            if (doctorNoteArray[i].getDate() == date) {
                return this.doctorNoteArray[i].getDate();
            }
        }
        return "";
    }

    // Gets the signature of patients doctor note
    public String getPatDocNoteSig(String date) {
        for (int i = 0; i < doctorNoteArray.length; i++) {
            if (doctorNoteArray[i].getDate() == date) {
                return this.doctorNoteArray[i].getSignature();
            }
        }
        return "";
    }

    // print patient information
    public void printPatient() {
        System.out.println("First Name: " + fName +
                ", Middle Name: " + mName +
                ", Last Name: " + lName +
                ", Age: " + age +
                ", Birthday: " + birthday +
                ", Gender: " + gender +
                ", Address: " + address +
                ", Phone Number: " + phoneNumber +
                ", Email: " + email +
                ", Pharmacy: " + pharmacy +
                ", Medications: " + Arrays.toString(medications) +
                ", Vaccines: " + Arrays.toString(vaccines) +
                ", Allergies: " + Arrays.toString(allergies) +
                ", Health Concerns: " + Arrays.toString(healthConcerns) +
                ", Doctor: " + doctor +
                ", Username: " + username +
                ", Password: " + password);
        System.out.println("\nPrescriptions: ");
        for (int i = 0; i < prescriptions.size(); i++) {
            prescriptions.get(i).printPrescription();
        }

        System.out.print("\nDoctor Note: ");
        for (int i = 0; i < doctorNoteArray.length; i++) {
            doctorNoteArray[i].printDoctorNote();
        }
        System.out.println("---------------------------------------------------------------------------------------------------------");
    }
    
    // store vitals information
    public void storeVitals(String heartRate, String weight, String bodyTemp, String respRate, String bloodPressure)
    {
    	VitalsObject newVitals = new VitalsObject(heartRate, weight, bodyTemp, respRate, bloodPressure);
    	
    	vitals.add(newVitals);
    }
    
    // store vitals information
    public void storeVitals(VitalsObject newVitals)
    {
    	vitals.add(newVitals);
    }
}