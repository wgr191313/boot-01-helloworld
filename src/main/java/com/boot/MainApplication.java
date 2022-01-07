package com.boot;

import ch.qos.logback.core.LifeCycleManager;
import ch.qos.logback.core.status.InfoStatus;
import com.boot.bean.Pet;
import com.boot.bean.User;
import com.boot.config.MyConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author wangguanru
 * @date 2022-01-07
 * 主程序类
 * 这是一个SpringBoot应用
 */
@SpringBootApplication
public class MainApplication {

    public static void main(String[] args) {
        //1.返回我们的IOC容器
        ConfigurableApplicationContext run = SpringApplication.run(MainApplication.class, args);

        //2.查看容器里的组件
        String[] names = run.getBeanDefinitionNames();
        for (String name:
             names) {
            System.out.println(name);
        }

        //3.从容器中获取组件
        Pet tom01 = run.getBean("tom", Pet.class);
        Pet tom02 = run.getBean("tom", Pet.class);
        System.out.println("组件:"+(tom01 == tom02));

        //4.com.boot.config.MyConfig$$EnhancerBySpringCGLIB$$124f1d30@13e698c7
        MyConfig bean=run.getBean(MyConfig.class);
        System.out.println(bean);

        //如果@Configuration(proxyBeanMethods = true)代理对象调用方法。SpringBoot总会检查这个组件是否在容器中有。
        //保持组件单实例
        User user = bean.user01();
        User user1 = bean.user01();
        System.out.println(user == user1);


        User user01=run.getBean("user01",User.class);
        Pet tom=run.getBean("tom",Pet.class);
        System.out.println("用户的宠物"+(user01.getPet()== tom));

        //5.获取组件
        String[] beanNamesForType = run.getBeanNamesForType(User.class);
        System.out.println("=========");
        for (String s:beanNamesForType
             ) {
            System.out.println(s);
        }
        LifeCycleManager bean1 = run.getBean(LifeCycleManager.class);
        System.out.println(bean1);

    }





}
