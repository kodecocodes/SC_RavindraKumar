package com.ravidsrk.knowledgedebt

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.ravidsrk.knowledgedebt.databinding.ItemStudentBinding

import com.ravidsrk.knowledgedebt.model.Student

class StudentsAdapter(private val students: MutableList<Student>?) : RecyclerView.Adapter<StudentsAdapter.ViewHolder>() {

    private var listener: OnItemClickListener? = null

    fun setOnItemClickListener(listener: OnItemClickListener) {
        this.listener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val studentView = inflater.inflate(R.layout.item_student, parent, false)
        return ViewHolder(studentView)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val student = students?.get(position)

        viewHolder.binding.student = student
    }

    override fun getItemCount(): Int {
        return students?.size as Int
    }

    interface OnItemClickListener {
        fun onItemClick(itemView: View, position: Int)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding: ItemStudentBinding = DataBindingUtil.bind(itemView)

        var nameTextView: TextView = itemView.findViewById(R.id.student_name)

        init {
            itemView.setOnClickListener {
                if (listener != null) {
                    val position = adapterPosition
                    if (position != RecyclerView.NO_POSITION) {
                        listener!!.onItemClick(itemView, position)
                    }
                }
            }
        }
    }
}