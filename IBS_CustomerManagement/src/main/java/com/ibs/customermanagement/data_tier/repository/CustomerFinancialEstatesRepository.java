package com.ibs.customermanagement.data_tier.repository;

import com.ibs.customermanagement.data_tier.entity.TIbsCustomersCustomerFinancialEstatesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerFinancialEstatesRepository extends JpaRepository<TIbsCustomersCustomerFinancialEstatesEntity, Integer> {

    List<TIbsCustomersCustomerFinancialEstatesEntity> getAllByCustomerId(Integer customerId);
}
