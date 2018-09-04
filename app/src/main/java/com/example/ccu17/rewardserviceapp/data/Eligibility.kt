package com.example.ccu17.rewardserviceapp.data

enum class Eligibility(val accountNumber: Int) {

    CUSTOMER_ELIGIBLE(11111),
    CUSTOMER_INELIGIBLE(33333),
    TECHNICAL_FAILURE(22222),
    INVALID_ACCOUNT_NUMBER(44444);


    companion object {
        fun from(accountNumber: Int?) = values().find {
                it.accountNumber == accountNumber
            } ?: INVALID_ACCOUNT_NUMBER
    }
}