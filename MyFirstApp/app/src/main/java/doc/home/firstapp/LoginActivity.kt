package doc.home.firstapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        text.setOnClickListener{
           Toast.makeText(this, "OnClick",Toast.LENGTH_SHORT).show()
        //    startActivity(Intent(this,MainActivity::class.java))
            testImplictIntent()
        }

        button.setOnClickListener{

        }

        Log.e("TAG","OnCreate Activity One")
    }

    fun testImplictIntent(){
        val sendIntent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, "Hi text")
            type = "text/plain"
        }

// Verify that the intent will resolve to an activity
        if (sendIntent.resolveActivity(packageManager) != null) {
            startActivity(sendIntent)
        }
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
