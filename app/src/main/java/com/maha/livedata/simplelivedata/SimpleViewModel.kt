package com.maha.livedata.simplelivedata

import android.os.Handler
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SimpleViewModel : ViewModel() {

    private val list = mutableListOf<String>()
    private val repository = ItemsRepository()

    private val handler = Handler()

    private var loading = false

    private var delay = 3000L

    private val _items = MutableLiveData<List<String>>().apply { value = list }

    val items: LiveData<List<String>>
        get() = _items

    fun fetchItem(): MutableLiveData<List<String>> {


        handler.postDelayed({

            val position = list.size
            val newItems = repository.getItemsPage()
            list.addAll(newItems)
            loading = false
        }, delay)

        return _items
    }

}