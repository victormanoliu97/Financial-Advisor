package com.ibs.customermanagement.data_tier.dao;

import com.ibs.customermanagement.data_tier.entity.TIbsCustomersCustomerFinancialLiabilitiesEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerFinancialLiabilitiesDAO extends CrudRepository<TIbsCustomersCustomerFinancialLiabilitiesEntity, Integer> {

    TIbsCustomersCustomerFinancialLiabilitiesEntity save(TIbsCustomersCustomerFinancialLiabilitiesEntity entity);

    void deleteByIdFinancialLiability(Integer financialLiabilityId);
}
