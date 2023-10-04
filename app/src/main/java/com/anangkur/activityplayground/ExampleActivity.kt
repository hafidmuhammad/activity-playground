package com.anangkur.activityplayground

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class ExampleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_example)
    }

    override fun onStart() {
        super.onStart()
        Log.d("ActivityLifecycle", "ini onStart()")
    }

    override fun onResume() {
        super.onResume()

        Log.d("ActivityLifecycle", "ini onResume()")

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