package xmu.mystore.goodsmgt.hqchou.service;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xmu.mystore.goodsmgt.hqchou.mappers.GoodsMapper;
import xmu.mystore.goodsmgt.hqchou.model.Goods;

import java.util.List;


/**
 * Created by 周鸿清 on 31/3/2017.
 */
@Service
@Transactional(readOnly = true)
public class ItemService {


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
}
