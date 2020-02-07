import AddressBook.Model.BuddyInfo;
import org.junit.Test;

public class BuddyInfoTest {

    BuddyInfo testBuddy = new BuddyInfo("boi", "18350798");

    @Test
    public void getBuddyName() {
        assert(testBuddy.getBuddyName().equals("boi"));
    }

    @Test
    public void getBuddyNum() {
        assert(testBuddy.getBuddyNum().equals("18350798"));
    }

    @Test
    public void setBuddyName() {
        testBuddy.setBuddyName("BOI");
        assert(testBuddy.getBuddyName().equals("BOI"));
    }

    @Test
    public void setBuddyNum() {
        testBuddy.setBuddyNum("7213641");
        assert(testBuddy.getBuddyNum().equals("7213641"));
    }

    @Test
    public void toStringTest() {
        assert(testBuddy.toString().equals("boi 18350798"));
    }
}
