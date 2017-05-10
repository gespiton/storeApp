package xmu.mystore.goodsmgt.hqchou.service;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xmu.mystore.goodsmgt.hqchou.mappers.GoodsMapper;
import xmu.mystore.goodsmgt.hqchou.model.Goods;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by 周鸿清 on 31/3/2017.
 */
@Service
@Transactional(readOnly = true)
public class GoodsService {


    //    public Goods getItem(long id) {
//        return goodsMapper.getItemById(id);
//    }
//
//    @Transactional(readOnly = false)
//    public void addNewItem(Goods item) {
//        itemDao.save(item);
//    }
    @Autowired
    private GoodsMapper goodsMapper;

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    public Goods getItemById(long id) {
        return goodsMapper.getItemById(id);
    }

    public Goods getItemBySerial(String serial) {
        return goodsMapper.getItemBySerial(serial);
    }

    public List<Goods> getGoodsByName(String name) {
        return goodsMapper.getGoodsByName(name);
    }

    public List<Goods> getAll() {
        return goodsMapper.getAll();
    }

    //    @Transactional(readOnly = false)
    public boolean addItem(Goods goods) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            GoodsMapper mapper = session.getMapper(GoodsMapper.class);
            return mapper.saveItem(goods);
        }
    }

    public boolean updateItem(Goods goods) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            GoodsMapper mapper = session.getMapper(GoodsMapper.class);
            return mapper.updateItem(goods);
        }
    }

    public List<Goods> getGoodsBy(String no, String size, String brandID_regex, String categoryID_regex) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            GoodsMapper mapper = session.getMapper(GoodsMapper.class);
            Map<String, String> map = new HashMap<>();
            map.put("no", no);
            map.put("size", size);
            map.put("brandId", brandID_regex);
            map.put("categoryId", categoryID_regex);

            return mapper.getGoodsBy(map);
        }
    }
}
