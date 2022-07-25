package com.example.musiclit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.inflate
import androidx.fragment.app.Fragment
import com.example.musiclit.databinding.ActivityEnterPageBinding
import com.example.musiclit.databinding.ActivityEnterPageBinding.inflate

class EnterPage : AppCompatActivity() {

    private  lateinit var binding : ActivityEnterPageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(HomeFragment())

        binding.bottomNavigationView.setOnItemReselectedListener {

            when(it.itemId){

                R.id.home-> replaceFragment(HomeFragment())
                R.id.music -> replaceFragment(MusicFragment())
                R.id.setting -> replaceFragment(SettingFragment())

                else ->{

                }
            }
            true
        }

    }

    private fun replaceFragment(fragment: Fragment){

        var fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout, fragment)
        fragmentTransaction.commit()
    }
}