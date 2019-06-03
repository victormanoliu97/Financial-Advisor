package com.ibs.customermanagement.data_tier.repository;

import com.ibs.customermanagement.data_tier.entity.TIbsCustomerFinancialObjectivesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerFinancialObjectivesRepository extends JpaRepository<TIbsCustomerFinancialObjectivesEntity, Integer> {

    List<TIbsCustomerFinancialObjectivesEntity> getAllByCustomerId(Integer customerId);

    TIbsCustomerFinancialObjectivesEntity getById(Integer id);
}
