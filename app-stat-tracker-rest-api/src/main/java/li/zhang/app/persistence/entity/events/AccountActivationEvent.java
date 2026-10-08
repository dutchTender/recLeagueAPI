package li.zhang.app.persistence.entity.events;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class AccountActivationEvent {
    String userInfoID;
    String confirmationAddress;
    String activationCode;
}
