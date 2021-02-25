import java.util.ArrayList;
import java.util.Scanner;
/**
*the class that performs most of the functionality wiith the bookable rooms, assistants on shift and bookings
*/
public class BookingSystem{
    //initialising the array lists to store the bookable rooms and assistants on shift
    ArrayList<BookableRoom> bookableRooms = new ArrayList<BookableRoom>();
    ArrayList<AssistantOnShift> assistantsOnShift = new ArrayList<AssistantOnShift>();
    ArrayList<Booking> bookings = new ArrayList<Booking>();
    
    /**
    *method to return the list of assistants
    */
    public ArrayList<AssistantOnShift> getAssistantsOnShift(){
        return assistantsOnShift;
    }
    
    /**
    *method to add assistants on shift to the assistants on shift array list
    */
    public void addAssistantShift(AssistantOnShift assistantshift_){
        assistantsOnShift.add(assistantshift_);
    }
    
    /**
    *method to add rooms to the rooms array list
    */
    public void addBookableRoom(BookableRoom bookRoom_){
        bookableRooms.add(bookRoom_);
    }
    
    /**
    *method to add booking to the booking array list
    */
    public void InitialiseAddBooking(Booking booking_){
        bookings.add(booking_);
    }
    
    /**
    *method to list bookings
    */
    public boolean listBookings(){
        //initialising the scanner
        Scanner input = new Scanner(System.in);
        
        String display = "\nUniversity of Knowledge - COVID test\n\nSelect which booking to list:\n1. All\n2. Only bookings status:SCHEDULED\n3. Only bookings status:COMPLETED\n0. Back to main menu.\n-1. Quit application.\n\n";
        System.out.println(display);
        String display1;
        
        while (true){
            String input1 = input.nextLine();
            //if they select -1 exit the application
            if (input1.equals("-1")){
                return false;
            } else if (input1.equals("0")){ //if they select 0 go to main menu
                return true;
            } else if (input1.equals("2")){ //if they select 2 go to SCHEDULED bookings
                int i = 11;
                display1 = "";
                for (Booking booking_ : bookings){
                    if (booking_.getStatus().equals("SCHEDULED")){
                        display1 = display1 + "\n\t" + i + ". " + booking_;
                    }
                    i++;
                    }
                display1 = display1 + "\n0. Back to main menu.\n-1. Quit application.\n\n";
                System.out.println(display1);
                while (true){
                    String input2 = input.nextLine();
                    //if they select -1 exit the application
                    if (input2.equals("-1")){
                        return false;
                    } else if (input2.equals("0")){ //if they select 1 go to the bookable rooms list
                        return true;
                    }   
                }
            } else if (input1.equals("3")){ //if they select 3 go to COMPLETED bookings
                int i = 11;
                display1 = "";
                for (Booking booking_ : bookings){
                    if (booking_.getStatus().equals("COMPLETED")){
                        display1 = display1 + "\n\t" + i + ". " + booking_;
                    }
                    i++;
                    }
                display1 = display1 + "\n0. Back to main menu.\n-1. Quit application.\n\n";
                System.out.println(display1);
                while (true){
                    String input2 = input.nextLine();
                    //if they select -1 exit the application
                    if (input2.equals("-1")){
                        return false;
                    } else if (input2.equals("0")){ //if they select 1 go to the bookable rooms list
                        return true;
                    }   
                }
            } else { //by default display all bookings
                int i = 11;
                display1 = "Incorrect option, all bookings:";
                for (Booking booking_ : bookings){
                    display1 = display1 + "\n\t" + i + ". " + booking_;
                    i++;
                    }
                display1 = display1 + "\n0. Back to main menu.\n-1. Quit application.\n\n";
                System.out.println(display1);
                while (true){
                    String input2 = input.nextLine();
                    //if they select -1 exit the application
                    if (input2.equals("-1")){
                        return false;
                    } else if (input2.equals("0")){ //if they select 1 go to the bookable rooms list
                        return true;
                    }   
                }
            }
        }
    }
    
