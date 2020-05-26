package doc.home.firstapp;

import android.app.Application;
import android.util.Log;

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("TAG","OnCreate My Application");
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }

}
