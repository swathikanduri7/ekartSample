package com.swaraj.core.business.repositories.catalog.product.manufacturer;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.swaraj.core.model.catalog.product.manufacturer.Manufacturer;

public interface PageableManufacturerRepository extends PagingAndSortingRepository<Manufacturer, Long> {

  @Query("select m from Manufacturer m left join m.descriptions md inner join m.merchantStore ms where ms.id=?1 and md.language.id=?2 and (?3 is null or md.name like %?3%)")
  Page<Manufacturer> findByStore(Integer storeId, Integer languageId, String name, Pageable pageable);  

  @Query("select m from Manufacturer m left join m.descriptions md inner join m.merchantStore ms where ms.id=?1 and (?2 is null or md.name like %?2%)")
  Page<Manufacturer> findByStore(Integer storeId, String name, Pageable pageable);  

  
}
