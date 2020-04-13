package com.bb.mygameapp2

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView

class MainActivity : BaseClass() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val redBlock = findViewById<ImageView>(R.id.redBlock)
        val blueBlock = findViewById<ImageView>(R.id.blueBlock)
        val yellowBlock = findViewById<ImageView>(R.id.yellowBlock)
        val androidBlock = findViewById<ImageView>(R.id.androidBlock)
        explodeTransition(this, redBlock)
        fadeTransition(this, blueBlock)
        rotateView(yellowBlock)
        switchAnimation(androidBlock, blueBlock, Intent(
                this, SecondActivity::class.java), this)
    }

    override fun getVortex2(view: View?) {
        val button4 = findViewById<Button>(R.id.imageView)
        button4?.setOnClickListener()
        {
            Log.d(BaseClass.LOG_TAG, "Button clicked!")
            val intent = Intent(this, VortextActivity2::class.java)
            startActivity(intent)
        }
    }

    override fun getVortex1(view: View?) {
        val button5 = findViewById<Button>(R.id.imageView7)
        button5?.setOnClickListener()
        {
            Log.d(BaseClass.LOG_TAG, "Bzzzzzzz 1000 points")
            val intent = Intent(this, VortexActivity::class.java)
            startActivity(intent)
        }
    }

    override fun getScoreR(view: View?) {
        val button6 = findViewById<Button>(R.id.gotorecycle)
        button6?.setOnClickListener()
        {
            Log.d(BaseClass.LOG_TAG, "Bzzzzzzz 1000 points!")
            val intent = Intent(this, RecycleActivity::class.java)
            startActivity(intent)
        }
    }

    companion object {
        private const val LOG_TAG = "TAG_N"
    }
}