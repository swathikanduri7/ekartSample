package com.swaraj.core.business.services.catalog.product.review;

import java.util.List;

import com.swaraj.core.business.services.common.generic.SalesManagerEntityService;
import com.swaraj.core.model.catalog.product.Product;
import com.swaraj.core.model.catalog.product.review.ProductReview;
import com.swaraj.core.model.customer.Customer;
import com.swaraj.core.model.reference.language.Language;

public interface ProductReviewService extends
		SalesManagerEntityService<Long, ProductReview> {
	
	
	List<ProductReview> getByCustomer(Customer customer);
	List<ProductReview> getByProduct(Product product);
	List<ProductReview> getByProduct(Product product, Language language);
	ProductReview getByProductAndCustomer(Long productId, Long customerId);
	/**
	 * @param product
	 * @return
	 */
	List<ProductReview> getByProductNoCustomers(Product product);



}
