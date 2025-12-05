package com.example.projectedulab

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.fragment.app.Fragment

class ProfileFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val imgProfile = view.findViewById<ImageView>(R.id.imgProfile)
        val edtNama = view.findViewById<EditText>(R.id.edtNama)
        val edtEmail = view.findViewById<EditText>(R.id.edtEmail)
        val edtPhone = view.findViewById<EditText>(R.id.edtPhone)
        val radioGender = view.findViewById<RadioGroup>(R.id.radioGender)
        val rbLaki = view.findViewById<RadioButton>(R.id.rbLaki)
        val rbPerempuan = view.findViewById<RadioButton>(R.id.rbPerempuan)

        // Isi contoh data
        edtNama.setText("User Edulab")
        edtEmail.setText("user@example.com")
        edtPhone.setText("08123456789")
        rbLaki.isChecked = true
    }
}
