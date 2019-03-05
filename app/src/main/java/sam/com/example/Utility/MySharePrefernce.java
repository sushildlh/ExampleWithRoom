package sam.com.example.Utility;

import android.content.Context;
import android.preference.PreferenceManager;

public class MySharePrefernce {
    
    public static void setSharePrefernceBoolean(Context ctx, String name, boolean flag) {
        PreferenceManager.getDefaultSharedPreferences(ctx).edit().putBoolean(name, flag).commit();
    }
    
    public static boolean getSharePrefernceBoolean(Context ctx, String name) {
        return PreferenceManager.getDefaultSharedPreferences(ctx).getBoolean(name, false);
    }
    
}
