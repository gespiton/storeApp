package store.business.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by 周鸿清 on 5/4/2017.
 */
public class CompositeCategory extends Category {
    List<CompositeCategory> subCategory = null;

    public CompositeCategory(Category category) {
        super(category);
    }

    public static List<CompositeCategory> buildComposedCategorysFromCategorys(List<Category> input) {
        Map<Long, CompositeCategory> dict = new HashMap<>();

        input.forEach(
                category -> dict.put(category.getId(), new CompositeCategory(category))
        );

        dict.values().forEach(
                catetory -> {
                    if (catetory.getRank() != null) {
                        dict.get(catetory.getUpperCategoryId()).addSubCategory(catetory);
                    }
                }
        );

        return dict.values().stream().filter(
                category -> category.getRank() == null
        ).collect(Collectors.toList());
    }

    public List<CompositeCategory> getSubCategory() {
        return subCategory;
    }

    private void addSubCategory(CompositeCategory catetory) {
        if (subCategory == null)
            subCategory = new ArrayList<>();
        subCategory.add(catetory);
    }
}
