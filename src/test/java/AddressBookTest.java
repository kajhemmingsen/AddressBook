import AddressBook.Model.AddressBook;
import AddressBook.Model.BuddyInfo;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

public class AddressBookTest {

    BuddyInfo testBuddy = new BuddyInfo("boi", "18350798");
    BuddyInfo testBuddy2 = new BuddyInfo("boi2", "231231");
    AddressBook testAB = new AddressBook();
    ArrayList<BuddyInfo> testContacts = new ArrayList<BuddyInfo>();

    @Before
    public void setUp() {
        testContacts.add(testBuddy);
    }

    @Test
    public void addBuddy() {
        testAB.addBuddy(testBuddy);
        assert(testAB.getBuddies().get(0).equals(testBuddy));
    }

    @Test
    public void getContacts() {
        testAB.addBuddy(testBuddy);
        assert(testAB.getBuddies().equals(testContacts));
    }

    @Test
    public void setContacts() {
        testAB.setBuddies(testContacts);
        assert(testAB.getBuddies().equals(testContacts));
    }

    @Test
    public void removeBuddy() {
        testAB.addBuddy(testBuddy);
        testAB.addBuddy(testBuddy2);
        testAB.removeBuddy(testBuddy2);
        assert(testBuddy.equals(testBuddy));
    }
    @Test
    public void toStringTest() {
        testAB.addBuddy(testBuddy);
        testAB.addBuddy(testBuddy2);
        System.out.println(testAB.toString());
        assert(testAB.toString().equals("boi 18350798\nboi2 231231\n"));
    }
}
