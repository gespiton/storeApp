package xmu.mystore.goodsmgt.hqchou.service;

import xmu.mystore.goodsmgt.hqchou.model.Brand;
import xmu.mystore.goodsmgt.hqchou.model.Category;
import xmu.mystore.goodsmgt.hqchou.model.Goods;
import xmu.mystore.goodsmgt.hqchou.model.Stand;

import java.util.List;

/**
 * Created by sher on 4/5/2017.
 */
public interface IGoodsMapper {
    Goods getGoodsByGoodsCode(String serialCode);

    List<Goods> getGoodsByGoodsName(String name);

    List<Goods> getGoodsBy(List<String> param);

    List<Category> getCategoryList();

    List<Brand> getBrandList();

    Stand getGoodsPrice(Long goodsID);

}
