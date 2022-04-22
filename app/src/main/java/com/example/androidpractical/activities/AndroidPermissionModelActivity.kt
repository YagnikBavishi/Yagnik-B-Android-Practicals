package com.example.androidpractical.activities

import android.Manifest
import android.Manifest.permission.CALL_PHONE
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.androidpractical.R
import com.example.androidpractical.common_floder.utils.Constants
import com.example.androidpractical.databinding.ActivityAndroidPermissionModelBinding
import com.shashank.sony.fancytoastlib.FancyToast

class AndroidPermissionModelActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAndroidPermissionModelBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAndroidPermissionModelBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAudioPermission.setOnClickListener {
            val permission =
                ContextCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO)
            if (permission != PackageManager.PERMISSION_GRANTED) {
                makeRequestForAudio()
            } else {
                FancyToast.makeText(this, getString(R.string.already_have_audio_permission), FancyToast.LENGTH_SHORT,
                    FancyToast.SUCCESS,false)
                    .show()
            }
        }

        binding.btnAccessLocation.setOnClickListener {
            val permission =
                ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
            if (permission != PackageManager.PERMISSION_GRANTED) {
                makeRequestForLocation()
            } else {
                FancyToast.makeText(this, getString(R.string.already_have_location_permission), FancyToast.LENGTH_SHORT,
                    FancyToast.SUCCESS,false).show()
            }
        }

        binding.btnDialCall.setOnClickListener {
            val intent = Intent(Intent.ACTION_CALL)
            intent.data = Uri.parse(getString(R.string.mobile_number))
            if (ContextCompat.checkSelfPermission(this, CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
                startActivity(intent)
            } else {
                ActivityCompat.requestPermissions(this, arrayOf(CALL_PHONE),Constants.THREE)
            }
        }

        binding.btnChooseFile.setOnClickListener {
            val intent = Intent()
                .setType("*/*")
                .setAction(Intent.ACTION_GET_CONTENT)
            fileChooserLauncher.launch(intent)
        }
    }

    private var fileChooserLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
                val fileLocation = result.data
                val itemPath = fileLocation?.data
                if (fileLocation != null) {
                    Toast.makeText(this, itemPath?.path.toString(), Toast.LENGTH_SHORT).show()
                }
            }
        }

    private fun makeRequestForAudio() {
        ActivityCompat.requestPermissions(
            this,
            arrayOf(Manifest.permission.RECORD_AUDIO),
            Constants.ONE
        )
    }

    private fun makeRequestForLocation() {
        ActivityCompat.requestPermissions(
            this,
            arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
            Constants.TWO
        )
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            Constants.ONE -> showingToast(grantResults.isEmpty() || grantResults[0] != PackageManager.PERMISSION_GRANTED, getString(R.string.audio_message))
            Constants.TWO -> showingToast(grantResults.isEmpty() || grantResults[0] != PackageManager.PERMISSION_GRANTED, getString(R.string.location_message))
            Constants.THREE -> showingToast(grantResults.isEmpty() || grantResults[0] != PackageManager.PERMISSION_GRANTED, getString(R.string.call_message))
        }
    }

    private fun showingToast(checkResult: Boolean, message: String?) {
        if (checkResult) {
           FancyToast.makeText(this, message + getString(R.string.permission_denied_message), FancyToast.LENGTH_SHORT, FancyToast.ERROR,false).show()
        } else {
            FancyToast.makeText(this, message + getString(R.string.permission_granted_message), FancyToast.LENGTH_SHORT, FancyToast.SUCCESS,false).show()
        }
    }
}