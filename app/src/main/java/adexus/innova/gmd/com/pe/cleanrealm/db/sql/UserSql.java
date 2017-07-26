package adexus.innova.gmd.com.pe.cleanrealm.db.sql;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by tincio on 25/07/17.
 */

public class UserSql extends RealmObject {
    public static final String primaryKey = "id";

    @PrimaryKey
    private int id;
    private String name;
    private String lastName;
    private int age;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
