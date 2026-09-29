package li.zhang.app.model.abs;

import org.springframework.http.ResponseEntity;

public class AbstractAPIResponse<T> {
    public ResponseEntity<AbstractRestResponse<T>> createAPIResponse(T dto, AbstractRestMetaData restMetaData, String message, String code) {
        AbstractRestResponse<T> restResponse = new AbstractRestResponse<>(
                code,
                message,
                dto,
                restMetaData
        ) {};
        return ResponseEntity.ok(restResponse);
    }
}
