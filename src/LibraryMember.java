
import java.util.ArrayList;


/**
 * A Class to represent a LibraryMember, such as a registered user. 
 * Acts as a Subclass to Person.
 *
 * @Ross Macpherson
 * @16/12/2024
 */
public class LibraryMember extends Person
{
    // instance variables - replace the example below with your own
    private int membershipNumber; 
    private ArrayList<PhysicalResource> borrowedPhysicalResource; 
    private ArrayList<ElectronicResource> borrowedElectronicResource;

    /**
     * Constructor for objects of class LibraryMember
     */
    public LibraryMember(String firstName, String lastName, int membershipNumber)
    {
        // initialise instance variables
        super(firstName, lastName);
        this.membershipNumber = membershipNumber;
        this.borrowedPhysicalResource = borrowedPhysicalResource;
        this.borrowedElectronicResource = borrowedElectronicResource;
        
        borrowedPhysicalResource = new ArrayList<>();
        borrowedElectronicResource = new ArrayList<>();
    }
    
    /**
     * Second Constructor to initialise variables to meaningful default values
     */
    public LibraryMember()
    {
        membershipNumber = 0000;
        borrowedPhysicalResource = new ArrayList<>();
        borrowedElectronicResource = new ArrayList<>();
    }

    // Getter for the Membership Number
    public int getMembershipNumber()
    {
        return membershipNumber;
    }
    
    // Getter for the Array List of Physical Resources Borrowed
    public ArrayList<PhysicalResource> getBorrowedPhysicalResources()
    {
        return borrowedPhysicalResource;
    }
    
    // Getter for the Array List of Electronic Resources Borrowed
    public ArrayList<ElectronicResource> getBorrowedElectronicResources()
    {
        return borrowedElectronicResource;
    }
    
    // Setter for the Membership Number
    public void setMembershipNumber(int membershipNumber)
    {
        this.membershipNumber = membershipNumber;    
    }
    
    // Getter for size of Physical Resources Array List
    public int getNumberOfBorrowedPhysicalResource() 
    {
        return borrowedPhysicalResource.size();
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
        if (getNumberOfBorrowedPhysicalResource() == 0)
        {
            System.out.println("This user has no Physical Resources currently on loan");
        }
        else
        {
            System.out.println("This user has " + getNumberOfBorrowedPhysicalResource() + " Physical Resources currently on loan");
        }
        if (getNumberOfBorrowedElectronicResource() == 0)
        {
            System.out.println("This user has no Electronic Resources currently on loan");
        }
        else
        {
            System.out.println("This user has " + getNumberOfBorrowedElectronicResource() + " Electronic Resources currently on loan");
        }
        if ((getNumberOfBorrowedPhysicalResource() == 0) && (getNumberOfBorrowedElectronicResource() == 0))
        {
            System.out.println("This user has no Resources currently on loan");
        }
        else
        {
            System.out.println("This user has a total of " + getNumberOfBorrowedPhysicalResource() + getNumberOfBorrowedElectronicResource() + " resources on loan");
        }
    }
    
    /**
     * Method to print details of an LibraryMember Object
     */
    public void printMemberDetails()
    {
        System.out.println("This Library Members name is: " + getFirstName() + " " + getLastName());
        System.out.println("This users Membership Number is: " + membershipNumber);
    }    
    
    /** Method to view a Members currently borrowed Physical Resources;
     * This is a secondary method that can be used to view resources taken from the library, the main method is used in the Library Class
     * Also having this method in this class is required as per final requirements document
     */
 
    public void checkCurrentlyBorrowedPhysical()
    {
         if (borrowedPhysicalResource.isEmpty())
         {
             System.out.println("This Member currently has no resources on loan from the library");
         }
         else
         {
            for (PhysicalResource physicalResource : borrowedPhysicalResource)
            {
               System.out.println("This Member currently has: " + physicalResource.getTitle() + " on loan from the library");
           }
         }
    }
    /**
     * Method to add a borrowed Physical Resource to this Member. Includes checking amount of copies avaliable
     * This is a secondary method that can be used to borrow books from the library, the main method is used in the Library Class
     * Also having this method in this class is required as per final requirements document
     */
    public void addBorrowedPhysicalResource(PhysicalResource physicalResource)
    {
        if (physicalResource == null)
        {   
            throw new IllegalArgumentException("Null value entered - Please enter a valid value!");
        }
        if (borrowedPhysicalResource.contains(physicalResource))
        {
            borrowedPhysicalResource.add(physicalResource);
            System.out.println("This resource is already on loan by this Member");
        }
        else if (physicalResource.getIsAvaliable() == true)
        {
            borrowedPhysicalResource.add(physicalResource);
            physicalResource.setCopiesAvaliable(physicalResource.getCopiesAvaliable() - 1);
            System.out.println("This Physical resource has been added to the Members collection of loaned resources");
        }
        else if (physicalResource.getCopiesAvaliable() == 0 || physicalResource.getIsAvaliable() == false)
        {
            System.out.println("Sorry, there are currently no copies for this resource! Check back later");
        }
    }
    
    /**
     * Method to return a borrowed Physical Resource to the Library
     * This is a secondary method that can be used to return books to the library, the main method is used in the Library Class
     * Also having this method in this class is required as per final requirements document
     */
    public void returnBorrowedPhysicalResource(PhysicalResource physicalResource)
    {
        if (physicalResource == null)
        {   
            throw new IllegalArgumentException("Null value entered - Please enter a valid value!");
        }
        if (borrowedPhysicalResource.contains(physicalResource))
        {
            borrowedPhysicalResource.remove(physicalResource);
            physicalResource.setCopiesAvaliable(physicalResource.getCopiesAvaliable() + 1);
            System.out.println("This Physical resource has been returned to the Library!");
        }
        else if (borrowedPhysicalResource.isEmpty())
        {
            System.out.println("This Member currently has no Physical resources on loan from the library");
        }
        else
        {
            System.out.println("Sorry! No Physical resources with that name found in this Members collection");
        }
    }
    
    /**
     * Method to view a Members currently borrowed Electronic Resources;
     * This is a secondary method that can be used to view resources taken from the library, the main method is used in the Library
     * Class as per final requirements document
     */
    public void checkCurrentlyBorrowedElectronic()
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
     * Method to add a borrowed Electronic Resource to this Member. Includes checking amount of copies avaliable
     * This is a secondary method that can be used to borrow books from the library, the main method is used in the Library Class
     * as per final requirements document
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
            System.out.println("This resource is already on loan by this Member");
        }
        else if (electronicResource.getAvaliableToDownload() == true)
        {
            borrowedElectronicResource.add(electronicResource);
            electronicResource.setCopiesAvaliable(electronicResource.getCopiesAvaliable() - 1);
            System.out.println("This resource has been added to the Members collection of loaned resources");
        }
        else if (electronicResource.getCopiesAvaliable() == 0 || electronicResource.getAvaliableToDownload() == false)
        {
            System.out.println("Sorry, there are currently no copies for this resource! Check back later");
        }
    }
    
    /**
     * Method to return a borrowed Electronic Resource to the Library
     * This is a secondary method that can be used to return books to the library, the main method is used in the Library Class
     * as per final requirements document
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
            System.out.println("This Member currently has no Electronic resources on loan from the library");
        }
        else
        {
            System.out.println("Sorry! No resource with that name found in this Members collection");
        }
    }
}
