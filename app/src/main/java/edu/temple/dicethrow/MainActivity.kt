package edu.temple.dicethrow

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragment1 = DieFragment.newInstance(20)
        val fragment2 = DieFragment.newInstance(10)


        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragmentContainerView,fragment1)
            .replace(R.id.fragmentContainerView3,fragment2)
            .commit()

        findViewById<Button>(R.id.rollDiceButton).apply{

            setOnClickListener {
                (supportFragmentManager
                    .findFragmentById(R.id.fragmentContainerView) as DieFragment)
                    .throwDie()
                (supportFragmentManager
                    .findFragmentById(R.id.fragmentContainerView3) as DieFragment)
                    .throwDie()
            }
        }
    }
}