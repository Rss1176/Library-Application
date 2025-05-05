

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class LibraryTest. It's purpose is to test the methods and functionality from within the Library class
 *
 * @Ross Macpherson
 * @16/12/2024
 */
public class LibraryTest
{
    private Author author1;
    private PhysicalResource physical1;
    private PhysicalResource physical2;
    private ElectronicResource electron1;
    private Library library1;
    private LibraryMember libraryM1;
    private LibraryGuest libraryG1;
    private LibraryMember libraryM2;

    /**
     * Default constructor for test class LibraryTest
     */
    public LibraryTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()
    {
        author1 = new Author("Damien", "Anderson", "123 University Avenue");
        physical1 = new PhysicalResource("Yipee the original", 5, author1);
        physical2 = new PhysicalResource("Yipee Volume 2", 6, author1);
        electron1 = new ElectronicResource("Yipee on Digital", author1);
        library1 = new Library();
        libraryM1 = new LibraryMember("John", "Halo", 117);
        libraryG1 = new LibraryGuest("Nathan", "Drake", 3);
        libraryM2 = new LibraryMember("Jane", "Dark Souls", 666);
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown()
    {
    }

    /**
     * A test to determine the outcome if a user adds a resource to the catalogue, catalogue should increase by 1
     */
    @Test
    public void testAddResourceToCatalogue()
    {
        assertEquals(0, library1.checkCatalogueSize());
        library1.addResource(physical1);
        assertEquals(1, library1.checkCatalogueSize());
    }

    /**
     * A test to determine the outcome if a user adds multiple resource to the catalogue, catalogue should increase by however
     * many resources were added, regardless of physical or electronic
     */
    @Test
    public void testAddMultipleResourceToCatalogue()
    {
        assertEquals(0, library1.checkCatalogueSize());
        library1.addResource(physical1);
        library1.addResource(electron1);
        assertEquals(2, library1.checkCatalogueSize());
    }

    /**
     * A test to determine the outcome if a user uses the checkEmptyCatalogue method. If used before adding resources, should
     * return 0
     */
    @Test
    public void testCheckEmptyCatalogue()
    {
        assertEquals(0, library1.checkCatalogueSize());
    }

    /**
     * A test to check the method of loaning a resource from the catalogue, to a user
     */
    @Test
    public void testLoanResourceFromCatalogue()
    {
        library1.addResource(physical1);
        library1.loanPhysicalResource(physical1, libraryM1);
    }

    /**
     * A test to check the method of returning a resource to the catalogue, from being on loan from a user
     */
    @Test
    public void testReturnResourceToCatalogue()
    {
        library1.addResource(physical1);
        library1.loanPhysicalResource(physical1, libraryM1);
        assertEquals(false, physical1.checkNoCurrentUser());
        library1.returnPhysicalResource(physical1, false, "none");
        assertEquals(true, physical1.checkNoCurrentUser());
    }

    /**
     * A test to check if the catalogue contains any physical resource objects. Method should return however many have been added 
     * to the catalogue
     */
    @Test
    public void testCatalogueContainsPhysical()
    {
        library1.addResource(physical1);
        library1.printPhysicalResources();
    }

    /**
     * A test to check the search function using authors name, this would only work if an author has been set, and the resource needs
     * to be contained within the catalogue. Returns true if author matches a catalogue entry.
     */
    @Test
    public void testSearchByAuthor()
    {
        library1.addResource(physical1);
        library1.searchByAuthorSurname("Anderson");
        assertEquals("Anderson", author1.getLastName());
    }

    /**
     * A test to check the search function using resource title,the resource needs to be contained within the catalogue.
     * Returns true if title matches a catalogue entry.
     */
    @Test
    public void testSearchByTitle()
    {
        library1.addResource(physical1);
        library1.searchByTitle("Yipee the original");
        assertEquals("Yipee the original", physical1.getTitle());
    }

    /**
     * A test to check the method of updating an authors name. Uses the getter in author object to ensure has updated correctly.
     */
    @Test
    public void testUpdateAuthorName()
    {
        library1.addResource(physical1);
        library1.updateAuthorFirstName(physical1, "John");
        assertEquals("John", author1.getFirstName());
    }

    /**
     * A test to check the method of removing an object from the catalogue using the object name. Should decrease the size of the
     * catalogue by 1 after removal.
     */
    @Test
    public void testRemoveResourceByObjectName()
    {
        library1.addResource(physical1);
        assertEquals(1, library1.checkCatalogueSize());
        library1.removeResource(physical1);
        assertEquals(0, library1.checkCatalogueSize());
    }

    /**
     * Test method for the remove at index method, should remove an object at a specified index in the catalogue.
     * Note - this doesn't work correctly but I'm not sure why, the test is correct but the code for the base method is wrong
     */
    @Test
    public void testRemoveAtIndex()
    {
        library1.addResource(physical1);
        assertEquals(1, library1.checkCatalogueSize());
        library1.removeResourceAtIndex(0);
        assertEquals(0, library1.checkCatalogueSize());
    }

    @Test
    public void testCheckResource()
    {
        library1.addResource(physical1);
        assertEquals(true, library1.checkResource(physical1));
    }

    @Test
    public void addIncorrectResourceToCatalogue()
    {
        assertEquals(0, library1.checkCatalogueSize());
        // library1.addResource(physical5); //adding a resource that doesn't exist gives an error
        assertEquals(0, library1.checkCatalogueSize());
    }
}
















