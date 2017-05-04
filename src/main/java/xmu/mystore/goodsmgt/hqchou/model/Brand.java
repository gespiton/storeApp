package xmu.mystore.goodsmgt.hqchou.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sher on 4/5/2017.
 */
public class Brand implements Serializable {
    Long id;
    String name;
    String website;
    String description;
    Integer type;

    public Brand() {
    }

    public Brand(Long id, String name, String website, String description, Integer type) {
        this.id = id;
        this.name = name;
        this.website = website;
        this.description = description;
        this.type = type;
    }

    public static List<Brand> getMockBrandList() {
        List<Brand> brands = new ArrayList<>();
        brands.add(new Brand((long) 1, "one", "www", "hi", 1));
        brands.add(new Brand((long) 1, "two", "www", "hi", 1));
        brands.add(new Brand((long) 1, "three", "www", "hi", 1));
        brands.add(new Brand((long) 1, "four", "www", "hi", 1));
        return brands;
    }
}
