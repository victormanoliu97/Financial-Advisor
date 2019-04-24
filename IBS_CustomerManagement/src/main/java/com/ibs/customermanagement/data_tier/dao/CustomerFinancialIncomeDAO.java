package com.ibs.customermanagement.data_tier.dao;

import com.ibs.customermanagement.data_tier.entity.TIbsCustomersCustomerFinancialIncomeEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerFinancialIncomeDAO extends CrudRepository<TIbsCustomersCustomerFinancialIncomeEntity, Integer> {

    TIbsCustomersCustomerFinancialIncomeEntity save(TIbsCustomersCustomerFinancialIncomeEntity entity);

    void deleteByIdFinancialIncome(Integer financialIncomeId);
}
