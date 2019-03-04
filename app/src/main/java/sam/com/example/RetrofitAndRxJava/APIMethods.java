package sam.com.example.RetrofitAndRxJava;

import java.util.ArrayList;

import io.reactivex.Observable;
import retrofit2.http.GET;
import sam.com.example.Models.ResultData;

public interface APIMethods {
    
    @GET("android_data_json")
    Observable<ArrayList<ResultData>> getData();
}
