package sam.com.example.Models;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;

import androidx.room.TypeConverter;

class DoubleTypeConverter {
    private static Gson gson = new Gson();
    @TypeConverter
    public static List<Double> stringToList(String data) {
        if (data == null) {
            return Collections.emptyList();
        }
        
        Type listType = new TypeToken<List<Double>>() {}.getType();
        
        return gson.fromJson(data, listType);
    }
    
    @TypeConverter
    public static String ListToString(List<Double> someObjects) {
        return gson.toJson(someObjects);
    }
}
