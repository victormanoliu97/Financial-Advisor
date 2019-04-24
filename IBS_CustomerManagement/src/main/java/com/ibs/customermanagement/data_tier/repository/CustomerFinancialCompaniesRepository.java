package com.ibs.customermanagement.data_tier.repository;

import com.ibs.customermanagement.data_tier.entity.TIbsCustomersCustomerFinancialCompaniesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerFinancialCompaniesRepository extends JpaRepository<TIbsCustomersCustomerFinancialCompaniesEntity, Integer> {

    List<TIbsCustomersCustomerFinancialCompaniesEntity> getAllByCustomerId(Integer customerId);
}
