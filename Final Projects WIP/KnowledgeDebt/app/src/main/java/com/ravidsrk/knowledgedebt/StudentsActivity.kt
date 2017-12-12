package com.ravidsrk.knowledgedebt

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.ravidsrk.knowledgedebt.model.Student
import com.ravidsrk.knowledgedebt.utils.DataFactory.makeStudents


class StudentsActivity : AppCompatActivity() {

    private var students: MutableList<Student>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_students)

        title = "Students List"

        val rvStudents = findViewById<RecyclerView>(R.id.rvStudents)
        students = makeStudents(5)

        val studentsAdapter = StudentsAdapter(students)
        rvStudents.apply {
            adapter = studentsAdapter
            layoutManager = LinearLayoutManager(this@StudentsActivity)
        }

    }
}
