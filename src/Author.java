
/**
 * A Class to represent an Author of a Resource. 
 *
 * @Ross Macpherson
 * @16/12/2024
 */
public class Author
{
    // instance variables - replace the example below with your own
    private String firstName;
    private String lastName;
    private String address;

    /**
     * Constructor for objects of class Author
     */
    public Author(String firstName, String lastName, String address)
    {
        // initialise instance variables
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }
    
    /**
     * Second Constructor to initialise variables to meaningful default values
     */
    public Author()
    {
        // Initialise instance variables to default values
        firstName = "Please enter a First Name";
        lastName = "Please enter a Last Name";
        address = "Please enter an address";
    }
    
    // Getter for the Authors First Name
    public String getFirstName()
    {
        return firstName;
    }
    
    // Getter for the Authors Last Name
    public String getLastName()
    {
        return lastName;
    }
    
    // Getter for the Authors Address
    public String getAddress()
    {
        return address;
    }
    
    // Setter for the Authors First Name, fulfilled by the User
    public void setFirstName(String firstName)
    {
        if (firstName == null)
        {   
            throw new IllegalArgumentException("Null value entered - Please enter a valid value!");
        }
        this.firstName = firstName;
    }
    
    // Setter for the Authors Last Name, fulfilled by the User
    public void setLastName(String lastName)
    {
        if (lastName == null)
        {   
            throw new IllegalArgumentException("Null value entered - Please enter a valid value!");
        }
        this.lastName = lastName;
    }
    
    // Setter for the Authors Address, fulfilled by the User
    public void setAddress(String address)
    {
        if (address == null)
        {   
            throw new IllegalArgumentException("Null value entered - Please enter a valid value!");
        }
        this.address = address;
    }
    
    /**
     * Method to Print the Authors Name
     */
    public void printName()
    {
        System.out.println("The Authors full name is: " + firstName + " " + lastName);
    }
    
    /**
     * Method to print all details of an Author Object
     */
    public void printAllDetails()
    {
        System.out.println("The Authors full name is: " + firstName + " " + lastName);
        System.out.println("The Authors address is: " + address);
    }
}
