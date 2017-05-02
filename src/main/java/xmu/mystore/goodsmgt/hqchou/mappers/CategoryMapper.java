package xmu.mystore.goodsmgt.hqchou.mappers;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import xmu.mystore.goodsmgt.hqchou.model.Category;

import java.util.List;

/**
 * Created by 周鸿清 on 4/4/2017.
 */
public interface CategoryMapper {
    //    @Select("SELECT * FROM category")
    List<Category> getAllcategory();

    //    @Select("SELECT * FROM category WHERE id = #{id}")
    Category getCategoryById(@Param("id") Long id);

    String getNameById(Long id);

    @Select("SELECT id FROM category WHERE name=#{name}")
    Long getIdByName(@Param("name") String name);

    boolean updateCategory(Category category);
}
