package com.bb.mygameapp2
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView

class FourthActivity : BaseClass() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fourth)
        val redBlock = findViewById<ImageView>(R.id.redBlock)
        val blueBlock = findViewById<ImageView>(R.id.blueBlock)
        val yellowBlock = findViewById<ImageView>(R.id.yellowBlock)
        val androidBlock = findViewById<ImageView>(R.id.androidBlock)
        explodeTransition(this, redBlock)
        fadeTransition(this, blueBlock)
        rotateView(yellowBlock)
        switchAnimation(androidBlock, blueBlock, Intent(
                this, ThirdActivity::class.java), this)
    }

    override fun getVortex2(view: View?) {
        val button12 = findViewById<Button>(R.id.imageView4)
        button12?.setOnClickListener()
        {
            Log.d(BaseClass.LOG_TAG, "Button clicked!")
            val intent = Intent(this, VortextActivity2::class.java)
            startActivity(intent)

        }
    }

    override fun getVortex1(view: View?) {
        val button13 = findViewById<Button>(R.id.imageView11)
        button13?.setOnClickListener()
        {
            Log.d(BaseClass.LOG_TAG, "Button clicked!")
            val intent = Intent(this, VortexActivity::class.java)
            startActivity(intent)
        }
    }

    override fun getScoreR(view: View?) {
        val button14 = findViewById<Button>(R.id.gotorecycle)
        button14?.setOnClickListener()
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