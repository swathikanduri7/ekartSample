package com.swaraj.core.modules.order.total;



import com.swaraj.core.model.catalog.product.Product;
import com.swaraj.core.model.customer.Customer;
import com.swaraj.core.model.merchant.MerchantStore;
import com.swaraj.core.model.order.OrderSummary;
import com.swaraj.core.model.order.OrderTotal;
import com.swaraj.core.model.shoppingcart.ShoppingCartItem;
import com.swaraj.core.modules.Module;

/**
 * Calculates order total based on specific
 * modules implementation
 * @author carlsamson
 *
 */
public interface OrderTotalPostProcessorModule extends Module {
	
	   /**
	    * Uses the OrderSummary and external tools for applying if necessary
	    * variations on the OrderTotal calculation.
	    * @param summary OrderSummary
	    * @param shoppingCartItem ShoppingCartItem
	    * @param product Product
	    * @param customer Customer
	    * @param store MerchantStore
	    * @return OrderTotal OrderTotal
	    * @throws Exception Exception
	    */
	   OrderTotal caculateProductPiceVariation(final OrderSummary summary, final ShoppingCartItem shoppingCartItem, final Product product, final Customer customer, final MerchantStore store) throws Exception;

}
