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
}
