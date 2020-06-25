package doc.home.firstapp;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import doc.home.firstapp.db.TestDatabaseHelper;

public class JavaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        TestDatabaseHelper dbHelper = new TestDatabaseHelper(this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("COLUMNNAME","VALUE");
        db.insert("TABLENAME",null,values);

        //-----------------
        values.put("NAME","ALI");
        db.update("TABLENAME",values,"COULNNAME = ? AND AGE = ?",new String[]{"Azmat", "20"});
       // db.delete()
       Cursor cursor= db.query(null,null,null,null,null,null,null,null);
       if(cursor!=null && cursor.moveToFirst()){
           while(!cursor.isAfterLast()){

           }
       }
     
    }
}
