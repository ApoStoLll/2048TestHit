package com.miss.a2048.game.ui.records

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.miss.a2048.game.data.RecordsDB
import com.miss.a2048.game.data.entities.RecordEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class RecordsViewModel(private val recordsDB : RecordsDB) : ViewModel(){

    val recordsList = MutableLiveData<List<RecordEntity>>()

    fun getList(){
        viewModelScope.launch(Dispatchers.IO) {
            val data = recordsDB.dao().get()
            withContext(Dispatchers.Main){
                recordsList.value = data
            }
        }
    }

}