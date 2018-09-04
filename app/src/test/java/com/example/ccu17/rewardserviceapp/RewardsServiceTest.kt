package com.example.ccu17.rewardserviceapp

import com.example.ccu17.rewardserviceapp.data.Channels
import com.example.ccu17.rewardserviceapp.data.Eligibility
import com.example.ccu17.rewardserviceapp.services.EligibilityService
import com.example.ccu17.rewardserviceapp.services.RewardsService
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.whenever
import org.junit.Assert
import org.junit.Test

class RewardsServiceTest {

    private val mockEligibilityService: EligibilityService = mock()
    private val rewardsService: RewardsService = RewardsService(mockEligibilityService)

    @Test
    fun customerIsEligible() {
        whenever(mockEligibilityService.getEligibility(any())).thenReturn(Eligibility.CUSTOMER_ELIGIBLE)

        val results = rewardsService.getAvailableRewards(11111, listOf(Channels.SPORTS))

        Assert.assertEquals(Channels.SPORTS.rewards, results)
    }

    @Test
    fun invalidAccountNumber() {
        whenever(mockEligibilityService.getEligibility(any())).thenReturn(Eligibility.INVALID_ACCOUNT_NUMBER)

        val results = rewardsService.getAvailableRewards(44444, listOf(Channels.SPORTS))

        Assert.assertEquals(emptyList<String>(), results)
    }
}