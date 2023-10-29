package com.workintech.mappings.dto;

public record AccountResponse(long id, String accountName, double moneyAmount, CustomerResponse customerResponse) {
}
