package com.ravidsrk.knowledgedebt

import android.content.Context
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import com.ravidsrk.knowledgedebt.databinding.ActivityStudentDetailsBinding
import com.ravidsrk.knowledgedebt.model.Student

class StudentDetailsActivity : AppCompatActivity() {

    private var student: Student? = null
    private lateinit var binding: ActivityStudentDetailsBinding

    companion object {
        private val EXTRA_STUDENT = "STUDENT"

        fun start(context: Context, student: Student) {
            val starter = Intent(context, StudentDetailsActivity::class.java)
            starter.putExtra(EXTRA_STUDENT, student)
            context.startActivity(starter)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_student_details)

        title = "Student Details"

        student = intent.getParcelableExtra(EXTRA_STUDENT) as Student

        // Before Data Binding

        val textName = findViewById<TextView>(R.id.textName)
        val textAge = findViewById<TextView>(R.id.textAge)
        val textCity = findViewById<TextView>(R.id.textCity)
        val textState = findViewById<TextView>(R.id.textState)
        val textZipCode = findViewById<TextView>(R.id.textZipcode)

        textName.text = student?.name
        textAge.text = student?.age.toString()
        textCity.text = student?.address?.city
        textState.text = student?.address?.state
        textZipCode.text = student?.address?.zipcode

        // After Data Binding

        binding.student = student
    }
}
