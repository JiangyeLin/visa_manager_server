package migao.life.visa_manager.model.vo;

import com.tencent.cloud.Credentials;
import lombok.Data;

@Data
public class CosCredentialVO {
    private Credentials credentials;
    private String requestId;
    private String expiration;
    private long startTime;
    private long expiredTime;
}
