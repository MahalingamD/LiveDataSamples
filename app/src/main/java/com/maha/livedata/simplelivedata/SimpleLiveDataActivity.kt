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
import com.maha.livedata.databinding.SimpleLiveDataActivityBinding
import kotlinx.android.synthetic.main.simple_live_data_activity.*

class SimpleLiveDataActivity : AppCompatActivity() {

    private var mSimpleViewModel: SimpleViewModel? = null

    private var mSimpleItemsAdapter: SimpleItemsAdapter? = null

    private lateinit var binding: SimpleLiveDataActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.simple_live_data_activity)
        binding.lifecycleOwner = this

        mSimpleViewModel = ViewModelProviders.of(this).get(SimpleViewModel::class.java)


        init()

        //binding.root
    }

    private fun init() {

        mSimpleItemsAdapter = SimpleItemsAdapter()


        val layoutManager = LinearLayoutManager(this)

        simpleRecyclerView.layoutManager = layoutManager
        simpleRecyclerView.hasFixedSize()
        simpleRecyclerView.adapter = mSimpleItemsAdapter
        simpleRecyclerView.addItemDecoration(DividerItemDecoration(this, layoutManager.orientation))


        simpleRecyclerView.endless {  mSimpleViewModel!!.fetchItems() }

        mSimpleViewModel!!.addItems.subscribe(this) {
            simpleRecyclerView.adapter?.notifyItemRangeInserted(data.positionStart, data.count)
        }
        mSimpleViewModel!!.removeItem.subscribe(this) {
            simpleRecyclerView.adapter?.notifyItemRemoved(data)
        }

        binding.viewModel = mSimpleViewModel
       // mSimpleViewModel!!.fetchItem()
       // mSimpleItemsAdapter!!.update(mSimpleViewModel!!.loadData())



    }
}
