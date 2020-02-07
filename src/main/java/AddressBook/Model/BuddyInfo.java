package AddressBook.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import static javax.persistence.CascadeType.ALL;

@Entity
public class BuddyInfo {



    private Long ID = null;
    private String buddyName;
    private String buddyNum;
    @JsonIgnore
    private AddressBook addressBook;


    public BuddyInfo() { }

    public BuddyInfo(String bName, String bNum) {
        this.buddyName = bName;
        this.buddyNum = bNum;
    }
    public String getBuddyName() {
        return buddyName;
    }

    public String getBuddyNum() {
        return buddyNum;
    }

    public void setBuddyName(String buddyName) {
        this.buddyName = buddyName;
    }

    public void setBuddyNum(String buddyNum) {
        this.buddyNum = buddyNum;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    @ManyToOne(fetch = FetchType.EAGER, cascade = ALL)
    public AddressBook getAddressBook() {
        return addressBook;
    }

    public void setAddressBook(AddressBook addressBook) {
        this.addressBook = addressBook;
    }

    @Override
    public String toString() {
        return buddyName + " " + buddyNum;
    }


}
