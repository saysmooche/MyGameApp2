package com.bb.mygameapp2

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.util.*

class RecycleActivity : AppCompatActivity() {

    private val mScoreList = LinkedList<String>()
    private var mRecyclerView: RecyclerView? = null
    private var mAdapter: RecycleView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.recycle_layout)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        val fab = findViewById<FloatingActionButton>(R.id.fab)
        fab.setOnClickListener {
            val scoreListSize = mScoreList.size
            mScoreList.addLast("+ Score $scoreListSize")
            mRecyclerView!!.adapter!!.notifyItemInserted(scoreListSize)
            mRecyclerView!!.smoothScrollToPosition(scoreListSize)
        }
        for (i in 0..19) {
            mScoreList.addLast("Score $i")
        }
        mRecyclerView = findViewById(R.id.recyclerview)
        mAdapter = RecycleView(this, mScoreList)
        mRecyclerView!!.setAdapter(mAdapter)
        mRecyclerView!!.setLayoutManager(LinearLayoutManager(this))
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        return if (id == R.id.action_settings) {
            true
        } else super.onOptionsItemSelected(item)
    }
}