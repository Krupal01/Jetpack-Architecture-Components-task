package com.example.assignment14.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.assignment14.R
import com.example.assignment14.db.RoomInstance
import com.example.assignment14.db.StudentDao
import com.example.assignment14.model.StudentModel
import kotlinx.coroutines.launch

class RoomViewModel(private val context: Context) : ViewModel() {

    private var roomInstance: RoomInstance = RoomInstance.getDatabase(context)!!
    private var studentDao: StudentDao = roomInstance.getStudentDao()

    var stuId = MutableLiveData<Int>()
    var stuName = MutableLiveData<String>("")
    var stuDOB= MutableLiveData<String>("")
    var stuPhone= MutableLiveData<String>("")
    var stuMail= MutableLiveData<String>("")
    var stuAdd= MutableLiveData<String>("")
    var stuGender= ""
    var stuBlood= MutableLiveData<String>("")
    var selectedBloodItem = MutableLiveData<Int>()



    var studentModel = MutableLiveData<StudentModel>()
    var isAddRequest = MutableLiveData<Boolean>(true)
    private lateinit var studentList : LiveData<List<StudentModel>>



    fun insertStudent(){
        viewModelScope.launch {
            studentDao.insertStudent(StudentModel(0,
                stuName.value,
                stuDOB.value,
                stuPhone.value,
                stuMail.value,
                stuAdd.value,
                stuGender,
                stuBlood.value))
        }
    }

    fun updateStudent(){
        viewModelScope.launch {
            studentDao.updateStudent(StudentModel(
                    stuId.value?:0,
                    stuName.value,
                    stuDOB.value,
                    stuPhone.value,
                    stuMail.value,
                    stuAdd.value,
                    stuGender,
                    stuBlood.value
                )
            )
        }
    }

    fun deleteStudent(studentModel: StudentModel){
        viewModelScope.launch {
            studentDao.deleteStudent(studentModel)
        }
    }

    fun getStudentList() : LiveData<List<StudentModel>>{
        studentList = studentDao.getStudentList()
        return studentList
    }

    fun resetViewModelData(){
        stuId.value = 0
        stuName.value = ""
        stuDOB.value = ""
        stuPhone.value = ""
        stuMail.value = ""
        stuAdd.value = ""
        stuGender = ""
        selectedBloodItem.value = 0
    }

    fun setStudentData(studentModel: StudentModel){
        stuId.value = studentModel.stuID!!
        stuName.value = studentModel.stuName!!
        stuDOB.value = studentModel.stuDOB!!
        stuPhone.value = studentModel.stuPhone!!
        stuMail.value = studentModel.stuMail!!
        stuGender = studentModel.stuGender!!
        stuBlood.value = studentModel.stuBlood!!
        selectedBloodItem.value = context.resources.getStringArray(R.array.blood_group_type).asList().indexOf(stuBlood.value)
    }

    init {
        selectedBloodItem.observeForever {
            stuBlood.value = context.resources.getStringArray(R.array.blood_group_type)[it]
        }
    }
}