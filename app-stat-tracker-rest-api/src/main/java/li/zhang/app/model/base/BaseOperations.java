package li.zhang.app.model.base;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;

import java.util.List;

public interface BaseOperations <T extends BaseEntity, K> {

    K find(final Long id);

    T findByExample(final Example<T> example);

    List<K> findAll();

    List<T> findAllByExample(final Example<T> example);

    Page<K> findAllPaginatedAndSorted(final int page, final int size, final String sortBy, final String sortOrder);

    T create(final T entity);

    T update(final T entity);

    void delete(final T entity);

    void deleteById(final Long id);

    void deleteAll();

    long count();


}
