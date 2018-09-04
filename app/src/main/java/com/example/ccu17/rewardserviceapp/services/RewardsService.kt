package com.example.ccu17.rewardserviceapp.services

import com.example.ccu17.rewardserviceapp.data.Channels
import com.example.ccu17.rewardserviceapp.data.Eligibility.*

class RewardsService (private val eligibilityService: EligibilityService) {

    fun getAvailableRewards(accountNumber: Int, listOfChannelSubscriptions: List<Channels>?): List<String> {
        val eligibility = eligibilityService.getEligibility(accountNumber)

        return when (eligibility) {
            CUSTOMER_ELIGIBLE -> {
                //Show rewards
                Channels.getRewardsFromChannels(listOfChannelSubscriptions)
            }
            CUSTOMER_INELIGIBLE, TECHNICAL_FAILURE, INVALID_ACCOUNT_NUMBER -> {
                //Show error
               emptyList()
            }
        }
    }
}