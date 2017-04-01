package store.web.controllers;
/**
 * Created by 周鸿清 on 28/2/2017.
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import store.business.models.Item;
import store.business.services.ItemService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

//import org.springframework.web.portlet.ModelAndView;

@Controller
public class HelloStoreController {
    @Autowired
    ItemService itemService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Locale locale, Model model) {
        return "redirect:/cars";
    }

    @RequestMapping(value = "/cars", method = RequestMethod.GET)
    public String init(@ModelAttribute("model") ModelMap model) {
        Item i = itemService.getItem(11);
        System.out.println(i.getName());
        model.addAttribute("carList", Arrays.asList(i));

        return "hello";
    }

//    @RequestMapping(value = "/add", method = RequestMethod.POST)
}
