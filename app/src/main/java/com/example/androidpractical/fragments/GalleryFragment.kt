package com.example.androidpractical.fragments

import android.app.Activity.RESULT_OK
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.example.androidpractical.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class GalleryFragment : Fragment() {

    private var imageUri: Uri? = null
    private lateinit var uriToOpen: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val view: View = inflater.inflate(R.layout.fragment_gallery, container, false)

        val btnOpenGallery: FloatingActionButton = view.findViewById(R.id.btnGallery)
        val btnOpenCamera: FloatingActionButton = view.findViewById(R.id.btnCamera)
        val btnOpenLink: Button = view.findViewById(R.id.btnOpenLink)
        val etOpenLink: TextView = view.findViewById(R.id.etForWebsite)
        val tvAddGallery: TextView = view.findViewById(R.id.tvAddGallery)
        val tvAddCamera: TextView = view.findViewById(R.id.tvAddCamera)
        val addFloatingActionButton: FloatingActionButton = view.findViewById(R.id.btnAdd)

        var isAllFloatingButtonVisible: Boolean
        btnOpenGallery.visibility = View.GONE
        btnOpenCamera.visibility = View.GONE
        tvAddGallery.visibility = View.GONE
        tvAddCamera.visibility = View.GONE
        isAllFloatingButtonVisible = false
        addFloatingActionButton.setOnClickListener(
            View.OnClickListener {
                if (!isAllFloatingButtonVisible) {
                    btnOpenGallery.show()
                    btnOpenCamera.show()
                    tvAddGallery.visibility = View.VISIBLE
                    tvAddCamera.visibility = View.VISIBLE
                    isAllFloatingButtonVisible = true
                } else {
                    btnOpenGallery.hide()
                    btnOpenCamera.hide()
                    tvAddGallery.visibility = View.GONE
                    tvAddCamera.visibility = View.GONE
                    isAllFloatingButtonVisible = false
                }
            })
        btnOpenCamera.setOnClickListener {
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            cameraLauncher.launch(intent)
        }

        btnOpenGallery.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
            galleryLauncher.launch(intent)
        }

        btnOpenLink.setOnClickListener {
            uriToOpen = etOpenLink.text.toString().trim()
            if (uriToOpen.isNotEmpty()) {
                if (Patterns.WEB_URL.matcher(uriToOpen).matches()) {
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(uriToOpen))
                    startActivity(intent)
                }
            } else {
                Toast.makeText(activity, getString(R.string.enter_proper_url), Toast.LENGTH_SHORT).show()
            }
        }
        return view
    }

    private var galleryLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
                val intent = result.data
                imageUri = intent?.data
                val imageView: ImageView = requireView().findViewById(R.id.ivImage)
                imageView.setImageURI(imageUri)
            }
        }

    private var cameraLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
                handleCameraImage(result.data)
            }
        }

    private fun handleCameraImage(intent: Intent?) {
        val bitmap = intent?.extras?.get(getString(R.string.intent_data)) as Bitmap
        val imageView: ImageView = requireView().findViewById(R.id.ivImage)
        imageView.setImageBitmap(bitmap)
    }
}