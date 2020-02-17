package cn.hyj.web.listener;

import java.text.MessageFormat;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.annotation.WebListener;

/**
* @ClassName: MyServletContextAttributeListener
* @Description: ServletContext域对象中属性的变更的事件监听器
* @author: Acheron
* @date: 2019-12-22 下午10:53:04
*
*/ 
@WebListener
public class MyServletContextAttributeListener implements
        ServletContextAttributeListener {

    @Override
    public void attributeAdded(ServletContextAttributeEvent scab) {
        String str =MessageFormat.format(
                "ServletContext域对象中添加了属性:{0}，属性值是:{1}"
                ,scab.getName()
                ,scab.getValue());
        System.out.println(str);
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent scab) {
        String str =MessageFormat.format(
                "ServletContext域对象中删除属性:{0}，属性值是:{1}"
                ,scab.getName()
                ,scab.getValue());
        System.out.println(str);
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent scab) {
        String str =MessageFormat.format(
                "ServletContext域对象中替换了属性:{0}的值"
                ,scab.getName());
        System.out.println(str);
    }
}