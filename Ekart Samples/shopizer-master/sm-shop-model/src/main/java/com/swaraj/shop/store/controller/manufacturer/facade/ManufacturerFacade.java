package com.swaraj.shop.store.controller.manufacturer.facade;

import java.util.List;

import com.swaraj.core.model.catalog.product.manufacturer.Manufacturer;
import com.swaraj.core.model.merchant.MerchantStore;
import com.swaraj.core.model.reference.language.Language;
import com.swaraj.shop.model.catalog.manufacturer.PersistableManufacturer;
import com.swaraj.shop.model.catalog.manufacturer.ReadableManufacturer;
import com.swaraj.shop.model.catalog.manufacturer.ReadableManufacturerList;
import com.swaraj.shop.model.entity.ListCriteria;

/**
 * Manufacturer / brand / collection product grouping
 * @author carlsamson
 *
 */
public interface ManufacturerFacade {
  
  List<ReadableManufacturer> getByProductInCategory(MerchantStore store, Language language, Long categoryId);
  
  /**
   * Creates or saves a manufacturer
   * 
   * @param manufacturer
   * @param store
   * @param language
   * @throws Exception
   */
  void saveOrUpdateManufacturer(PersistableManufacturer manufacturer, MerchantStore store,
      Language language) throws Exception;

  /**
   * Deletes a manufacturer
   * 
   * @param manufacturer
   * @param store
   * @param language
   * @throws Exception
   */
  void deleteManufacturer(Manufacturer manufacturer, MerchantStore store, Language language)
      throws Exception;

  /**
   * Get a Manufacturer by id
   * 
   * @param id
   * @param store
   * @param language
   * @return
   * @throws Exception
   */
  ReadableManufacturer getManufacturer(Long id, MerchantStore store, Language language)
      throws Exception;

  /**
   * Get all Manufacturer
   * 
   * @param store
   * @param language
   * @return
   * @throws Exception
   */
  ReadableManufacturerList getAllManufacturers(MerchantStore store, Language language, ListCriteria criteria, int page, int count) ;
  
  /**
   * List manufacturers by a specific store
   * @param store
   * @param language
   * @param criteria
   * @param page
   * @param count
   * @return
   */
  ReadableManufacturerList listByStore(MerchantStore store, Language language, ListCriteria criteria, int page, int count) ;
  
  /**
   * Determines if manufacturer code already exists
   * @param store
   * @param manufacturerCode
   * @return
   */
  boolean manufacturerExist(MerchantStore store, String manufacturerCode);

}
