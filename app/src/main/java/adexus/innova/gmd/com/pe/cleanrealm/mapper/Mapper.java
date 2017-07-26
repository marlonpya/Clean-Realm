package adexus.innova.gmd.com.pe.cleanrealm.mapper;

/**
 * Created by tincio on 25/07/17.
 */

public interface Mapper<T1, T2> {
    T1 map(T2 object);
    T2 reverseMap(T1 object);
}
