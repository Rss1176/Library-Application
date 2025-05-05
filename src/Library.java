
import java.util.ArrayList;


/**
 * A Class for the Library itself, which will contain a catelogue of all the Library Resources.
 *
 * @Ross Macpherson
 * @16/12/2024
 */
public class Library
{
    // instance variables - replace the example below with your own
    private ArrayList<Resource>catalogue;

    /**
     * Constructor for the catalogue of Library Resources
     */
    public Library()
    {
        // initialise instance variables
        catalogue = new ArrayList<>();
    }
    
    // Getter for the catelogue
    public ArrayList<Resource> getCatalogue()
    {
        return catalogue;
    }
    
    /**
     * Method to add a Resource object, either Physical or Electronic to the Library Catalogue
     */
    public void addResource(Resource resource)
    { 
        if (resource == null)
        {   
            throw new IllegalArgumentException("Null value entered - Please enter a valid value!");
        }
        if (catalogue.contains(resource)) 
        {
            System.out.println("This Resource has already been added to the catalogue!");
        }
        else 
        {
            catalogue.add(resource);
            System.out.println("This Resource has been added to the catalogue!");
        }
    }
    
    /**
     * Method to remove a Resource object (including all copies), either Physical or Electronic from the Library Catelogue
     * The default value, unless specified specifically by the user the amount of copies avaliable is 1
     */
    public void removeResource(Resource resource)
    {
        if (resource == null)
        {   
            throw new IllegalArgumentException("Null value entered - Please enter a valid value!");
        }
        if (catalogue.contains(resource) && resource.getCurrentUser() == null)
        {
            catalogue.remove(resource);
            System.out.println("This Resource has been removed from the catalogue!");
        }
        else if (catalogue.contains(resource) && resource.getCurrentUser() != null)
        {
            System.out.println("A copy of this resource is currently on loan, once all copies have been returned try again");
        }
        else if (catalogue.isEmpty())
        {
            System.out.println("The catalogue is currently empty! There are no resources to remove");
        }
        else
        {
            System.out.println("No resource found with that name in the catalogue!");
        }
    }
    
    /**
     * Method to remove a Resource object (including all copies) using an index
     */
    public void removeResourceAtIndex(int index)
    {
        Resource resource = catalogue.get(index);
        if (index < 0 || index >= catalogue.size()) 
        { 
            System.out.println("Please enter a valid index!");
        }
        else if (catalogue.contains(index) && resource.getCurrentUser() != null)
        {
            System.out.println("A copy of this resource is currently on loan, once all copies have been returned try again");
        }
        else if (catalogue.isEmpty())
        {
            System.out.println("The catalogue is currently empty! There are no resources to remove");
        }
        else
        {
            System.out.println("No resource found at specified index!");
        }
    }
    
    /**
     * Method to check, and print all Resource objects currently contained within the catalogue
     * This method does not print books currently out on loan if there are no copies left
     */
    public void printCatalogue()
    {
        for (Resource resource : catalogue)
        {
            if (catalogue.contains(resource))
            {
                resource.printDetails();
            }
            else
            {
                System.out.println("The catalogue is currently empty, please add some resources first!");
            }
        }
    }
    
    /**
     * Method to check, and print all Physical Resource objects only currently contained within the catalogue
     * This method does not print books currently out on loan if there are no copies left
     */
    public void printPhysicalResources()
    {
        boolean contains = false;
        for (Resource resource : catalogue)
        {
            if (resource instanceof PhysicalResource)
            {
                resource.printDetails();
            }
        }
        if (catalogue.isEmpty())
        {
            System.out.println("The catalogue is currently empty!");
        }
        else if (contains == false)
        {
            System.out.println("The catalogue doesn't contain any electronic resources!");
        }
    }
    
    /**
     * Method to check, and print all Electronic Resource objects only currently contained within the catalogue
     * This method does not print books currently out on loan if there are no copies left
     */
    public void printElectronicResources()
    {
        boolean contains = false;
        for (Resource resource : catalogue)
        {
            if (resource instanceof ElectronicResource)
            {
                resource.printDetails();
                contains = true;
            }
        }
        if (catalogue.isEmpty())
            {
                System.out.println("The catalogue is currently empty!");
            }
            else if (contains == false)
            {
                System.out.println("The catalogue doesn't contain any electronic resources!");
            }
    }
    
    /**
     * Method to print the size of the catalogue
     */
    public int checkCatalogueSize()
    {
        return catalogue.size();
    }
    
