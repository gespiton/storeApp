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
import store.business.models.ComposedCategory;
import store.business.models.Item;
import store.business.services.CategoryService;
import store.business.services.ItemService;

import java.util.List;
import java.util.Locale;

@Controller
public class AddItemController {
    @Autowired
    ItemService itemService;

    @Autowired
    CategoryService categoryService;

    @RequestMapping(value = "/", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public String home(Locale locale, Model model) {
        return "redirect:/addItem";
    }

    @RequestMapping(value = "/addItem", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public String init(@ModelAttribute("model") ModelMap model) {
        //TODO transfer this, for test here
        model.addAttribute("itemList", itemService.getAll());
        System.out.println(categoryService.getNameById((long) 1));
        List<ComposedCategory> c = categoryService.getDisplayedCategory();
        model.addAttribute("composedCategoryList", categoryService.getDisplayedCategory());
        return "addItem";

    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public String addItem(@ModelAttribute("Item") Item item) {
        System.out.println(item == null);
        itemService.addItem(item);
        return "redirect:/addItem";
    }
}
