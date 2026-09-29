package li.zhang.app.model.base;

import java.io.Serializable;

public interface BaseEntity extends Serializable {

    Long getId();

    void setId(final Long id);
}