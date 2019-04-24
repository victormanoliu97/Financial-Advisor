package com.ibs.customermanagement.data_tier.dao;

import com.ibs.customermanagement.data_tier.entity.TIbsCustomersBankAccountsEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerBankAccountsDAO extends CrudRepository<TIbsCustomersBankAccountsEntity, Integer> {

    TIbsCustomersBankAccountsEntity save(TIbsCustomersBankAccountsEntity entity);

    void deleteByIdAccount(Integer accountId);
}
