package com.example.projectedulab

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Base64
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import java.io.ByteArrayOutputStream

class ProfileFragment : Fragment() {

    private lateinit var imgProfile: ImageView
    private lateinit var btnPick: Button
    private lateinit var edtNama: EditText
    private lateinit var edtEmail: EditText
    private lateinit var edtHp: EditText
    private lateinit var rbLaki: RadioButton
    private lateinit var rbPerempuan: RadioButton

    private val PICK_IMAGE = 1

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        imgProfile = view.findViewById(R.id.imgProfile)
        btnPick = view.findViewById(R.id.btnPickImage)
        edtNama = view.findViewById(R.id.edtNama)
        edtEmail = view.findViewById(R.id.edtEmail)
        edtHp = view.findViewById(R.id.edtHp)
        rbLaki = view.findViewById(R.id.rbLaki)
        rbPerempuan = view.findViewById(R.id.rbPerempuan)

        // Load data profil yang tersimpan
        loadProfile()

        // Button pilih gambar
        btnPick.setOnClickListener {
            pickImage()
        }
    }

    private fun pickImage() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent, PICK_IMAGE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == PICK_IMAGE && resultCode == Activity.RESULT_OK) {
            val imageUri: Uri? = data?.data

            val bitmap = MediaStore.Images.Media.getBitmap(requireActivity().contentResolver, imageUri)
            imgProfile.setImageBitmap(bitmap)

            saveImageToSharedPreferences(bitmap)
        }
    }

    private fun saveImageToSharedPreferences(bitmap: Bitmap) {
        val sharedPref = requireContext().getSharedPreferences("userProfile", Context.MODE_PRIVATE)
        val editor = sharedPref.edit()

        val byteArrayOutputStream = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream)
        val byteArray = byteArrayOutputStream.toByteArray()

        val encodedImage = Base64.encodeToString(byteArray, Base64.DEFAULT)

        editor.putString("profileImage", encodedImage)
        editor.apply()
    }

    private fun loadProfile() {
        val sharedPref = requireContext().getSharedPreferences("userProfile", Context.MODE_PRIVATE)

        val encodedImage = sharedPref.getString("profileImage", null)

        if (encodedImage != null) {
            val byteArray = Base64.decode(encodedImage, Base64.DEFAULT)
            val bitmap = android.graphics.BitmapFactory.decodeByteArray(byteArray, 0, byteArray.size)
            imgProfile.setImageBitmap(bitmap)
        }
    }
}
