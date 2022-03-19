package com.secondworld.clickernew.ui.screens.game

import android.widget.RelativeLayout
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.secondworld.clickernew.core.log
import com.secondworld.clickernew.data.repository.Repository
import com.secondworld.clickernew.domain.DamageCase
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
    private val damagePriceCase: DamagePriceCase,
    private val damageCase: DamageCase
) : ViewModel() {

    private val _score = MutableLiveData(repository.getScore())
    val score: LiveData<Int> get() = _score

    private val _damage = MutableLiveData(repository.getDamage())
    val damage: LiveData<Int> get() = _damage

    private val _damagePrice = MutableLiveData(repository.getDamagePrice())
    val damagePrice: LiveData<Int> get() = _damagePrice

    private val _enemyHp = MutableLiveData(enemyCase.createEnemyHp())
    val enemyHp: LiveData<Int> get() = _enemyHp

    private val _enemyDead = MutableLiveData(false)
    val enemyDead: LiveData<Boolean> get() = _enemyDead

    // TODO: нужно починить определение смерти enemy

    // Score
    private fun updateScore(value: Int) {
        repository.updateScore(value)
        _score.postValue(repository.getScore())
    }

    private fun setScore(value: Int){
        repository.setScore(value)
        _score.postValue(repository.getScore())
    }

    fun clearScore() {
        repository.setScore(0)
        _score.postValue(repository.getScore())
    }

    // Damage
    private fun updateDamage(value : Int) {
        repository.updateDamage(value)
        _damage.postValue(repository.getDamage())
    }

    fun cleanDamage(){
        repository.setDamage(1)
        _damage.postValue(repository.getDamage())
    }

    // Enemy HP
    private fun getEnemyHp() {
        _enemyHp.postValue(enemyCase.createEnemyHp())
    }

    fun updateEnemyHp(fieldTextDamageToEnemy: RelativeLayout) {

        val damageEntity = damageCase.getCurrentDamage()
        createTextDamage(fieldTextDamageToEnemy, damageEntity.damage, damageEntity.typeDamage)

        val s = _enemyHp.value!!.minus(damageEntity.damage)

        if(s <= 0){
            getEnemyHp()
            updateScore(scoreCase.getScoreForTheEnemy())
        } else {
            _enemyHp.postValue(s)
        }
    }

    // Damage Price
    private fun updateDamagePrice(){
        repository.updateDamagePrice(damagePriceCase.getDamagePrice())
        _damagePrice.postValue(repository.getDamagePrice())
    }

    fun cleanDamagePrice(){
        repository.setDamagePrice(1)
        _damagePrice.postValue(repository.getDamagePrice())
    }

    // Other
    fun damageSale(){
        setScore(repository.getScore() - repository.getDamagePrice())
        updateDamagePrice()
        updateDamage(1)
    }

    fun getBgColor() = repository.getRandomColor()
    private fun createTextDamage(
        fieldTextDamageToEnemy: RelativeLayout,
        value: Int?,
        typeDamage: DamageCase.DamageType
    ) {
        damageCase.createTextDamage(fieldTextDamageToEnemy, value, typeDamage)
    }


}