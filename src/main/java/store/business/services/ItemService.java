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
    @Autowired
    private ItemMapper itemMapper;

    public Item getItemById(long id) {
        return itemMapper.getItemById(id);
    }

    public Item getItemBySerial(String serial) {
        return itemMapper.getItemBySerial(serial);
    }

    public List<Item> getAll() {
        return itemMapper.getAll();
    }

    // for test
    public String addItem(Item item) {
        String message = "";
        try {
            boolean b = itemMapper.savaItem(item.getName(), item.getSerialCode(), item.getWeight(), item.getStockNumber(), item.getPreSaleNumber(), item.getShop(), item.getIntroducedPrice(), item.getMarketPrice(), item.getBankPrice(), item.getExchangeCredit(), item.getCategoryName(), item.getBrandName(), item.getOnMarketTime(), item.getOutMarketTime(), item.getAddedTime(), item.getLastModifiedTime(), item.getDescription(), item.getImagePath(), item.getDividable(), item.getDefaultExpress());
        } catch (Exception ignored) {
            message = ignored.getMessage();
            throw ignored;
        }
        return message;// when message is not "", meaning something happened
    }


}
