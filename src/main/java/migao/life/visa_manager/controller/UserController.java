package migao.life.visa_manager.controller;


import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.stp.StpUtil;
import migao.life.visa_manager.common.vo.Result;
import migao.life.visa_manager.mapper.UserMapper;
import migao.life.visa_manager.model.UserModel;
import migao.life.visa_manager.model.entity.UserEntity;
import migao.life.visa_manager.model.vo.LoginVO;
import migao.life.visa_manager.model.vo.UserDetailVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
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

    @PostMapping("/login")
    public Result<LoginVO> login() {
        //Long userId = userService.getUserIdByUserNameAndPassWord(loginForm);

        StpUtil.login(1L);
        String tokenValue = StpUtil.getTokenInfo().getTokenValue();
        List<String> permsById = new ArrayList<>();
        permsById.add("ROOT");

        LoginVO loginVO = new LoginVO();
        loginVO.setToken(tokenValue);
        loginVO.setPharmacies(permsById);
        return Result.success(loginVO);
    }

    @SaCheckLogin
    @GetMapping("/loadUserInfo")
    public Result<UserDetailVO> getCurrentUserInfo() {
        UserEntity userEntity = new UserEntity();

        userEntity.setUserName("测试");

        UserDetailVO userDetailVO = new UserDetailVO();
        userDetailVO.setId(1L);
        userDetailVO.setName(userEntity.getUserName());
        return Result.success(userDetailVO);
    }

}
