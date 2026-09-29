package li.zhang.app.model.abs;
import li.zhang.app.model.base.BaseEntity;


public abstract class AbstractController<T extends BaseEntity, K> extends  AbstractReadController<T,K> {


    protected final T createEntity(final T entity) {

        return getService().create(entity);
    }

    protected final T updateInternal(final T entity) {

        return getService().update(entity);
    }

    protected final void deleteById(final T id) {

        getService().delete(id);
    }
}
