
import java.util.ArrayList;


/**
 * A Class to represent a LibraryMember, such as a visiting guest at the Library. 
 * Acts as a Subclass to Person.
 *
 * @Ross Macpherson
 * @16/12/2024
 */
public class LibraryGuest extends Person
{
    // instance variables - replace the example below with your own
    private int accessDuration;
    private ArrayList<ElectronicResource> borrowedElectronicResource;

    /**
     * Constructor for objects of class LibraryGuest
     */
    public LibraryGuest(String firstName, String lastName, int accessDuration)
    {
        // initialise instance variables
        super(firstName, lastName);
        if (accessDuration > 3)
        {
            System.out.println("Access cannot be longer than 3 days!");
        }
        else if (accessDuration < 0)
        {
            System.out.println("Please enter a valid duration!");
        }
        else
        {
            this.accessDuration = accessDuration;
        }
        this.borrowedElectronicResource = borrowedElectronicResource;
        
        borrowedElectronicResource = new ArrayList<>();
    }
    
    /**
     * Second constructor to set default values to meaningful data.
     * Includes setting access duration to 1 by default if not entered by user
     */
    public LibraryGuest()
    {
        accessDuration = 1;
        borrowedElectronicResource = new ArrayList<>();
    }
    
    // Getter for the Guests Access Duration
    public int getAcessDuration()
    {
        return accessDuration;
    }
    
    // Getter for the Array List of Electronic Resources Borrowed
    public ArrayList<ElectronicResource> getBorrowedElectronicResources()
    {
        return borrowedElectronicResource;
    }
    
    // Setter for the Guests Access Duration, fulfilled by the User
    public void setAccessDuration(int accessDuration)
    {
        if (accessDuration > 3)
        {
            System.out.println("Access cannot be longer than 3 days!");
        }
        else if (accessDuration < 0)
        {
            System.out.println("Please enter a valid duration!");
        }
        else
        {
            this.accessDuration = accessDuration;
            System.out.println("Guest access duration has been amended");
        }    
    }
    
    /**
     * Method to view a Guests currently borrowed Electronic Resources;
     */
    public void checkCurrentlyBorrowed()
    {
        if (borrowedElectronicResource.isEmpty())
        {
            System.out.println("This Member currently has no resources on loan from the library");
        }
        else
        {
           for (ElectronicResource electronicResource : borrowedElectronicResource)
           {
               System.out.println("This Member currently has: " + electronicResource.getTitle() + " on loan from the library");
           }
        }
    }
    
    /**
     * Method to add a borrowed Electronic Resource to this Guest. Includes checking amount of copies avaliable
     */
    public void addBorrowedElectronicResource(ElectronicResource electronicResource)
    {
        if (electronicResource == null)
        {   
            throw new IllegalArgumentException("Null value entered - Please enter a valid value!");
        }
        if (borrowedElectronicResource.contains(electronicResource))
        {
            borrowedElectronicResource.add(electronicResource);
            System.out.println("This resource is already on loan by this Guest");
        }
        else if (electronicResource.getAvaliableToDownload() == true)
        {
            borrowedElectronicResource.add(electronicResource);
            electronicResource.setCopiesAvaliable(electronicResource.getCopiesAvaliable() - 1);
            System.out.println("This resource has been added to the Guests collection of loaned resources");
        }
        else if (electronicResource.getCopiesAvaliable() == 0 || electronicResource.getAvaliableToDownload() == false)
        {
            System.out.println("Sorry, there are currently no copies for this resource! Check back later");
        }
        else
        {
            System.out.println("Sorry! No resource with that name found in this Guests collection");
        }
    }
    
    /**
     * Method to return a borrowed Electronic Resource to the Library
     */
    public void returnBorrowedElectronicResource(ElectronicResource electronicResource)
    {
        if (electronicResource == null)
        {   
            throw new IllegalArgumentException("Null value entered - Please enter a valid value!");
        }
        if (borrowedElectronicResource.contains(electronicResource))
        {
            borrowedElectronicResource.remove(electronicResource);
            electronicResource.setCopiesAvaliable(electronicResource.getCopiesAvaliable() + 1);
            System.out.println("This resource has been returned to the Library!");
        }
        else if (borrowedElectronicResource.isEmpty())
        {
            System.out.println("This Guest currently has no resources on loan from the library");
        }
        else
        {
            System.out.println("Sorry! No resource with that name found in this Guests collection");
        }
    }
    
    /**
     * Method to print all details of an LibraryGuest Object
     */
    public void printDetails()
    {
        System.out.println("This Library Guests name is: " + getFirstName() + " " + getLastName());
        System.out.println("They have been allocated " + accessDuration + " days of access");
    }
    
    // Getter for size of Electronic Resources Array List
    public int getNumberOfBorrowedElectronicResource() 
    {
        return borrowedElectronicResource.size();
    }
    
    /**
     * Method to print how many Resources this member has on Loan 
     */
    public void numberOfResourcesBorrowed()
    {
        System.out.println("This user has " + getNumberOfBorrowedElectronicResource() + " Electronic Resources currently on loan");
    }
}
