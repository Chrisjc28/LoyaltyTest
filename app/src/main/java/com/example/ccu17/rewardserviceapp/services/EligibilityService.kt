package com.example.ccu17.rewardserviceapp.services

import com.example.ccu17.rewardserviceapp.data.Eligibility


class EligibilityService {

    fun getEligibility(accountNumber: Int?) = Eligibility.from(accountNumber)
}