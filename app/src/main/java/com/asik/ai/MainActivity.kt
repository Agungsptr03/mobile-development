package com.asik.ai

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.asik.ai.fragments.ChatbotFragment
import com.asik.ai.fragments.FileFragment
import com.asik.ai.fragments.HomeFragment
import com.asik.ai.fragments.ProfileFragment
import com.qamar.curvedbottomnaviagtion.CurvedBottomNavigation

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigation = findViewById<CurvedBottomNavigation>(R.id.bottomNavigation)
        bottomNavigation.add(
            CurvedBottomNavigation.Model(1,"Home",R.drawable.ic_home)
        )
        bottomNavigation.add(
            CurvedBottomNavigation.Model(2,"Add File",R.drawable.ic_attach_file)
        )
        bottomNavigation.add(
            CurvedBottomNavigation.Model(3,"Chatbot",R.drawable.ic_chatbot)
        )
        bottomNavigation.add(
            CurvedBottomNavigation.Model(4,"Profile",R.drawable.ic_profile)
        )

        bottomNavigation.setOnClickMenuListener {
            when(it.id){
                1 -> {
                    replaceFragment(HomeFragment())
                }
                2 -> {
                    replaceFragment(FileFragment())
                }
                3 -> {
                    replaceFragment(ChatbotFragment())
                }
                4 -> {
                    replaceFragment(ProfileFragment())
                }
            }
        }

        // default Bottom Tab Selected
        replaceFragment(HomeFragment())
        bottomNavigation.show(2)
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragmentContainer,fragment)
            .commit()
    }
}
