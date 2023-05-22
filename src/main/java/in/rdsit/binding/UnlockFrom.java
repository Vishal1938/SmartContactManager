package in.rdsit.binding;

public class UnlockFrom {
	
	private String email;
	private String tempPwd;
	private String newPwd;
	private String confirmPwd;
	
	
	
	public UnlockFrom() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public UnlockFrom(String email, String tempPwd, String newPwd, String confirmPwd) {
		super();
		this.email = email;
		this.tempPwd = tempPwd;
		this.newPwd = newPwd;
		this.confirmPwd = confirmPwd;
	}

	public String getConfirmPwd() {
		return confirmPwd;
	}


	public void setConfirmPwd(String confirmPwd) {
		this.confirmPwd = confirmPwd;
	}


	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTempPwd() {
		return tempPwd;
	}
	public void setTempPwd(String tempPwd) {
		this.tempPwd = tempPwd;
	}
	public String getNewPwd() {
		return newPwd;
	}
	public void setNewPwd(String newPwd) {
		this.newPwd = newPwd;
	}
	
	

}
