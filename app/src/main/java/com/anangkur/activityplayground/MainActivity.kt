package com.anangkur.activityplayground

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private val viewModel = MainViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d("ActivityLifecycle", "ini onCreate()")

        findViewById<Button>(R.id.button).setOnClickListener {
            startActivity(Intent(this, ExampleActivity::class.java))
        }

        viewModel.panggilAkuSatuKaliSaja()
    }

    /**
     * function ini akan dipanggil setiap kali user kembali ke activity tersebut
     */
    private fun ambilDataDariServer() {
        for (i in 0 until 100) {
            Log.d("ActivityLifecycle", "data: $i")
        }
    }

    /**
     * function ini akan dipanggil hanya satu kali, setiap kali membuka activity
     */
    private fun panggilAkuSatuKaliSaja() {
        Log.d("ActivityLifecycle", "panggil aku satu kali saja")
    }

    override fun onStart() {
        super.onStart()
        Log.d("ActivityLifecycle", "ini onStart()")
    }

    override fun onResume() {
        super.onResume()

        Log.d("ActivityLifecycle", "ini onResume()")

        ambilDataDariServer()
    }

    override fun onPause() {
        super.onPause()

        Log.d("ActivityLifecycle", "ini onPause()")
    }

    override fun onStop() {
        super.onStop()

        Log.d("ActivityLifecycle", "ini onStop()")
    }

    override fun onDestroy() {
        super.onDestroy()

        Log.d("ActivityLifecycle", "ini onDestroy()")
    }
}