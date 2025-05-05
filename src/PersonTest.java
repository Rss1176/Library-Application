

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class PersonTest. It's purpose is to test the methods and functionality from within the Person class
 *
 * @Ross Macpherson
 * @16/12/2024
 */
public class PersonTest
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
     * Default constructor for test class PersonTest
     */
    public PersonTest()
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
     * A test for all getters in the Person class
     */
    @Test
    public void testGetters()
    {
        Person person3 = new Person("bob", "jamie");
        assertEquals("bob", person3.getFirstName());
        assertEquals("jamie", person3.getLastName());
    }

    /**
     * A test for all setters in the Person class
     */
    @Test
    public void testSetters()
    {
        Person person1 = new Person("bob", "jamie");
        person1.setFirstName("John");
        person1.setLastName("bungie");
        assertEquals("John", person1.getFirstName());
        assertEquals("bungie", person1.getLastName());
    }
}


