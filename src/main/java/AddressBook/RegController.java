package AddressBook;

import AddressBook.Model.AddressBook;
import AddressBook.Model.AddressBookRepo;
import AddressBook.Model.BuddyInfo;
import AddressBook.Model.BuddyInfoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin(origins = "http://localhost:8101")
public class RegController {

    long id;
    @Autowired
    private AddressBookRepo addressBookRepo;
    @Autowired
    private BuddyInfoRepo buddyInfoRepo;

    @GetMapping("/init")
    public String landPage(Model model) {
        model.addAttribute("addressBook", new AddressBook());
        return "init";
    }
    @PostMapping("/init")
    @ResponseBody
    public AddressBook addBook(@ModelAttribute AddressBook addressBook, Model model) {
        id = addressBook.getID();
        addressBookRepo.save(addressBook);
        model.addAttribute("addressBook", addressBook);
        return addressBook;
    }

    @GetMapping("/addBuddy")
    public String requestBuddies(Model model) {
        model.addAttribute("buddyInfo", new BuddyInfo());
        return "addBuddy";
    }

    @PostMapping("/addBuddy")
    public String addBuddy(@ModelAttribute BuddyInfo buddyInfo, Model model) {
        AddressBook refBook = addressBookRepo.findById(id);
        refBook.addBuddy(buddyInfo);
        model.addAttribute("addressBook", refBook);
        buddyInfoRepo.save(buddyInfo);
        addressBookRepo.save(refBook);

        return "result";
    }
}
