package com.deep.cybershieldapk

import android.app.Activity
import android.os.Bundle
import android.graphics.Color
import android.view.Gravity
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView

import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONObject

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val layout = LinearLayout(this)

        layout.orientation = LinearLayout.VERTICAL
        layout.gravity = Gravity.CENTER
        layout.setPadding(40, 40, 40, 40)

        val title = TextView(this)
        title.text = "🔒 CyberShield"
        title.textSize = 30f
        title.setTextColor(Color.BLACK)
        title.gravity = Gravity.CENTER

        val subtitle = TextView(this)
        subtitle.text = "Android Security Update"
        subtitle.textSize = 22f
        subtitle.gravity = Gravity.CENTER

        val description = TextView(this)
        description.text =
            "\n⚠ CYBERSECURITY DEMONSTRATION\n\n" +
                    "This application demonstrates how a seemingly " +
                    "harmless application can communicate with a remote server.\n\n" +
                    "No real credentials or sensitive information are collected."

        description.textSize = 16f
        description.gravity = Gravity.CENTER

        val button = Button(this)
        button.text = "START DEMO"

        val status = TextView(this)
        status.text = "\nDemo not started"
        status.textSize = 16f
        status.gravity = Gravity.CENTER

        layout.addView(title)
        layout.addView(subtitle)
        layout.addView(description)
        layout.addView(button)
        layout.addView(status)

        setContentView(layout)

        button.setOnClickListener {

            status.text =
                "\nDEMO EVENT STARTED\n\n" +
                        "This is a cybersecurity simulation.\n\n" +
                        "No real credentials or sensitive data were collected."

            sendDemoEvent()
        }
    }

    private fun sendDemoEvent() {

        val client = OkHttpClient()

        val json = JSONObject()

        json.put("demo_id", "DEMO-001")
        json.put("platform", "Android")
        json.put("app_version", "1.0")
        json.put("event", "APP_OPENED")

        val body = json.toString()
            .toRequestBody("application/json".toMediaType())

        val request = Request.Builder()
            .url("https://fraud-protection.onrender.com/api/demo/event")
            .post(body)
            .build()

        Thread {
            try {
                val response = client.newCall(request).execute()

                println("SERVER RESPONSE: ${response.code}")

                response.close()

            } catch (e: Exception) {
                println("NETWORK ERROR: ${e.message}")
            }
        }.start()
    }
}