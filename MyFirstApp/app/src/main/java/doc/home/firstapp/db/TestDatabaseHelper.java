package doc.home.firstapp.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class TestDatabaseHelper  extends SQLiteOpenHelper {

    private final String DATABASE_CREATE_TABLE_SETTINGS = "CREATE TABLE IF NOT EXISTS "
            + DBConstants.TABLE_SETTINGS
            + "("
            + DBConstants.COLUMN_ID
            + " integer primary key, "
            + DBConstants.COLUMN_USER_ID
            + " text, "
            + DBConstants.COLUMN_SETTING_TYPE
            + " text, "
            + DBConstants.COLUMN_SETTING_VALUE + " integer );";


    public TestDatabaseHelper(@Nullable Context context) {
        super(context, DBConstants.DATABASE_NAME, null, DBConstants.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
       sqLiteDatabase.execSQL(DATABASE_CREATE_TABLE_SETTINGS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        //sqLiteDatabase.

    }
}
