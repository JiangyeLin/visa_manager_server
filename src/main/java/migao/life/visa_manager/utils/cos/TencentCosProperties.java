package migao.life.visa_manager.utils.cos;

import com.qcloud.cos.utils.Jackson;
import com.tencent.cloud.CosStsClient;
import com.tencent.cloud.Policy;
import com.tencent.cloud.Response;
import com.tencent.cloud.Statement;
import com.tencentcloudapi.common.AbstractModel;
import com.tencentcloudapi.common.Credential;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;
import com.tencentcloudapi.common.profile.ClientProfile;
import com.tencentcloudapi.common.profile.HttpProfile;
import com.tencentcloudapi.ocr.v20181119.OcrClient;
import com.tencentcloudapi.ocr.v20181119.models.PassportOCRRequest;
import com.tencentcloudapi.ocr.v20181119.models.PassportOCRResponse;
import lombok.Setter;
import migao.life.visa_manager.model.vo.CustomerVO;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.TreeMap;

@ConfigurationProperties(prefix = "tencent.cos")
@Component
@Setter
public class TencentCosProperties {
    /**
     * 腾讯云账号秘钥
     */
    private String secretId;
    /**
     * 密码秘钥
     */
    private String secretKey;
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


    /**
     * 获取临时密钥
     *
     * @return
     */
    public Response getCredential() {
        TreeMap<String, Object> config = new TreeMap<String, Object>();
        try {
            // 替换为您的云 api 密钥 SecretId
            config.put("secretId", this.secretId);
            // 替换为您的云 api 密钥 SecretKey
            config.put("secretKey", this.secretKey);

            // 初始化 policy
            Policy policy = new Policy();

            // 临时密钥有效时长，单位是秒，默认 1800 秒，目前主账号最长 2 小时（即 7200 秒），子账号最长 36 小时（即 129600）秒
            config.put("durationSeconds", 60 * 30);
            // 换成您的 bucket
            config.put("bucket", this.bucketName);
            // 换成 bucket 所在地区
            config.put("region", this.region);

            // 开始构建一条 statement
            Statement statement = new Statement();
            // 声明设置的结果是允许操作
            statement.setEffect("allow");
            /**
             * 密钥的权限列表。必须在这里指定本次临时密钥所需要的权限。
             * 权限列表请参见 https://cloud.tencent.com/document/product/436/31923
             * 规则为 {project}:{interfaceName}
             * project : 产品缩写  cos相关授权为值为cos,数据万象(数据处理)相关授权值为ci
             * 授权所有接口用*表示，例如 cos:*,ci:*
             * 添加一批操作权限 :
             */
            statement.addActions(new String[]{"cos:PutObject",
                    // 表单上传、小程序上传
                    "cos:PostObject",
                    // 分块上传
                    "cos:InitiateMultipartUpload", "cos:ListMultipartUploads", "cos:ListParts", "cos:UploadPart", "cos:CompleteMultipartUpload",
                    // 处理相关接口一般为数据万象产品 权限中以ci开头
                    // 创建媒体处理任务
                    "ci:CreateMediaJobs",
                    // 文件压缩
                    "ci:CreateFileProcessJobs"});

            //statement.addResource("qcs::cos:ap-chongqing:uid/1316966592:visa-1316966592/*");
            statement.addResource("*");

            // 把一条 statement 添加到 policy
            // 可以添加多条
            policy.addStatement(statement);
            // 将 Policy 示例转化成 String，可以使用任何 json 转化方式，这里是本 SDK 自带的推荐方式
            config.put("policy", Jackson.toJsonPrettyString(policy));

            // TODO: 2025/3/1 直接转换成最终结果返回

            return CosStsClient.getCredential(config);
        } catch (Exception e) {
            e.printStackTrace();
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    /**
     * 护照OCR识别
     *
     * @param passportUrl
     * @return
     */
    public CustomerVO passportOcrRequest(String passportUrl) {
        try {
            PassportOCRResponse resp = getPassportOCRResponse(passportUrl);
            // 输出json格式的字符串回包
            System.out.println(AbstractModel.toJsonString(resp));

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            // 使用 DateTimeFormatter 解析字符串
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");

            CustomerVO customerVO = new CustomerVO();

            customerVO.setName(resp.getName());
            customerVO.setPassportNumber(resp.getPassportNo());

            LocalDate localDate = LocalDate.parse(resp.getIssueDate(), formatter);

            // 如果需要转换成 java.util.Date，可以使用 java.sql.Date 或者转换为 Date 类型
            Date date = java.sql.Date.valueOf(localDate);
            customerVO.setPassportIssueDate(date);

            localDate = LocalDate.parse(resp.getExpiryDate(), formatter);

            customerVO.setPassportValidity(java.sql.Date.valueOf(localDate));
            customerVO.setBirthPlace(resp.getBirthPlace());
            customerVO.setGender(resp.getSex());
            customerVO.setPassportIssuePlace(resp.getIssuePlace());
            customerVO.setFamilyName(resp.getFamilyName());
            customerVO.setGivenName(resp.getFirstName());

            customerVO.setNationality(resp.getNationality());

            localDate = LocalDate.parse(resp.getBirthDate(), formatter);
            date = java.sql.Date.valueOf(localDate);

            customerVO.setBirthDate(date);
            return customerVO;
        } catch (TencentCloudSDKException e) {
            e.printStackTrace();
        }
        return null;
    }

    private PassportOCRResponse getPassportOCRResponse(String passportUrl) throws TencentCloudSDKException {
        Credential cred = new Credential(this.secretId, this.secretKey);
        // 实例化一个http选项，可选的，没有特殊需求可以跳过
        HttpProfile httpProfile = new HttpProfile();
        httpProfile.setEndpoint("ocr.tencentcloudapi.com");
        // 实例化一个client选项，可选的，没有特殊需求可以跳过
        ClientProfile clientProfile = new ClientProfile();
        clientProfile.setHttpProfile(httpProfile);
        // 实例化要请求产品的client对象,clientProfile是可选的
        OcrClient client = new OcrClient(cred, "ap-chongqing", clientProfile);
        // 实例化一个请求对象,每个接口都会对应一个request对象
        PassportOCRRequest req = new PassportOCRRequest();
        req.setImageUrl(passportUrl);

        // 返回的resp是一个PassportOCRResponse的实例，与请求对象对应
        return client.PassportOCR(req);
    }
}
