package sam.com.example.RetrofitAndRxJava;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import sam.com.example.Models.ResultData;

@Database(entities = {ResultData.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    
    public abstract MyDatabase createAll();
}