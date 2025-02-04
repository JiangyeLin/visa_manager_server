package migao.life.visa_manager.controller;


import migao.life.visa_manager.common.vo.Result;
import migao.life.visa_manager.model.entity.CustomerEntity;
import migao.life.visa_manager.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping("/list")
    public Result<List<CustomerEntity>> getCurrentUserInfo() {
        return Result.success(customerService.list().subList(1, 10));
    }
}
