package com.dextra.spending.controller;

import com.dextra.spending.model.Spending;
import com.dextra.spending.repository.SpendingRepository;
import com.dextra.spending.enums.PaymentTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/spendings")
public class SpendingController {

    @Autowired
    private SpendingRepository spendingRepository;

    @GetMapping
    public List<Spending> getAllSpendings() {
        return this.spendingRepository.findAll();
    }

    @GetMapping("/prices/{price}")
    public List<Spending> getSpendingsByPrice(@PathVariable(value = "price", required = true) final Long price) {
        return this.spendingRepository.findByPrice(new BigDecimal(price));
    }

    @GetMapping("/paymentTypes/{paymentType}")
    public List<Spending> getSpendingsByPaymentType(@PathVariable(value = "paymentType", required = true) final String paymentType) {
        return this.spendingRepository.findByPaymentType(PaymentTypes.valueOf(paymentType));
    }

    @GetMapping("/customerNames/{customerName}")
    public List<Spending> getSpendingsByCustomerName(@PathVariable(value = "customerName", required = true) final String customerName) {
        return this.spendingRepository.findByCustomerName(customerName);
    }

    @DeleteMapping("/ids/{id}")
    public void deleteById(@PathVariable(value = "id", required = true) final Long id) {
        this.spendingRepository.deleteById(id);
    }

    @PostMapping
    public Spending saveSpending(@RequestBody final Spending spending) {
        return this.spendingRepository.save(spending);
    }
}
