package com.example.assignment14.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "StudentList")
data class StudentModel (

    @PrimaryKey(autoGenerate = true)
    val stuID: Int = 0,

    var stuName: String? = null,
    var stuDOB: String? = null,
    var stuPhone: String? = null,
    var stuMail: String? = null,
    var stuAdd: String? = null,
    var stuGender: String? = null,
    var stuBlood: String? = null,
){

}