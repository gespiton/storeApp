import org.junit.*;
import org.springframework.test.web.servlet.MockMvc;
import store.web.controllers.AddItemController;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/**
 * Created by 周鸿清 on 8/3/2017.
 */
public class HelloControllerTest {
    @Test
    public void testHelloPage() throws Exception {
        AddItemController controller = new AddItemController();
        MockMvc mockMvc = standaloneSetup(controller).build();
        mockMvc.perform(get("/")).andExpect(view().name("redirect:/items"));
    }
}
