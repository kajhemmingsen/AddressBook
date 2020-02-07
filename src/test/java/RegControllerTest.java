import AddressBook.RegController;
import AddressBook.ServingWebContentApplication;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = {ServingWebContentApplication.class})
public class RegControllerTest {

   /* @Autowired
    private RegController controller;

    @Test
    public void contexLoad() throws Exception {
        assertThat(controller).isNotNull();
    }*/
}
