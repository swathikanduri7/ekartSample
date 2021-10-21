package com.swaraj.core.business.repositories.system;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.swaraj.core.model.merchant.MerchantStore;
import com.swaraj.core.model.system.MerchantLog;

public interface MerchantLogRepository extends JpaRepository<MerchantLog, Long> {

	List<MerchantLog> findByStore(MerchantStore store);
}
