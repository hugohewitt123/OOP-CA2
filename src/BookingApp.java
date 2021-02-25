import java.util.Scanner;
/**
*main class that is the centre of the application connecting the separate classes
*/
public class BookingApp{
    public static void main(String[] args) {
        //initialising the UniversityResources object
        UniversityResources resources = new UniversityResources();
        
        //adding the starting assistants
        Assistant assistant1 = new Assistant("Jane Doe", "janed@uok.ac.uk");
        Assistant assistant2 = new Assistant("Mark Smith", "marks@uok.ac.uk");
        Assistant assistant3 = new Assistant("James Parker", "jamesp@uok.ac.uk");
        resources.addAssistant(assistant1);
        resources.addAssistant(assistant2);
        resources.addAssistant(assistant3);
        
        //adding the starting rooms
        Room room1 = new Room("IC215",1);
        Room room2 = new Room("IC113",4);
        Room room3 = new Room("IC115",7);
        resources.addRoom(room1);
        resources.addRoom(room2);
        resources.addRoom(room3);
        
        //initialising the Booking system object
        BookingSystem bookingsystem = new BookingSystem();
        
        //initialising the bookable rooms
        BookableRoom bookroom1 = new BookableRoom(room2, "21/02/2021", "09:00");
        BookableRoom bookroom2 = new BookableRoom(room1, "01/03/2021", "08:00");
        BookableRoom bookroom3 = new BookableRoom(room1, "01/03/2021", "09:00");
        BookableRoom bookroom4 = new BookableRoom(room2, "01/03/2021", "07:00");
        BookableRoom bookroom5 = new BookableRoom(room2, "01/03/2021", "08:00");
        BookableRoom bookroom6 = new BookableRoom(room2, "01/03/2021", "09:00");
        BookableRoom bookroom7 = new BookableRoom(room3, "01/03/2021", "07:00");
        BookableRoom bookroom8 = new BookableRoom(room3, "01/03/2021", "08:00");
        BookableRoom bookroom9 = new BookableRoom(room3, "01/03/2021", "09:00");
        bookingsystem.addBookableRoom(bookroom1);
        bookingsystem.addBookableRoom(bookroom2);
        bookingsystem.addBookableRoom(bookroom3);
        bookingsystem.addBookableRoom(bookroom4);
        bookingsystem.addBookableRoom(bookroom5);
        bookingsystem.addBookableRoom(bookroom6);
        bookingsystem.addBookableRoom(bookroom7);
        bookingsystem.addBookableRoom(bookroom8);
        bookingsystem.addBookableRoom(bookroom9);
        
        //initialising the assistants on shift
        AssistantOnShift assistantshift1 = new AssistantOnShift(assistant2, "21/02/2021", bookingsystem);
        bookingsystem.addAssistantShift(assistantshift1);
        AssistantOnShift assistantshift2 = new AssistantOnShift(assistant1, "01/03/2021", bookingsystem);
        bookingsystem.addAssistantShift(assistantshift2);
        AssistantOnShift assistantshift3 = new AssistantOnShift(assistant3, "01/03/2021", bookingsystem);
        bookingsystem.addAssistantShift(assistantshift3);
        AssistantOnShift assistantshift4 = new AssistantOnShift(assistant2, "01/03/2021", bookingsystem);
        bookingsystem.addAssistantShift(assistantshift4);
        
        Booking booking1 = new Booking(assistantshift2, bookroom3, "JohnB@uok.ac.uk");
        Booking booking2 = new Booking(assistantshift1, bookroom1, "PaulB@uok.ac.uk");
        bookingsystem.InitialiseAddBooking(booking1);
        bookingsystem.InitialiseAddBooking(booking2);
        booking2.conclude();
        
        displayMain(bookingsystem, resources);
        
    }
    
    public static void displayMain(BookingSystem bookingsystem_, UniversityResources resources_){
        //initialising the scanner
        Scanner input = new Scanner(System.in);
        
        //showing all the options the user has to input and manage the system
        String displayScreen = "\nUniversity of Knowledge - COVID test\n\nManage Bookings\n\nPlease, enter the number to select your option:\n\nTo manage Bookable Rooms:\n\t1. List\n\t2. Add\n\t3. Remove\nTo manage Assistants on Shift:\n\t4. List\n\t5. Add\n\t6. Remove\nTo manage Bookings:\n\t7. List\n\t8. Add\n\t9. Remove\n\t10. Conclude\nAfter selecting one the options above, you will be presented other screens.\nIf you press 0, you will be able to return to this main menu.\nPress -1 (or ctrl+c) to quit this application.\n";
        
        boolean exit = true;
        
        while (exit == true){
            System.out.println(displayScreen);
            //waiting for the user to select an option
            String input1 = input.nextLine();
            //if they select -1 exit the application
            if (input1.equals("-1")){
                exit = false;
            } else if (input1.equals("1")){ //if they select 1, go to the booking system, bookable rooms list
                exit = bookingsystem_.listBookableRooms();
            } else if (input1.equals("2")){ //if they select 2, go to the booking system, bookable rooms add method
                exit = bookingsystem_.addBookableRooms(resources_);
            } else if (input1.equals("3")){ //if they select 3, go to the booking system, bookable rooms remove method
                exit = bookingsystem_.removeBookableRooms();
            } else if (input1.equals("4")){ //if they select 4, go to the booking system, list assistants method 
                exit = bookingsystem_.listAssistantsOnShift();    
            } else if (input1.equals("5")){ //if they select 5, go to the booking system, add assisnants on shift method
                exit = bookingsystem_.addAssistantsOnShift(resources_, bookingsystem_);    
            } else if (input1.equals("6")){ //if they select 6, go to the booking system, remove assistants on shift method
                exit = bookingsystem_.removeAssistantOnShift();    
            } else if (input1.equals("7")){ //if they select 7, go to the booking system, list bookings method
                exit = bookingsystem_.listBookings();
            } else if (input1.equals("8")){ //if they select 8, go to the booking system, add bookings method
                exit = bookingsystem_.addBooking(0);
            } else if (input1.equals("9")){ //if they select 9, go to the booking system, remove bookings method
                exit = bookingsystem_.removeBooking();
            } else if (input1.equals("10")){ //if they select 10, go to the booking system, finish booking method
                exit = bookingsystem_.concludeBooking();
            }
        }
    }
}
