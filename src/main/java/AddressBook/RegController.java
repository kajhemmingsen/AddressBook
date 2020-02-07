package AddressBook;

import AddressBook.Model.AddressBook;
import AddressBook.Model.AddressBookRepo;
import AddressBook.Model.BuddyInfo;
import AddressBook.Model.BuddyInfoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegController {

    long id =  1L;
    @Autowired
    private AddressBookRepo addressBookRepo;
    @Autowired
    private BuddyInfoRepo buddyInfoRepo;

    @GetMapping("/init")
    public String welcomePage() {
        AddressBook ab = new AddressBook();
        addressBookRepo.save(ab);
        return "init";
    }

    @GetMapping("/addBuddy")
    public String requestBuddies(Model model) {
        model.addAttribute("buddyInfo", new BuddyInfo());
        return "addBuddy";
    }

    @PostMapping("/addBuddy")
    public String addbuddy(@ModelAttribute BuddyInfo buddyInfo, Model model) {
        AddressBook refBook = addressBookRepo.findById(id);
        BuddyInfo newBuddy = buddyInfo;
        buddyInfoRepo.save(newBuddy);
        refBook.addBuddy(buddyInfo);
        model.addAttribute("ActiveBook", refBook);
        addressBookRepo.save(refBook);
        return "result";
    }

    @GetMapping("/result")
    public String displayAddressBook(@RequestParam(value = "id") long id, Model model) {
        AddressBook refBook = addressBookRepo.findById(id);
        model.addAttribute("addressBook", refBook);
        return "result";
    }

}
