package com.ibs.customermanagement.data_tier.dao;

import com.ibs.customermanagement.data_tier.entity.TIbsCustomersCustomerFinancialEstatesEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface CustomerFinancialEstatesDAO extends CrudRepository<TIbsCustomersCustomerFinancialEstatesEntity, Integer> {

    TIbsCustomersCustomerFinancialEstatesEntity save(TIbsCustomersCustomerFinancialEstatesEntity entity);

    @Transactional
    void deleteByIdEstate(Integer estateId);
}
