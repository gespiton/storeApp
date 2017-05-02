package xmu.mystore.goodsmgt.hqchou.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import xmu.mystore.goodsmgt.hqchou.model.Category;
import xmu.mystore.goodsmgt.hqchou.service.CategoryService;

/**
 * Created by sher on 24/4/2017.
 */
@Controller
public class CategoryManaegController {
    @Autowired
    CategoryService categoryService;

    @RequestMapping(value = "/viewCategory", method = RequestMethod.GET)
    public String viewCategory(@ModelAttribute("model") ModelMap model) {
        model.addAttribute("categoryList", categoryService.getAllcategory());
        model.addAttribute("composedCategoryList", categoryService.getDisplayedCategory());
        return "category";
    }

    @ResponseBody
    @RequestMapping(value = "/updateCategory", method = RequestMethod.POST)
    public String updateCategory(Category category) {
        if (categoryService.updateCategory(category))
            return "update success";
        else
            return "update fail";
    }
}

