package store.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by sher on 9/3/2017.
 */
@Controller
@RequestMapping("/weixin")
public class WeixinConnectorController {
    @RequestMapping(method = RequestMethod.GET)
    public String helloWorld(Model model) {
        System.out.println("in");
        return "helloya";
    }
}