    /**
    *method to list assistants on shift
    */
    public boolean listAssistantsOnShift(){
        //initialising the scanner
        Scanner input = new Scanner(System.in);
        
        String display = "\nUniversity of Knowledge - COVID test\n";
        int i = 11;
        for (AssistantOnShift assistantshift_ : assistantsOnShift){
            display = display + "\n\t" + i + ". " + assistantshift_;
            i++;
        }
        display = display + "\n\n0. Back to main menu.\n-1. Quit application.\n\n";
        System.out.println(display);
        
        while (true){
            String input1 = input.nextLine();
            //if they select -1 exit the application
            if (input1.equals("-1")){
                return false;
            } else if (input1.equals("0")){ //if they select 1 go to the bookable rooms list
                return true;
            }   
        }
    }
    
    /**
    *method to list bookable rooms
    */
    public boolean listBookableRooms(){
        //initialising the scanner
        Scanner input = new Scanner(System.in);
        
        String display = "\nUniversity of Knowledge - COVID test\n";
        int i = 11;
        for (BookableRoom bookableroom_ : bookableRooms){
            display = display + "\n\t" + i + ". " + bookableroom_;
            i++;
        }
        display = display + "\n\n0. Back to main menu.\n-1. Quit application.\n\n";
        System.out.println(display);
        
        while (true){
            String input1 = input.nextLine();
            //if they select -1 exit the application
            if (input1.equals("-1")){
                return false;
            } else if (input1.equals("0")){ //if they select 1 go to the bookable rooms list
                return true;
            }   
        }
    }
    
