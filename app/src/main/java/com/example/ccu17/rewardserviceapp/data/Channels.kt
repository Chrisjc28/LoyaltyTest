package com.example.ccu17.rewardserviceapp.data

enum class Channels(val rewards: List<String>?) {

    SPORTS(listOf("CHAMPIONS_LEAGUE_FINAL_TICKET")),
    KIDS(null),
    NEWS(null),
    MUSIC(listOf("KARAOKE_PRO_MICROPHONE")),
    MOVIES(listOf("PIRATES_OF_THE_CARIBBEAN_COLLECTION"));

    companion object {
        fun getRewardsFromChannels(channels: List<Channels>?) = Channels.values().flatMap { localChannel ->
            channels?.filter { channel ->
                localChannel.rewards == channel.rewards
            }?.flatMap {
                it.rewards?.map { it } ?: emptyList()
            } ?: emptyList()
        }
    }
}