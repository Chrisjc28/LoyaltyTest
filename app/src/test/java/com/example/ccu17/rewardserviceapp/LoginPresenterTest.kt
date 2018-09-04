package com.example.ccu17.rewardserviceapp

import com.example.ccu17.rewardserviceapp.data.SkyCustomer
import org.junit.Assert
import org.junit.Test

class LoginPresenterTest {

    @Test
    fun eligibilityWithInvalidCustomerNumber() {
        Assert.assertNull(LoginPresenter(emptyList()).findCustomerByAccountNumber(99999))
    }

    @Test
    fun eligibilityWithValidCustomerNumber() {
        val listOfCustomer = listOf(SkyCustomer(11111, emptyList()))

        val loginPresenter = LoginPresenter(listOfCustomer)

        val result = loginPresenter.findCustomerByAccountNumber(listOfCustomer.first().accountNumber)

        Assert.assertEquals(result, listOfCustomer.first())
    }
}