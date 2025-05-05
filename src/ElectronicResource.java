/**
 * A Class to represent an Electronic Resource, such as a Digital Book, Online Journal Article etc.
 * Subclass to Resource Class
 *
 * @Ross Macpherson
 * @16/12/2024
 */
public class ElectronicResource extends Resource
{
    // instance variables
    private boolean avaliableToDownload;
    private int copiesAvaliable;

    /**
     * Constructor for objects of class ElectronicResource
     */
    public ElectronicResource(String title, Author authorName)
    {
        // initialise instance variables
        super(title, authorName);
        this.avaliableToDownload = avaliableToDownload;
        this.copiesAvaliable = copiesAvaliable;
        
        copiesAvaliable = 1;
    }
    
    /**
     * Second Constructor to initialise variables to meaningful default values
     */
    public ElectronicResource()
    {
       // initialise instance variables to meaningful values
       copiesAvaliable = 1;
    }
    
    // Getter for True/False value if the resource is avaliable, based on value of Copies Avaliable(below).
    public boolean getAvaliableToDownload()
    {
        return copiesAvaliable > 0;
    }
    
    // Getter for the amount of Copies Avaliable to download.
    public int getCopiesAvaliable()
    {
        return copiesAvaliable;
    }
    
    // No Setter needed for avaliableToDownload, as it determined by the amount of Copies Avaliable.
    
    // Setter for the amount of Copies Avaliable, fulfilled by the User.
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
}
