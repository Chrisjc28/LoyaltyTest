package com.example.ccu17.rewardserviceapp.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SkyCustomer(val accountNumber: Int, val listOfChannels: List<Channels>) : Parcelable