package sam.com.example.RetrofitAndRxJava;

import android.content.Context;

import java.util.List;

import androidx.room.Room;
import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import sam.com.example.Models.ResultData;

public class LocalCacheManager  {
    private static final String DB_NAME = "Sam";
    private Context context;
    private static LocalCacheManager _instance;
    private AppDatabase db;
    
    public static LocalCacheManager getInstance(Context context) {
        if (_instance == null) {
            _instance = new LocalCacheManager(context);
        }
        return _instance;
    }
    
    public LocalCacheManager(Context context) {
        this.context = context;
        db = Room.databaseBuilder(context, AppDatabase.class, DB_NAME).build();
    }
    
    public void getUsers(final DatabaseCallback databaseCallback) {
        db.createAll().getFromTable().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<List<ResultData>>() {
            @Override
            public void accept(@io.reactivex.annotations.NonNull List<ResultData> datas) throws Exception {
                databaseCallback.onUsersLoaded(datas);
            }
        });
    }
    
    public void addAllData(final DatabaseCallback databaseCallback, List<ResultData> data) {
        Completable.fromAction(new Action() {
            @Override
            public void run() throws Exception {
                db.createAll().insertAll(data);
            }
        }).observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io()).subscribe(new CompletableObserver() {
            @Override
            public void onSubscribe(Disposable d) {
            }
            
            @Override
            public void onComplete() {
                databaseCallback.onUserAdded();
            }
            
            @Override
            public void onError(Throwable e) {
                databaseCallback.onDataNotAvailable();
            }
        });
    }
    
}
