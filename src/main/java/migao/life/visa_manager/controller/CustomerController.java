package migao.life.visa_manager.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import migao.life.visa_manager.common.vo.Result;
import migao.life.visa_manager.model.entity.CustomerEntity;
import migao.life.visa_manager.model.form.CustomerQueryForm;
import migao.life.visa_manager.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping("/list")
    public Result<IPage<CustomerEntity>> getCustomerList(@RequestBody CustomerQueryForm customerQueryForm) {
        return Result.success((customerService.getCustomerList(customerQueryForm)));
    }

    @PostMapping("/update")
    public Result<Boolean> saveCustomer(@RequestBody CustomerEntity customerEntity) {
        System.out.println("添加客户");
        System.out.println(customerEntity);
        return Result.success(customerService.saveCustomer(customerEntity) > 0);
    }

    @DeleteMapping("/delete")
    public Result<Boolean> delete(@RequestBody CustomerEntity customerEntity) {
        System.out.println("删除" + customerEntity);
        return Result.success(customerService.removeById(customerEntity));
    }
}
