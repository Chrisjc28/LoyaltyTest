package com.example.ccu17.rewardserviceapp

import com.example.ccu17.rewardserviceapp.data.Eligibility
import com.example.ccu17.rewardserviceapp.data.SkyCustomer

class LoginPresenter(val customers: List<SkyCustomer> = CustomersModel.customers) : LoginContract.Presenter{

    override fun findCustomerByAccountNumber(accountNumber: Int): SkyCustomer? {
        val eligibility = Eligibility.from(accountNumber)

        return if (eligibility == Eligibility.INVALID_ACCOUNT_NUMBER) {
            return null
        } else {
            customers.find { it.accountNumber == accountNumber }
        }
    }
}