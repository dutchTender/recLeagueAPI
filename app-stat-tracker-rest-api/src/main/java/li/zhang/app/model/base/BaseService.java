package li.zhang.app.model.base;

import java.util.logging.Logger;

public interface BaseService<T extends BaseEntity, K> extends BaseOperations<T,K> {

    Logger getLogger();

}
