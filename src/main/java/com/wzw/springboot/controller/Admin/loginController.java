package com.wzw.springboot.controller.Admin;

import com.wzw.springboot.entity.Admin.UsersEntity;
import com.wzw.springboot.service.Admin.UsersServiceI;
import com.wzw.springboot.util.Common;
import com.wzw.springboot.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

@Controller
public class loginController {
	@Autowired
	UsersServiceI usersServiceI;

	  //验证是否记录的用户名和密码
		@RequestMapping(value="/",method = RequestMethod.GET)
		public String getUserAndPassword(HttpServletRequest request, HttpServletResponse response, Model model) {
			Cookie[] cookies = request.getCookies();
			Boolean checkbox = false;
			String saveName="";
			String savePass="";
			if (cookies != null) {
				System.out.println("验证cookies");
				// 传递到登录页面，作为标签checkbox默认勾选的判断
				for (int i = 0; i < cookies.length; i++) {
					Cookie c = cookies[i];
					if (c.getName().equalsIgnoreCase("saveName")) {
						saveName = c.getValue();
						if (saveName.length() > 1) {
							checkbox = true;
						}
					} else if (c.getName().equalsIgnoreCase("savePass")) {
						savePass = c.getValue();
					}
				}
			}else{
				System.out.println("cookies验证无效");
			}
			System.out.println("saveName="+saveName+"====savePass="+savePass+"=====checkbox="+checkbox);
			model.addAttribute("saveName", saveName);
			model.addAttribute("savePass", savePass);
			model.addAttribute("checkbox", checkbox);
			System.out.println("登录页面跳转");
			return "login";
		}

		//系统登录
		@ResponseBody
		@RequestMapping("/login")
			public String login(HttpServletRequest request, HttpServletResponse response, String user_name, String password, Boolean checkbox) {
				HttpSession session=request.getSession();
				if(checkbox){
					  Cookie  namecookie = new Cookie("saveName", user_name);// 新建cookie对象
					  Cookie  passwordcookie = new Cookie("savePass", password);
					  namecookie.setMaxAge(60 * 60 * 24 * 365);// 设置cookie对象的有效时间
					  passwordcookie.setMaxAge(60 * 60 * 24 * 365);
					  response.addCookie(namecookie);
					  response.addCookie(passwordcookie);
				}else{
					 Cookie[] cookies=request.getCookies();
					for(Cookie cookie: cookies){
						cookie.setMaxAge(0);
						response.addCookie(cookie);
					}
				}

				UsersEntity loginSuccess = null;
				UsersEntity userinfor = new UsersEntity();
				userinfor.setUser_name(user_name);
				userinfor.setPassword(password);
				String biaozhi = "";
				/* 把实体中的密码重新设置一些，因为数据库中用md5加密 */
				String mm = password;
				userinfor.setPassword(Common.md5_2(userinfor.getPassword()));
				try {
					if (userinfor != null) {
						/* 查询数据 */
						System.out.println("查询用户");
						loginSuccess = (UsersEntity) this.usersServiceI.selectById(userinfor);
					}
				} catch (Exception e) {
					loginSuccess = null;
				}
			    String result=null;
				String status = "true";
				String message = "登录成功！";
				String message1=null;
				if (loginSuccess != null) {// 如果查到数据后就把查到的信息放到session 中
					System.out.println("用户存在session数据写入");
					//此处可加入查询权限菜单逻辑代码
					String menuobject ="菜单对象";
					String menu ="菜单集合";
					if(menu==null||menu.length()==0) {
						message1="00";
					}else{
						message1="11";
						loginSuccess.setLogintime(new Date());
						session.setAttribute("loginedUser", loginSuccess);
						session.setAttribute("saveName", user_name);
						session.setAttribute("savePass", password);
						session.setAttribute("pa", password);
						session.setAttribute("username", loginSuccess.getUser_name());
						session.setAttribute("userid", loginSuccess.getUser_id());
						session.setAttribute("truename", loginSuccess.getTrue_name());
						session.setAttribute("unitid", loginSuccess.getDepartment_code());
					}
					UsersEntity user = (UsersEntity) session.getAttribute("loginedUser");
					 Integer count=(Integer) request.getServletContext().getAttribute("count");
						if(count==null){
						  count=0;
						}
						//使当前在线人数 +1
						count++;
						request.getServletContext().setAttribute("count", count);
					status = "true";
					message = "登陆成功！";
					result="{\"status\":\""+status+"\",\"message\":\""+message+"\",\"message1\":\""+message1+"\"}";
				 } else {
					status = "false";
					message = "用户名或密码错误！";
					result="{\"status\":\""+status+"\",\"message\":\""+message+"\",\"message1\":\""+message1+"\"}";
				}
			return result;
			}

	@RequestMapping("/main")
	String main(Model model, HttpSession session) {
		UsersEntity user=	(UsersEntity)session.getAttribute("loginedUser");
	    model.addAttribute("loginedUser", user);
	    return "main";
	}
	@ResponseBody
	@RequestMapping("/hello")
	public JsonResult hello(Model model, HttpSession session) {
		UsersEntity user = new UsersEntity();
		String password = "11223344";
		user.setUser_name("张三丰");
		user.setPassword(password);
		user.setGender("男");
		user.setBirthday(new Date());
		user.setDepartment("助理");
		return JsonResult.ok(user);
	}

		//注销账号退出
		@RequestMapping("/admin/logout")
		public String logout(HttpServletRequest request, HttpServletResponse response){
			HttpSession session=request.getSession();
			session.invalidate();
			return  "redirect:index";
			
		}
    
    
}  