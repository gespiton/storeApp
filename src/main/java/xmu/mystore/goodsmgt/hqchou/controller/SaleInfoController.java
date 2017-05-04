package xmu.mystore.goodsmgt.hqchou.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import xmu.mystore.goodsmgt.hqchou.model.Goods;
import xmu.mystore.goodsmgt.hqchou.model.Stand;
import xmu.mystore.goodsmgt.hqchou.service.GoodsService;
import xmu.mystore.goodsmgt.hqchou.service.SaleService;

import java.util.List;

/**
 * Created by sher on 4/5/2017.
 */
@Controller
public class SaleInfoController {
    @Autowired
    SaleService saleService;
    @Autowired
    GoodsService goodsService;

    @RequestMapping(value = "/saleInfo/{goodsID}", method = RequestMethod.GET)
    public String saleInfoPage(@ModelAttribute("model") ModelMap model, @PathVariable Long goodsID) {
        Stand buf = saleService.getStandByGoodsId(goodsID);
        model.addAttribute("saleInfo", buf);
        return "saleInfo";
    }

    @RequestMapping(value = "/saleInfo/save/{saleInfoId}", method = RequestMethod.POST)
    public String saveChange(Stand stand) {
        Goods goods = goodsService.getItemById(stand.getGoodsID());
        fillStand(stand, goods);
        if (saleService.exist(goods.getId()))
            saleService.update(stand);
        else {
            saleService.insert(stand);
            Stand buf = saleService.getStandByGoodsId(goods.getId());
            goods.setStandId(saleService.getStandByGoodsId(goods.getId()).getId());
            goodsService.updateItem(goods);
        }
        return "redirect:/saleInfo";
    }

    @RequestMapping(value = "/saleInfo", method = RequestMethod.GET)
    public String allSailingInfo(@ModelAttribute("model") ModelMap model) {
        List<Stand> stands = saleService.getAllStand();
        model.addAttribute("standList", stands);
        stands.forEach(
                stand -> stand.setGoods(goodsService.getItemById(stand.getGoodsID()))
        );

        return "allSaleInfo";
    }

    private void fillStand(Stand stand, Goods goods) {
        stand.setMarketPrice(goods.getMarketPrice());
        stand.setMidUserPrice(goods.getMidUserPrice());
        stand.setRealPrice(goods.getRealPrice());
    }
}