    /**
    *method to add a booking
    */
    public boolean addBooking(int fromMethod){
        //initialising the scanner
        Scanner input = new Scanner(System.in);
        
        //creating the message to display
        String display = "";
        if (fromMethod == 0){
            display = display + "\nUniversity of Knowledge - COVID test\n\nAdding booking (appointment for a COVID test) to the system\n";
        }
        display = display + "\nList of available time-slots:";
        int i = 11;
        int j = 0;
        int []id = new int [bookableRooms.size()+11];
        boolean assistantAvailable = false;
        for (BookableRoom bookableroom_ : bookableRooms){
            assistantAvailable = false;
            for (AssistantOnShift assistantsonshift_ : assistantsOnShift){
                if (bookableroom_.getDate().equals(assistantsonshift_.getAssistantShiftDate()) && bookableroom_.getTime().equals(assistantsonshift_.getAssistantShiftTime()) && assistantsonshift_.getStatus().equals("FREE")){
                    assistantAvailable = true;
                    break;
                }
            }
            if ((bookableroom_.getStatus().equals("AVAILABLE") || bookableroom_.getStatus().equals("EMPTY")) && assistantAvailable == true){
                display = display + "\n\t" + i + ". " + bookableroom_.getDate() + " " + bookableroom_.getTime();
                id[i] = j;
                i++;
            }
            j++;
        }
        String msg = "\n\nPlease, enter one of the following:\n\nThe sequential ID of an available time-slot and the student email, separated by a white space.\n0. Back to main menu.\n-1. Quit application.\n\n";
        display = display + msg;
        System.out.println(display);
        
        while (true){
            //waiting for the user to input
            String input1 = input.nextLine();
            int input2;
            String temp = " ";
            String studentEmail = "";
            AssistantOnShift bookingAssistant = null;
            
            try {//catching errors in the user input
                if (input1.length() >= 2){//if statements to determin which bits to substring an dconvert to int
                    temp = input1.substring(0,2);
                } else if (input1.length() == 1){
                    temp = input1.substring(0,1);
                }
                
                input2 = Integer.parseInt(temp);
                //if they select -1 exit the application
                if (input2 == -1){
                    return false;
                } else if (input2 == 0){ //if they select 0 go to the main menu
                    return true;
                } else if (input2 > 10 && input2 <= i){
                    try{//catching any errror in the new assistant on shift input
                        if (input1.length() >= 12){//checking the length is correct and that the date is correct
                            // setting the duplicate variable to false
                            boolean duplicate = false;
                            if (input1.substring(2,3).equals(" ")){
                                studentEmail = input1.substring(3);
                            } else if (input1.substring(3,4).equals(" ")){
                                studentEmail = input1.substring(4);
                            }
                            int bookableroomID = id[input2];
                            
                            //loopoing through the current bookings to find a duplicate
                            for (Booking bookingdup : bookings){
                                if (bookingdup.getDate().equals(bookableRooms.get(bookableroomID).getDate()) && bookingdup.getTime().equals(bookableRooms.get(bookableroomID).getTime()) && bookingdup.getStudentEmail().equals(studentEmail)){// checking if the user inputs are a duplicate
                                    duplicate = true;
                                }
                            }
                            for (AssistantOnShift availableAssistant_ : assistantsOnShift){
                                if (bookableRooms.get(bookableroomID).getTime().equals(availableAssistant_.getAssistantShiftTime()) && bookableRooms.get(bookableroomID).getDate().equals(availableAssistant_.getAssistantShiftDate()) && availableAssistant_.getStatus().equals("FREE")){
                                    bookingAssistant = availableAssistant_;
                                    break;
                                }
                            }
                            if (duplicate == false && studentEmail.substring(studentEmail.length()-10).equals("@uok.ac.uk")){
                                Booking booking_ = new Booking(bookingAssistant, bookableRooms.get(bookableroomID), studentEmail);
                                bookings.add(booking_);
                                System.out.println("\nBooking added successfully:");
                                System.out.println(booking_);
                                return addBooking(1);
                            } else {
                                //returning error if the input is a duplicate or the email is incorrect
                                System.out.println("ERROR!");
                                System.out.println("duplicate booking or email not registered with the @uok.ac.uk");
                                System.out.println(msg);
                            }
                        } else {
                            //returning error if the length isn't valid
                            System.out.println("ERROR!");
                            System.out.println("incorrect length");
                            System.out.println(msg);
                        }
                    } catch (Exception e) {
                        System.out.println(e);
                        System.out.println("ERROR!");
                        System.out.println("incorrect format for new booking");
                        System.out.println(msg);
                    }
                    
                } else {
                    System.out.println("ERROR!");
                    System.out.println("incorrect format for new booking");
                    System.out.println(msg);
                }
            } catch (NumberFormatException e){
                System.out.println("ERROR!");
                System.out.println(e);
            }
        }
    }
    
