package com.ibs.customermanagement.data_tier.repository;

import com.ibs.customermanagement.data_tier.entity.TIbsCustomersCustomerFinancialLiabilitiesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerFinancialLiabilitiesRepository extends JpaRepository<TIbsCustomersCustomerFinancialLiabilitiesEntity, Integer> {

    List<TIbsCustomersCustomerFinancialLiabilitiesEntity> getAllByCustomerId(Integer customerId);

}
