package AddressBook;

import AddressBook.Model.AddressBook;
import AddressBook.Model.AddressBookRepo;
import AddressBook.Model.BuddyInfo;
import AddressBook.Model.BuddyInfoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
@CrossOrigin
public class RestHandlingController {

    @Autowired
    private AddressBookRepo addressBookRepo;

    @Autowired
    private BuddyInfoRepo buddyInfoRepo;

    @GetMapping("/getRestAB")
    public AddressBook getAddressBook(@RequestParam(value = "id") long id) {
        return addressBookRepo.findById(id);
    }

    @PostMapping("/addRestAB")
    public AddressBook addAddressBook() {
        AddressBook newAB = new AddressBook();
        addressBookRepo.save(newAB);
        return newAB;
    }

    @GetMapping("getRestBuddy")
    public BuddyInfo getBuddy(@RequestParam(value = "id") long id) {
        return buddyInfoRepo.findByID(id);
    }

    @PostMapping("addRestBuddy")
    public BuddyInfo addBuddy(@RequestParam(value = "id") long id, @RequestParam(value = "name") String name, @RequestParam(value = "number") String number) {
        BuddyInfo buddyToStore = new BuddyInfo(name, number);
        buddyInfoRepo.save(buddyToStore);
        AddressBook pulledAB = addressBookRepo.findById(id);
        pulledAB.addBuddy(buddyToStore);
        addressBookRepo.save(pulledAB);
        return buddyToStore;
    }
}
