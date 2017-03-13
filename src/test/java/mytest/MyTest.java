package mytest;
import java.util.List;

import junit.*;

import org.springframework.aop.BeforeAdvice;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.demo.domain.User;
import com.demo.service.UserService;
public class MyTest {
	
	
	public  static void testuser() {
		ApplicationContext ac = new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml","spring-mvc.xml","spring-mybatis.xml"});
		//根据配置的service name 取得userService 接口的实现类
	    UserService  uc =  (UserService) ac.getBean("userService") ;
	    
	    //这里有个坑 mysql insert 语句中字段如果是mysql中的关键字，这个字段必须带 `` 否则认为语法错误，例如插入
	    //错误写法 insert into user (name, sex, sfz, add, code, csrq)  values('a','1','adfasd ','18963782','7987666','sdf')
	    //因为name code add 为关键字，应该用``括起来
       //正确写法  insert into user  (`name`, `sex`, `sfz`, `add`, `code`, `csrq`) values('a','1','adfasd ','18963782','7987666','sdf')
	    //自动生成的mapper.xml中insert 没有带`，需要加上
	   /** User  user  = new User(); 
	    	  user.setAdd("我的住址");
	    	  user.setCode("90890");
	    	  user.setCsrq("19800908");
	    	  user.setName("我的名子");
	    	  user.setSex("1");
	    	  user.setSfz("66122419800980");
	    	  
	    	 uc.addUser(user);**/
//	   List<User> ls =  uc.getAllUser();
//	   for (User user : ls) {
//		System.out.println(user.getAdd());
//	   }
	}
	
	
	public static void main(String[] args) {
		testuser();
	}

}
