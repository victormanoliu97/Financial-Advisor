package com.ibs.customermanagement.data_tier.dao;

import com.ibs.customermanagement.data_tier.entity.TIbsCustomersCustomerFinancialCompaniesEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerFinancialCompaniesDAO extends CrudRepository<TIbsCustomersCustomerFinancialCompaniesEntity, Integer> {

    TIbsCustomersCustomerFinancialCompaniesEntity save(TIbsCustomersCustomerFinancialCompaniesEntity entity);

    void deleteByIdCompany(Integer companyId);
}
