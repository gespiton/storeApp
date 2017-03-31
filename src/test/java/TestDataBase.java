import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import store.business.DAOs.IItemDao;
import store.business.DAOs.ItemDaoImpl;
import store.business.models.Item;
import store.business.services.ItemService;
import store.config.RootConfig;
import store.config.StoreInitializer;
import store.business.DAOs.*;
import store.config.WebConfig;

import java.io.File;


/**
 * Created by sher on 31/3/2017.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RootConfig.class)
public class TestDataBase {

//    @Autowired
//    private SessionFactory sessionFactory;

    @Test
    public void dataAccess() {
//        System.out.println("Working Directory = " + System.getProperty("java.class.path"));

        AnnotationConfigApplicationContext conext = new AnnotationConfigApplicationContext(RootConfig.class);
        ItemService service = conext.getBean(ItemService.class);

//        System.out.println(conext.containsBean("tilesConfigurer"));

//        IItemDao dao = new ItemDaoImpl(sessionFactory);
//        dao.save(new Item((long) 34));
//        System.out.println(dao.findById(34));
    }
}
