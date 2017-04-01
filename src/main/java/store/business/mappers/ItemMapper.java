package store.business.mappers;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import store.business.models.Item;
public interface ItemMapper {
    @Select("select * from items where id = #{id}")
    public Item getItemById(@Param("id") long id);
}
