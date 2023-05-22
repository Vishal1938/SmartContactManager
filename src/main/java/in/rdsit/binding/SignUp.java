package in.rdsit.binding;


public class SignUp {
	
	private String name;
	
	private String email;
	
	private Long phno;
	
	

	public SignUp() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SignUp(String name, String email, Long phno) {
		super();
		this.name = name;
		this.email = email;
		this.phno = phno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getPhno() {
		return phno;
	}

	public void setPhno(Long phno) {
		this.phno = phno;
	}

	@Override
	public String toString() {
		return "SignUp [name=" + name + ", email=" + email + ", phno=" + phno + "]";
	}
	
	

}
