package com.kbyai.iddetect

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.content.res.AssetManager
import android.os.Bundle
import android.util.Log
import android.util.Size
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import io.fotoapparat.Fotoapparat
import io.fotoapparat.parameter.Resolution
import io.fotoapparat.preview.Frame
import io.fotoapparat.preview.FrameProcessor
import io.fotoapparat.selector.front
import io.fotoapparat.selector.back
import io.fotoapparat.view.CameraView
import com.kbyai.iddetectsdk.IDBox
import com.kbyai.iddetectsdk.IDDetectSDK

class CameraActivityKt : AppCompatActivity() {

    val TAG = "IDCapture"
    val PREVIEW_WIDTH = 720
    val PREVIEW_HEIGHT = 1280

    private lateinit var cameraView: CameraView
    private lateinit var faceView: FaceView
    private lateinit var initView: TextView
    private lateinit var fotoapparat: Fotoapparat
    private lateinit var context: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_camera_kt)

        context = this
        cameraView = findViewById(R.id.preview)
        faceView = findViewById(R.id.faceView)
        initView = findViewById(R.id.initView)

//        initView.setVisibility(View.VISIBLE)
//        initView.setText("Demo")

        var ret = IDDetectSDK.setActivation(
            "e6vgsnSe/CxXxzHoH25Ko8WGPXPd7qAWKfoB1QgavVD9UYQI947I6kk70EQleiUcPtZxtvxroaX9\n" +
                    "Z32Rm116Lw8K5qOk8DS/06j0Pt+sZYKye2xlQAbtXLqLSytXCyvqXXfOj0v6J/elDJV1J1P1mJ2n\n" +
                    "IbxpwnghpMKjZ/n/tPJOvyRagvqJedo/iLnzfOFcEcAKUg9pCOzaM/wVICPZKJv8f5KreU6DVSq0\n" +
                    "i40NTaKKYqP3MQwM42aQtbxk2wloL9VgHV87flyN+xDi9oG5ZbNaNd4dcVltq5sjxB6bmUWgMnxH\n" +
                    "5l6OEEFaegfqWAioHTATRGZ9/nuNup4aHTRAtA=="
        )

        if (ret == IDDetectSDK.SDK_SUCCESS) {
            ret = IDDetectSDK.init(assets)
        }

        if (ret != IDDetectSDK.SDK_SUCCESS) {
            initView.setVisibility(View.VISIBLE)
            if (ret == IDDetectSDK.SDK_LICENSE_KEY_ERROR) {
                initView.setText("Invalid license!")
            } else if (ret == IDDetectSDK.SDK_LICENSE_APPID_ERROR) {
                initView.setText("Invalid error!")
            } else if (ret == IDDetectSDK.SDK_LICENSE_EXPIRED) {
                initView.setText("License expired!")
            } else if (ret == IDDetectSDK.SDK_NO_ACTIVATED) {
                initView.setText("No activated!")
            } else if (ret == IDDetectSDK.SDK_INIT_ERROR) {
                initView.setText("Init error!")
            }
        }
//        val loadingState: Int = IDDetectSDK.init(assets)
//        Log.e(TAG, "Model Loaded Successfully: ${loadingState}")
        fotoapparat = Fotoapparat.with(this)
            .into(cameraView)
            .lensPosition(back())
            .frameProcessor(FaceFrameProcessor())
            .previewResolution { Resolution(PREVIEW_HEIGHT,PREVIEW_WIDTH) }
            .build()

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
            == PackageManager.PERMISSION_DENIED
        ) {
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CAMERA), 1)
        } else {
            fotoapparat.start()
        }
    }

    override fun onResume() {
        super.onResume()
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
            == PackageManager.PERMISSION_GRANTED
        ) {
            val out: Int = IDDetectSDK.init(assets)
            fotoapparat.start()
        }
    }

    override fun onPause() {
        super.onPause()
        fotoapparat.stop()
//        faceView.setFaceBoxes(null)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String?>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 1) {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
                == PackageManager.PERMISSION_GRANTED
            ) {
                fotoapparat.start()
            }
        }
    }

    inner class FaceFrameProcessor : FrameProcessor {

        override fun process(frame: Frame) {
            val idBoxes = IDDetectSDK.idDetect(frame.image, frame.size.width, frame.size.height, frame.rotation);
            runOnUiThread {
                faceView.setFrameSize(Size(frame.size.height, frame.size.width))
                faceView.setFaceBoxes(idBoxes)
            }
        }
    }
}