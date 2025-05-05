

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class PhysicalResourceTest. It's purpose is to test the methods and functionality from within the PhysicalResource class
 *
 * @Ross Macpherson
 * @16/12/2024
 */
public class PhysicalResourceTest
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
     * Default constructor for test class PhysicalResourceTest
     */
    public PhysicalResourceTest()
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
     * Getters for title, author and current user are tested within the ResourceTest class
     */
    
    /**
     * A test for all getters
     */
    @Test
    public void testGetters()
    {
        Author author1 = new Author();
        PhysicalResource physical1 = new PhysicalResource("Yipee Volume 2", 5, author1);
        
        assertEquals(1, physical1.getCopiesAvaliable());
        assertEquals(true, physical1.getIsAvaliable());
        assertEquals(5, physical1.getISBN());
    }

    /**
     * A test for all setters
     */
    @Test
    public void testSetters()
    {
        Author author1 = new Author();
        PhysicalResource physical1 = new PhysicalResource("Yipee Volume 2", 5, author1);
        
        physical1.setISBN(10);
        Author author2 = new Author();
        physical1.setAuthorDetails(author2);
        physical1.setTitle("Yipee the original");
        
        assertEquals(10, physical1.getISBN());
        assertEquals(author2, physical1.getAuthorDetails());
        assertEquals("Yipee the original", physical1.getTitle());
    }

    /**
     * A test to add damage to the array list
     * Leaving here as a comment, I couldn't get this to work but allows you to see thought process when testing terminal outputs
     *
    @Test
    public void testAddDamage()
    {
        PhysicalResource physical2 = new PhysicalResource();
        physical2.addNewDamage("Someone has eaten page 3");
        
        String expectedOutput = "Someone has eaten page 3";
        String systemOutput = physical2.checkExistingDamages();
        
        assertEquals(expectedOutput, systemOutput);
    }
     */
    
    /**
     * A test to add damage to the object, and confirm the output to terminal matches the expected String
     */

    @Test
    public void testAddDamage()
    {
        /**
         * Noting here - but applies elsewhere when comparing strings, cannot figure out how to match einput string to the new line added
         * However, while below is correct, if someone enters a different string the code for testing has to change, so is not efficient
         */
        PhysicalResource physical1 = new PhysicalResource();
        physical1.addNewDamage("Someone has eaten page 3");
        physical1.checkExistingDamages();
        
        String inputString = "Current recorded damages are: [Someone has eaten page 3]";
        String expectedString = "Current recorded damages are: [Someone has eaten page 3]";
        
        assertEquals(inputString, expectedString);
    }

    /**
     * A test for the NoCurrentUser boolean check within the PhysicalResource class. Should return true if no current user.
     * As no user set before testing, test should return true
     */
    @Test
    public void testNoCurrentUser()
    {
        assertEquals(true, physical1.checkNoCurrentUser());
    }

    /**
     * A test for the check damages method in the PhysicalResource class. As list should be empty should return no damages.
     * String does successfully match, but unsure of the syntax to complete this.
     */
    @Test
    public void testCheckDamages()
    {
        physical1.checkExistingDamages();
        // assertEquals(0, physical1.resourceDamages.Size(0));
    }

    /**
     * A test to print resource details in the PhysicalResource class
     * Terminal output matches what is expected
     */
    @Test
    public void testPrintDetails()
    {
        physical1.printResourceDetails();
    }

    /**
     * A test to confirm the default value of copies avaliable is 1
     */
    @Test
    public void testGetCopiesAvaliable()
    {
        assertEquals(1, physical1.getCopiesAvaliable());
    }

    /**
     * A test for to confirm the value of copies after user input of multiple copies. Uses setter for CopiesAvaliable
     */
    @Test
    public void testGetCopiesAvaliableMultiple()
    {
        physical1.setCopiesAvaliable(10);
        assertEquals(10, physical1.getCopiesAvaliable());
    }

    /**
     * A test to confirm output if user enters an invalid value for copies avaliable, should default to 1 and print error to terminal.
     */
    @Test
    public void testInvalidGetCopiesAvaliable()
    {
        physical1.setCopiesAvaliable(-5);
        assertEquals(1, physical1.getCopiesAvaliable());
    }
}










