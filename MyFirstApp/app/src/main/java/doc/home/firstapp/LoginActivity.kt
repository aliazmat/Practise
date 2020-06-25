package doc.home.firstapp

import android.Manifest
import android.content.BroadcastReceiver
import android.content.Intent
import android.content.IntentFilter
import android.content.pm.PackageManager
import android.net.ConnectivityManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import doc.home.firstapp.model.UserModel
import doc.home.firstapp.receiver.MyReceiver
import doc.home.firstapp.util.Constants
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

//        progressBar.setOnClickListener {
//            Toast.makeText(this, "OnClick ProgressBar",Toast.LENGTH_SHORT).show()
//        }
//
//        progressBar.apply {
//
//        }
//        text.apply {
//            text = "Today Demo"
//            //background =
//
//        }

        text.setOnClickListener{
           Toast.makeText(this, "OnClick",Toast.LENGTH_SHORT).show()

            val openIntent = Intent(this, MainActivity::class.java)
            val userModel = UserModel("Azmat","Ali",32)
           // openIntent.putExtra(Constants.FNAME,input1.text.toString())
            openIntent.putExtra(Constants.AGE,20)

            startActivity(openIntent)
           finish()
        //  testImplictIntent()
        }



        button.setOnClickListener{
//            val sceneViewerIntent = Intent(Intent.ACTION_VIEW)
//            sceneViewerIntent.data =
//                Uri.parse("https://arvr.google.com/scene-viewer/1.0?file=https://raw.githubusercontent.com/KhronosGroup/glTF-Sample-Models/master/2.0/Avocado/glTF/Avocado.gltf")
////            sceneViewerIntent.data =
////                Uri.parse("https://arvr.google.com/scene-viewer/1.0?file=https://raw.githubusercontent.com/KhronosGroup/glTF-Sample-Models/blob/master/2.0/Sponza/glTF/Sponza.gltf")
//            sceneViewerIntent.setPackage("com.google.android.googlequicksearchbox")
//            startActivity(sceneViewerIntent)

          // getRunTimePermission()
            sendCustomBroadcast()
        }







        Log.e("TAG","OnCreate Activity One")
    }

    fun sendCustomBroadcast(){
        Intent().also { intent ->
            intent.setAction("com.example.broadcast.MY_NOTIFICATION")
            intent.putExtra("data", "Notice me senpai!")
            sendBroadcast(intent)
        }
    }

    fun getRunTimePermission(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if(checkSelfPermission(Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED){
                //Perform desired operation.
            }else{
             requestPermissions(arrayOf(Manifest.permission.CAMERA),100)
            }

        }else{
            //Perform desired operation.
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        if(requestCode == 100){
            if(grantResults[0] == PackageManager.PERMISSION_GRANTED){
                //
            }
        }

        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }

    fun testImplictIntent(){
        val sendIntent = Intent().apply {
            action = "SUMIT_ACTION"
            putExtra(Intent.EXTRA_TEXT, "Hi text")
            type = "text/plain"
        }

//        val sendNewIntent = Intent().apply {
//            action = ""
//
//        }
//        sendIntent.action = Intent.ACTION_SEND
//        sendIntent.

// Verify that the intent will resolve to an activity
       // if (sendIntent.resolveActivity(packageManager) != null) {
            startActivity(sendIntent)
        //}
    }

    override fun onStart() {
        super.onStart()
        Log.e("TAG","OnStart Activity One")
    }

    override fun onResume() {
        super.onResume()
        val br: BroadcastReceiver = MyReceiver()
        val filter = IntentFilter().apply {
            addAction("com.example.broadcast.MY_NOTIFICATION")
        }
       registerReceiver(br, filter)
        Log.e("TAG","OnResume Activity One")
    }

    override fun onPause() {
        super.onPause()
       // unregisterReceiver(br)
        Log.e("TAG","OnPause Activity One")
    }

    override fun onStop() {
        super.onStop()
        Log.e("TAG","onStop Activity One")
    }

    override fun onRestart() {
        super.onRestart()
        Log.e("TAG","onRestart Activity One")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("TAG","onDestroy Activity One")
    }
}
