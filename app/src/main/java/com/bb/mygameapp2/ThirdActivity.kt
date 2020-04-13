package com.bb.mygameapp2

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import com.bb.mygameapp2.SecondActivity

class ThirdActivity : BaseClass() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)
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
        val button9 = findViewById<Button>(R.id.imageView4)
        button9?.setOnClickListener()
        {
            Log.d(BaseClass.LOG_TAG, "Button clicked!")
            val intent = Intent(this, VortextActivity2::class.java)
            startActivity(intent)
        }
    }

    override fun getVortex1(view: View?) {
        val button10 = findViewById<Button>(R.id.imageView3)
        button10?.setOnClickListener()
        {
            Log.d(BaseClass.LOG_TAG, "Button clicked!")
            val intent = Intent(this, VortexActivity::class.java)
            startActivity(intent)
        }
    }

    override fun getScoreR(view: View?) {
        val button11 = findViewById<Button>(R.id.gotorecycle)
        button11?.setOnClickListener()
        {
            Log.d(BaseClass.LOG_TAG, "Button clicked!")
            val intent = Intent(this, RecycleActivity::class.java)
            startActivity(intent)
        }
    }

    companion object {
        private const val LOG_TAG = "TAG_N"
    }
}