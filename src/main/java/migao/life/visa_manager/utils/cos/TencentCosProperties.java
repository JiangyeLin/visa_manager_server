package migao.life.visa_manager.utils.cos;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "tencent.cos")
@Component
@Data
public class TencentCosProperties {
    /**
     * 腾讯云账号秘钥
     */
    private String SecretId;
    /**
     * 密码秘钥
     */
    private String SecretKey;
    /**
     * 存储桶地区
     */
    private String region;
    /**
     * 存储桶名称
     */
    private String bucketName;
    /**
     * 存储桶访问路径
     */
    private String rootSrc;

}
