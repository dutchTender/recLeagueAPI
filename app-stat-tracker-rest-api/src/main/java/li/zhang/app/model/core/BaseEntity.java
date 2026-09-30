package li.zhang.app.model.core;

import java.io.Serializable;

public interface BaseEntity extends Serializable {

    Long getId();

    void setId(final Long id);
}