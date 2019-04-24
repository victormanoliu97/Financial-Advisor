package com.ibs.customermanagement.data_tier.dao;

import com.ibs.customermanagement.data_tier.entity.TIbsCustomersCustomerFinancialEstatesEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerFinancialEstatesDAO extends CrudRepository<TIbsCustomersCustomerFinancialEstatesEntity, Integer> {

    TIbsCustomersCustomerFinancialEstatesEntity save(TIbsCustomersCustomerFinancialEstatesEntity entity);

    void deleteByIdEstate(Integer estateId);
}
