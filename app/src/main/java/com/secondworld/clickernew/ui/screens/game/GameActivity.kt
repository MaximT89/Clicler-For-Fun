package com.secondworld.clickernew.ui.screens.game

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.TextView
import androidx.activity.viewModels
import com.secondworld.clickernew.animations.Animators
import com.secondworld.clickernew.core.BaseActivity
import com.secondworld.clickernew.databinding.ActivityGameBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@SuppressLint("SetTextI18n")
@AndroidEntryPoint
class GameActivity : BaseActivity<ActivityGameBinding>() {

    override val bindingInflater: (LayoutInflater) -> ActivityGameBinding = ActivityGameBinding::inflate
    private val viewModel: GameViewModel by viewModels()

    @Inject
    lateinit var animators: Animators

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initView()
        initObservers()
    }

    private fun initObservers() {
        viewModel.score.observe(this) {
            updateText(binding.testText, it)
        }
    }

    private fun initView() {
        binding.testText.setOnClickListener {
            viewModel.updateScore(1)
            animators.animScale(binding.testText)
        }
    }

    private fun updateText(view: TextView, message: Any) {
        view.text = message.toString()
    }
}