    /**
    *method to add assistant on shift
    */
    public boolean addAssistantsOnShift(UniversityResources resources_, BookingSystem bookingsystem_){
        //initialising the scanner
        Scanner input = new Scanner(System.in);
        
        ArrayList<Assistant> assistants = resources_.getAssistants();//putting the assinants into an array list
        
        //creating the message to display
        String display = "\nUniversity of Knowledge - COVID test\n\nAdding Assistants on shift\n";
        int i = 11;
        for (Assistant assistant_ : assistants){
            display = display + "\n\t" + i + ". " + assistant_;
            i++;
        }
        String msg = "\nPlease, enter one of the following:\n\nThe sequential ID of an assistant and date (dd/mm/yyyy), separated by a white space.\n0. Back to main menu.\n-1. Quit application.\n\n";
        display = display + msg;
        System.out.println(display);
        
        while (true){
            //waiting for the user to input
            String input1 = input.nextLine();
            int input2;
            String temp = " ";
            
            try {//catching errors in the user input
                if (input1.length() >= 2){//if statements to determin which bits to substring an dconvert to int
                    temp = input1.substring(0,2);
                } else if (input1.length() == 1){
                    temp = input1.substring(0,1);
                }
                
                input2 = Integer.parseInt(temp);
                //if they select -1 exit the application
                if (input2 == -1){
                    return false;
                } else if (input2 == 0){ //if they select 0 go to the main menu
                    return true;
                } else if (input2 > 10 && input2 <= i){
                    try{//catching any errror in the new assistant on shift input
                        if (input1.length() >= 13 && input1.substring(input1.length()-11, input1.length()-10).equals(" ")){//checking the length is correct and that the date is correct
                            // setting the duplicate variable to false
                            boolean duplicate = false;
                            //loopoing through the current assistants to find a duplicate
                            for (AssistantOnShift assistantshift : assistantsOnShift){
                                if (assistants.get(input2-11).equals(assistantshift.getAssistant()) && input1.substring(input1.length()-10).equals(assistantshift.getAssistantShiftDate())){// checking if the user inputs are a duplicate
                                    duplicate = true;
                                }
                            }
                            if (duplicate == false){
                                AssistantOnShift assistantshift = new AssistantOnShift(assistants.get(input2-11), input1.substring(input1.length()-10), bookingsystem_);
                                assistantsOnShift.add(assistantshift);
                                System.out.println("\nAssistant on Shift added successfully:");
                                System.out.println(assistantshift);
                                System.out.println(msg);
                            } else {
                                //returning error if the input is a duplicate
                                System.out.println("ERROR!");
                                System.out.println("duplicate assistant on shift");
                                System.out.println(msg);
                            }
                        } else {
                            //returning error if the length isn't valid
                            System.out.println("ERROR!");
                            System.out.println("incorrect length, whitespace or date format");
                            System.out.println(msg);
                        }
                    } catch (Exception e) {
                        System.out.println(e);
                        System.out.println("ERROR!");
                        System.out.println("incorrect format for new assistant on shift");
                        System.out.println(msg);
                    }
                    
                } else {
                    System.out.println("ERROR!");
                    System.out.println("incorrect format for new assistant on shift");
                    System.out.println(msg);
                }
            } catch (NumberFormatException e){
                System.out.println("ERROR!");
                System.out.println(e);
            }
        }
    }
    
    /**
    *method to add bookable rooms
    */
    public boolean addBookableRooms(UniversityResources resources_){
        //initialising the scanner
        Scanner input = new Scanner(System.in);
        
        ArrayList<Room> rooms = resources_.getRooms();//putting the rooms into an array list
        
        //creating the messgae to display
        String display = "\nUniversity of Knowledge - COVID test\n\nAdding bookable room\n";
        int i = 11;
        for (Room room_ : rooms){
            display = display + "\n\t" + i + ". " + room_;
            i++;
        }
        String msg = "\nPlease, enter one of the following:\n\nThe sequential ID listed to a room, a date (dd/mm/yyyy), and a time (HH:MM), separated by a white space.\n0. Back to main menu.\n-1. Quit application.\n\n";
        display = display + msg;
        System.out.println(display);
        
        while (true){
            //waiting for the user to input
            String input1 = input.nextLine();
            int input2;
            String temp = " ";
            
            try {//catching errors in the user input
                if (input1.length() >= 2){//if statements to determin which bits to substring an dconvert to int
                    temp = input1.substring(0,2);
                } else if (input1.length() == 1){
                    temp = input1.substring(0,1);
                }
                
                input2 = Integer.parseInt(temp);
                //if they select -1 exit the application
                if (input2 == -1){
                    return false;
                } else if (input2 == 0){ //if they select 0 go to the main menu
                    return true;
                } else if (input2 > 10 && input2 <= i){
                    try{//catching any errror in the new bookable room input
                        if (input1.substring(input1.length()-5).equals("07:00") || input1.substring(input1.length()-5).equals("08:00") || input1.substring(input1.length()-5).equals("09:00") && input1.length() >= 19){//checking that the time correct and the length is correct
                            if (input1.substring(input1.length()-6, input1.length()-5).equals(" ")){
                                // setting the duplicate variable to false
                                boolean duplicate = false;
                                //loopoing through the current assistants to find a duplicate
                                for (BookableRoom bookableRoom_ : bookableRooms){
                                    if (rooms.get(input2-11).equals(bookableRoom_.getRoom()) && input1.substring(input1.length()-16, input1.length()-6).equals(bookableRoom_.getDate()) && input1.substring(input1.length()-5).equals(bookableRoom_.getTime())){// checking if the user inputs are a duplicate
                                        duplicate = true;
                                    }
                                }
                                if (duplicate == false){
                                    BookableRoom bookroom = new BookableRoom(rooms.get(input2-11), input1.substring(input1.length()-16, input1.length()-6), input1.substring(input1.length()-5));
                                    bookableRooms.add(bookroom);
                                    System.out.println("\nBookable Room added successfully:");
                                    System.out.println(bookroom);
                                    System.out.println(msg);
                                } else {
                                    //returning error if the bookable room is a duplicate
                                    System.out.println("ERROR!");
                                    System.out.println("incorrect bookable room is a duplicate");
                                    System.out.println(msg);
                                }
                            } else {
                                //returning error if the whitespace isn't valid
                                System.out.println("ERROR!");
                                System.out.println("incorrect time whitespace or date format");
                                System.out.println(msg);
                            }
                        } else {
                            //returning error if the time isn't valid
                            System.out.println("ERROR!");
                            System.out.println("incorrect time format or length");
                            System.out.println(msg);
                        }
                    } catch (Exception e) {
                        System.out.println(e);
                        System.out.println("ERROR!");
                        System.out.println("incorrect format for new bookable room");
                        System.out.println(msg);
                    }
                    
                } else {
                    System.out.println("ERROR!");
                    System.out.println("incorrect format for new bookable room");
                    System.out.println(msg);
                }
            } catch (NumberFormatException e){
                System.out.println("ERROR!");
                System.out.println(e);
            }
        }
    }
    
