package com.example.ccu17.rewardserviceapp

import com.example.ccu17.rewardserviceapp.data.Channels
import org.junit.Assert
import org.junit.Test

class ChannelsTest {

    @Test
    fun rewardsFound() {
        Assert.assertEquals(listOf("CHAMPIONS_LEAGUE_FINAL_TICKET"), Channels.getRewardsFromChannels(listOf(Channels.SPORTS)))
    }

    @Test
    fun noChannelsNoRewards() {
        Assert.assertEquals(emptyList<String>(), Channels.getRewardsFromChannels(null))
    }

    @Test
    fun channelReturnNoRewards() {
        Assert.assertEquals(emptyList<String>(), Channels.getRewardsFromChannels(listOf(Channels.KIDS)))
    }
}