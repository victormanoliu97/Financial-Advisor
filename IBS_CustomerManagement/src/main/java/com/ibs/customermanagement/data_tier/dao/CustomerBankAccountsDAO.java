package com.ibs.customermanagement.data_tier.dao;

import com.ibs.customermanagement.data_tier.entity.TIbsCustomersBankAccountsEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface CustomerBankAccountsDAO extends CrudRepository<TIbsCustomersBankAccountsEntity, Integer> {

    TIbsCustomersBankAccountsEntity save(TIbsCustomersBankAccountsEntity entity);

    @Modifying
    @Transactional
    @Query(value = "update t_ibs_customers_bank_accounts set status = :status where id_account = :id_account", nativeQuery = true)
    void updateCustomerAccountStatus(@Param("status") String status, @Param("id_account") Integer accountId);
}