    /**
    *method to remove a booking
    */
    public boolean removeBooking(){
        //initialising the scanner
        Scanner input = new Scanner(System.in);
        
        //creating the message to display
        String display = "\nUniversity of Knowledge - COVID test\n";
        int i = 11;
        int j = 0;
        int []id = new int [bookings.size()+11];
        for (Booking booking : bookings){
            if (booking.getStatus().equals("SCHEDULED")){
                display = display + "\n\t" + i + ". " + booking;
                id[i] = j;
                i++;
            }
            j++;
        }
        display = display + "\n\nRemoving booking from the system";
        String msg = "\n\nPlease, enter one of the following:\n\nThe sequential ID to select the booking to be removed from the listed bookings above.\n0. Back to main menu.\n-1. Quit application.\n\n";
        display = display + msg;
        System.out.println(display);
        
        while (true){
            //waiting for the user to input
            String input1 = input.nextLine();
            int input2;
            String temp = " ";
            
            try {//catching errors in the user input
                if (input1.length() >= 2){//if statements to determin which bits to substring an dconvert to int
                    temp = input1.substring(0,2);
                } else if (input1.length() == 1){
                    temp = input1.substring(0,1);
                }
                
                input2 = Integer.parseInt(temp);
                //if they select -1 exit the application
                if (input2 == -1){
                    return false;
                } else if (input2 == 0){ //if they select 0 go to the main menu
                    return true;
                } else if (input2 > 10 && input2 <= i){
                    try{//catching any errror in the new assistant on shift input
                        int bookingID = id[input2];
                        Booking temp2 = bookings.get(bookingID);
                            if (temp2.getStatus().equals("SCHEDULED")){
                                temp2.removeBooking();
                                bookings.remove(bookingID);
                                System.out.println("\nBooking removed successfully:");
                                System.out.println(temp2);
                                System.out.println(msg);
                            } else {
                                System.out.println("ERROR!");
                                System.out.println("booking has been completed and therfore cannot be removed");
                                System.out.println(msg);
                            }
                    } catch (Exception e) {
                        System.out.println(e);
                        System.out.println("ERROR!");
                        System.out.println("incorrect format for removing booking");
                        System.out.println(msg);
                    }
                    
                } else {
                    System.out.println("ERROR!");
                    System.out.println("incorrect format for removing booking");
                    System.out.println(msg);
                }
            } catch (NumberFormatException e){
                System.out.println("ERROR!");
                System.out.println(e);
            }
        }
    }
    
