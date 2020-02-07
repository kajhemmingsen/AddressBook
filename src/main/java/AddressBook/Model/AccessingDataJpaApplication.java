//package AddressBook.Model;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.Bean;
//
//@SpringBootApplication
//public class AccessingDataJpaApplication {
//
//    private static final Logger log = LoggerFactory.getLogger(AccessingDataJpaApplication.class);
//
//    public static void main(String[] args) {
//        SpringApplication.run(AccessingDataJpaApplication.class, args);
//    }
//
//    @Bean
//    public CommandLineRunner demo(AddressBookRepo repository) {
//        return (args) -> {
//            // save a few customers
//            AddressBook testBook = new AddressBook();
//            BuddyInfo buddy1 = new BuddyInfo("Jack", "120798312");
//            BuddyInfo buddy2 = new BuddyInfo("Chloe", "1231728");
//
//            testBook.addBuddy(buddy1);
//            testBook.addBuddy(buddy2);
//            repository.save(testBook);
//            /*
//            repository.save(new BuddyInfo("Jack", "120798312"));
//            repository.save(new BuddyInfo("Chloe", "1231728"));
//            repository.save(new BuddyInfo("Kim", "12361238271"));
//            repository.save(new BuddyInfo("David", "136798312"));
//            repository.save(new BuddyInfo("Michelle", "1283686"));
//*/
//            // fetch all customers
//            log.info("Customers found with findAll():");
//            log.info("-------------------------------");
//            for (AddressBook ab : repository.findAll()) {
//                log.info(ab.toString());
//            }
//            log.info("");
//
//            // fetch an individual customer by ID
//            AddressBook ab1 = repository.findById(1L);
//            log.info("Customer found with findById(1L):");
//            log.info("--------------------------------");
//            log.info(ab1.toString());
//            log.info("");
//
//            // fetch customers by last name
//            //log.info("Customer found with findByName('Jack'):");
//            //log.info("--------------------------------------------");
//            //repository.findByName("Jack").forEach(jack -> {
//              //  log.info(jack.toString());
//            //});
//            // for (Customer bauer : repository.findByLastName("Bauer")) {
//            //  log.info(bauer.toString());
//            // }
//            log.info("");
//        };
//    }
//}
