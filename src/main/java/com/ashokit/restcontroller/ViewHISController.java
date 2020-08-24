package com.ashokit.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ashokit.model.HISCreateAccountBinding;
import com.ashokit.service.HISServiceImpl;

@Controller
public class ViewHISController {
	
	@Autowired
	private HISServiceImpl hisServiceImpl;
	
	@GetMapping("/editHisUser")
	public String editUser(@RequestParam("uId") Integer uId, Model model) {
		HISCreateAccountBinding h = hisServiceImpl.getHisUserById(uId);
	    model.addAttribute("contact",h );
		return "userInfo";
	}
      
	@RequestMapping("/deleteHisUser")
	public String deleteHisUser(@RequestParam("userId") Integer userId) {
		Boolean isDelete = hisServiceImpl.deleteById(userId);
		if(isDelete) {
			return "redirect:/viewHisUser";
		}
		return null;
	}

}