    /**
    *method to remove an assistant on shift
    */
    public boolean removeAssistantOnShift(){
        //initialising the scanner
        Scanner input = new Scanner(System.in);

        //creating the message to display
        String display = "\nUniversity of Knowledge - COVID test\n\nAdding Assistants on shift\n";
        int i = 11;
        int j = 0;
        int []id = new int [assistantsOnShift.size()+11];
        for (AssistantOnShift assistantshift_ : assistantsOnShift){
            if (assistantshift_.getStatus().equals("FREE")){
                display = display + "\n\t" + i + ". " + assistantshift_;
                id[i] = j;
                i++;
            }
            j++;
        }
        String msg = "\nPlease, enter one of the following:\n\nThe sequential ID to select the assistant on shift to be removed.\n0. Back to main menu.\n-1. Quit application.\n\n";
        display = display + msg;
        System.out.println(display);
        
        while (true){
            //waiting for the user to input
            String input1 = input.nextLine();
            int input2;
            String temp = " ";
            
            try {//catching errors in the user input
                if (input1.length() >= 2){//if statements to determin which bits to substring an dconvert to int
                    temp = input1.substring(0,2);
                } else if (input1.length() == 1){
                    temp = input1.substring(0,1);
                }
                
                input2 = Integer.parseInt(temp);
                //if they select -1 exit the application
                if (input2 == -1){
                    return false;
                } else if (input2 == 0){ //if they select 1 go to the bookable rooms list
                    return true;
                } else if (input2 > 10 && input2 <= i){
                    try{//catching any errror in the new bookable room input
                        int assistantID = id[input2];
                        AssistantOnShift temp2 = assistantsOnShift.get(assistantID);
                        if (temp2.getStatus().equals("FREE")){
                            assistantsOnShift.remove(assistantID);
                            System.out.println("\nAssistant on shift removed successfully:");
                            System.out.println(temp2);
                            System.out.println(msg);
                        } else { //making sure that the user input is not a room that isn't empty
                            System.out.println("ERROR!");
                            System.out.println("incorrect input, assistant is busy then");
                            System.out.println(msg);
                        }
                    } catch (Exception e) {
                        System.out.println(e);
                        System.out.println("ERROR!");
                        System.out.println("incorrect format for removing an assistant on shift");
                        System.out.println(msg);
                    }
                    
                } else {
                    System.out.println("ERROR!");
                    System.out.println("incorrect format for removing an assistant on shift");
                    System.out.println(msg);
                }
            } catch (NumberFormatException e){
                System.out.println("ERROR!");
                System.out.println(e);
            }
        }
    }
    
