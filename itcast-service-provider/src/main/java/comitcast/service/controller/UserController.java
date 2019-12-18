package comitcast.service.controller;


import comitcast.service.pojo.User;
import comitcast.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName:UserController
 * @Description:
 * @author:chenyun
 * @Date:2019/12/17 14:25
 */
//加入RestController注解，表示返回的方法都是json数据格式的
@RestController
//然后加入一个全局路径
@RequestMapping("user")
public class UserController {
    //将service注入
    @Autowired
    private UserService userService;

    @GetMapping("{id}")
    public User queryUserById(@PathVariable("id") Long id) {
        return userService.queryUserById(id);
    }
}
