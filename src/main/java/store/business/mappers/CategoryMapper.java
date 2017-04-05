package store.business.mappers;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import store.business.models.Category;

import java.util.List;

/**
 * Created by 周鸿清 on 4/4/2017.
 */
public interface CategoryMapper {
    @Select("SELECT * FROM category")
    List<Category> getAllcategory();

    @Select("SELECT * FROM category WHERE id = #{id}")
    Category getCategoryById(@Param("id") Long id);

    @Select("SELECT name from category where id = #{id}")
    String getNameById(@Param("id") Long id);

    @Select("SELECT id FROM category WHERE name=#{name}")
    Integer getIdByName(@Param("name") String name);
}
