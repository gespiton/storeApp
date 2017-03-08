package store.web;

/**
 * Created by sher on 28/2/2017.
 */

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//import org.springframework.web.portlet.ModelAndView;

@Controller
@RequestMapping("/")
public class HelloStoreController {

    @RequestMapping(method = RequestMethod.GET)
    public String helloWorld(Model model) {
        return "hello";
    }
}
