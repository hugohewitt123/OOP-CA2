/**
*A class to manage the bookable rooms, add, remove and list them
*/
public class BookableRoom{
    //declaring the attributes for the Bookable room object
    private Room room;
    private String date;
    private String time;
    private String status;
    private int occupancy;
    
    /**
    *creating a room object from inputs
    */
    public BookableRoom(Room room_, String date_, String time_){
        //allocating the room code and cpacity to the bookable room object from the room object
        this.room = room_;
        this.occupancy = 0;
        //allocating the date and time and status to the bookable room
        this.date = date_;
        this.time = time_;
        this.status = "EMPTY";
    }
    
    /**
    *method to return the room 
    */
    public Room getRoom(){
        return this.room;
    }
    
    /**
    *method to return the room code
    */
    public String getRoomCode(){
        return this.room.getCode();
    }
    
    /**
    *method to return the date
    */
    public String getDate(){
        return this.date;
    }
    
    /**
    *method to return the time
    */
    public String getTime(){
        return this.time;
    }
    
    /**
    *method to return the status
    */
    public String getStatus(){
        return this.status;
    }
    
    /**
    *method to add an occupant to the room
    */
    public void addOccupant(){
        if (this.occupancy == 0){
            this.status = "AVAILABLE";
        }
        this.occupancy = this.occupancy + 1;
        if (this.occupancy == this.room.getCapacity()){
            this.status = "FULL";
        }
    }
    
    /**
    *method to remove an occupant from the room
    */
    public void removeOccupant(){
        this.occupancy = this.occupancy - 1;
        if (this.occupancy == 0){
            this.status = "EMPTY";
        } else  {
            this.status = "AVAILABLE";
        }
    }
    
    
    /**
    *method to override the toString method and return the transcript
    */
    @Override
    public String toString() {
        return " | " + this.date + " " + this.time + " | " + this.status + " | " + this.room.getCode() + " | occupancy: " + this.occupancy + " | ";
    }
}
