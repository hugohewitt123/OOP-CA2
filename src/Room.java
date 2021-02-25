/**
*Room class that stores the rooms in objects
*/
public class Room{
    //declaring the attributes for the Room object
    private String code;
    private int capacity;
    
    /**
    *creating a room object from inputs
    */
    public Room(String code_, int capacity_){
        //chekcing the code is not null
        if (code_ != null){
            code = code_;
            //chekcing that the capacity if greater than 0
            if (capacity_ > 0){
                capacity = capacity_;
            } else {
        //returnign erros if the code and capacity isn't valid
                System.out.println("capacity must be greater than 0");
            }
        } else {
            System.out.println("room code cannot be null");
        }
    }
    
    /**
    *method to get a Room code
    */
    public String getCode(){
        return this.code;
    }
    
    /**
    *method to get capacity
    */
    public int getCapacity(){
        return this.capacity;
    }
    
    /**
    *method to override the toString method and return the transcript
    */
    @Override
    public String toString() {
        return " | " + this.code + " | capacity: " + this.capacity + " | ";
    }
}