    /**
     * Method to check if a specific object is contained in the library catalogue
     */
    public boolean checkResource (Resource resource)
    {
        if (resource == null)
        {   
            throw new IllegalArgumentException("Null value entered - Please enter a valid value!");
        }
        if (catalogue.contains(resource))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    /**
     * Method to update an Authors first name in a resource
     * Note - I thought 'String' in the parameters should be 'Author', however it does not work if so, not sure why this happens?
     */
    public void updateAuthorFirstName(Resource resource, String updatedFirstName)
    {
        if (resource == null || updatedFirstName == null)
        {   
            throw new IllegalArgumentException("Null value entered - Please enter a valid value!");
        }
        if (resource.getAuthorDetails() == null)
        {
            System.out.println("No Author information is found for this Resource!");
        }
        else if (catalogue.contains(resource))
        {
            resource.getAuthorDetails().setFirstName(updatedFirstName);
            System.out.println("Authors first name for this resource has been updated!");
        }
        else 
        {
            System.out.println("No resource found in the catalogue with that name!");
        }
    }
    
    /**
     * Method to search the Catalogue using the Resource title
     */
    public void searchByTitle(String titleSearch)
    {
        if (titleSearch == null)
        {   
            throw new IllegalArgumentException("Null value entered - Please enter a valid value!");
        }
        int index = 0;
        for (Resource resource : catalogue)
        {
            if (resource.getTitle().equalsIgnoreCase(titleSearch))
            {
                resource.printDetails(); 
                index = index + 1;
            }
            else if (catalogue.isEmpty())
            {
                System.out.println("The catalogue currently doesn't have any Resources to search through!");
            }
            else
            {
                System.out.println("No resources found with that title!");
            }
        }
        System.out.println("The total number of resources found that matched your search title was: " + index);
    }
    
    /** 
     * Method to search the Catalogue using the Authors last name
     */
    public void searchByAuthorSurname(String surnameSearch)
    {
        if (surnameSearch == null)
        {   
            throw new IllegalArgumentException("Null value entered - Please enter a valid value!");
        }
        int index = 0;
        for (Resource resource : catalogue)
        {
            Author author = resource.getAuthorDetails();
            if (resource.getAuthorDetails().getLastName().equalsIgnoreCase(surnameSearch))
            {
                resource.printDetails();
                index = index + 1;
            }
            else if (resource.getAuthorDetails() == null)
            {
                System.out.println("No resources found matching that authors last name");
            }
            else if (catalogue.isEmpty())
            {
                System.out.println("The catalogue currently doesn't have any Resources to search through!");
            }
        }
        System.out.println("The total number of resources found that matched your search title was: " + index);
    }
    
    /**
     * Method for a Library Member to loan a Physical resource
     * Only includes Members, Guests are only able to loan electronic resources
     */
    public void loanPhysicalResource(PhysicalResource resource, LibraryMember member)
    {
        if (resource == null || member == null)
        {   
            throw new IllegalArgumentException("Null value entered - Please enter a valid value!");
        }
        if (catalogue.isEmpty())
        {
            System.out.print("The Library currently has no resources to loan out!");
        }
        else if (resource.getCopiesAvaliable() > 0)
        {
            resource.setCopiesAvaliable(resource.getCopiesAvaliable() - 1);
            resource.setCurrentUser(member);
            System.out.println("This member has successfully loaned a copy of this resource!");
        }
        else if (resource.getCopiesAvaliable() == 0)
        {
            System.out.println("Sorry, all copies of this resource are currently loaned to other members! Please check back later");
        }
    }
    
    /**
     * Method for a Library Member to loan an Electronic resource
     * Both members and guests are able to loan electronic resources.
     */
    public void loanElectronicResource(ElectronicResource resource, Person person)
    {
        if (resource == null || person == null)
        {   
            throw new IllegalArgumentException("Null value entered - Please enter a valid value!");
        }
        if (catalogue.isEmpty())
        {
            System.out.print("The Library currently has no resources to loan out!");
        }
        else if (resource.getCopiesAvaliable() > 0 && person instanceof LibraryMember)
        {
            resource.setCopiesAvaliable(resource.getCopiesAvaliable() - 1);
            resource.setCurrentUser(person);
            System.out.println("This member has successfully loaned a copy of this resource!");
        }
        else if (resource.getCopiesAvaliable() > 0 && person instanceof LibraryGuest)
        {
            resource.setCopiesAvaliable(resource.getCopiesAvaliable() - 1);
            resource.setCurrentUser(person);
            System.out.println("This guest has successfully loaned a copy of this resource!");
        }
        else if (resource.getCopiesAvaliable() == 0)
        {
            System.out.println("Sorry, all copies of this resource are currently loaned to other members or guests! Please check back later");
        }
    }
    
    /**
     * Method to return a Physical Resource to the library
     * This includes a possible damage checker, this will add on to the Array List contained within the Physical Resource Class.
     * It calls the method from that class, and to check damage use the checkExistingDamages() method on the physical resource object.
     * 
     * After testing, I have discovered that due to the 'copiesAvaliable' variable, I do not need to include an 'if' all copies are checked
     * out specifically, because it will still remain in the catalogue, just with 0 copies, the full resource is never 'completely' removed
     * from the catalogue Array List - I only need to specify if it doesn't exist at all, suggesting it was never in the catalogue initially
     */
    public void returnPhysicalResource(PhysicalResource resource, boolean newDamage, String damageDetails)
    {
        // No need to have == null for damageDetails, as a user could enter null and false into newDamage, suggesting nothing to record
        if (resource == null)
        {   
            throw new IllegalArgumentException("Null value entered - Please enter a valid value!");
        }
        if (catalogue.contains(resource) && newDamage == false)
        {
            resource.setCopiesAvaliable(resource.getCopiesAvaliable() + 1);
            resource.setCurrentUser(null);
            System.out.println("This copy has been added back into the catalogue!");
        }
        else if (!catalogue.contains(resource))
        {
            System.out.println("Oops! This resource isn't contained in the library");
        }
        
        if (newDamage == true)
        {
            resource.addNewDamage(damageDetails);
            resource.setCopiesAvaliable(resource.getCopiesAvaliable() + 1);
            resource.setCurrentUser(null);
            System.out.println("This copy has been added back into the catalogue!");
        }
    }
    
    /**
     * Method to return an Electronic Resource to the library
     */
    public void returnElectronicResource(ElectronicResource resource)
    {
        if (resource == null)
        {   
            throw new IllegalArgumentException("Null value entered - Please enter a valid value!");
        }
        if (catalogue.contains(resource))
        {
            resource.setCopiesAvaliable(resource.getCopiesAvaliable() + 1);
            resource.setCurrentUser(null);
            System.out.println("This copy has been added back into the catalogue!");
        }
        else if (!catalogue.contains(resource))
        {
            System.out.println("Oops! This resource isn't contained in the library");
        }
    }
}










