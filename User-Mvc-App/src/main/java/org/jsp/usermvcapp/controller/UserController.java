package org.jsp.usermvcapp.controller;

import org.jsp.usermvcapp.dao.UserDao;
import org.jsp.usermvcapp.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
	@Autowired
	private UserDao userDao;

	@RequestMapping("/test")
	@ResponseBody
	public String testConfig() {
		return userDao.getManager().toString();
	}

	@RequestMapping(value = "/open-register")
	public ModelAndView openRegister() {
		ModelAndView view = new ModelAndView();
		view.setViewName("register");
		view.addObject("u", new User());
		return view;
	}

	@PostMapping(value = "/register")
	public ModelAndView register(@ModelAttribute User u, ModelAndView view) {
		u = userDao.saveUser(u);
		view.setViewName("print");
		view.addObject("message", "User saved with Id:" + u.getId());
		return view;
	}

	@RequestMapping(value = "/open-update")
	public ModelAndView openUpdate(ModelAndView view) {
		view.setViewName("update");
		view.addObject("u", new User());
		return view;
	}

	@PostMapping("/update")
	public ModelAndView update(@ModelAttribute User u, ModelAndView view) {
		u = userDao.updateUser(u);
		if (u != null) {
			view.setViewName("print");
			view.addObject("message", "User Updated");
			return view;
		} else {
			view.setViewName("print");
			view.addObject("message", "Cannot Update User");
			return view;
		}
	}

	@RequestMapping("/open-view")
	public String openView(String view) {
		return view;
	}

	@GetMapping("/find-by-id")
	public ModelAndView findById(@RequestParam int id, ModelAndView view) {
		User u = userDao.findUserById(id);
		if (u != null) {
			view.setViewName("display");
			view.addObject("u", u);
			return view;
		}
		view.setViewName("print");
		view.addObject("message", "Invalid Id or Password");
		return view;
	}

	@GetMapping("/verify-by-id")
	public ModelAndView verifyById(@RequestParam int id, @RequestParam String password, ModelAndView view) {
		User u = userDao.verifyUserById(id, password);
		if (u != null) {
			view.setViewName("display");
			view.addObject("u", u);
			return view;
		}
		view.setViewName("print");
		view.addObject("message", "Invalid Id or Password");
		return view;
	}

	@GetMapping("/verify-by-phone")
	public ModelAndView verifyByPhone(@RequestParam long phone, @RequestParam String password, ModelAndView view) {
		User u = userDao.verifyUserByPhone(phone, password);
		if (u != null) {
			view.setViewName("display");
			view.addObject("u", u);
			return view;
		}
		view.setViewName("print");
		view.addObject("message", "Invalid Phone or Password");
		return view;
	}

	@GetMapping("/verify-by-email")
	public ModelAndView verifyByEmail(@RequestParam String email, @RequestParam String password, ModelAndView view) {
		User u = userDao.verifyUserByEmail(email, password);
		if (u != null) {
			view.setViewName("display");
			view.addObject("u", u);
			return view;
		}
		view.setViewName("print");
		view.addObject("message", "Invalid Email or Password");
		return view;
	}
	
	@RequestMapping("/delete-by-id")
	public ModelAndView delete(@RequestParam int id, ModelAndView view) {
		boolean deleted = userDao.deleteUser(id);
		if (deleted) {
			view.setViewName("print");
			view.addObject("message", "User deleted");
			return view;
		}
		view.setViewName("print");
		view.addObject("message", "Cannot delete user as Id is Invalid");
		return view;
	}
}
