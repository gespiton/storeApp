package store.business.services;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import store.business.mappers.ItemMapper;
import store.business.models.Item;

import java.util.List;


/**
 * Created by 周鸿清 on 31/3/2017.
 */
@Service
@Transactional(readOnly = true)
public class ItemService {


//    public Item getItem(long id) {
//        return itemMapper.getItemById(id);
//    }
//
//    @Transactional(readOnly = false)
//    public void addNewItem(Item item) {
//        itemDao.save(item);
//    }

    public Item getItemById(@Param("id") long id) {
        return itemMapper.getItemById(id);
    }

    public List<Item> getAll() {
        return itemMapper.getAll();
    }

    // for test
    public boolean addItem(Item item) {
        boolean b = itemMapper.savaItem(item.getName(), item.getSerialCode());
        return b;
    }

    @Autowired
    private ItemMapper itemMapper;
}
