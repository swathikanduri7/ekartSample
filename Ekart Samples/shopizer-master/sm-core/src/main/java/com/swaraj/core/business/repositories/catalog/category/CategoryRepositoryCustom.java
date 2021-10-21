package com.swaraj.core.business.repositories.catalog.category;

import java.util.List;

import com.swaraj.core.model.catalog.category.Category;
import com.swaraj.core.model.merchant.MerchantStore;

public interface CategoryRepositoryCustom {

	List<Object[]> countProductsByCategories(MerchantStore store,
			List<Long> categoryIds);

	List<Category> listByStoreAndParent(MerchantStore store, Category category);

}
