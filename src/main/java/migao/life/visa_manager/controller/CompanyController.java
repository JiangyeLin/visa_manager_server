package migao.life.visa_manager.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import migao.life.visa_manager.common.vo.Result;
import migao.life.visa_manager.model.entity.CompanyEntity;
import migao.life.visa_manager.model.form.CompanyQueryForm;
import migao.life.visa_manager.model.form.CustomerQueryForm;
import migao.life.visa_manager.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    CompanyService companyService;

    @PostMapping("/list")
    public Result<IPage<CompanyEntity>> getCustomerList(@RequestBody CompanyQueryForm companyQueryForm) {
        return Result.success((companyService.getCompanyList(companyQueryForm)));
    }
}
