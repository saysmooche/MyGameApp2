package com.bb.mygameapp2

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.app.ActivityOptions
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.transition.Explode
import android.transition.Fade
import android.transition.Slide
import android.util.Log
import android.util.Pair
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

abstract class BaseClass : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val button3 = findViewById<Button>(R.id.gotorecycle)

        if (intent.hasExtra(TRANSITION_TYPE)) {
            when (intent.getStringExtra(TRANSITION_TYPE)) {
                "Explode" -> window.enterTransition = Explode()
                "Slide" -> window.enterTransition = Slide()
                "Fade" -> window.enterTransition = Fade()
                else -> {
                }
            }
        }
    }

    protected fun explodeTransition(context: Context,
                                    imageView: ImageView) {
        imageView.setOnClickListener { // Relaunch the activity with the transition information.
            val intent = Intent(context, context.javaClass)
            intent.putExtra(TRANSITION_TYPE, "Explode")
            window.exitTransition = Explode()
            startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(
                    context as AppCompatActivity).toBundle())
        }
    }

    protected fun fadeTransition(context: Context, imageView: ImageView) {
        imageView.setOnClickListener {
            val intent = Intent(context, context.javaClass)
            intent.putExtra(TRANSITION_TYPE, "Fade")
            window.exitTransition = Fade()
            startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(
                    context as AppCompatActivity).toBundle())
        }
    }

    protected fun rotateView(imageView: ImageView) {
        val animator = ObjectAnimator.ofFloat(
                imageView, View.ROTATION, 0f, 360f)
        animator.duration = 1000
        animator.repeatMode = ValueAnimator.REVERSE
        animator.repeatCount = 1
        imageView.setOnClickListener { animator.start() }
    }

    protected fun switchAnimation(androidImage: ImageView,
                                  otherImage: ImageView?,
                                  intent: Intent?,
                                  context: Context?) {
        androidImage.setOnClickListener {
            val options = ActivityOptions
                    .makeSceneTransitionAnimation(context as AppCompatActivity?,
                            Pair.create(androidImage as View,
                                    ANDROID_TRANSITION),
                            Pair.create(otherImage as View?,
                                    BLUE_TRANSITION))
            startActivity(intent, options.toBundle())
        }
    }

    open fun getVortex2(view: View?) {
        val button = findViewById<Button>(R.id.imageView)
        button?.setOnClickListener()
        {
            Log.d(LOG_TAG, "Button clicked!")
            val intent = Intent(this, VortextActivity2::class.java)
            startActivity(intent)
        }
    }

    open fun getVortex1(view: View?) {
        val button2 = findViewById<Button>(R.id.imageView7)
        button2?.setOnClickListener()
        {
            Log.d(LOG_TAG, "Button clicked!")
            val intent = Intent(this, VortexActivity::class.java)
            startActivity(intent)

        }
    }

    open fun getScoreR(view: View?) {
        val button3 = findViewById<Button>(R.id.gotorecycle)
        button3?.setOnClickListener()
        {
            Log.d(LOG_TAG, "Button clicked!")
            val intent = Intent(this, RecycleActivity::class.java)
            startActivity(intent)
        }
    }

    companion object {
        private const val TRANSITION_TYPE = "Transition Type"
        private const val ANDROID_TRANSITION = "switchAndroid"
        private const val BLUE_TRANSITION = "switchBlue"
        const val LOG_TAG = "TAG_N"
        val TEXT_REQUEST = 1
        val EXTRA_MESSAGE = "Vortex"
}

    fun launchVortexActivity(view:View) {
        Log.d(LOG_TAG, "Button clicked!")
        val intent = Intent(this, VortexActivity::class.java)
        startActivityForResult(intent, TEXT_REQUEST)
    }

//    private fun onActivityResult(requestCode:Int, resultCode:Int) {
//        super.onActivityResult(requestCode, resultCode)
//        if (requestCode == TEXT_REQUEST)
//        {
//            if (resultCode == RESULT_OK)
//            {
//                Log.d(LOG_TAG, "Score!")
//            }
//        }
}