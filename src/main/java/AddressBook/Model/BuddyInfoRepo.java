package AddressBook.Model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "buddies", path = "displayBuddies")
public interface BuddyInfoRepo extends CrudRepository<BuddyInfo,Long> {

    List<BuddyInfo> findByBuddyName(String name);

    BuddyInfo findByID(long id);
}
