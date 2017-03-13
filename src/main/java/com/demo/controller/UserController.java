/**
 * 
 */
package com.demo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.demo.domain.User;
import com.demo.dto.ResponseDto;
import com.demo.dto.UserDto;
import com.demo.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	public List<User> list=null;
	@Autowired
	private UserService userService ; 

	/**
	 *  client ajax     
	 *   
	 * var sdata = {"name":"test","tel":"13245678","pwd":"pwd"} ;
      Tajax = function(url){
       $.ajax({
                url: url, 
                type:"POST",
                dataType:"json",
                data:JSON.stringify(sdata), 
                contentType:"application/json",
                //data:sdata,
                //async:true,
                success: function(res){
                    console.info(res);
//                   $.each(data.items,function(i,item){
//
//                    console.info(item.name);
//
//                           if(item.spec.containers != undefined &&  item.spec.containers[0].ports != undefined ){
//                                $.each(item.spec.containers,function(j,item){
//                                     $.each(item.ports,function(k,item){
//                                            cachePort(item.hostPort);
//                                    });
//
//                                });
//
//                            }
//
//                    });

                },
                error:function(){
                    console.info("get some error!") ; 
                }
            });
}

var regurl = "http://localhost:8080/springrestful/user/register";
var logurl = "http://localhost:8080/springrestful/user/login";

//Tajax(regurl);
Tajax(logurl);
	 * 
	 * 
*/
	@RequestMapping(value="register",method=RequestMethod.POST)
	@ResponseBody 
	  public Object  register(@RequestBody User user){  
		userService.addUser(user);
		//return new ModelAndView("user/index",model);
		return user ;
	}
	
	@RequestMapping(value="test",method=RequestMethod.GET)
	@ResponseBody 
	public ModelAndView test(){ //返回页面视图
		return new ModelAndView("user/test");
	}
	
	
	@RequestMapping(value="login",method=RequestMethod.POST)
	@ResponseBody 
	public Object mylogin(@RequestBody User user){ 
		ResponseDto res = new ResponseDto() ;
		res.setError("0");
		res.setInfo("ok");
		res.setUser_info(user);
		return res  ; 
	}
	
	
	
	/**
	 * user路径下默认显示用户列表
	 * @return
	 */
	@RequestMapping(method=RequestMethod.GET)
	@ResponseBody 
	//public ModelAndView index(){ //返回页面视图
	  public Object  index(){   //返回Josn 
		if(list==null){
			list=userService.getAllUser();
		}
		ModelMap model=new ModelMap();
		model.addAttribute("list",list);
		
		//return new ModelAndView("user/index",model);
		return list ;
	}
	
	
	/**
	 * 验证用户是否存在
	 * @return
	 */
	@RequestMapping(value="login/{name}/{password}",method=RequestMethod.GET)
	@ResponseBody 
	//public ModelAndView index(){ //返回页面视图
	  public Object  login(@PathVariable("name") String name,@PathVariable("password") String pwd){   //返回Josn 
		User u = userService.getUser(name);
		if(u!=null){
			return  u ; 
		}
		return null ;
	}
	
	/**
	 * 跳转到添加用户页面，约定优于配置，默认匹配文件/WEB-INF/views/user/add.jsp
	 */
	@RequestMapping("add")
	public void add(){}
	
	/**
	 * 新增保存用户
	 * @param user
	 * @return ModelAndView
	 */
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView addUser(User user){
		if(list==null){
			list=userService.getAllUser();
		}
		list.add(user);
		
		ModelMap model=new ModelMap();
		model.addAttribute("list",list);
		
		return new ModelAndView("user/index",model);
	}
	
	/**
	 * 查看用户详细信息
	 * @param id
	 * @return ModelAndView
	 */
	@RequestMapping(method=RequestMethod.GET,value="{id}")
	public ModelAndView viewUser(@PathVariable("id")String id){
		User user=findUserById(id);
		ModelMap model=new ModelMap();
		model.addAttribute("user",user);
		
		return new ModelAndView("user/view",model);
	}
	
	/**
	 * 删除用户
	 * @param id
	 */
	@ResponseBody
	@RequestMapping(method=RequestMethod.DELETE,value="{id}")
	public String deleteUser(@PathVariable("id")String id){
		if(list==null){
			list=userService.getAllUser();
		}
		removeUserByUserId(id);
		return "suc";
	}
	
	/**
	 * 跳转到编辑页面
	 * @param id
	 * @return ModelAndView
	 */
	@RequestMapping("{id}/edit")
	public ModelAndView toEdit(@PathVariable("id")String id){
		
		User user=findUserById(id);
		ModelMap model=new ModelMap();
		model.addAttribute("user",user);
		
		return new ModelAndView("user/edit",model);
	}
	
	/**
	 * 更新用户并跳转到用户列表页面
	 * @param user
	 * @return ModelAndView
	 */
	@RequestMapping(method=RequestMethod.PUT)
	public ModelAndView edit(User user){
		updateUser(user);
		return new ModelAndView("redirect:/user/");
	}
	
	

	/**
	 * 删除用户
	 * @param id
	 * @return List<User>
	 */
	private List<User> removeUserByUserId(String id){
		if(list==null)return null;
		for(User user:list){
			if(user.getId().equals(id)){
				list.remove(user);
				break;
			}
		}
		return list;
	}
	/**
	 * 查找用户
	 * @param id
	 * @return User
	 */
	private User findUserById(String id){
		User user=null;
		if(list==null)return null;
		for(User _user:list){
			if(_user.getId().equals(id)){
				user=_user;
				break;
			}
		}
		return user;
	}
	/**
	 * 更新用户
	 * @param user
	 */
	private void updateUser(User user){
		for(User _user:list){
			if(_user.getId().equals(user.getId())){
				_user.setName(user.getName());
				break;
			}
		}
	}
	
	
}
