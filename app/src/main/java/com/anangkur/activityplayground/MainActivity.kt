package com.anangkur.activityplayground

import android.content.ActivityNotFoundException
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.view.View.OnClickListener
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.ContextCompat
import java.security.Permission
import java.security.Permissions

class MainActivity : AppCompatActivity(), OnClickListener {

    companion object {
        private const val REQUEST_PERMISSION_CALL = 2
        const val EXTRA_STRING = "string"
        const val EXTRA_BUNDLE = "bundle"
        const val EXTRA_INTEGER = "integer"
        const val EXTRA_SERIALIZABLE = "serializable"
        const val EXTRA_PARCELABLE = "parcelable"
    }

    private var button: AppCompatButton? = null
    private var button2: AppCompatButton? = null
    private var button3: AppCompatButton? = null
    private var button4: AppCompatButton? = null
    private var button5: AppCompatButton? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button = findViewById(R.id.button)
        button2 = findViewById(R.id.button_2)
        button3 = findViewById(R.id.button_3)
        button4 = findViewById(R.id.button_4)
        button5 = findViewById(R.id.button_5)

        button?.setOnClickListener(this)
        button2?.setOnClickListener(this)
        button3?.setOnClickListener(this)
        button4?.setOnClickListener(this)
        button5?.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.button -> {
                goToExample()
            }
            R.id.button_2 -> {
                showToast()
            }
            R.id.button_3 -> {
                captureImage()
            }
            R.id.button_4 -> {
                dial()
            }
            R.id.button_5 -> {
                call()
            }
        }
    }

    private fun goToExample() {
        val bundle = Bundle()
        val serializableClass = SerializableClass(
            name = "anang",
            age = 10,
            gender = "male",
        )
        val parcelableClass = ParcelableClass(
            name = "kurniawan",
            age = 20,
            gender = "male",
        )
        bundle.putString(EXTRA_STRING, "anang kurniawan")
        bundle.putInt(EXTRA_INTEGER, 10)
        val intent = Intent(this, ExampleActivity::class.java)
            .putExtra(EXTRA_STRING, "hello world!")
            .putExtra(EXTRA_BUNDLE, bundle)
            .putExtra(EXTRA_SERIALIZABLE, serializableClass)
            .putExtra(EXTRA_PARCELABLE, parcelableClass)
        startActivity(intent)
    }

    private fun showToast() {
        Toast.makeText(this, "ini contoh toast", Toast.LENGTH_SHORT).show()
    }

    private fun captureImage() {
        startActivity(Intent(MediaStore.ACTION_IMAGE_CAPTURE))
    }

    private fun dial() {
        startActivity(Intent(Intent.ACTION_DIAL))
    }

    private fun call() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (
                ContextCompat.checkSelfPermission(
                    this,
                    "android.permission.CALL_PHONE",
                ) == PackageManager.PERMISSION_GRANTED
            ) {
                startActivity(Intent(Intent.ACTION_CALL, Uri.parse("tel:+620000000000")))
            } else {
                requestPermissions(arrayOf("android.permission.CALL_PHONE"), REQUEST_PERMISSION_CALL)
            }
        } else {
            Toast.makeText(this, "hanya berjalan pada android M ke atas", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == REQUEST_PERMISSION_CALL) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                call()
            } else {
                Toast.makeText(this, "izin call harus diberikan!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}