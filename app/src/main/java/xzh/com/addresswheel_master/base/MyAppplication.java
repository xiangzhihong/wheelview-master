package xzh.com.addresswheel_master.base;

import android.app.Application;

public class MyAppplication extends Application {

    private static MyAppplication instance;

    public static synchronized MyAppplication getInstance() {
        if (instance==null){
         instance=new MyAppplication();
        }
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }
}
