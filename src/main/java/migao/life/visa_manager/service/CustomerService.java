package migao.life.visa_manager.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import migao.life.visa_manager.model.entity.CustomerEntity;
import migao.life.visa_manager.model.form.CustomerQueryForm;

public interface CustomerService extends IService<CustomerEntity> {

    int saveCustomer(CustomerEntity customerEntity);

    IPage<CustomerEntity> getCustomerList(CustomerQueryForm customerQueryForm);
}
