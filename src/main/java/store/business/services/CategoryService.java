package store.business.services;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import store.business.mappers.CategoryMapper;
import store.business.models.Category;
import store.business.models.ComposedCategory;

import java.util.List;

/**
 * Created by sher on 4/4/2017.
 */
@Service
@Transactional(readOnly = true)
public class CategoryService {

    @Autowired
    private CategoryMapper mapper;

    public List<Category> getAllcategory() {
        return mapper.getAllcategory();
    }

    public Category getCategoryById(Long id) {
        return mapper.getCategoryById(id);
    }

    public String getNameById(Long id) {
        return mapper.getNameById(id);
    }

    public Integer getIdByName(String name) {
        return mapper.getIdByName(name);
    }

    public List<ComposedCategory> getDisplayedCategory() {
        // todo optimize here
        return ComposedCategory.buildComposedCategorysFromCategorys(getAllcategory());
    }
}
