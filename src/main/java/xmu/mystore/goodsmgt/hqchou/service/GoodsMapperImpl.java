package xmu.mystore.goodsmgt.hqchou.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xmu.mystore.goodsmgt.hqchou.model.Brand;
import xmu.mystore.goodsmgt.hqchou.model.Category;
import xmu.mystore.goodsmgt.hqchou.model.Goods;
import xmu.mystore.goodsmgt.hqchou.model.Stand;

import java.util.List;

/**
 * Created by sher on 4/5/2017.
 */
@Service
public class GoodsMapperImpl implements IGoodsMapper {
    @Autowired
    GoodsService goodsService;
    @Autowired
    CategoryService categoryService;
    @Autowired
    SaleService saleService;

    @Override
    public Goods getGoodsByGoodsCode(String serialCode) {
        return goodsService.getItemBySerial(serialCode);
    }

    @Override
    public List<Goods> getGoodsByGoodsName(String name) {
        return goodsService.getGoodsByName(name);
    }

    @Override
    public List<Goods> getGoodsBy(List<String> param) {
        return goodsService.getAll();
    }

    @Override
    public List<Category> getCategoryList() {
        return categoryService.getAllcategory();
    }

    @Override
    public List<Brand> getBrandList() {
        return Brand.getMockBrandList();
    }

    @Override
    public Stand getGoodsPrice(Long goodsID) {
        return saleService.getStandByGoodsId(goodsID);
    }
}
