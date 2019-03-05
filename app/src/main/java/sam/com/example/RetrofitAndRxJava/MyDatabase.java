package sam.com.example.RetrofitAndRxJava;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import io.reactivex.Maybe;
import sam.com.example.Models.ResultData;

@Dao
public interface MyDatabase {
    
    @Query("SELECT * FROM my_table")
    Maybe<List<ResultData>> getFromTable();
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<ResultData> items);
}
