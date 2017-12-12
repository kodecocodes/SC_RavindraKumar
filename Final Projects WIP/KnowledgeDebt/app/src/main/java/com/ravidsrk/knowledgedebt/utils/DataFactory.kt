package com.ravidsrk.knowledgedebt.utils

import com.ravidsrk.knowledgedebt.model.Address
import com.ravidsrk.knowledgedebt.model.Student

import java.util.ArrayList
import java.util.Random

object DataFactory {

    private val names = arrayOf("Saket", "Arun", "Garima", "Vinay", "Adit", "Gompa", "Ritesh", "Manish", "Abhilasha", "Pari", "Kumar", "Ravindra")
    private val ages = intArrayOf(25, 34, 26, 43, 23)

    fun makeStudents(numberOfStudents: Int): MutableList<Student>? {
        val students = ArrayList<Student>()

        for (i in 0 until numberOfStudents) {
            students.add(makeStudent())
        }
        return students
    }

    private fun makeStudent(): Student {
        val nameRandom = Random()
        val ageRandom = Random()
        val nameIndex = nameRandom.nextInt(names.size)
        val ageIndex = ageRandom.nextInt(ages.size)

        return Student(names[nameIndex], ages[ageIndex], makeAddress())
    }

    private fun makeAddress(): Address {
        return Address("Bangalore", "Karnataka", "56001")
    }
}
