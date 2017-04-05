package store.business.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by 周鸿清 on 5/4/2017.
 */
public class ComposedCategory extends Category {
    List<ComposedCategory> subCategory = null;

    public ComposedCategory(Category category) {
        super(category);
    }

    public static List<ComposedCategory> buildComposedCategorysFromCategorys(List<Category> input) {
        Map<Long, ComposedCategory> dict = new HashMap<>();

        input.forEach(
                category -> dict.put(category.getId(), new ComposedCategory(category))
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

//        List<ComposedCategory> result = new ArrayList<>(baseCategory.size());
//
//        baseCategory.forEach(
//                category -> {
//                    while (category.)
//                }
//        );

    }

    public List<ComposedCategory> getSubCategory() {
        return subCategory;
    }

    private void addSubCategory(ComposedCategory catetory) {
        if (subCategory == null)
            subCategory = new ArrayList<>();
        subCategory.add(catetory);
    }
}
