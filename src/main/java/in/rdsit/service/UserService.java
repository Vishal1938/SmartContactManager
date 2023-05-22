package in.rdsit.service;

import in.rdsit.binding.LoginForm;
import in.rdsit.binding.SignUp;
import in.rdsit.binding.UnlockFrom;

public interface UserService {
	
	
	public String login(LoginForm form) ;
	
	public boolean signup(SignUp form);
	
	public boolean unlockAccount(UnlockFrom form);
	
	public boolean forgotPwd(String email);
	
	
}
