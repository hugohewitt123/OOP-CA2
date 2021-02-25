/**
*Assistant on shift class that stores the assistants on shift
*/
public class AssistantOnShift{
    //declaring the attributes for the Bookable room object
    private Assistant assistant;
    private String date;
    private String time;
    private String status;
    
    /**
    *creating a Assistant on shift object from inputs
    */
    public AssistantOnShift(Assistant assistant_, String date_, BookingSystem bookingsystem_){
        //allocating the assistant object to the assistant attribute
        this.assistant = assistant_;
        //allocating the date and time and status to the assistant on shift object if it isn't a duplicate
        this.date = date_;
        this.time = "09:00";
        this.status = "FREE";
        AssistantOnShift assistantshift = new AssistantOnShift(assistant_, date_, "07:00");
        bookingsystem_.addAssistantShift(assistantshift);
        AssistantOnShift assistantshift1 = new AssistantOnShift(assistant_, date_, "08:00");
        bookingsystem_.addAssistantShift(assistantshift1);
    }
    
    /**
    *creating a Assistant on shift object from inputs
    */
    public AssistantOnShift(Assistant assistant_, String date_, String time_){
        //allocating the assistant object to the assistant attribute
        this.assistant = assistant_;
        //allocating the date and time and status to the assistant on shift object
        this.date = date_;
        this.time = time_;
        this.status = "FREE";
    }
    
    /**
    *method to get assistant email
    */
    public String getStatus(){
        return this.status;
    }
    
    /**
    *method to get assistant email
    */
    public String getAssistantEmail(){
        return this.assistant.getEmail();
    }
    
    /**
    *method to get date
    */
    public String getAssistantShiftDate(){
        return this.date;
    }
    
    /**
    *method to get time
    */
    public String getAssistantShiftTime(){
        return this.time;
    }
    
    /**
    *method to get assistant
    */
    public Assistant getAssistant(){
        return this.assistant;
    }
    
    /**
    *method to get make an assistant busy
    */
    public void makeBusy(){
        this.status = "BUSY";
    }
    
    /**
    *method to get make an assistant free
    */
    public void makeFree(){
        this.status = "FREE";
    }
    
    /**
    *method to override the toString method and return the transcript
    */
    @Override
    public String toString() {
        return " | " + this.date + " " + this.time + " | " + this.status + " | " + this.assistant.getEmail() + " | ";
    }
}
