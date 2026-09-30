package li.zhang.app.model.base;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class AbstractRestResponse<T> {
    private String code;
    private String message;
    private T data;
    private AbstractRestMetaData metaData;

    protected AbstractRestResponse(String code, String message, T data, AbstractRestMetaData metaData) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.metaData = metaData;
    }

}

