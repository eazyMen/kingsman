package ru.amria.kingman.ui.ar

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.snap.camerakit.Session
import com.snap.camerakit.invoke
import com.snap.camerakit.lenses.LensesComponent
import com.snap.camerakit.lenses.whenHasFirst
import com.snap.camerakit.support.camerax.CameraXImageProcessorSource
import com.snap.camerakit.supported
import ru.amria.kingman.R

class ArActivity : AppCompatActivity(R.layout.activity_main) {

    private lateinit var cameraKitSession: Session
    private lateinit var imageProcessorSource: CameraXImageProcessorSource

    companion object {
        const val LENS_GROUP_ID = "6c126e51-f0d2-4f39-9de7-e6a3a8402302"
        const val LENS_ID = "533bc300-4db0-45e2-8031-7fa14604feb2"
    }

    // Initialize a permission request launcher
    private val requestPermissionLauncher =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted ->
            if (isGranted) {
                startPreview()
            } else {
                // Explain to the user that Camera Kit is unavailable because the
                // requested camera permission is denied by the user, then attempt retry.
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Checking if Camera Kit is supported on this device or not.
        if (!supported(this)) {
            Toast.makeText(this, "camera_kit_not_supported", Toast.LENGTH_SHORT).show()
            finish()
            return
        }

        imageProcessorSource = CameraXImageProcessorSource(
            context = this, lifecycleOwner = this
        )

        // If camera permission is granted, then start the preview
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
            startPreview()
        } else {
            requestPermissionLauncher.launch(Manifest.permission.CAMERA)
        }

        cameraKitSession = Session(context = this) {
            imageProcessorSource(imageProcessorSource)
            attachTo(findViewById(R.id.camera_kit_stub))
        }.apply {
            lenses.repository.observe(
                LensesComponent.Repository.QueryCriteria.ById(LENS_ID, LENS_GROUP_ID)
            ) { result ->
                result.whenHasFirst { requestedLens ->
                    lenses.processor.apply(requestedLens)
                }
            }
        }
    }

    private fun startPreview() {
        // starting preview with world facing camera
        imageProcessorSource.startPreview(false)
    }

    override fun onDestroy() {
        cameraKitSession.close()
        super.onDestroy()
    }
}
