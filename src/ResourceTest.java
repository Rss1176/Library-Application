

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class ResourceTest. It's purpose is to test the methods and functionality from within the Resource class
 *
 * @Ross Macpherson
 * @16/12/2024
 */
public class ResourceTest
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
     * Default constructor for test class ResourceTest
     */
    public ResourceTest()
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
     * A test for the title getter within the resource class
     */
    @Test
    public void testGetTitle()
    {
        Author author1 = new Author("Damien", "Anderson", "123 University Avenue");
        Resource resource1 = new Resource("Testing Title Yipee", author1);
        assertEquals("Testing Title Yipee", resource1.getTitle());
    }

    /**
     * A test for the author object getter within the resource class
     */
    @Test
    public void testGetAuthor()
    {
        Author author1 = new Author("Damien", "Anderson", "123 University Avenue");
        Resource resource1 = new Resource("Testing Authors Yipee", author1);
        assertEquals(author1, resource1.getAuthorDetails());
    }

    /**
     * A test for the current user getter within the resource class
     */
    @Test
    public void testGetCurrentUser()
    {
        Resource resource1 = new Resource();
        assertEquals(null, resource1.getCurrentUser());
    }

    /**
     * A test for the to print details of an object within the resource class
     */
    @Test
    public void testPrintDetails()
    {
        Author author1 = new Author("Damien", "Anderson", "123 University Avenue");
        Resource resource2 = new Resource("Testing Print Details Yipee", author1);
        resource2.printDetails();
    }

    /**
     * A test for all setter methods within the resource class
     */
    @Test
    public void testSetters()
    {
        Resource resource1 = new Resource();
        resource1.setCurrentUser(libraryM1);
        resource1.setTitle("Yipee the 3rd");
        resource1.setAuthorDetails(author1);
        assertEquals(author1, resource1.getAuthorDetails());
        assertEquals(libraryM1, resource1.getCurrentUser());
        assertEquals("Yipee the 3rd", resource1.getTitle());
    }
}





