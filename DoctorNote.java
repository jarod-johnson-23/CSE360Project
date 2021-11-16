package application;

public class DoctorNote {
    private String subject;     // Subject of doctor note
    private String note;        // Note of doctor note
    private String date;        // Date of doctor note
    private String signature;   // Signature of doctor note

    // Default Constructor
    public DoctorNote() {
        this.subject = null;
        this.note = null;
        this.date = null;
        this.signature = null;
    }

    //---------------------------------------------------------------------------------------------------
    // SETTER METHODS

    // Sets the doctor note
    public void setDocNote(String subject, String date, String note, String signature) {
        this.subject = subject;
        this.note = note;
        this.date = date;
        this.signature = signature;
    }

    //---------------------------------------------------------------------------------------------------
    // GETTER METHODS

    // Gets the note of doctor note
    public String getNote() {
        return note;
    }

    // Gets the date of doctor note
    public String getDate() {
        return date;
    }

    // Gets the subject of doctor note
    public String getSubject() {
        return subject;
    }

    // Gets the signature of doctor note
    public String getSignature() {
        return signature;
    }

    public void printDoctorNote() {
        System.out.println("Subject: " + this.subject +
                ", Note: " + this.note +
                ", Date: " + this.date +
                ", Signature: " + this.signature);
    }
}

