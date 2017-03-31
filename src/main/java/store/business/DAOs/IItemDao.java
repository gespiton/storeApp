package store.business.DAOs;

import org.springframework.stereotype.Repository;
import store.business.models.Item;

import java.io.Serializable;

/**
 * Created by sher on 31/3/2017.
 */
@Repository
public interface IItemDao {
    Serializable save(Item item);
    Item findById(Serializable id);
}
