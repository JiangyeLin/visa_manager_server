package migao.life.visa_manager.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import migao.life.visa_manager.mapper.CompanyMapper;
import migao.life.visa_manager.model.entity.CompanyEntity;
import migao.life.visa_manager.model.form.CompanyQueryForm;
import migao.life.visa_manager.service.CompanyService;
import org.springframework.stereotype.Service;

@Service
public class CompanyServiceImpl extends ServiceImpl<CompanyMapper, CompanyEntity> implements CompanyService {
    public IPage<CompanyEntity> getCompanyList(CompanyQueryForm companyQueryForm) {
        IPage<CompanyEntity> page = companyQueryForm.toPage();
        QueryWrapper<CompanyEntity> queryWrapper = new QueryWrapper<>();

        if (companyQueryForm.getKeyword() != null) {
            String keyword = companyQueryForm.getKeyword().trim();
            queryWrapper.like("phone_number", keyword).or().like("passport_number", keyword).or().like("family_name", keyword).or().like("given_name", keyword);
        }

        return this.baseMapper.selectPage(page, queryWrapper);
    }
}
