package store.business.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Iterator;

/**
 * Created by sher on 31/3/2017.
 */
@Entity
@Table(name = "items")
public class Item implements Serializable {

    public static final long serialVersionUID = 131420;

    private Long id;
    private String name;
//    private String code;
//    private String weight;
//    private String onsaleNumber;
//    private String preSaleNumber;
//    private String ownerShop;
//    private String introducedPrice;
//    private String marketPrice;
//    private String bankPrice;
//    private int credit;
//    private Date onMarketTime;
//    private Date outMarketTime;
//    private String description;
//    private Date addedTime;
//    private Date lastModifiedTime;
//    private boolean isDividable;

    public Item() {
        this.id = (long) 222;
    }

    public Item(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "itemName", length = 100)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
//    image
//    brand

    @Override
    public String toString() {
        return id + " " + name;
    }
//    catagory
}
