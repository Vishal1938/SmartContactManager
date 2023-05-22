package in.rdsit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.rdsit.binding.LoginForm;
import in.rdsit.binding.SignUp;
import in.rdsit.binding.UnlockFrom;
import in.rdsit.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/signup")
	public String signUpPage(Model model) {
		model.addAttribute("user",new SignUp());
		return "signup";
	}
		
	@PostMapping("/signup")
	public String handleSignUp(@ModelAttribute("user") SignUp form,Model model) {
		
		boolean status=userService.signup(form);
		
		if(status) {
			model.addAttribute("sucmsg","Check your mail");
		}
		else {
			model.addAttribute("errmsg", "Provide Unique mail");
		}
		return "signup";
	}
	
	@GetMapping("/login")
	public String loginPage(Model model) {
		model.addAttribute("loginForm", new LoginForm());
		return "login";
	}
	
	@PostMapping("/login")
	public String login(@ModelAttribute LoginForm form,Model model) {
		String status=userService.login(form);
		if(status.contains("success")) {
			return "dashboard";
			//return "redirect:/dashboard";
		}
		model.addAttribute("errMsg",status);
		return "login";
	}
	
	/*@GetMapping("/unlock")
	public String unlockPage(@RequestParam String email,Model model) {
		UnlockFrom unlockformobj=new UnlockFrom();
		unlockformobj.setEmail(email);
		model.addAttribute("unlock",unlockformobj);
		
		return "unlock";
	}*/
	
	/*@GetMapping("/unlock")
	public String unlockPage(Model model) {
		model.addAttribute("unlockForm form",new UnlockFrom());		
		return "unlock";
	}*/
	/*@PostMapping("/unlock")
	public String unlockUserAccount( @ModelAttribute("unlock") UnlockFrom form,Model model) {
		if(form.getNewPwd().equals(form.getConfirmPwd())) {
			boolean status=userService.unlockAccount(form);
			if(status) {
				model.addAttribute("sucMsg","Your account is unlocked ");
			}
			else {
				model.addAttribute("errMsg", "Given tempPwd is not matched with your Provided pwd");
			}
		}
		else {
			model.addAttribute("errMsg","New Password and confirm password should be same");
		}
		return "unlock";
	}*/
		
	@PostMapping("/unlock")
	public String unlockUserAccount( @ModelAttribute("unlock") UnlockFrom form,Model model) {
		if(form.getNewPwd().equals(form.getConfirmPwd())) {
			boolean status=userService.unlockAccount(form);
			if(status) {
				model.addAttribute("sucMsg","Your account is unlocked ");
			}
			else {
				model.addAttribute("errMsg", "Given tempPwd is not matched with your Provided pwd");
			}
		}
		else {
			model.addAttribute("errMsg","New Password and confirm password should be same");
		}
		return "unlock";
	}
		
	@GetMapping("/forgotPwd")
	public String forgotPwdPage() {
		return "forgotPwd";
	}
	
	@PostMapping("/forgotPwd")
	public String forgotPwd(@RequestParam String email,Model model) {
		
		boolean status=userService.forgotPwd(email);
		if(status) {
			model.addAttribute("sucMsg","Your password sent to your mail");
		}
		else {
			model.addAttribute("errMsg","Invalid id");
		}
		return "forgotPwd";
	}

}
