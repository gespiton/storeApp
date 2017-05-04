package xmu.mystore.goodsmgt.hqchou.mappers;

import xmu.mystore.goodsmgt.hqchou.model.Stand;

import java.util.List;

/**
 * Created by sher on 4/5/2017.
 */
public interface StandMapper {
    Stand getStandByGoodsId(Long id);

    void insertStand(Stand stand);

    void updateStand(Stand stand);

    List<Stand>  getAllStands();
}
