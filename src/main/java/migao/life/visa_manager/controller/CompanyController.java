package migao.life.visa_manager.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import migao.life.visa_manager.common.vo.Result;
import migao.life.visa_manager.model.entity.CompanyEntity;
import migao.life.visa_manager.model.form.CompanyQueryForm;
import migao.life.visa_manager.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    CompanyService companyService;

    @PostMapping("/list")
    public Result<IPage<CompanyEntity>> getCustomerList(CompanyQueryForm companyQueryForm) {
        return Result.success((companyService.getCompanyList(companyQueryForm)));
    }

    @GetMapping("/info/{id}")
    public Result<CompanyEntity> getCompanyInfo(@PathVariable("id") String id) {
        return Result.success(companyService.getById(id));
    }

    @PostMapping("/update")
    public Result<Boolean> saveCompany(@RequestBody CompanyEntity companyEntity) {
        return Result.success(companyService.saveOrUpdate(companyEntity));
    }

    @DeleteMapping("/delete")
    public Result<Boolean> delete(@RequestBody CompanyEntity companyEntity) {
        return Result.success(companyService.removeById(companyEntity));
    }
}
