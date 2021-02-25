/**
*Assistant class that stores all the assistants in objects
*/
public class Assistant{
    //declaring the attributes for the assistant object
    private String name;
    private String email;
    
    /**
    *creating an assistant object from inputs
    */
    public Assistant(String name_, String email_){
        //checking the name is not null
        if (name_ != null){
            name = name_;
            //chekcing that the email is valid
            if ((email_.length() > 10)&&((email_.substring(email_.length() - 10)).equals("@uok.ac.uk"))){
                email = email_;
            } else {
        //returning errors if the name and email isn't valid
                System.out.println("email must be registered with the university");
            }
        } else {
            System.out.println("assistant name cannot be null");
        }
    }
    
    /**
    *method to get an assistant name
    */
    public String getName(){
        return this.name;
    }
    
    /**
    *method to get an assistant email
    */
    public String getEmail(){
        return this.email;
    }
    
    /**
    *method to override the toString method and return the transcript
    */
    @Override
    public String toString() {
        return " | " + this.name + " | " + this.email + " | ";
    }
}
