package store.business.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import store.business.mappers.ItemMapper;
import store.business.models.Item;


/**
 * Created by 周鸿清 on 31/3/2017.
 */
@Service
@Transactional(readOnly = true)
public class ItemService {


    public Item getItem(long id) {
        return itemMapper.getItemById(id);
    }
//
//    @Transactional(readOnly = false)
//    public void addNewItem(Item item) {
//        itemDao.save(item);
//    }

    @Autowired
    private ItemMapper itemMapper;
}
