package sam.com.example.RetrofitAndRxJava;

import java.util.List;

import sam.com.example.Models.ResultData;

public interface DatabaseCallback {
    
    void onUsersLoaded(List<ResultData> datas);
    
    void onUserDeleted();
    
    void onUserAdded();
    
    void onDataNotAvailable();
    
    void onUserUpdated();
}