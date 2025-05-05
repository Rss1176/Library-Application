

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class LibraryGuestTest. It's purpose is to test the methods and functionality from within the LibraryGuest class
 *
 * @Ross Macpherson
 * @16/12/2024
 */
public class LibraryGuestTest
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
     * Default constructor for test class LibraryGuestTest
     */
    public LibraryGuestTest()
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
     * A test to ensure that when the Guest object is created, the input matches the getter for the duration.
     */
    @Test
    public void testValidDuration()
    {
        assertEquals(3, libraryG1.getAcessDuration());
    }

    /**
     * A test to determine the outcome if a user tries to set an invalid duration, the value should remain at what it was previously.
     */
    @Test
    public void testInvalidDuration()
    {
        libraryG1.setAccessDuration(5);
        assertEquals(3, libraryG1.getAcessDuration());
    }

    /**
     * A test of the method in libraryGuest for borrowing an electronic resource, checks by using the getter for number of
     * resources borrowed, after borrowing should increase by 1
     */
    @Test
    public void testBorrowResource()
    {
        libraryG1.addBorrowedElectronicResource(electron1);
        assertEquals(1, libraryG1.getNumberOfBorrowedElectronicResource());
    }

    /**
     * A test of the method to return an electronic resource, after returning the getter for the number borrowed should be 0, or
     * decrease by 1 from whatever the value was while the resource was borrowed
     */
    @Test
    public void testReturnResource()
    {
        libraryG1.addBorrowedElectronicResource(electron1);
        libraryG1.returnBorrowedElectronicResource(electron1);
        assertEquals(0, libraryG1.getNumberOfBorrowedElectronicResource());
    }

    /**
     * A test to determine the outcome if a user borrows multiple resources, the get number borrowed should be however many resources
     * were taken.
     */
    @Test
    public void testMultipleBorrowedResources()
    {
        ElectronicResource electron2 = new ElectronicResource();
        libraryG1.addBorrowedElectronicResource(electron1);
        libraryG1.addBorrowedElectronicResource(electron2);
        assertEquals(2, libraryG1.getNumberOfBorrowedElectronicResource());
    }
}





