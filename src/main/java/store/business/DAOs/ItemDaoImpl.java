package store.business.DAOs;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import store.business.models.Item;

import java.io.Serializable;

/**
 * Created by sher on 31/3/2017.
 */
@Repository
public class ItemDaoImpl implements IItemDao {

    private final SessionFactory sessionFactory;

    @Autowired
    public ItemDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session getSession() {
        System.out.println(sessionFactory == null);
        return this.sessionFactory.getCurrentSession();
    }


    @Override
    public Serializable save(Item item) {
        return getSession().save(item);
    }

    @Override
    public Item findById(Serializable id) {
        return getSession().get(Item.class, id);
    }
}
