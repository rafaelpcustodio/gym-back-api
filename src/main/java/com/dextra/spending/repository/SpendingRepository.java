package com.dextra.spending.repository;

import com.dextra.spending.model.Spending;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpendingRepository extends MongoRepository<Spending, Long> {
}
