package store.business.models;

import java.io.Serializable;

/**
 * Created by 周鸿清 on 4/4/2017.
 */
public class Category implements Serializable {
    public static final long serialVersionUID = 13142020;
    private Long id;
    private String name;
    private Long upperCategoryId;
    private Integer rank;

    Category(Category category) {
        id = category.id;
        name = category.name;
        upperCategoryId = category.upperCategoryId;
        rank = category.rank;
    }

    Category(Long id, String name, Long upperCategoryId, Integer rank) {
        this.id = id;
        this.name = name;
        this.upperCategoryId = upperCategoryId;
        this.rank = rank;
    }

    public Long getId() {
        return id;
    }

//    public void setId(Long id) {
//        this.id = id;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getUpperCategoryId() {
        return upperCategoryId;
    }

    public void setUpperCategoryId(Long upperCategoryId) {
        this.upperCategoryId = upperCategoryId;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }
}
