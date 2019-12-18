package comitcast.service.mapper;


import comitcast.service.pojo.User;
import tk.mybatis.mapper.common.Mapper;

/**
 * @ClassName:UserMapper
 * @Description: 以下接口继承了通用mapper，这样单表的增删改查就不需要我们自己进行编写了
 * @author:chenyun
 * @Date:2019/12/17 14:09
 */
//这个位置不加注解的情况下就去启动类上加一个@MapperScan()的mapper包扫描注解，这里的@MapperScan()使用的是通用mapper中的
public interface UserMapper extends Mapper<User> {

}
