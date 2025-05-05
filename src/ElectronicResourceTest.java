

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class ElectronicResourceTest. It's purpose is to test the methods and functionality from within the ElectronicResource class
 *
 * @Ross Macpherson
 * @16/12/2024
 */
public class ElectronicResourceTest
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
     * Default constructor for test class ElectronicResourceTest
     */
    public ElectronicResourceTest()
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
     * Test to get copies avaliable using the default value
     */
    @Test
    public void testGetCopiesAvaliable()
    {
        ElectronicResource electron2 = new ElectronicResource();
        assertEquals(1, electron2.getCopiesAvaliable());
    }

    /**
     * Test to get copies avaliable after the user specifies an amount greater than the default value
     */
    @Test
    public void testGetCopiesAvaliableMultiple()
    {
        Author author1 = new Author("Damien", "Anderson", "123 University Avenue");
        ElectronicResource electron1 = new ElectronicResource("Yipee Volume 2", author1);
        electron1.setCopiesAvaliable(5);
        assertEquals(5, electron1.getCopiesAvaliable());
    }

    /**
     * Test to get copies avaliable after the user specifies an amount less than 0 (invalid value, so will default to 1)
     */
    @Test
    public void testInvalidGetCopiesAvaliable()
    {
        Author author1 = new Author();
        ElectronicResource electron1 = new ElectronicResource("Yipee Volume 2", author1);
        electron1.setCopiesAvaliable(-10);
        assertEquals(1, electron1.getCopiesAvaliable());
    }

    /**
     * Test to return true if resource is avaliable, as default value is 1, should return true as user has not changed copiesAvaliable
     */
    @Test
    public void testAvaliableToDownload()
    {
        Author author1 = new Author();
        ElectronicResource electron1 = new ElectronicResource("Yipee Volume 2", author1);
        assertEquals(true, electron1.getAvaliableToDownload());
    }
    
    /**
     * Test to return false if resource is unavaliable, should return false as copiesAvaliable is 0
     */
    @Test
    public void testInvalidAvaliableToDownload()
    {
        Author author1 = new Author();
        ElectronicResource electron1 = new ElectronicResource("Yipee Volume 2", author1);
        electron1.setCopiesAvaliable(0);
        assertEquals(false, electron1.getAvaliableToDownload());
    }
}





