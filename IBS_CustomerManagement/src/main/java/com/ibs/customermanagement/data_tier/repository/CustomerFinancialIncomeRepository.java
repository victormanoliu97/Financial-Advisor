package com.ibs.customermanagement.data_tier.repository;

import com.ibs.customermanagement.data_tier.entity.TIbsCustomersCustomerFinancialIncomeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerFinancialIncomeRepository extends JpaRepository<TIbsCustomersCustomerFinancialIncomeEntity, Integer> {

    List<TIbsCustomersCustomerFinancialIncomeEntity> getAllByCustomerId(Integer customerId);
}
