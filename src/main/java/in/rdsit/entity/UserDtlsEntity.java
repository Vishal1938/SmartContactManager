package in.rdsit.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="RDSIT_USER_DTLS")
public class UserDtlsEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer userId;
	
	private String name;
	
	private String email;
	
	private String pwd;
	private Long phno;
	private String accStatus;
	
	@OneToMany(mappedBy = "userDtls", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<StudentEnqEntity> enquiries;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
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

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public Long getPhno() {
		return phno;
	}

	public void setPhno(Long phno) {
		this.phno = phno;
	}

	public String getAccStatus() {
		return accStatus;
	}

	public void setAccStatus(String accStatus) {
		this.accStatus = accStatus;
	}

	public List<StudentEnqEntity> getEnquiries() {
		return enquiries;
	}

	public void setEnquiries(List<StudentEnqEntity> enquiries) {
		this.enquiries = enquiries;
	}

	public UserDtlsEntity(Integer userId, String name, String email, String pwd, Long phno, String accStatus,
			List<StudentEnqEntity> enquiries) {
		super();
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.pwd = pwd;
		this.phno = phno;
		this.accStatus = accStatus;
		this.enquiries = enquiries;
	}

	public UserDtlsEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
}
