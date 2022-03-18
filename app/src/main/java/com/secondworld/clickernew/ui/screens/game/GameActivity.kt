package com.secondworld.clickernew.ui.screens.game

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.viewModels
import com.secondworld.clickernew.animations.AnimateType
import com.secondworld.clickernew.animations.Animators
import com.secondworld.clickernew.core.BaseActivity
import com.secondworld.clickernew.core.enabled
import com.secondworld.clickernew.core.notEnabled
import com.secondworld.clickernew.core.updateText
import com.secondworld.clickernew.databinding.ActivityGameBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@SuppressLint("SetTextI18n")
@AndroidEntryPoint
class GameActivity : BaseActivity<ActivityGameBinding>() {

    override val bindingInflater: (LayoutInflater) -> ActivityGameBinding =
        ActivityGameBinding::inflate
    private val viewModel: GameViewModel by viewModels()

    @Inject
    lateinit var animators: Animators

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initView()
        initObservers()
    }

    private fun initObservers() {

        viewModel.apply {

            score.observe(this@GameActivity) {
                animators.animScale(binding.textScore, AnimateType.OUTSIDE)
                updateText(binding.textScore, "Score : $it")
                checkDamageSaleBtn()
            }

            enemyHp.observe(this@GameActivity) {
                if(it < 0) updateText(binding.btnEnemyHp, 0)
                else updateText(binding.btnEnemyHp, it)
            }

            damage.observe(this@GameActivity) {
                updateText(binding.textCurrentDamage, "Damage : $it")
            }

            damagePrice.observe(this@GameActivity) {
                updateText(binding.btnDamageSale, it)
                checkDamageSaleBtn()
            }
        }
    }

    private fun checkDamageSaleBtn() {
        if (viewModel.damagePrice.value!! <= viewModel.score.value!!) binding.btnDamageSale.enabled()
        else binding.btnDamageSale.notEnabled()
    }

    private fun initView() {

        binding.apply {

            btnEnemyHp.setOnClickListener {
                animators.animScale(btnEnemyHp, AnimateType.INSIDE)
                viewModel.updateEnemyHp()
            }

            btnClearScore.setOnClickListener {
                viewModel.clearScore()
                viewModel.cleanDamagePrice()
                viewModel.cleanDamage()
            }

            btnDamageSale.setOnClickListener {
                animators.animScale(binding.btnDamageSale, AnimateType.INSIDE)
                viewModel.damageSale()
            }
        }
    }
}

