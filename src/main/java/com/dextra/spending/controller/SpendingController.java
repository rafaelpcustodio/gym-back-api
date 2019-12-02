package com.dextra.spending.controller;

import com.dextra.spending.model.Spending;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
public class SpendingController {

    @GetMapping
    public List<Spending> getAllSpendings() {
        return Collections.emptyList();
    }
}
