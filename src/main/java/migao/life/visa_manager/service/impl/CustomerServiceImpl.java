package migao.life.visa_manager.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import migao.life.visa_manager.common.constant.CommonStatus;
import migao.life.visa_manager.common.exception.CommonException;
import migao.life.visa_manager.mapper.CustomerMapper;
import migao.life.visa_manager.model.entity.CustomerEntity;
import migao.life.visa_manager.model.form.CustomerQueryForm;
import migao.life.visa_manager.service.CustomerService;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper, CustomerEntity> implements CustomerService {
    @Override
    public int saveCustomer(CustomerEntity customerEntity) {

        QueryWrapper<CustomerEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("passport_number", customerEntity.getPassportNumber());

        CustomerEntity existingUser = this.baseMapper.selectOne(queryWrapper);
        if (existingUser != null) {
            // 存在相同的 护照号，进行更新操作
            throw new CommonException(CommonStatus.CUSTOMER_EXISTS);
        } else {
            // 不存在相同的 护照号，执行插入操作
            return this.baseMapper.insert(customerEntity);
        }
    }

    public IPage<CustomerEntity> getCustomerList(CustomerQueryForm customerQueryForm) {
        IPage<CustomerEntity> page = customerQueryForm.toPage();
        LambdaQueryWrapper<CustomerEntity> wrapper = new LambdaQueryWrapper<>();

        // TODO: 2025/2/10 优化搜索逻辑 公司和keyword 混合搜索
        if (customerQueryForm.getKeyword() != null) {
            String keyword = customerQueryForm.getKeyword().trim();
            wrapper.like(CustomerEntity::getName, keyword).or().like(CustomerEntity::getPhoneNumber, keyword).or().like(CustomerEntity::getPassportNumber, keyword).or().like(CustomerEntity::getFamilyName, keyword).or().like(CustomerEntity::getGivenName, keyword);
        }
        if (customerQueryForm.getCompanyId() != null) {
            wrapper.eq(CustomerEntity::getCompanyId, customerQueryForm.getCompanyId());
        }

        wrapper.orderByDesc(CustomerEntity::getId);
        return this.baseMapper.selectPage(page, wrapper);
    }
}
