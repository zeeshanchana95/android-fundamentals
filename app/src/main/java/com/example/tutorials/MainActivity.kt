package com.example.tutorials
import android.Manifest
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.pm.PackageManager
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

class MainActivity : AppCompatActivity() {

    val CHANNEL_ID = "channelID"
    val CHANNEL_NAME = "channelName"
    val NOTIFICATION_ID = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val btnShowNotification = findViewById<Button>(R.id.btnShowNotification)

        createNotificationChannel()

        val notification = NotificationCompat.Builder(this, CHANNEL_ID)
            .setContentTitle("Awesome Notification")
            .setContentText("This is the notification description")
            .setSmallIcon(R.drawable.ic_home)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .build()

        val notificationManager = NotificationManagerCompat.from(this)
        btnShowNotification.setOnClickListener {
           if (ActivityCompat.checkSelfPermission(
                   this,
                   Manifest.permission.POST_NOTIFICATIONS
               ) != PackageManager.PERMISSION_GRANTED
           ) {
               // TODO: Consider calling
               //    ActivityCompat#requestPermissions
               // here to request the missing permissions, and then overriding
               //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
               //                                          int[] grantResults)
               // to handle the case where the user grants the permission. See the documentation
               // for ActivityCompat#requestPermissions for more details.
           }
            notificationManager.notify(NOTIFICATION_ID, notification)
        }
    }


    fun createNotificationChannel() {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(CHANNEL_ID, CHANNEL_NAME,
                NotificationManager.IMPORTANCE_DEFAULT).apply {
                    lightColor = Color.GREEN
                enableLights(true)
            }
            val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            manager.createNotificationChannel(channel)

        }
    }



}