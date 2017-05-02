package xmu.mystore.goodsmgt.hqchou.service;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xmu.mystore.goodsmgt.hqchou.mappers.CategoryMapper;
import xmu.mystore.goodsmgt.hqchou.model.Category;
import xmu.mystore.goodsmgt.hqchou.model.CompositeCategory;

import java.util.List;

/**
 * Created by sher on 4/4/2017.
 */
@Service
@Transactional(readOnly = true)
public class CategoryService {

    @Autowired
    private SqlSessionFactory sqlSessionFactory;


    public List<Category> getAllcategory() {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            CategoryMapper mapper = session.getMapper(CategoryMapper.class);
            return mapper.getAllcategory();
        }
    }

    public Category getCategoryById(Long id) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            CategoryMapper mapper = session.getMapper(CategoryMapper.class);
            return mapper.getCategoryById(id);
        }
    }

    public String getNameById(Long id) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            CategoryMapper mapper = session.getMapper(CategoryMapper.class);
            return mapper.getNameById(id);
        }
    }

    public Long getIdByName(String name) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            CategoryMapper mapper = session.getMapper(CategoryMapper.class);
            return mapper.getIdByName(name);
        }
    }

    public List<CompositeCategory> getDisplayedCategory() {
        // todo optimize here
        return CompositeCategory.buildComposedCategorysFromCategorys(getAllcategory());
    }

    public boolean updateCategory(Category category) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            category.setUpperCategoryId(getIdByName(category.getUpperCategoryName()));
            CategoryMapper mapper = session.getMapper(CategoryMapper.class);
            return mapper.updateCategory(category);
        }
    }
}
