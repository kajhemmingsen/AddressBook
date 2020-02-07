package AddressBook.Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.ALL;

@Entity
public class AddressBook {



    private Long ID;
    private List<BuddyInfo> buddies;

    public AddressBook() {
        this.buddies = new ArrayList<BuddyInfo>();
    }

    public AddressBook(ArrayList<BuddyInfo> existingContacts) {
        this.buddies = existingContacts;
    }

    public void addBuddy(BuddyInfo newBuddy) {
        this.buddies.add(newBuddy);
    }

    public void addBuddy(String bName, String bNum) {
        BuddyInfo newBuddy = new BuddyInfo(bName, bNum);
        newBuddy.setAddressBook(this);
        this.buddies.add(newBuddy);
    }
    public void removeBuddy(BuddyInfo friendShipEnded) {
        for (int i = 0; i < buddies.size(); i++) {
            if(friendShipEnded.getBuddyName().equals(buddies.get(i).getBuddyName()) && (friendShipEnded.getBuddyNum()) == buddies.get(i).getBuddyNum()) {
                buddies.remove(buddies.get(i));
            }
        }
    }

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    @OneToMany(cascade = ALL, fetch = FetchType.EAGER, mappedBy = "addressBook")
    public List<BuddyInfo> getBuddies() {
        return buddies;
    }


    public void setBuddies(List<BuddyInfo> buddies) {
        this.buddies = buddies;
    }

    public String toString() {
        StringBuilder outString = new StringBuilder();
        for (int i = 0; i < buddies.size(); i++) {
            outString.append(buddies.get(i).getBuddyName() + " " + buddies.get(i).getBuddyNum() + "\n");
        }
        return outString.toString();


    }
}


