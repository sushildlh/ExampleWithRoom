package sam.com.example.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import sam.com.example.Adapter.ListAdapter;
import sam.com.example.Models.ResultData;
import sam.com.example.R;
import sam.com.example.RetrofitAndRxJava.APIMethods;
import sam.com.example.RetrofitAndRxJava.RedtrofitClient;
import sam.com.example.Utility.MySharePrefernce;

public class MainActivity extends Activity {
    
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        APIMethods apiMethods = RedtrofitClient.getClient().create(APIMethods.class);
        
        Observable<ArrayList<ResultData>> apiObservable = apiMethods.getData();
        
        if (!MySharePrefernce.getSharePrefernceBoolean(this, "isFirst")) {
            apiObservable.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(this::handleResults, this::handleError);
        }
    }
    
    private void handleResults(ArrayList<ResultData> resultData) {
        //Toast.makeText(this, "success" + resultData.get(0).getName(), Toast.LENGTH_LONG).show();
        RecyclerView mList = findViewById(R.id.list);
        mList.setLayoutManager(new LinearLayoutManager(this));
        mList.setAdapter(new ListAdapter(this,resultData));
    }
    
    private void handleError(Throwable throwable) {
        Toast.makeText(this, throwable.getMessage(), Toast.LENGTH_LONG).show();
    }
    
}
