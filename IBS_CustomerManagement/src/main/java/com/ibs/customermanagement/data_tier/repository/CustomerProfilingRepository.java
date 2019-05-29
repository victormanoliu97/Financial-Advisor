package com.ibs.customermanagement.data_tier.repository;

import com.ibs.customermanagement.data_tier.entity.TIbsCustomersProfilingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerProfilingRepository extends JpaRepository<TIbsCustomersProfilingEntity, Integer> {

    List<TIbsCustomersProfilingEntity> getAllByIdCustomer(Integer customerId);

    TIbsCustomersProfilingEntity getByIdProfiling(Integer idProfiling);
}
