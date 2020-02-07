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
@RequestMapping("/")
public class RegController {

    long id =  1L;
    @Autowired
    private AddressBookRepo addressBookRepo;
    @Autowired
    private BuddyInfoRepo buddyInfoRepo;

    @GetMapping("/init")
    public String welcomePage(Model model) {
        AddressBook ab = new AddressBook();
        addressBookRepo.save(ab);
        model.addAttribute("ActiveBook", ab);
        return "init";
    }

    @GetMapping("/addBuddy")
    public String requestBuddies(Model model) {
        model.addAttribute("buddyInfo", new BuddyInfo());
        return "addBuddy";
    }

    @PostMapping("/addBuddy")
    public String addbuddy(@ModelAttribute BuddyInfo buddyInfo, Model model) {
        buddyInfoRepo.save(buddyInfo);
        AddressBook refBook = addressBookRepo.findById(id);
        refBook.addBuddy(buddyInfo);
        model.addAttribute("ActiveBook", refBook);
        addressBookRepo.save(refBook);
        return "result";
    }
}
