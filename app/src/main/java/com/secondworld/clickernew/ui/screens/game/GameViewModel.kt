package com.secondworld.clickernew.ui.screens.game

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.secondworld.clickernew.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class GameViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    private val _score = MutableLiveData(repository.getScore())
    val score: LiveData<Int> get() = _score

    fun updateScore(value: Int) {
        repository.updateScore(value)
        _score.postValue(repository.getScore())
    }
}