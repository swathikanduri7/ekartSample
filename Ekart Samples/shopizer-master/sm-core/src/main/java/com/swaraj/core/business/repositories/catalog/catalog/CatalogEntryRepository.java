package com.swaraj.core.business.repositories.catalog.catalog;

import org.springframework.data.jpa.repository.JpaRepository;

import com.swaraj.core.model.catalog.catalog.CatalogCategoryEntry;

public interface CatalogEntryRepository extends JpaRepository<CatalogCategoryEntry, Long> {

}
