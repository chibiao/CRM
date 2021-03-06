package com.tjetc.aspect;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tjetc.pojo.Systemlog;
import com.tjetc.mapper.SystemlogMapper;
import com.tjetc.utils.RequestUtils;
import org.aspectj.lang.JoinPoint;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

public class SystemAspect {
    @Autowired
    private SystemlogMapper systemlogMapper;
    public void writeLog(JoinPoint joinpoint) throws JsonProcessingException {
        Systemlog systemlog = new Systemlog();
        /*设置时间*/
        systemlog.setOptime(new Date());
        HttpServletRequest request = RequestUtils.getRequest();
        if(request!=null){
        	System.out.println(request.getRemoteAddr());
            systemlog.setIp(request.getRemoteAddr());
        }
        /*获取目标执行方法的全路径*/
        String name = joinpoint.getTarget().getClass().getName();
        /*获取方法名称*/
        String signature = joinpoint.getSignature().getName();
        String func=name+":"+signature;
        systemlog.setFnc(func);
        /*获取方法参数*/
        Object[] args = joinpoint.getArgs();
        String params = new ObjectMapper().writeValueAsString(args);
        systemlog.setParams(params);
        systemlogMapper.insert(systemlog);
    }
}
