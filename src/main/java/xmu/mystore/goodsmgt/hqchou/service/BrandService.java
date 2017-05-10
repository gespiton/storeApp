package xmu.mystore.goodsmgt.hqchou.service;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xmu.mystore.goodsmgt.hqchou.mappers.BrandMapper;
import xmu.mystore.goodsmgt.hqchou.model.Brand;

import java.util.List;

/**
 * Created by sher on 10/5/2017.
 */
@Service
@Transactional(readOnly = true)
public class BrandService {
    @Autowired
    private SqlSessionFactory sqlSessionFactory;


    public List<Brand> getAllbrands() {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            BrandMapper mapper = session.getMapper(BrandMapper.class);
            return mapper.getAllBrands();
        }
    }
}
