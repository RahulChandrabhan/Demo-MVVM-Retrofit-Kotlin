package com.rsc.assignment247.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rsc.assignment247.R
import com.rsc.assignment247.adapter.UserAdapter
import com.rsc.assignment247.model.UserResult
import com.rsc.assignment247.viewModel.MainActivityViewModel


class MainActivity : AppCompatActivity() {

    private lateinit var mainActivityViewModel: MainActivityViewModel
    private lateinit var userRv: RecyclerView
    private lateinit var userAdapter: UserAdapter
    private var userDetailsList = arrayListOf<UserResult>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainActivityViewModel = ViewModelProviders.of(this).get(MainActivityViewModel::class.java)

        val linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        userRv = findViewById(R.id.act_main_rv)
        userRv.addItemDecoration(
            DividerItemDecoration(
                userRv.context,
                DividerItemDecoration.VERTICAL
            )
        )
        userRv.layoutManager = linearLayoutManager
        userAdapter = UserAdapter(userDetailsList, this)
        userRv.adapter = userAdapter
        getUserDetails()

    } // End On-Create \\

    private fun getUserDetails() {
        mainActivityViewModel.showProgressDialog(this)
        mainActivityViewModel.getUserResult().observe(this,
            Observer<List<UserResult>> {
                userDetailsList.clear()
                userDetailsList.addAll(it as ArrayList<UserResult>)
                userAdapter.notifyDataSetChanged()
                mainActivityViewModel.dismissProgressDialog()
            })
    }

    companion object {
        private const val TAG = "MainActivity"
    }

} // End Class \\