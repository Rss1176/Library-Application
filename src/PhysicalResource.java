
import java.util.ArrayList;


/**
 * A Class to represent a Physical Resource, such as a Book.
 * Subclass to Resource Class
 *
 * @Ross Macpherson
 * @16/12/2024
 */
public class PhysicalResource extends Resource
{
    // instance variables
    private int ISBN;
    private int copiesAvaliable;
    private boolean isAvaliable;
    private ArrayList<String> resourceDamages;
    private Author author;

    /**
     * Constructor for objects of class PhysicalResource
     */
    public PhysicalResource(String title, int ISBN, Author authorName)
    {
        // initialise instance variables
        super(title, authorName);
        this.ISBN = ISBN;
        this.copiesAvaliable = copiesAvaliable;
        this.isAvaliable = isAvaliable;
        this.resourceDamages = resourceDamages;
        
        copiesAvaliable = 1;
        resourceDamages = new ArrayList<>();
    }
    
    /**
     * Second Constructor to initialise variables to meaningful default values
     */
    public PhysicalResource()
    {
       // initialise instance variables to meaningful values
       ISBN = 0;
       copiesAvaliable = 1;
       resourceDamages = new ArrayList<>();
    }
    
    // Getter for ISBN Number
    public int getISBN()
    {
        return ISBN;
    }
    
    // Getter for amount of Copies Avaliable
    public int getCopiesAvaliable()
    {
        return copiesAvaliable;
    }

    // Getter for True/False value if the resource is avaliable, based on value of Copies (above).
    public boolean getIsAvaliable()
    {
        return copiesAvaliable > 0;
    }
        
    // Setter for the ISBN number, fulfilled by the User
    public void setISBN(int ISBN)
    {
        this.ISBN = ISBN;
    }
    
    // Setter for the amount of Copies Avaliable, fulfilled by the User
    public void setCopiesAvaliable(int copiesAvaliable)
    {
        if (copiesAvaliable < 0)
        {
            System.out.println("Please enter a valid number of copies!");
        }
        else
        {
            this.copiesAvaliable = copiesAvaliable;
        }
    }
    
    // No Setter for 'isAvaliable' variable, as is determined by the amount of Copies Avaliable. Not the User
    
    /**
     * Method to Check current recorded damages to a Physical Resource object
     */
    public void checkExistingDamages()
    {
        if (resourceDamages.isEmpty() || resourceDamages.contains(null))
        {
            System.out.println("There are currently no recorded damages for this resource!");
        }
        else
        {
            System.out.println("Current recorded damages are: " + resourceDamages);
        }
    }
    
    /**
     * Method to add new damages to a Physical Resource object
     */
    public void addNewDamage(String newDamage)
    {
        if (newDamage == null)
        {   
            throw new IllegalArgumentException("Null value entered - Please enter a valid value!");
        }
        if (resourceDamages.contains(newDamage))
        {
            System.out.println("This damage has already been recorded");
        }
        else
        {
            resourceDamages.add(newDamage);
            System.out.println("The damage has been recorded");
        }
    }
    
    /**
     * Method to print all details of a Physical Resource
     * This includes Author name only, the user shouldn't be able to see the authors address here, only details of the book
     * 
     * Note - I did attempt to print the actual users details here, 
     * but i couldn't manage it to work, I tried - (using .getCurrentUser().printMemberDetails())
     */
    public void printResourceDetails()
    {
        System.out.println("Book Title: " + getTitle());
        System.out.println("Book ISBN: " + ISBN);
        if (getCurrentUser() != null)
        {
            System.out.println("There is a current active user for this resource!");
        }
        else
        {
            System.out.println("There is currently no active user for this resource!");
        }
        if (getAuthorDetails() != null)
        {
            getAuthorDetails().printName();
        }
        else
        {
            System.out.println("No Author information on record for this resource");
        } 
    }
    
    /**
     * Method to return True if no current user, false if there is a current user.
     * This method is dependant on the book being checked out through the Library class
     */
    public boolean checkNoCurrentUser()
    {
        if (getCurrentUser() == null)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
