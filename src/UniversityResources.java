import java.util.ArrayList;
/**
*UniversityResources class that store the roomsa dn assistants in lists
*/
public class UniversityResources{
    //initialising the array lists to store the rooms and assistants
    ArrayList<Room> rooms = new ArrayList<Room>();
    ArrayList<Assistant> assistants = new ArrayList<Assistant>();
    
    /**
    *method to add assistants to the assistants array list
    */
    public void addAssistant(Assistant assistant_){
        assistants.add(assistant_);
    }
    
    /**
    *method to add rooms to the rooms array list
    */
    public void addRoom(Room room_){
        rooms.add(room_);
    }
    
    /**
    *method to return the rooms
    */
    public ArrayList<Room> getRooms(){
        return this.rooms;
    }
    
    /**
    *method to return the assistants
    */
    public ArrayList<Assistant> getAssistants(){
        return this.assistants;
    }
    
    /**
    *method to get an assistant from assistants array list
    */
    public Assistant getAssistant(String name_){
        Assistant assistant1 = null;
        //looping through the array list to find the assistant
        for (Assistant assistant : assistants){
            //checking if the input name is the assistant name
            if (assistant.getName().equals(name_)){
                assistant1 = assistant;
                break;
            }
        }
        return assistant1;
    }
    
    /**
    *method to get a room from room array list
    */
    public Room getRoom(String code_){
        Room room1 = null;
        //looping through the array list to find the room
        for (Room room_ : rooms){
            //checking if the input is the code in the room object
            if (room_.getCode().equals(code_)){
                room1 = room_;
                break;
            }
        }
        return room1;
    }
}
