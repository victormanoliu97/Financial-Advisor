package com.ibs.customermanagement.data_tier.repository;

import com.ibs.customermanagement.data_tier.entity.TIbsCustomersBankAccountsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerBankAccountsRepository extends JpaRepository<TIbsCustomersBankAccountsEntity, Integer> {

    List<TIbsCustomersBankAccountsEntity> getAllByCustomerId(Integer customerId);
}
