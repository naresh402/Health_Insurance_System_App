package com.ashokit.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ashokit.model.HISCreateAccountBinding;
import com.ashokit.service.HISServiceImpl;


@Controller
public class HISCreateAccountRestController {

	
	
	@Autowired
	private HISServiceImpl hisServiceImpl;
	
	@GetMapping(value= {"/","/addHis"})
	public String loadForm(Model model) {
		HISCreateAccountBinding hb=new HISCreateAccountBinding();
		model.addAttribute("HIS", hb);
		return "userInfo";
	}
	
	@PostMapping("/saveHisUser")
	public String handleSubmitBtn(@ModelAttribute("contact") HISCreateAccountBinding hb,Model model) {
		boolean isSaved=hisServiceImpl.saveHISUserDetails(hb);
		if(isSaved) {
			model.addAttribute("succMsg", "SuccessFull Saved");
		}
		else {
			model.addAttribute("errMsg", "Failed To saved");
		}
		
		return "userInfo";

}
	
	@GetMapping("/viewHisUser")
	public String handleViewHISUserLink(Model model) {
		List<HISCreateAccountBinding> hisLIst=hisServiceImpl.getAllHISData();
		model.addAttribute("HIS", hisLIst);
		return "viewHISUserInfo";
	}
	
}
