package xmu.mystore.goodsmgt.hqchou.mappers;

import xmu.mystore.goodsmgt.hqchou.model.Goods;

import java.util.List;

//@Mapper
public interface GoodsMapper {
    //    @Select("select * from items where id = #{id}")
    Goods getItemById(long id);

    //    @Select("select * from items")
    List<Goods> getAll();

    //    @Select("select * from items where serialCode=#{serial}")
    Goods getItemBySerial(String serial);

//    @Select("SELECT count(*) FROM items;")
//    int countItems();

    //for test only
    boolean saveItem(Goods i);

    boolean updateItem(Goods goods);
}
