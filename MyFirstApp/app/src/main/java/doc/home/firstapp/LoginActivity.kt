package doc.home.firstapp

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import doc.home.firstapp.util.Constants
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        progressBar.setOnClickListener {
            Toast.makeText(this, "OnClick ProgressBar",Toast.LENGTH_SHORT).show()
        }

        progressBar.apply {

        }
//        text.apply {
//            text = "Today Demo"
//            //background =
//
//        }
        text.setOnClickListener{
           Toast.makeText(this, "OnClick",Toast.LENGTH_SHORT).show()

            val openIntent = Intent(this, MainActivity::class.java)
            openIntent.putExtra(Constants.FNAME,input1.text.toString())
            openIntent.putExtra(Constants.AGE,20)

            startActivity(openIntent)
          // testImplictIntent()
        }

        button.setOnClickListener{
            Thread(Runnable{

            }).start()
        }

        Log.e("TAG","OnCreate Activity One")
    }

    fun testImplictIntent(){
        val sendIntent = Intent().apply {
            action = "ABC"
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
        Log.e("TAG","OnResume Activity One")
    }

    override fun onPause() {
        super.onPause()
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
