package xmu.mystore.goodsmgt.hqchou.controller;

import org.springframework.web.bind.annotation.*;
import xmu.mystore.goodsmgt.hqchou.model.Category;

@RestController
public class AjaxCategoryController {

    @ResponseBody
    @RequestMapping(value = "/supdateCategory")
    public String updateCategory(@RequestBody Category category) {
        return "category";
    }
}
