package cn.itcast.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName:LoginFilter
 * @Description:
 * @author:chenyun
 * @Date:2019/12/19 16:37
 */
//做一个登陆过滤器
//加一个注解注册到spring容器
@Component
public class LoginFilter extends ZuulFilter {

    /**
     * 过滤器的几种类型：pre route post error
     *
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 执行顺序，返回值越小，优先级越高
     *
     * @return
     */
    @Override
    public int filterOrder() {
        return 10;
    }

    /**
     * 是否执行run方法
     * true：执行run方法
     * false：不执行run方法
     *
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 编写过滤器的业务逻辑
     *
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {

        //获取zuul网关的上下文对象
        RequestContext context = RequestContext.getCurrentContext();
        //获取request对象
        HttpServletRequest request = context.getRequest();
        //获取到参数
        String token = request.getParameter("token");
        //判断这个参数是不是为空，如果为空就做拦截
        if (StringUtils.isBlank(token)) {
            //如果为空就拦截不转发
            //设置这个转发拦截请求的响应
            context.setSendZuulResponse(false);
            //响应状态码，401
            context.setResponseStatusCode(HttpStatus.SC_UNAUTHORIZED);
            //返回友好提示
            context.setResponseBody("request error");
        }

        //返回值为null表示该过滤器什么都不做
        return null;
    }
}
