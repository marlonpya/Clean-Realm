package adexus.innova.gmd.com.pe.cleanrealm.mapper;

import adexus.innova.gmd.com.pe.cleanrealm.db.sql.UserSql;
import adexus.innova.gmd.com.pe.cleanrealm.model.UserEntity;

/**
 * Created by tincio on 25/07/17.
 */

public class UserSqlToUserEntityMapper implements Mapper<UserSql, UserEntity> {
    private static UserSqlToUserEntityMapper instance;

    private UserSqlToUserEntityMapper(){};

    public static UserSqlToUserEntityMapper getInstance() {
        return instance == null ? new UserSqlToUserEntityMapper() : instance;
    }

    @Override
    public UserSql map(UserEntity object) {
        UserSql userSql = new UserSql();
        userSql.setId(object.getId());
        userSql.setName(object.getName());
        userSql.setLastName(object.getLastName());
        userSql.setAge(object.getAge());
        return userSql;
    }

    @Override
    public UserEntity reverseMap(UserSql object) {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(object.getId());
        userEntity.setName(object.getName());
        userEntity.setLastName(object.getLastName());
        userEntity.setAge(object.getAge());
        return userEntity;
    }
}
