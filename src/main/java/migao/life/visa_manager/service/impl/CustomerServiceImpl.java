package migao.life.visa_manager.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import migao.life.visa_manager.mapper.CustomerMapper;
import migao.life.visa_manager.model.entity.CustomerEntity;
import migao.life.visa_manager.model.form.CustomerQueryForm;
import migao.life.visa_manager.service.CustomerService;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper, CustomerEntity> implements CustomerService {
    public IPage<CustomerEntity> getCustomerList(CustomerQueryForm customerQueryForm) {
        IPage<CustomerEntity> page = customerQueryForm.toPage();
        QueryWrapper<CustomerEntity> queryWrapper = new QueryWrapper<>();

        // TODO: 2025/2/10 优化搜索逻辑 
        if (customerQueryForm.getKeyword() != null) {
            String keyword = customerQueryForm.getKeyword().trim();
            queryWrapper.like("phone_number", keyword).or().like("passport_number", keyword).or().like("family_name", keyword).or().like("given_name", keyword).or().like("company_id", customerQueryForm.getCompanyId());
        } else if (customerQueryForm.getCompanyId() != null) {
            queryWrapper.like("company_id", customerQueryForm.getCompanyId());
        }

        return this.baseMapper.selectPage(page, queryWrapper);
    }
}
