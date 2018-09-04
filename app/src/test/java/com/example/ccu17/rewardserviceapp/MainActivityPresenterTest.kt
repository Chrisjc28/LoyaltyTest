package com.example.ccu17.rewardserviceapp

import com.example.ccu17.rewardserviceapp.data.SkyCustomer
import com.example.ccu17.rewardserviceapp.services.RewardsService
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.verifyNoMoreInteractions
import com.nhaarman.mockito_kotlin.whenever
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class MainActivityPresenterTest {

    private val mockRewardsService: RewardsService = mock()
    private val mockView: MainActivityContract.View = mock()
    private val mockCustomer: SkyCustomer = SkyCustomer(11111, emptyList())

    private lateinit var presenter: MainActivityPresenter

    @Before
    fun setUp() {
        presenter = MainActivityPresenter(mockRewardsService, mockView, mockCustomer)
    }

    @Test
    fun ifEmptyRewardsShowError() {
        whenever(mockRewardsService.getAvailableRewards(mockCustomer.accountNumber, mockCustomer.listOfChannels)).thenReturn(listOf())

        val results = presenter.collectRewardResults(mockCustomer.accountNumber)

        verify(mockView).showError()
        Assert.assertEquals(emptyList<String>(), results)
    }

    @Test
    fun returnListOfRewards() {
        whenever(mockRewardsService.getAvailableRewards(mockCustomer.accountNumber, mockCustomer.listOfChannels)).thenReturn(listOf("Test", "Test"))

        val results = presenter.collectRewardResults(mockCustomer.accountNumber)

        verifyNoMoreInteractions(mockView)
        Assert.assertEquals(listOf("Test", "Test"), results)
    }
}
