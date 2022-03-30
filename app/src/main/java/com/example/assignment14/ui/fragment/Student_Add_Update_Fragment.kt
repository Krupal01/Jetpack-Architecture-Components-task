package com.example.assignment14.ui.fragment

import android.app.DatePickerDialog
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.assignment14.R
import com.example.assignment14.databinding.FragmentStudentAddUpdateBinding
import com.example.assignment14.viewmodel.RoomViewModel
import com.example.assignment14.viewmodel.RoomViewModelFactory
import java.text.SimpleDateFormat
import java.util.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Student_Add_Update_Fragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class Student_Add_Update_Fragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    private lateinit var binding: FragmentStudentAddUpdateBinding
    private lateinit var viewModel: RoomViewModel
    private val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"
    private var calendar = Calendar.getInstance()
    private var datePickerListener: DatePickerDialog.OnDateSetListener? = null
    private val dataFormat = SimpleDateFormat("dd/MM/yyyy", Locale.UK)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentStudentAddUpdateBinding.inflate(layoutInflater)
        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.etStudentDob.setOnClickListener {
            DatePickerDialog(
                requireContext(),
                { _, year, monthOfYear, dayOfMonth ->
                    calendar.set(Calendar.YEAR, year)
                    calendar.set(Calendar.MONTH, monthOfYear)
                    calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                    viewModel.stuDOB.setValue(dataFormat.format(calendar.time))
                },
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)
            ).show()
        }

            binding.lifecycleOwner = requireActivity()
            viewModel = ViewModelProvider(
                requireActivity(),
                RoomViewModelFactory(requireContext())
            )[RoomViewModel::class.java]

            binding.viewModel = viewModel

            binding.btnSubmit.setOnClickListener {
                if (dataValid()){
                    if (viewModel.isAddRequest.value!!) {
                        viewModel.insertStudent()
                    } else {
                        viewModel.updateStudent()
                    }
                    requireActivity().onBackPressed()
                }
            }

    }

    private fun dataValid(): Boolean {
        when {
            (viewModel.stuName.value!!.isEmpty()) -> {
                binding.etStudentName.error = getString(R.string.error_name)
                binding.etStudentName.requestFocus()
                return false
            }
            ((viewModel.stuPhone.value!!.isEmpty())||(viewModel.stuPhone.value!!.length != 10)) -> {
                binding.etStudentContact.error = getString(R.string.error_phone_number)
                binding.etStudentContact.requestFocus()
                return false
            }
            ((!viewModel.stuMail.value!!.matches(emailPattern.toRegex()))||(viewModel.stuMail.value!!.isEmpty())) -> {
                binding.etStudentMail.error = getString(R.string.error_email_valid)
                binding.etStudentMail.requestFocus()
                return false
            }
            (viewModel.stuAdd.value!!.isEmpty()) -> {
                binding.etStudentAddress.error = getString(R.string.error_address)
                binding.etStudentAddress.requestFocus()
                return false
            }
            (viewModel.stuDOB.value!!.isEmpty()) -> {
                binding.etStudentDob.error = getString(R.string.error_DOB)
                binding.etStudentDob.requestFocus()
                return false
            }
            (viewModel.selectedBloodItem.value == 0) -> {
                binding.tvBloodgrp.error = getString(R.string.error_blood)
                return false
            }
        }
        return true
    }

    companion object {
            /**
             * Use this factory method to create a new instance of
             * this fragment using the provided parameters.
             *
             * @param param1 Parameter 1.
             * @param param2 Parameter 2.
             * @return A new instance of fragment Student_Add_Update_Fragment.
             */
            // TODO: Rename and change types and number of parameters
            @JvmStatic
            fun newInstance(param1: String, param2: String) =
                Student_Add_Update_Fragment().apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM1, param1)
                        putString(ARG_PARAM2, param2)
                    }
                }
        }
}
