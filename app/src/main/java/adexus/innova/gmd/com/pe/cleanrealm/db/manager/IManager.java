package adexus.innova.gmd.com.pe.cleanrealm.db.manager;

import java.util.List;

/**
 * Created by tincio on 25/07/17.
 */

public interface IManager<C> {

    int lastId();

    void createOrUpdate(C object);

    C getObject(final int id);

    List<C> getList();

    void delete(final int id);

    void close();
}
