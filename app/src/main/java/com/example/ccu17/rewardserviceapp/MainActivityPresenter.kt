package com.example.ccu17.rewardserviceapp

import com.example.ccu17.rewardserviceapp.data.SkyCustomer
import com.example.ccu17.rewardserviceapp.services.EligibilityService
import com.example.ccu17.rewardserviceapp.services.RewardsService

class MainActivityPresenter(val rewardsService: RewardsService = RewardsService(EligibilityService()),
                            val view: MainActivityContract.View,
                            val customer: SkyCustomer) : MainActivityContract.Presenter {


    override fun collectRewardResults(accountNumber: Int): List<String> {
        val availableRewards = rewardsService.getAvailableRewards(customer.accountNumber,
                customer.listOfChannels)

        if (availableRewards.isEmpty()) {
            view.showError()
        }

        return availableRewards
    }

}