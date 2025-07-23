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

    @PostMapping("/save")
    public Result<Boolean> saveCustomer(@RequestBody CustomerEntity customerEntity) {
        return Result.success(customerService.saveCustomer(customerEntity) > 0);
    }

    @PostMapping("/update")
    public Result<Boolean> updateCustomer(@RequestBody CustomerEntity customerEntity) {
        return Result.success(customerService.saveOrUpdate(customerEntity));
    }

    @GetMapping("/{id}")
    public Result<CustomerEntity> getCompanyInfo(@PathVariable("id") String id) {
        return Result.success(customerService.getById(id));
    }

    @DeleteMapping("/delete")
    public Result<Boolean> delete(@RequestBody CustomerEntity customerEntity) {
        return Result.success(customerService.removeById(customerEntity));
    }
}
