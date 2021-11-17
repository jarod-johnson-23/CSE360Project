package application;

import java.util.ArrayList;
import java.util.List;

public class ScheduleAppointment {

    private List<Appointment> appointment_list;

    // constructor
    public ScheduleAppointment()
    {
        appointment_list = new ArrayList<Appointment>();
    }

    //store appointment info
    public void make_appointment(int time, int date, Patient patient, String reason_for_visit) {
        Appointment newAppointment = new Appointment(time, date, patient, reason_for_visit);

        appointment_list.add(newAppointment);
    }
}
