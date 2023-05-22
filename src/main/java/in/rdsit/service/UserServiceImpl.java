package in.rdsit.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.rdsit.binding.LoginForm;
import in.rdsit.binding.SignUp;
import in.rdsit.binding.UnlockFrom;
import in.rdsit.entity.UserDtlsEntity;
import in.rdsit.repo.UserDtlsRepo;
import in.rdsit.util.EmailUtils;
import in.rdsit.util.PwdUtils;
import jakarta.servlet.http.HttpSession;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDtlsRepo repo;
	
	@Autowired
	private EmailUtils emailUtils;
	
	@Autowired
	private HttpSession session;

	@Override
	public String login(LoginForm form) {
		UserDtlsEntity entity=repo.findByEmailAndPwd(form.getEmail(), form.getPwd());
		if(entity==null) {
			return "Invalid Creadentials";
		}
		if(entity.getAccStatus().equalsIgnoreCase("Unlocked")) {
			return "Your Account is already Unlocked";
		}
		//create seesion and store user data in session
		session.setAttribute("userId", entity.getPwd());
		return "success";
	}

	@Override
	public boolean signup(SignUp form) {
		
		UserDtlsEntity user=repo.findByEmail(form.getEmail());
		
		if(user!=null) {
			return false;
		}
		
		//Copy data from binding object to entity object
		UserDtlsEntity entity=new UserDtlsEntity();
		BeanUtils.copyProperties(form, entity);
		
	   //Generate Random pwd and set to Object
		String tempPwd=PwdUtils.generateRandomPwd();
		entity.setPwd(tempPwd);
		
		//Set Account status as Locked;
		entity.setAccStatus("LOCKED");
		
		//Insert Record
		repo.save(entity);
		
		//Send Mail to unlock Account
		String to=form.getEmail();
		String subject="Unlock the Account RDSIT ";
		
		StringBuffer body=new StringBuffer("");
		body.append("<h1>Use the below password to Unlock your Account</h1>");
		body.append("Temprory Password :"+tempPwd);
		body.append("<a href=\"http://localhost:8080unlock?email="+to+"\">click here to unlock the account</a>");
		emailUtils.sendEmail(to,subject , body.toString());
		return true;
	}

	@Override
	public boolean unlockAccount(UnlockFrom form) {
		// TODO Auto-generated method stub
		
		UserDtlsEntity entity=repo.findByEmail(form.getEmail());
		if(entity.getPwd().equals(form.getTempPwd())) {
			entity.setPwd(form.getNewPwd());
			entity.setAccStatus("UnLocked");
			repo.save(entity);
			return true;
		}
		else {
			return false;
		}	
	}

	@Override
	public boolean forgotPwd(String email) {
		UserDtlsEntity entity=repo.findByEmail(email);
		if(entity==null) {
			return false;
		}
		String Subject="Recover password";
		String body="Your Password :"+entity.getPwd();
		//service.sendEmail(email, Subject, body.toString());
		//emailUtils.sendEmail(email, Subject, body);
		//Email sending property have some problem that'why i am printing it o console
		System.out.println(Subject+"\n"+body);
			return true;
	}

}
