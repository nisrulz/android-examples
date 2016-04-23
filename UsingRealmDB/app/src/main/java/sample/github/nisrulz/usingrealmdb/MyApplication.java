package sample.github.nisrulz.usingrealmdb;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();


        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder(this)
                .name("example.realm")
                .build();

        Realm.setDefaultConfiguration(realmConfiguration);
    }
}
