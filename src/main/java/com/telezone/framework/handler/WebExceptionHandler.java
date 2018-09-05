package com.telezone.framework.handler;

import com.telezone.framework.constant.ResultEnum;
import com.telezone.framework.constant.ResultModel;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 李树林
 * @description 当服务器出现异常时拦截并返回具体描述
 * @date 2018/8/24 11:14
 */
public class WebExceptionHandler {

    public static final String  ERROR_VIEW = "/error/404";

    @ExceptionHandler(value = Exception.class)
    public Object ExceptionHandler(HttpServletRequest request, HttpServletResponse respone, Exception e){
        e.printStackTrace();
        //如果是ajax请求
        if(isAjax(request)){
            return ResultModel.error(ResultEnum.ERROR_500);
            //如果是页面请求
        }else{
            ModelAndView mav = new ModelAndView();
            mav.addObject("exception",e);
            mav.addObject("url",request.getRequestURI());
            mav.setViewName(ERROR_VIEW);
            return mav;
        }
    }

    public static boolean isAjax(HttpServletRequest httpRequest){

        return (httpRequest.getHeader("X-Requested-With") != null
                && "XMLHttpRequest".equals(httpRequest.getHeader("X-Requested-With").toString()));
    }
}
