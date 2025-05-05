
import java.util.ArrayList;


/**
 * A Class to represent a Resource. 
 * Acts as a Superclass to ElectronicResource, and PhysicalResource
 *
 * @Ross Macpherson
 * @16/12/2024
 */
public class Resource
{
    // instance variables
    private String title; 
    private Author author;
    private Person currentUser;
    private ArrayList<PhysicalResource> physicalCollection;
    private ArrayList<ElectronicResource> electronicCollection;
    
    /**
     * Constructor for objects of class Resource
     */
    public Resource(String title, Author author)
    {
        // initialise instance variables
        this.title = title;
        this.author = author;
        this.currentUser = currentUser;
        physicalCollection = new ArrayList<>();
        electronicCollection = new ArrayList<>();
    }
    
    /**
     * Second Constructor to set default values to meaningful data
     */
    public Resource()
    {
        title = "Please enter a title for this resource!";
    }
    
    // Getter for the Title of the Resource
    public String getTitle()
    {
        return title;
    }
    
    // Getter for the Authors Name of a Resource
    public Author getAuthorDetails()
    {
        return author;
    }
    
    // Getter for the Current user of a resource
    public Person getCurrentUser()
    {
        return currentUser;
    }
    
    // Getter for the Array list of objects in the Physical Collection class
    public ArrayList<PhysicalResource> getPhysicalCollection()
    {
        return physicalCollection;    
    }
    
    // Getter for the Array list of objects in the Electronic Collection class
        public ArrayList<ElectronicResource> getElectronicCollection()
    {
        return electronicCollection;    
    }
    
    // Setter for the Title of the Resource, fulfilled by the User
    public void setTitle(String title)
    {
        if (title == null)
        {
            throw new IllegalArgumentException("Null value entered - Please enter a valid value!");
        }
        this.title = title;
    }
    
    // Setter for the Author Details, fulfilled by the User
    public void setAuthorDetails(Author author)
    {
        if (author == null)
        {
            throw new IllegalArgumentException("Null value entered - Please enter a valid value!");
        }
        this.author = author;
    }
    
    // Setter for the Current User of a Resource
    public void setCurrentUser(Person currentUser)
    {
        this.currentUser = currentUser;
    }
    
    /**
     * Method to check if a book is avaliable.
     * This is required by Final Documentation, however is already done through the way the variables have been done,
     * as 'isAvaliable' is determined by the copies avaliable in both Physical and Electronic Resource Classes.
     * Method will be implemented below, but in real world use I don't feel this program would include it
     */
    public boolean isResourceAvailable() 
    { 
        return currentUser == null; 
    }
    
    /**
     * Method to print all details of a Resource
     * This includes Author name only, the user shouldn't be able to see the authors address here, only details of the book
     * 
     * I wanted to include copies avaliable here, but I was unable to get it to work. I maybe should have 'copiesAvaliable' in
     * the superclass, instead of subclass - Have commented my attempt below.
     */
    public void printDetails()
    {
        System.out.println("Book Title: " + getTitle());
        
        /**
         * 
         *     for (PhysicalResource resource : physicalCollection)
         *       {
         *           if (resource instanceof PhysicalResource)
         *           {
         *               System.out.println("The copies avaliable for this resource are: " + resource.getCopiesAvaliable());
         *           }
         *      }
         */
        
        if (getAuthorDetails() != null)
        {
            getAuthorDetails().printName();
        }
        else
        {
            System.out.println("No Author information on record for this resource");
        } 
    }
}
