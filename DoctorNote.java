package application;

public class DoctorNote {
    private String subject;
    private String note;
    private String date;
    private String signature;

    public DoctorNote() {
        this.subject = null;
        this.note = null;
        this.date = null;
        this.signature = null;
    }

    public void setDocNote(String subject, String date, String note, String signature) {
        this.subject = subject;
        this.note = note;
        this.date = date;
        this.signature = signature;
    }

    public String getNote() {
        return note;
    }

    public String getDate() {
        return date;
    }

    public String getSubject() {
        return subject;
    }

    public String getSignature() {
        return signature;
    }
}
