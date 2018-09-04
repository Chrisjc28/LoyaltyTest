package com.example.ccu17.rewardserviceapp


interface MainActivityContract {

    interface View {
        fun showError()
    }

    interface Presenter {
        fun collectRewardResults(accountNumber: Int): List<String>
    }
}