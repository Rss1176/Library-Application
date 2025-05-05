

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class LibraryMemberTest. It's purpose is to test the methods and functionality from within the LibraryMember class
 *
 * @Ross Macpherson
 * @16/12/2024
 */
public class LibraryMemberTest
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
     * Default constructor for test class LibraryMemberTest
     */
    public LibraryMemberTest()
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
     * A test for all setters within the LibraryMember class
     */
    @Test
    public void testSetters()
    {
        libraryM1.setMembershipNumber(100);
        assertEquals(100, libraryM1.getMembershipNumber());
    }

    /**
     * A test for the borrow physical resource method in the LibraryMember class. Once borrowed, amount borrowed should be at 1.
     */
    @Test
    public void testBorrowPhysicalResource()
    {
        libraryM1.addBorrowedPhysicalResource(physical1);
        assertEquals(1, libraryM1.getNumberOfBorrowedPhysicalResource());
    }

    /**
     * A test for the return of a physical resource method in the LibraryMember class. Once borrowed, amount borrowed should be at 0.
     */
    @Test
    public void testReturnPhysicalResource()
    {
        libraryM1.addBorrowedPhysicalResource(physical1);
        libraryM1.returnBorrowedPhysicalResource(physical1);
        assertEquals(0, libraryM1.getNumberOfBorrowedPhysicalResource());
    }

    /**
     * A test for the borrow electronic resource method in the LibraryMember class. Once borrowed, amount borrowed should be at 1.
     */
    @Test
    public void testBorrowElectronicResource()
    {
        libraryM1.addBorrowedElectronicResource(electron1);
        assertEquals(1, libraryM1.getNumberOfBorrowedElectronicResource());
    }
    
    /**
     * A test for the return of an electronic resource method in the LibraryMember class. Once borrowed, amount borrowed should be at 0.
     */
    @Test
    public void testReturnElectronicResource()
    {
        libraryM1.addBorrowedElectronicResource(electron1);
        libraryM1.returnBorrowedElectronicResource(electron1);
        assertEquals(0, libraryM1.getNumberOfBorrowedElectronicResource());
    }
    
    /**
     * A test to ensure that if a user borrows multiple resources, the array list increases appropriately.
     */
    @Test
    public void testBorrowMultiple()
    {
        libraryM1.addBorrowedPhysicalResource(physical1);
        libraryM1.addBorrowedPhysicalResource(physical2);
        assertEquals(2, libraryM1.getNumberOfBorrowedPhysicalResource());
    }

    /**
     * A test for the outcome of a return method on an empty list, should return 0 if nothing has been borrowed. For Physical resources.
     */
    @Test
    public void testEmptyListOfBorrowedPhysical()
    {
        assertEquals(0, libraryM1.getNumberOfBorrowedPhysicalResource());
    }

    /**
     * A test for the outcome of a return method on an empty list, should return 0 if nothing has been borrowed. For Electronic resources.
     */
    @Test
    public void testEmptyListOfBorrowedElectronic()
    {
        assertEquals(0, libraryM1.getNumberOfBorrowedElectronicResource());
    }
}








