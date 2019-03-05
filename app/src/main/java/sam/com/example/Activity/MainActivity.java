package sam.com.example.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import sam.com.example.Adapter.ListAdapter;
import sam.com.example.Models.ResultData;
import sam.com.example.R;
import sam.com.example.RetrofitAndRxJava.APIMethods;
import sam.com.example.RetrofitAndRxJava.DatabaseCallback;
import sam.com.example.RetrofitAndRxJava.LocalCacheManager;
import sam.com.example.RetrofitAndRxJava.RedtrofitClient;
import sam.com.example.Utility.MySharePrefernce;

public class MainActivity extends Activity implements DatabaseCallback {
    
    
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
        } else {
            LocalCacheManager.getInstance(this).getUsers(this);
        }
    }
    
    private void handleResults(ArrayList<ResultData> resultData) {
        MySharePrefernce.setSharePrefernceBoolean(this, "isFirst", true);
        RecyclerView mList = findViewById(R.id.list);
        mList.setLayoutManager(new LinearLayoutManager(this));
        mList.setAdapter(new ListAdapter(this, resultData));
        LocalCacheManager.getInstance(this).addAllData(this, resultData);
    }
    
    private void handleError(Throwable throwable) {
        Toast.makeText(this, "Please Check Internet Connection.", Toast.LENGTH_LONG).show();
    }
    
    @Override
    protected void onDestroy() {
        
        super.onDestroy();
    }
    
    @Override
    public void onUsersLoaded(List<ResultData> datas) {
        RecyclerView mList = findViewById(R.id.list);
        mList.setLayoutManager(new LinearLayoutManager(this));
        mList.setAdapter(new ListAdapter(this, datas));
    }
    
    @Override
    public void onUserDeleted() {
        Log.d("room", "onUserDeleted");
    }
    
    @Override
    public void onUserAdded() {
        Log.d("room", "onUserAdded");
    }
    
    @Override
    public void onDataNotAvailable() {
        Log.d("room", "onDataNotAvailable");
    }
    
    @Override
    public void onUserUpdated() {
        Log.d("room", "onUserUpdated");
    }
}
