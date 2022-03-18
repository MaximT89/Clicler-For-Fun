package com.secondworld.clickernew.ui.screens.game

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.secondworld.clickernew.data.repository.Repository
import com.secondworld.clickernew.domain.DamagePriceCase
import com.secondworld.clickernew.domain.EnemyCase
import com.secondworld.clickernew.domain.ScoreCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class GameViewModel @Inject constructor(
    private val repository: Repository,
    private val enemyCase: EnemyCase,
    private val scoreCase: ScoreCase,
    private val damagePriceCase: DamagePriceCase
) : ViewModel() {

    private val _score = MutableLiveData(repository.getScore())
    val score: LiveData<Int> get() = _score

    private val _damage = MutableLiveData(repository.getDamage())
    val damage: LiveData<Int> get() = _damage

    private val _damagePrice = MutableLiveData(repository.getDamagePrice())
    val damagePrice: LiveData<Int> get() = _damagePrice

    private val _enemyHp = MutableLiveData(enemyCase.createEnemyHp())
    val enemyHp: LiveData<Int> get() = _enemyHp

    private fun updateScore(value: Int) {
        repository.updateScore(value)
        _score.postValue(repository.getScore())
    }

    fun clearScore() {
        repository.setScore(0)
        _score.postValue(repository.getScore())
    }

    private fun setScore(value: Int){
        repository.setScore(value)
        _score.postValue(repository.getScore())
    }

    fun cleanDamagePrice(){
        repository.setDamagePrice(1)
        _damagePrice.postValue(repository.getDamagePrice())
    }

    fun cleanDamage(){
        repository.setDamage(1)
        _damage.postValue(repository.getDamage())
    }

    private fun getEnemyHp() {
        _enemyHp.postValue(enemyCase.createEnemyHp())
    }

    fun updateEnemyHp(){
        val s = _enemyHp.value!!.minus(_damage.value!!)

        if(s <= 0){
            getEnemyHp()
            updateScore(scoreCase.getScoreForTheEnemy())
        } else {
            _enemyHp.postValue(s)
        }
    }

    private fun updateDamagePrice(){
        repository.updateDamagePrice(damagePriceCase.getDamagePrice())
        _damagePrice.postValue(repository.getDamagePrice())
    }

    fun damageSale(){
        setScore(repository.getScore() - repository.getDamagePrice())
        updateDamagePrice()
        updateDamage(1)
    }

    private fun updateDamage(value : Int) {
        repository.updateDamage(value)
        _damage.postValue(repository.getDamage())
    }
}