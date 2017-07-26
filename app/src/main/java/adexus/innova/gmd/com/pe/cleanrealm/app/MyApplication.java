package adexus.innova.gmd.com.pe.cleanrealm.app;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by tincio on 25/07/17.
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
        Realm.setDefaultConfiguration(getConfiguration());
    }

    private RealmConfiguration getConfiguration() {
        return new RealmConfiguration.Builder()
                .name("example.db")
                .schemaVersion(0)
                .deleteRealmIfMigrationNeeded()
                .build();
    }
}
