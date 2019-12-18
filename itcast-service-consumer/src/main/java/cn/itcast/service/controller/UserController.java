package cn.itcast.service.controller;



import cn.itcast.service.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @ClassName:UserContytroller
 * @Description:
 * @author:chenyun
 * @Date:2019/12/17 15:45
 */
//使用这个注解声明这个类是一个controller类
@Controller
//声明全局访问的前缀
@RequestMapping("consumer/user")
public class UserController {
    //将RestTemplate注入
    @Autowired
    private RestTemplate restTemplate;

    //包含了所有的拉取的服务信息
    @Autowired
    private DiscoveryClient discoveryClient;

    //通过远程调用的方法根据id查用户
    @GetMapping
    @ResponseBody
    public User queryUserById(@RequestParam("id")Long id){
        //通过discoveryClient获取服务实例
        //以下是所有叫这个名字的服务的集合，如果做集群的话这块就会有多个值
        List<ServiceInstance> instances = discoveryClient.getInstances("SERVIVE-PROVIDER");
        //由于当前只有一个实例，所以获取第一个实例
        ServiceInstance instance = instances.get(0);
        //通过实例获取主机地址和端口
        return restTemplate.getForObject("http://"+instance.getHost()+":"+instance.getPort()+"/user/"+id, User.class);
    }

}
