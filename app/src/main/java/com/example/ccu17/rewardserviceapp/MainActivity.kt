package com.example.ccu17.rewardserviceapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.example.ccu17.rewardserviceapp.adpaters.MainAdapter
import com.example.ccu17.rewardserviceapp.data.SkyCustomer
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainActivityContract.View {

    lateinit var mainActivityPresenter: MainActivityPresenter

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val accountNumber = intent.getStringExtra(ACCOUNT_NUMBER)
        val customer = intent.getParcelableExtra<SkyCustomer>(CUSTOMER)

        mainActivityPresenter = MainActivityPresenter(view = this, customer = customer)

        customer_account_no.text = this.getString(R.string.customer_account_number, accountNumber)
        customer_rewards_title.setText(R.string.custom_rewards_title)

        val rewardsResult = mainActivityPresenter.collectRewardResults(accountNumber!!.toInt())

        viewManager = LinearLayoutManager(this)
        viewAdapter = MainAdapter(rewardsResult)

        recyclerView = findViewById<RecyclerView>(R.id.recycler_view).apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
        }
    }

    override fun showError() {
        customer_rewards_title.text = getString(R.string.no_rewards_error)
    }

    companion object {

        const val ACCOUNT_NUMBER = "account_number"
        const val CUSTOMER = "customer"

        fun newIntent(context: Context, accountNumber: String, customer: SkyCustomer): Intent =
            Intent(context, MainActivity::class.java).apply {
                putExtra(ACCOUNT_NUMBER, accountNumber)
                putExtra(CUSTOMER, customer)
            }
    }


}
