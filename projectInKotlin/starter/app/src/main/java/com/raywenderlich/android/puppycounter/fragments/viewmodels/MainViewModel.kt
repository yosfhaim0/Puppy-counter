package com.raywenderlich.android.puppycounter.fragments.viewmodels
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.raywenderlich.android.puppycounter.model.DogCount

class MainViewModel : ViewModel() {

    private val _dogCount: MutableLiveData<DogCount> by lazy {
        MutableLiveData<DogCount>(DogCount())
    }
    val dogCount: LiveData<DogCount> = _dogCount

    fun setDogCount(dogCount: DogCount) {
        _dogCount.value = dogCount
    }
}