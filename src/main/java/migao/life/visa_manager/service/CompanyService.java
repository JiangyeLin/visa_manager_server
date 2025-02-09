package migao.life.visa_manager.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import migao.life.visa_manager.model.entity.CompanyEntity;
import migao.life.visa_manager.model.form.CompanyQueryForm;

public interface CompanyService extends IService<CompanyEntity> {
    public IPage<CompanyEntity> getCompanyList(CompanyQueryForm companyQueryForm);
}
