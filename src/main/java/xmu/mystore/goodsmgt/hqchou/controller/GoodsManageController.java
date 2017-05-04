package xmu.mystore.goodsmgt.hqchou.controller;
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
import xmu.mystore.goodsmgt.hqchou.model.Goods;
import xmu.mystore.goodsmgt.hqchou.service.CategoryService;
import xmu.mystore.goodsmgt.hqchou.service.GoodsService;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Locale;
import java.util.Objects;

@Controller
public class GoodsManageController {
    @Autowired
    GoodsService goodsService;

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
        Goods goods = goodsService.getItemBySerial(serial);
        if (goods != null) {
            model.addAttribute("goods", goods);
            model.addAttribute("composedCategoryList", categoryService.getDisplayedCategory());
            model.addAttribute("action", "update");
        } else {
            return "redirect:/viewAllItems";
        }
        return "editItem";
    }

    @RequestMapping(value = "/viewAllItems", method = RequestMethod.GET)
    public String viewAllItems(@ModelAttribute("model") ModelMap model) {
        model.addAttribute("itemList", goodsService.getAll());
        model.addAttribute("appName", app);
        return "viewAllItems";
    }

    private boolean verifyItem(Goods goods) {
        // todo add default value for field
        // todo verification

        // todo default values,
//        String timeStamp = new SimpleDateFormat("yyyyMMdd:HH:mm:ss").format(Calendar.getInstance().getTime());
        if (Objects.equals(goods.getName(), ""))
            goods.setName("test goods");
        if (goods.getStoreId() == null)
            goods.setStoreId(0);
        if (goods.getBrandId() == null)
            goods.setBrandId(0);
//        String currentMills = String.valueOf(System.currentTimeMillis());
//        goods.setAddTime(currentMills);
//        goods.setLastModifiedTime(currentMills);
//        goods.setOnMarketTime(currentMills);
//        goods.setOutMarketTime(currentMills);
        if (goods.getCategoryId() == null)
            goods.setCategoryId(0);
        if (goods.getMarketPrice() == null)
            goods.setMarketPrice(11.0);
        if (goods.getRealPrice() == null)
            goods.setRealPrice(10.0);
        if (goods.getWeight() == null)
            goods.setWeight(1.0);
        if (goods.getStockNumber() == null)
            goods.setStockNumber(0);
        if (goods.getMidUserPrice() == null)
            goods.setMidUserPrice(11.0);
        if (goods.getPreSaleNumber() == null)
            goods.setPreSaleNumber(0);
        if (goods.getRedeemPoint() == null)
            goods.setRedeemPoint(0);
//        if (goods.getStandId() == null)
//            goods.setStandId(0);
        goods.setAddTime("");
        goods.setLastModifiedTime("");
        goods.setDescription("Donec rutrum congue leo eget malesuada. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Donec velit neque, auctor sit amet aliquam vel, ullamcorper sit amet ligula. Cras ultricies ligula sed magna dictum porta. Sed porttitor lectus nibh. Praesent sapien massa, convallis a pellentesque nec, egestas non nisi. Cras ultricies ligula sed magna dictum porta. Curabitur arcu erat, accumsan id imperdiet et, porttitor at sem. Nulla porttitor accumsan tincidunt. Cras ultricies ligula sed magna dictum porta. Nulla quis lorem ut libero malesuada feugiat.");
        goods.setDividable(goods.getDividable() != null);
        if (goods.getImagePath() == null) {
            goods.setImagePath("0.jpg");
        }
        return true;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addItem(Goods goods, @RequestParam("image") MultipartFile image) {
        saveImage(goods.getSerialCode(), image, goods);
        //todo check default goods.imageNumber
        if (verifyItem(goods)) {
            Boolean state = goodsService.addItem(goods);
//            if (!state.equals("")) {
//                System.out.println(state);
//            }
        }
        return "redirect:/viewAllItems";
    }

    @RequestMapping(value = "editItem/{id}", method = RequestMethod.POST)
    public String updateItem(Goods goods, @RequestParam("image") MultipartFile image) {
        saveImage(goods.getSerialCode(), image, goods);
        //todo check default goods.imageNumber
        Boolean state = goodsService.updateItem(goods);
        return "redirect:/viewAllItems";
    }

    private void saveImage(String serial, MultipartFile file, Goods goods) {
        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();
                // Creating the directory to xmu.mystore file
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

                goods.setImagePath(serial + "." + file.getContentType().substring(file.getContentType().indexOf('/') + 1));
                System.out.println("You successfully uploaded file=" + file.getOriginalFilename());
            } catch (Exception e) {
                System.out.println("error");
            }
        }
    }
}
