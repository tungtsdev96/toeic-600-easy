package tungts.hust.edu.toeic600;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by tungts on 5/23/2018.
 */

public class ApplicationToeic extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
        RealmConfiguration configuration = new RealmConfiguration.Builder()
                                                    .name("toeic.realm").build();
        Realm.setDefaultConfiguration(configuration);
    }
}
