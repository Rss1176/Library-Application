
/**
 * A Class to represent a Person who can go to the Library. 
 * Acts as a Superclass to LibraryMember, and Library Guest.
 *
 * @Ross Macpherson
 * @16/12/2024
 */
public class Person
{
    // instance variables - replace the example below with your own
    private String firstName;
    private String lastName;

    /**
     * Constructor for objects of class Person
     */
    public Person(String firstName, String lastName)
    {
        // initialise instance variables
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    /**
     * Second Constructor to initialise variables to meaningful default values
     */
    public Person()
    {
        // Initialise instance variables to default values
        firstName = "Please enter a First Name";
        lastName = "Please enter a Last Name";
    }
    
    // Getter for the persons First Name
    public String getFirstName()
    {
        return firstName;
    }
    
    // Getter for the persons Last Name
    public String getLastName()
    {
        return lastName;
    }
    
    // Setter for the persons First name
    public void setFirstName(String firstName)
    {
        if (firstName == null)
        {   
            throw new IllegalArgumentException("Null value entered - Please enter a valid value!");
        }
        this.firstName = firstName;
    }
    
    // Setter for the persons last name
    public void setLastName(String lastName)
    {
        if (lastName == null)
        {   
            throw new IllegalArgumentException("Null value entered - Please enter a valid value!");
        }
        this.lastName = lastName;
    }
}