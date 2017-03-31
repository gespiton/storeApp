package store.business.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import store.business.DAOs.IItemDao;
import store.business.DAOs.ItemDaoImpl;
import store.business.models.Item;


/**
 * Created by sher on 31/3/2017.
 */
@Service
@Transactional(readOnly = true)
public class ItemService {
    @Autowired
    ItemDaoImpl itemDao;

    public Item getItem(long id) {
        return itemDao.findById(id);
    }

    @Transactional(readOnly = false)
    public void addNewItem(Item item) {
        itemDao.save(item);
    }
}
