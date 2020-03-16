package com.maha.livedata.simplelivedata

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.maha.livedata.R
import com.maha.livedata.adapter.SimpleItemsAdapter
import com.maha.livedata.databinding.ActivitySimpleLiveDataBinding
import kotlinx.android.synthetic.main.activity_simple_live_data.*

class SimpleLiveDataActivity : AppCompatActivity() {

    private var mSimpleViewModel: SimpleViewModel? = null

    private var mSimpleItemsAdapter: SimpleItemsAdapter? = null

    private lateinit var binding: ActivitySimpleLiveDataBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_simple_live_data)
        binding.lifecycleOwner = this

        init()

        mSimpleViewModel = ViewModelProviders.of(this).get(SimpleViewModel::class.java)
        mSimpleViewModel!!.fetchItem().observe(this, Observer {

        })

        binding.root
    }

    private fun init() {

        mSimpleItemsAdapter = SimpleItemsAdapter()


        val layoutManager = LinearLayoutManager(this)

        simpleRecyclerView.layoutManager = layoutManager
        simpleRecyclerView.hasFixedSize()
        simpleRecyclerView.adapter = mSimpleItemsAdapter
        simpleRecyclerView.addItemDecoration(DividerItemDecoration(this, layoutManager.orientation))

    }
}
