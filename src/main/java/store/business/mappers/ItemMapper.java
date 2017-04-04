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

    @Select("SELECT count(*) FROM items;")
    int countItems();

    //for test only
    @Insert("INSERT INTO items (name, serialCode) VALUES ( #{name}, #{serial})")
    boolean savaItem(@Param("name") String name, @Param("serial") long serial);
}
