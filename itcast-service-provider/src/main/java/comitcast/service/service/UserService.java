package comitcast.service.service;


import comitcast.service.mapper.UserMapper;
import comitcast.service.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName:UserService
 * @Description:
 * @author:chenyun
 * @Date:2019/12/17 14:20
 */
@Service
public class UserService {

    //将mapper注入
    @Autowired
    private UserMapper userMapper;

    //根据id查用户
    public User queryUserById(Long id) {
        return userMapper.selectByPrimaryKey(id);
    }
}
