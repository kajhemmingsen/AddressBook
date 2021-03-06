package AddressBook.Model;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "addressBooks", path = "displayAddressBook")
public interface AddressBookRepo extends PagingAndSortingRepository<AddressBook ,Long> {
   public AddressBook  findById(long id);
}
