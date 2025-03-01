package migao.life.visa_manager.controller;

import com.tencent.cloud.Response;
import migao.life.visa_manager.common.vo.Result;
import migao.life.visa_manager.model.form.PassportOcrForm;
import migao.life.visa_manager.model.vo.CosCredentialVO;
import migao.life.visa_manager.model.vo.CustomerVO;
import migao.life.visa_manager.utils.cos.TencentCosProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/cos")
public class CosController {

    @Autowired
    TencentCosProperties tencentCosProperties;

    @GetMapping("/getCredential")
    public Result<CosCredentialVO> getCredential() {
        System.out.println("生成临时密钥");
        Response response = tencentCosProperties.getCredential();

        CosCredentialVO cosCredentialVO = new CosCredentialVO();
        cosCredentialVO.setStartTime(response.startTime);
        cosCredentialVO.setExpiredTime(response.expiredTime);
        cosCredentialVO.setCredentials(response.credentials);
        cosCredentialVO.setRequestId(response.requestId);
        cosCredentialVO.setExpiration(response.expiration);

        return Result.success(cosCredentialVO);
    }

    @PostMapping("/passportOcr")
    public Result<CustomerVO> passportOcr(@RequestBody PassportOcrForm passportOcrForm) {
        CustomerVO customerVO = tencentCosProperties.passportOcrRequest(passportOcrForm.getPassportUrl());
        return Result.success(customerVO);
    }
}
