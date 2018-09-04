package com.example.ccu17.rewardserviceapp

import com.example.ccu17.rewardserviceapp.data.Channels
import com.example.ccu17.rewardserviceapp.data.SkyCustomer

object CustomersModel {

    val customers = listOf(SkyCustomer(11111, listOf(Channels.MUSIC, Channels.MOVIES)),
            SkyCustomer(33333, listOf(Channels.SPORTS, Channels.MUSIC)),
            SkyCustomer(22222, listOf(Channels.MUSIC, Channels.MOVIES)),
            SkyCustomer(44444, listOf(Channels.NEWS, Channels.KIDS)))
}