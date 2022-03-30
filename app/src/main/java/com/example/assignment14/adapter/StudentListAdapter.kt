package com.example.assignment14.adapter

import android.content.Context
import android.content.DialogInterface
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.assignment14.R
import com.example.assignment14.databinding.RowItemStudentBinding
import com.example.assignment14.model.StudentModel
import com.example.assignment14.viewmodel.RoomViewModel

class StudentListAdapter(private var viewModel: RoomViewModel , private var context: Context) : RecyclerView.Adapter<StudentListAdapter.StudentViewHolder>() {

    private var studentList = ArrayList<StudentModel>()

    fun submitData(students : List<StudentModel>){
        this.studentList = students as ArrayList<StudentModel>
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        var binding = RowItemStudentBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return StudentViewHolder(binding)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        holder.bind(studentList[position],viewModel , context)
    }

    override fun getItemCount(): Int {
        return studentList.size
    }

    class StudentViewHolder(private var binding : RowItemStudentBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(studentModel: StudentModel, viewModel: RoomViewModel, context: Context){
            binding.student = studentModel
            binding.itemDelet.setOnClickListener {
                val builder = AlertDialog.Builder(context)
                builder.setTitle(context.getString(R.string.delete))
                builder.setMessage(context.getString(R.string.delete_message))
                builder.setPositiveButton(context.getString(R.string.yes)){
                        dialog,
                        which -> viewModel.deleteStudent(studentModel)
                    }
                builder.setNegativeButton(context.getString(R.string.no)){
                    dialog,which -> dialog.dismiss()
                }
                var alertDialogDelete = builder.create()
                alertDialogDelete.show()

            }
            binding.itemEdit.setOnClickListener {
                viewModel.setStudentData(studentModel)
                viewModel.isAddRequest.value = false
                Navigation.findNavController(binding.root).navigate(R.id.action_studentListFragment_to_student_Add_Update_Fragment)
            }
        }
    }
}