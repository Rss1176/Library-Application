

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class AuthorTest. It's purpose is to test the methods and functionality from within the Author class
 *
 * @Ross Macpherson
 * @16/12/2024
 */
public class AuthorTest
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
     * Default constructor for test class AuthorTest
     */
    public AuthorTest()
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
     * A test for the first name getter within the Author class
     */
    @Test
    public void testGetFirstName()
    {
        Author author2 = new Author("Damien", "Anderson", "123 University Avenue");
        assertEquals("Damien", author2.getFirstName());
    }
    
    /**
     * A test for the last name getter within the Author class
     */
    @Test
    public void testGetLastName()
    {
        Author author2 = new Author("Damien", "Anderson", "123 University Avenue");
        assertEquals("Anderson", author2.getLastName());
    }
    
    /**
     * A test for the address getter within the Author class
     */
    @Test
    public void testGetAddress()
    {
        Author author2 = new Author("Damien", "Anderson", "123 University Avenue");
        assertEquals("123 University Avenue", author2.getAddress());
    }

    /**
     * Method test to print all details of an author object
     */
    @Test
    public void testPrintAllDetails()
    {
        Author author2 = new Author("Damien", "Anderson", "123 University Avenue");
        author2.printAllDetails();
    }

    /**
     * A test for all setters within the Author class
     */
    @Test
    public void testSetters()
    {
        author1.setAddress("123 college street");
        author1.setFirstName("Joe");
        author1.setLastName("Blogs");
        assertEquals("123 college street", author1.getAddress());
        assertEquals("Joe", author1.getFirstName());
        assertEquals("Blogs", author1.getLastName());
    }
}



