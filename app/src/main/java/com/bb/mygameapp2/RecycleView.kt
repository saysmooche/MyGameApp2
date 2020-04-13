package com.bb.mygameapp2

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bb.mygameapp2.R
import com.bb.mygameapp2.RecycleView.ScoreViewHolder
import java.util.*

class RecycleView(context: Context?, scoreList: LinkedList<String>) : RecyclerView.Adapter<ScoreViewHolder>() {
    private val mScoreList: LinkedList<String>
    private val mInflater: LayoutInflater

    inner class ScoreViewHolder(itemView: View, adapter: RecycleView) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        val scoreItemView: TextView
        val mAdapter: RecycleView
        override fun onClick(view: View) {
            val mPosition = layoutPosition
            val element = mScoreList[mPosition]
            mScoreList[mPosition] = "Clicked! $element"
            mAdapter.notifyDataSetChanged()
        }

        init {
            scoreItemView = itemView.findViewById(R.id.word)
            mAdapter = adapter
            itemView.setOnClickListener(this)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): ScoreViewHolder {
        val mItemView = mInflater.inflate(
                R.layout.score_layout, parent, false)
        return ScoreViewHolder(mItemView, this)
    }

    override fun onBindViewHolder(holder: ScoreViewHolder,
                                  position: Int) {
        val mCurrent = mScoreList[position]
        holder.scoreItemView.text = mCurrent
    }

    override fun getItemCount(): Int {
        return mScoreList.size
    }

    init {
        mInflater = LayoutInflater.from(context)
        mScoreList = scoreList
    }
}