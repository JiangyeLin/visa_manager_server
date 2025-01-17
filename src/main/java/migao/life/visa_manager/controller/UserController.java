package migao.life.visa_manager.controller;


import migao.life.visa_manager.mapper.UserMapper;
import migao.life.visa_manager.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/test")
    private int test() {
        List<UserModel> list = userMapper.selectList(null);
        System.out.println(list);

        return list.size();
    }
}
