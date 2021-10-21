package com.swaraj.shop.store.controller.product.facade;

import com.swaraj.core.model.merchant.MerchantStore;
import com.swaraj.core.model.reference.language.Language;
import com.swaraj.shop.model.catalog.product.inventory.PersistableInventory;
import com.swaraj.shop.model.catalog.product.inventory.ReadableInventory;
import com.swaraj.shop.model.catalog.product.inventory.ReadableInventoryList;
import com.swaraj.shop.model.entity.ReadableEntityList;

public interface ProductInventoryFacade {

  ReadableEntityList<ReadableInventory> getInventory(Long productId, MerchantStore store, String child, Language language, int page, int count);
  
  ReadableInventory get(Long inventoryId, MerchantStore store, Language language);
  
  ReadableInventory get(Long productId, Long inventoryId, MerchantStore store, Language language);
  
  ReadableInventory get(Long productId, String child, Language language);
  
  ReadableInventory add(Long productId, PersistableInventory inventory, MerchantStore store, Language language);
  
  void update(Long productId, PersistableInventory inventory, MerchantStore store, Language language);
  
  void delete(Long inventoryId, MerchantStore store);
  
  

}
