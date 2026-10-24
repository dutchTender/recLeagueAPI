package li.zhang.app.model.base;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AbstractRestMetaData {
    private String uri;
    private String stats;

    public AbstractRestMetaData(String url, String stats) {
        this.uri = url;
        this.stats = stats;
    }

}
