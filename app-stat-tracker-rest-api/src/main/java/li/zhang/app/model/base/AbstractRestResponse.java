package li.zhang.app.model.base;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class AbstractRestResponse<T> {
    private String status;
    private String message;
    private T data;
    private AbstractRestMetaData metaData;

    protected AbstractRestResponse(String code, String message, T data, AbstractRestMetaData metaData) {
        this.status = code;
        this.message = message;
        this.data = data;
        this.metaData = metaData;
    }

}

