package li.zhang.app.model.abs;

import li.zhang.app.model.base.BaseEntity;
import li.zhang.app.model.base.BaseService;
import org.springframework.data.domain.Example;

import java.util.List;


public abstract class AbstractReadController<T extends BaseEntity, K> {
    
    protected final K findOneEntity(final Long id) {
        return getService().find(id);
    }

    protected final T findOneEntityByExample(Example<T> example) {
        return getService().findByExample(example);
    }

    protected final List<K> findAllEntities() {

        return getService().findAll();
    }

    protected final List<T> findAlEntitiesByExample(Example<T> example) {

        return getService().findAllByExample(example);
    }
    protected final long countEntities() {
        return getService().count();
    }
    protected abstract BaseService<T,K> getService();
}
