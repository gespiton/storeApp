package Application;

/**
 * Created by sher on 28/2/2017.
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.portlet.ModelAndView;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloStore {

    @RequestMapping("/")
    public ModelAndView helloWorld() {
        String message = "<br><div style='text-align:center;'>"
                + "<h3>********** Hello World **********</div><br><br>";
        return new ModelAndView("hello", "message", message);
    }
}
