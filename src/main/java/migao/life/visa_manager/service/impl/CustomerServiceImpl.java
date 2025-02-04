package migao.life.visa_manager.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import migao.life.visa_manager.mapper.CustomerMapper;
import migao.life.visa_manager.model.entity.CustomerEntity;
import migao.life.visa_manager.service.CustomerService;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper, CustomerEntity> implements CustomerService {
}
