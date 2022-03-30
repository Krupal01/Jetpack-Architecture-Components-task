package com.example.assignment14.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.assignment14.model.StudentModel

@Dao
interface StudentDao {

    @Insert
    suspend fun insertStudent(studentModel: StudentModel)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateStudent(studentModel: StudentModel) : Int

    @Delete
    suspend fun deleteStudent(studentModel: StudentModel) : Int

    @Query("select * from StudentList")
    fun getStudentList() : LiveData<List<StudentModel>>
}