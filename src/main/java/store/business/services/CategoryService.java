package store.business.services;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import store.business.mappers.CategoryMapper;
import store.business.models.Category;

/**
 * Created by sher on 4/4/2017.
 */
@Service
@Transactional(readOnly = true)
public class CategoryService {

    @Autowired
    private CategoryMapper mapper;

    public Category getCategoryById(@Param("id") Long id) {

        return mapper.getCategoryById(id);
    }

    public String getNameById(@Param("id") Long id) {
        return mapper.getNameById(id);
    }
}
