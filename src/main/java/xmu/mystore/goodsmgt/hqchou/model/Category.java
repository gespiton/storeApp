package xmu.mystore.goodsmgt.hqchou.model;

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
    private Integer type;
    private Integer priority;
    private String upperCategoryName;

    Category() {

    }

    Category(Category category) {
        id = category.id;
        name = category.name;
        upperCategoryId = category.upperCategoryId;
        rank = category.rank;
        type = category.type;
        priority = category.priority;
    }

    Category(Long id, String name, Long upperCategoryId, Integer rank, Integer type, Integer priority) {
        this.id = id;
        this.name = name;
        this.upperCategoryId = upperCategoryId;
        this.rank = rank;
        this.type = type;
        this.priority = priority;
    }

//    Category(Long id, String name, Long upperCategoryId, Integer rank, Integer type, Integer priority, String upperCategoryName) {
//        this.id = id;
//        this.name = name;
//        this.upperCategoryId = upperCategoryId;
//        this.rank = rank;
//        this.type = type;
//        this.priority = priority;
//        this.upper
//    }

    public Long getId() {
        return id;
    }

    //    public void setId(Long id) {
//        this.id = id;
//    }
    public void setId(Long id) {
        this.id = id;
    }

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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public String getUpperCategoryName() {
        return upperCategoryName;
    }

    public void setUpperCategoryName(String upperCategoryName) {
        this.upperCategoryName = upperCategoryName;
    }
}
