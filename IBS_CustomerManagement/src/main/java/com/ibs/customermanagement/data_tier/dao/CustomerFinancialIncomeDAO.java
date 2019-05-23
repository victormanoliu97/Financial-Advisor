package com.ibs.customermanagement.data_tier.dao;

import com.ibs.customermanagement.data_tier.entity.TIbsCustomersCustomerFinancialIncomeEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface CustomerFinancialIncomeDAO extends CrudRepository<TIbsCustomersCustomerFinancialIncomeEntity, Integer> {

    TIbsCustomersCustomerFinancialIncomeEntity save(TIbsCustomersCustomerFinancialIncomeEntity entity);

    @Transactional
    void deleteByIdFinancialIncome(Integer financialIncomeId);
}
