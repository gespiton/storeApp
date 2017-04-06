package store.web.controllers;
/**
 * Created by 周鸿清 on 28/2/2017.
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import store.business.models.Item;
import store.business.services.CategoryService;
import store.business.services.ItemService;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Locale;

@Controller
public class ItemManageController {
    @Autowired
    ItemService itemService;

    @Autowired
    CategoryService categoryService;

    @Value("${appName}")
    private String app;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Locale locale, Model model) {
        return "redirect:/viewAllItems";
    }

    @RequestMapping(value = "/addItem", method = RequestMethod.GET)
    public String addItem(@ModelAttribute("model") ModelMap model) {
        //TODO transfer this, for test here
        model.addAttribute("composedCategoryList", categoryService.getDisplayedCategory());
        model.addAttribute("action", "add");
        return "addItem";
    }

    @RequestMapping(value = "/editItem/{serial}", method = RequestMethod.GET)
    public String editItem(@ModelAttribute("model") ModelMap model, @PathVariable String serial) {
        System.out.println(serial);
        Item item = itemService.getItemBySerial(serial);
        if (item != null) {
//            model.addAttribute("item", item);
            model.addAttribute("composedCategoryList", categoryService.getDisplayedCategory());
            model.addAttribute("action", "update");
        } else {
            return "redirect:/viewAllItems";
        }
        return "editItem";
    }

    @RequestMapping(value = "/viewAllItems", method = RequestMethod.GET)
    public String viewAllItems(@ModelAttribute("model") ModelMap model) {
        model.addAttribute("itemList", itemService.getAll());
        model.addAttribute("appName", app);
        return "viewAllItems";
    }

    private boolean verifyItem(Item item) {
        // todo add default value for field
        // todo verification

        // todo default values,
//        String timeStamp = new SimpleDateFormat("yyyyMMdd:HH:mm:ss").format(Calendar.getInstance().getTime());
        if (item.getName() != null)
            item.setName("test item");
        item.setWeight(10.0);
        item.setStockNumber(100);
        item.setPreSaleNumber(100);
        item.setShop("system manager");
        item.setIntroducedPrice(100.0);
        item.setBankPrice(100.11);
        item.setMarketPrice(120.0);
        item.setBrandName("hqchou");
        String currentMills = String.valueOf(System.currentTimeMillis());
        item.setAddedTime(currentMills);
        item.setLastModifiedTime(currentMills);
        item.setOnMarketTime(currentMills);
        item.setOutMarketTime(currentMills);
        item.setCategoryName("food");
        item.setDescription("Donec rutrum congue leo eget malesuada. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Donec velit neque, auctor sit amet aliquam vel, ullamcorper sit amet ligula. Cras ultricies ligula sed magna dictum porta. Sed porttitor lectus nibh. Praesent sapien massa, convallis a pellentesque nec, egestas non nisi. Cras ultricies ligula sed magna dictum porta. Curabitur arcu erat, accumsan id imperdiet et, porttitor at sem. Nulla porttitor accumsan tincidunt. Cras ultricies ligula sed magna dictum porta. Nulla quis lorem ut libero malesuada feugiat.");
        if (item.getImagePath() == null) {
            item.setImagePath("0.jpg");
        }
        return true;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addItem(@ModelAttribute("Item") Item item, @RequestParam("image") MultipartFile image) {
        saveImageTo(item.getSerialCode(), image, item);
        //todo check default item.imageNumber
        if (verifyItem(item)) {
            String state = itemService.addItem(item);
            if (!state.equals("")) {
                System.out.println(state);
            }
        }
        return "redirect:/addItem";
    }


    private void saveImageTo(String serial, MultipartFile file, Item item) {
        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();
                // Creating the directory to store file
                String rootPath = System.getProperty("catalina.home");
                File dir = new File(rootPath + File.separator + "tempFiles");

                if (!dir.exists())
                    dir.mkdirs();

                // Create the file on server
                File serverFile = new File(dir.getAbsolutePath()
                        + File.separator + serial + "." + file.getContentType().substring(file.getContentType().indexOf('/') + 1));
                BufferedOutputStream stream = new BufferedOutputStream(
                        new FileOutputStream(serverFile));
                stream.write(bytes);
                stream.close();

                item.setImagePath(serial + "." + file.getContentType().substring(file.getContentType().indexOf('/') + 1));
                System.out.println("You successfully uploaded file=" + file.getOriginalFilename());
            } catch (Exception e) {
                System.out.println("error");
            }
        }
    }
}
