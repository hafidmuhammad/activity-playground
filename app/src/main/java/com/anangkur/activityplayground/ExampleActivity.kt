package com.anangkur.activityplayground

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatTextView

class ExampleActivity : AppCompatActivity() {

    private var textIntent: AppCompatTextView? = null
    private var textBundle: AppCompatTextView? = null
    private var textSerializable: AppCompatTextView? = null
    private var textParcelable: AppCompatTextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_example)

        textIntent = findViewById(R.id.text_intent)
        textBundle = findViewById(R.id.text_bundle)
        textSerializable = findViewById(R.id.text_serializable)
        textParcelable = findViewById(R.id.text_parcelable)

        val string = intent?.getStringExtra(MainActivity.EXTRA_STRING)
        val bundle = intent?.getBundleExtra(MainActivity.EXTRA_BUNDLE)
        val serializable = intent?.getSerializableExtra(MainActivity.EXTRA_SERIALIZABLE) as SerializableClass
        val parcelable = intent?.getParcelableExtra<ParcelableClass>(MainActivity.EXTRA_PARCELABLE)

        textIntent?.text = string
        textBundle?.text = "${bundle?.getString(MainActivity.EXTRA_STRING)} ${bundle?.getInt(MainActivity.EXTRA_INTEGER)}"
        textSerializable?.text = "${serializable.name} - ${serializable.age} - ${serializable.gender}"
        textParcelable?.text = "${parcelable?.name} - ${parcelable?.age} - ${parcelable?.gender}"
    }
}