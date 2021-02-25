/**
*booking class that stores the bookings
*/
public class Booking{
    //declaring the attributes for the Bookable room object
    private AssistantOnShift assistantOnShift;
    private BookableRoom bookableRoom;
    private String date;
    private String time;
    private String studentEmail;
    private String status;
    
    /**
    *creating a Assistant on shift object from inputs
    */
    public Booking(AssistantOnShift assistantonshift_, BookableRoom bookableroom_, String email_){
        //allocating the assistant and bookable room objects to the assistant and bookable room attributes
        this.assistantOnShift = assistantonshift_;
        assistantonshift_.makeBusy();
        this.bookableRoom = bookableroom_;
        bookableroom_.addOccupant();
        //allocating the date and time and status to the assistant on shift object
        this.date = bookableroom_.getDate();
        this.time = bookableroom_.getTime();
        this.studentEmail = email_;
        this.status = "SCHEDULED";
    }
    
    /**
    *method to free the assistant shift and remove one from the occupancy
    */
    public void removeBooking(){
        this.assistantOnShift.makeFree();
        this.bookableRoom.removeOccupant();
    }
    
    /**
    *method to get the date of a booking
    */
    public String getDate(){
        return this.date;
    }
    
    /**
    *method to get the time of a booking
    */
    public String getTime(){
        return this.time;
    }
    
    /**
    *method to get the student email of a booking
    */
    public String getStudentEmail(){
        return this.studentEmail;
    }
    
    /**
    *method to get the status of a booking
    */
    public String getStatus(){
        return this.status;
    }
    
    /**
    *method to conclude a booking
    */
    public void conclude(){
        this.status = "COMPLETED";
    }
    
    /**
    *method to override the toString method and return the transcript
    */
    @Override
    public String toString() {
        return " | " + this.date + " " + this.time + " | " + this.status + " | " + this.assistantOnShift.getAssistantEmail() + " | " + this.bookableRoom.getRoomCode() + " | " + this.studentEmail + " | ";
    }
}
