package com.dextra.spending.repository;

import com.dextra.spending.model.Spending;
import com.dextra.spending.enums.PaymentTypes;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface SpendingRepository extends MongoRepository<Spending, Long> {

    List<Spending> findByPrice(BigDecimal price);

    List<Spending> findByPaymentType(PaymentTypes paymentType);

    List<Spending> findByCustomerName(String name);
}
