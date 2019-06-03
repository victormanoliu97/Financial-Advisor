package com.ibs.customermanagement.data_tier.dao;

import com.ibs.customermanagement.data_tier.entity.TIbsCustomerFinancialObjectivesEntity;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

public interface CustomerFinancialObjectivesDAO extends CrudRepository<TIbsCustomerFinancialObjectivesEntity, Integer> {

    TIbsCustomerFinancialObjectivesEntity save(TIbsCustomerFinancialObjectivesEntity entity);

    @Transactional
    void deleteById(Integer id);
}
