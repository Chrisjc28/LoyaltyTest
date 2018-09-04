package com.example.ccu17.rewardserviceapp

import com.example.ccu17.rewardserviceapp.data.Eligibility
import org.junit.Assert
import org.junit.Test

class EligibilityTest {

    @Test
    fun returnEligibleCustomer() {
        Assert.assertEquals(Eligibility.CUSTOMER_ELIGIBLE, Eligibility.from(11111))
    }

    @Test
    fun returnIneligibleCustomer() {
        Assert.assertEquals(Eligibility.CUSTOMER_INELIGIBLE, Eligibility.from(33333))
    }

    @Test
    fun returnDefaultIfNoneMatched() {
        Assert.assertEquals(Eligibility.INVALID_ACCOUNT_NUMBER, Eligibility.from(99999))
    }
}