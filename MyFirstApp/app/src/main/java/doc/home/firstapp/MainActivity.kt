package doc.home.firstapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.CalendarContract
import android.util.Log
import android.widget.Toast
import doc.home.firstapp.util.Constants
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val name = intent.getStringExtra(Constants.FNAME)
        Log.e("TAG","First Name is "+intent.getStringExtra(Constants.FNAME))
        Log.e("TAG", "The AGE is "+intent.getIntExtra(Constants.AGE,10))
        text2.text= name
        text2.setOnClickListener{
            Toast.makeText(this, "OnClick", Toast.LENGTH_SHORT).show()
            val bundle = Bundle().apply {

            }
            Intent().apply {

            }
            val myIntent = Intent(this,MainActivity::class.java)
            startActivity(Intent(this,MainActivity::class.java))
        }

        buttonone.setOnClickListener{
           // addEvent()
        }
        Log.e("TAG","OnCreate Activity Two")
    }

    fun addEvent(title: String, location: String, begin: Long, end: Long) {
        val intent = Intent(Intent.ACTION_INSERT).apply {
            data = CalendarContract.Events.CONTENT_URI
            putExtra(CalendarContract.Events.TITLE, title)
            putExtra(CalendarContract.Events.EVENT_LOCATION, location)
            putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, begin)
            putExtra(CalendarContract.EXTRA_EVENT_END_TIME, end)
        }
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)

        Log.e("TAG","OnNewIntent Activity Two")

    }

    override fun onStart() {
        super.onStart()
        Log.e("TAG","OnStart Activity Two")
    }

    override fun onResume() {
        super.onResume()
        Log.e("TAG","OnResume Activity Two")
    }

    override fun onPause() {
        super.onPause()
        Log.e("TAG","OnPause Activity Two")
    }

    override fun onStop() {
        super.onStop()
        Log.e("TAG","onStop Activity Two")
    }

    override fun onRestart() {
        super.onRestart()
        Log.e("TAG","onRestart Activity Two")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("TAG","onDestroy Activity Two")
    }
}