    /**
    *method to remove bookable rooms
    */
    public boolean removeBookableRooms(){
        //initialising the scanner
        Scanner input = new Scanner(System.in);
        
        //creating the messgae to display
        String display = "\nUniversity of Knowledge - COVID test\n";
        int i = 11;
        int j = 0;
        int []id = new int [bookableRooms.size()+11];
        for (BookableRoom bookableroom_ : bookableRooms){
            if (bookableroom_.getStatus().equals("EMPTY")){
                display = display + "\n\t" + i + ". " + bookableroom_;
                id[i] = j;
                i++;
            }
            j++;
        }
        String msg = "\nRemoving bookable room\n\nPlease, enter one of the following:\n\nThe sequential ID  to select the bookable room to be removed.\n0. Back to main menu.\n-1. Quit application.\n\n";
        display = display + msg;
        System.out.println(display);
        
        while (true){
            //waiting for the user to input
            String input1 = input.nextLine();
            int input2;
            String temp = " ";
            
            try {//catching errors in the user input
                if (input1.length() >= 2){//if statements to determin which bits to substring an dconvert to int
                    temp = input1.substring(0,2);
                } else if (input1.length() == 1){
                    temp = input1.substring(0,1);
                }
                
                input2 = Integer.parseInt(temp);
                //if they select -1 exit the application
                if (input2 == -1){
                    return false;
                } else if (input2 == 0){ //if they select 1 go to the bookable rooms list
                    return true;
                } else if (input2 > 10 && input2 <= i){
                    try{//catching any errror in the new bookable room input
                        int bookableroomID_ = id[input2];
                        BookableRoom temp2 = bookableRooms.get(bookableroomID_);
                        if (temp2.getStatus().equals("EMPTY")){
                            bookableRooms.remove(bookableroomID_);
                            System.out.println("\nBookable Room removed successfully:");
                            System.out.println(temp2);
                            System.out.println(msg);
                        } else { //making sure that the user input is not a room that isn't empty
                            System.out.println("ERROR!");
                            System.out.println("incorrect input, room not empty");
                            System.out.println(msg);
                        }
                    } catch (Exception e) {
                        System.out.println(e);
                        System.out.println("ERROR!");
                        System.out.println("incorrect format for removing a bookable room");
                        System.out.println(msg);
                    }
                    
                } else {
                    System.out.println("ERROR!");
                    System.out.println("incorrect format for removing a bookable room");
                    System.out.println(msg);
                }
            } catch (NumberFormatException e){
                System.out.println("ERROR!");
                System.out.println(e);
            }
        }
    }
    
    /**
    *method to conclude a booking
    */
    public boolean concludeBooking(){
        //initialising the scanner
        Scanner input = new Scanner(System.in);
        
        //creating the message to display
        String display = "\nUniversity of Knowledge - COVID test\n";
        int i = 11;
        int j = 0;
        int []id = new int [bookings.size()+11];
        for (Booking booking : bookings){
            if (booking.getStatus().equals("SCHEDULED")){
                display = display + "\n\t" + i + ". " + booking;
                id[i] = j;
                i++;
            }
            j++;
        }
        display = display + "\n\nConclude booking";
        String msg = "\n\nPlease, enter one of the following:\n\nThe sequential ID to select the booking to be completed.\n0. Back to main menu.\n-1. Quit application.\n\n";
        display = display + msg;
        System.out.println(display);
        
        while (true){
            //waiting for the user to input
            String input1 = input.nextLine();
            int input2;
            String temp = " ";
            
            try {//catching errors in the user input
                if (input1.length() >= 2){//if statements to determin which bits to substring an dconvert to int
                    temp = input1.substring(0,2);
                } else if (input1.length() == 1){
                    temp = input1.substring(0,1);
                }
                
                input2 = Integer.parseInt(temp);
                //if they select -1 exit the application
                if (input2 == -1){
                    return false;
                } else if (input2 == 0){ //if they select 0 go to the main menu
                    return true;
                } else if (input2 > 10 && input2 <= i){
                    try{//catching any errror in the new assistant on shift input
                        int bookingID = id[input2];
                        Booking temp2 = bookings.get(bookingID);
                            if (temp2.getStatus().equals("SCHEDULED")){
                                temp2.conclude();
                                System.out.println("\nBooking completed successfully:");
                                System.out.println(temp2);
                                System.out.println(msg);
                            } else {
                                System.out.println("ERROR!");
                                System.out.println("booking is already complete");
                                System.out.println(msg);
                            }
                    } catch (Exception e) {
                        System.out.println(e);
                        System.out.println("ERROR!");
                        System.out.println("incorrect format for completing bookings");
                        System.out.println(msg);
                    }
                    
                } else {
                    System.out.println("ERROR!");
                    System.out.println("incorrect format for completing booking");
                    System.out.println(msg);
                }
            } catch (NumberFormatException e){
                System.out.println("ERROR!");
                System.out.println(e);
            }
        }
    }
}
