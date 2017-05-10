package xmu.mystore.goodsmgt.hqchou.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xmu.mystore.goodsmgt.hqchou.model.Brand;
import xmu.mystore.goodsmgt.hqchou.model.Category;
import xmu.mystore.goodsmgt.hqchou.model.Goods;
import xmu.mystore.goodsmgt.hqchou.model.Stand;

import java.util.List;
import java.util.Map;

/**
 * Created by sher on 4/5/2017.
 */
@Service
public class GoodsServiceImpl implements IGoodsService {
    @Autowired
    GoodsService goodsService;
    @Autowired
    CategoryService categoryService;
    @Autowired
    SaleService saleService;
    @Autowired
    BrandService brandService;

    @Override
    public Goods getGoodsByGoodsCode(String serialCode) {
        return goodsService.getItemBySerial(serialCode);
    }

    @Override
    public List<Goods> getGoodsByGoodsName(String name) {
        return goodsService.getGoodsByName(name);
    }

    @Override
    public List<Goods> getGoodsBy(Map<String, String> param) {
        int mode = 0;
//        if (param.containsKey("no") && param.containsKey("size"))
//            mode = 1;

        String brandID_REGEX = ".*";
        String categoryID_REGEX = ".*";

        if (param.containsKey("brand_id")) {
            brandID_REGEX = param.get("brand_id");
        }

        if (param.containsKey("category_id")) {
            categoryID_REGEX = param.get("category_id");
        }

        return goodsService.getGoodsBy(param.get("no"), param.get("size"), brandID_REGEX, categoryID_REGEX);
    }

    @Override
    public List<Category> getCategoryList() {
        return categoryService.getAllcategory();
    }

    @Override
    public List<Brand> getBrandList() {
        return brandService.getAllbrands();
    }

    @Override
    public Stand getGoodsPrice(Long goodsID) {
        return saleService.getStandByGoodsId(goodsID);
    }
}
