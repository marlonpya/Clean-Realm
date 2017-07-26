package adexus.innova.gmd.com.pe.cleanrealm.db.manager;

import java.util.ArrayList;
import java.util.List;

import adexus.innova.gmd.com.pe.cleanrealm.db.sql.UserSql;
import io.realm.Realm;

/**
 * Created by tincio on 25/07/17.
 */

public class UserManager implements IManager<UserSql> {
    private Realm realm;

    @Override
    public int lastId() {
        if (realm == null) realm = Realm.getDefaultInstance();
        Number number = realm.where(UserSql.class).max(UserSql.primaryKey);
        return number == null ? 0 : number.intValue() + 1;
    }

    @Override
    public void createOrUpdate(UserSql object) {
        if (realm == null) realm = Realm.getDefaultInstance();
        UserSql userSql = getObject(object.getId());
        if (userSql != null)
            delete(object.getId());
        realm.beginTransaction();
        //object.setId(lastId());
        object = realm.createObject(UserSql.class);
        realm.copyFromRealm(object);
        realm.commitTransaction();
    }

    @Override
    public UserSql getObject(int id) {
        if (realm == null) realm = Realm.getDefaultInstance();
        UserSql userSql = realm.where(UserSql.class).equalTo(UserSql.primaryKey, id).findFirst();
        if (userSql == null) {
            throw new RuntimeException("not find user");
        }
        return userSql;
    }

    @Override
    public List<UserSql> getList() {
        if (realm == null) realm = Realm.getDefaultInstance();
        return new ArrayList<>(realm.where(UserSql.class).findAll());
    }

    @Override
    public void delete(int id) {
        if (realm == null) realm = Realm.getDefaultInstance();
        UserSql userSql = getObject(id);
        realm.beginTransaction();
        userSql.deleteFromRealm();
        realm.commitTransaction();
    }

    @Override
    public void close() {
        if (realm != null) realm.close();
    }
}
