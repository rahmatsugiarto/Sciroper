package com.binar.sciroper.ui.leaderboard

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import androidx.recyclerview.widget.LinearLayoutManager
import com.binar.sciroper.databinding.ActivityLeaderBoardBinding
import com.binar.sciroper.util.UserLevel
import android.view.WindowManager
import com.binar.sciroper.R


class LeaderBoardActivity : AppCompatActivity(), MainView {
    private lateinit var binding: ActivityLeaderBoardBinding
    private lateinit var presenterMain: PresenterBoard

    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLeaderBoardBinding.inflate(layoutInflater)
        setTheme(R.style.Theme_ActivityLeaerboard)
        setContentView(binding.root)
        presenterMain = PresenterBoard(this)

        presenterMain.getData().observe(this, {
            when {
                it.size <= 1 -> {
                    binding.tvRankSatu.text = UserLevel.sortUsersLevel(it)[0].username
                    binding.rankSatu.setImageResource(UserLevel.sortUsersLevel(it)[0].avatarId)
                    binding.tvRankDua.visibility = View.INVISIBLE
                    binding.tvRankTiga.visibility = View.INVISIBLE
                    binding.ivRank2.visibility = View.INVISIBLE
                    binding.ivRank3.visibility = View.INVISIBLE

                }
                it.size <= 2 -> {
                    binding.tvRankSatu.text = UserLevel.sortUsersLevel(it)[0].username
                    binding.rankSatu.setImageResource(UserLevel.sortUsersLevel(it)[0].avatarId)
                    binding.tvRankDua.text = UserLevel.sortUsersLevel(it)[1].username
                    binding.rankDua.setImageResource(UserLevel.sortUsersLevel(it)[1].avatarId)
                    binding.tvRankTiga.visibility = View.INVISIBLE
                    binding.ivRank3.visibility = View.INVISIBLE
                }
                else -> {
                    binding.tvRankSatu.text = UserLevel.sortUsersLevel(it)[0].username
                    binding.rankSatu.setImageResource(UserLevel.sortUsersLevel(it)[0].avatarId)
                    binding.tvRankDua.text = UserLevel.sortUsersLevel(it)[1].username
                    binding.rankDua.setImageResource(UserLevel.sortUsersLevel(it)[1].avatarId)
                    binding.tvRankTiga.text = UserLevel.sortUsersLevel(it)[2].username
                    binding.rankTiga.setImageResource(UserLevel.sortUsersLevel(it)[2].avatarId)
                }
            }


        })
        presenterMain.getData().observe(this, {
            val recyclerView = binding.rcPlayer
            recyclerView.layoutManager = LinearLayoutManager(this)
            recyclerView.setHasFixedSize(true)
            recyclerView.adapter = AdapterPlayer(UserLevel.sortUsersLevel(it))
            binding.rcPlayer.apply {
                recyclerView.adapter
            }
        })
        binding.btnBack.setOnClickListener {
            onBackPressed()
        }
    }
}


