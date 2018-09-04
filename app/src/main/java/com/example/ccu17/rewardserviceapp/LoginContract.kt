package com.example.ccu17.rewardserviceapp

import com.example.ccu17.rewardserviceapp.data.SkyCustomer

interface LoginContract {

    interface Presenter {

        fun findCustomerByAccountNumber(accountNumber: Int): SkyCustomer?
    }

}
