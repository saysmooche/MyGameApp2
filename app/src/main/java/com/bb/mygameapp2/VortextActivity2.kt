package com.bb.mygameapp2

import android.os.Bundle
import android.util.Log

class VortextActivity2 : BaseClass() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.vortex2_layout)
        Log.d(VortextActivity2.LOG_TAG, "You Lose!")
    }
    companion object {
        const val LOG_TAG = "TAG_N"
    }
}