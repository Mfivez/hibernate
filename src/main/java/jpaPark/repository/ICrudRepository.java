package jpaPark.repository;

import java.util.List;
import java.util.Optional;

public interface ICrudRepository <T,ID>{
    List<T> findAll();
    Optional<T> findById(ID id);

    T insert(T t);

    T update(T t);

    T delete(ID id);
}
