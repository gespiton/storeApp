package xmu.mystore.goodsmgt.hqchou.service;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xmu.mystore.goodsmgt.hqchou.mappers.GoodsMapper;
import xmu.mystore.goodsmgt.hqchou.mappers.StandMapper;
import xmu.mystore.goodsmgt.hqchou.model.Stand;

import java.util.List;

/**
 * Created by sher on 4/5/2017.
 */
@Service
@Transactional(readOnly = true)
public class SaleService {

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    public Stand getStandByGoodsId(Long id) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            StandMapper mapper = session.getMapper(StandMapper.class);
            Stand stand = mapper.getStandByGoodsId(id);
            if (stand == null)
                return makeDefaultObject(id);
            return stand;
        }
    }

    public boolean exist(Long goodsId) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            StandMapper mapper = session.getMapper(StandMapper.class);
            return mapper.getStandByGoodsId(goodsId) != null;
        }
    }

    public void update(Stand stand) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            StandMapper mapper = session.getMapper(StandMapper.class);
            mapper.updateStand(stand);
        }
    }

    public void insert(Stand stand) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            StandMapper mapper = session.getMapper(StandMapper.class);
            mapper.insertStand(stand);
        }
    }

    public List<Stand> getAllStand() {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            StandMapper mapper = session.getMapper(StandMapper.class);
            return mapper.getAllStands();
        }
    }

    Stand makeDefaultObject(Long goodsID) {
        Stand stand = new Stand();
        stand.setGoodsID(goodsID);
        stand.setOnMarketTime("");
        stand.setOffMarketTime("");
        stand.setPreSaleCount((long) 0);
        return stand;
    }
}
