package com.aistar.util;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogUtil {

    @After("execution(* com.aistar.service.ProductService.add*(..))" +
            "||execution(* com.aistar.service.ProductService.update*(..))" +
            "||execution(* com.aistar.service.ProductService.delete*(..))")
    public void addLog(){
        System.out.println("添加日志》》》》》》》");
    }
}
