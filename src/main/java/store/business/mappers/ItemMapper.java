package store.business.mappers;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import store.business.models.Item;

import java.util.List;

@Mapper
public interface ItemMapper {
    @Select("select * from items where id = #{id}")
    Item getItemById(@Param("id") long id);

    @Select("select * from items")
    List<Item> getAll();

    @Select("select * from items where serialCode=#{serial}")
    Item getItemBySerial(@Param("serial") String serial);

    @Select("SELECT count(*) FROM items;")
    int countItems();

    //for test only
    @Insert("INSERT INTO items (name,serialCode,weight,stockNumber,preSaleNumber,shop,introducedPrice,marketPrice,bankPrice,exchangeCredit,categoryName,brandName,onMarketTime,outMarketTime,addedTime,lastModifiedTime,description,imagePath,isDividable,defaultExpress)VALUES (#{name},#{serialCode},#{weight},#{stockNumber},#{preSaleNumber},#{shop},#{introducedPrice},#{marketPrice},#{bankPrice},#{exchangeCredit},#{categoryName},#{brandName},#{onMarketTime},#{outMarketTime},#{addedTime},#{lastModifiedTime},#{description},#{imagePath},#{isDividable},#{defaultExpress})")
    boolean savaItem(@Param("name") String name, @Param("serialCode") String serialCode, @Param("weight") Double weight, @Param("stockNumber") Integer stockNumber, @Param("preSaleNumber") Integer preSaleNumber, @Param("shop") String shop, @Param("introducedPrice") Double introducedPrice, @Param("marketPrice") Double marketPrice, @Param("bankPrice") Double bankPrice, @Param("exchangeCredit") Integer exchangeCredit, @Param("categoryName") String categoryName, @Param("brandName") String brandName, @Param("onMarketTime") String onMarketTime, @Param("outMarketTime") String outMarketTime, @Param("addedTime") String addedTime, @Param("lastModifiedTime") String lastModifiedTime, @Param("description") String description, @Param("imagePath") String imagePath, @Param("isDividable") Boolean isDividable, @Param("defaultExpress") String defaultExpress);
}
