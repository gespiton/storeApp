import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import xmu.mystore.goodsmgt.hqchou.controller.GoodsManageController;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/**
 * Created by 周鸿清 on 8/3/2017.
 */
public class HelloControllerTest {
    @Test
    public void testHelloPage() throws Exception {
        GoodsManageController controller = new GoodsManageController();
        MockMvc mockMvc = standaloneSetup(controller).build();
        mockMvc.perform(get("/")).andExpect(view().name("redirect:/viewAllItems"));
    }

}
