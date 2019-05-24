package com.ibs.customermanagement.data_tier.dao;

import com.ibs.customermanagement.data_tier.entity.TIbsCustomersCustomerFinancialLiabilitiesEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface CustomerFinancialLiabilitiesDAO extends CrudRepository<TIbsCustomersCustomerFinancialLiabilitiesEntity, Integer> {

    TIbsCustomersCustomerFinancialLiabilitiesEntity save(TIbsCustomersCustomerFinancialLiabilitiesEntity entity);

    @Transactional
    void deleteByIdFinancialLiability(Integer financialLiabilityId);
}
