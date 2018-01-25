package com.bsit.common.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * 
 * 多线程调用需要注入的对象的时候用此工具类比较简单
 * 1、写此工具类
 * 2、配置文件：<bean name="springContextUtil" class="com.bsit.common.SpringContextUtil" />
 * 3、直接调用：HandleData handleData = (HandleData)SpingContextUtil.getSpringBean("handleData");
 *    最好在构造方法中或初始化时调用
 *
 */
public class SpringContextUtil implements ApplicationContextAware{
	
	private static ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext context) throws BeansException {
    	SpringContextUtil.context = context;
    }
   
    public static Object getSpringBean(String beanName) {
        return context == null ? null : context.getBean(beanName);
    }

    public static String[] getBeanDefinitionNames() {
        return context.getBeanDefinitionNames();
    }
}
