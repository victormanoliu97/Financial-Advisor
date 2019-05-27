package com.ibs.customermanagement.data_tier.dao;

import com.ibs.customermanagement.data_tier.entity.TIbsCustomersProfilingEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerProfilingDAO extends CrudRepository<TIbsCustomersProfilingEntity, Integer> {

    TIbsCustomersProfilingEntity save(TIbsCustomersProfilingEntity entity);
}
