package in.rdsit.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class StudentEnqEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer enqId;
	private String studentName;
	private Long phno;
	private String courseName;
	private String className;
	private String classMode;
	private String enqstatus;
	private Date createdDate;
	private Date updateDate;
	
	
	 @ManyToOne
	 @JoinColumn(name = "userId")
	 private UserDtlsEntity userDtls;
	 
	public UserDtlsEntity getUserDtls() {
		return userDtls;
	}
	public void setUserDtls(UserDtlsEntity userDtls) {
		this.userDtls = userDtls;
	}
	public Integer getEnqId() {
		return enqId;
	}
	public void setEnqId(Integer enqId) {
		this.enqId = enqId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public Long getPhno() {
		return phno;
	}
	public void setPhno(Long phno) {
		this.phno = phno;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getClassMode() {
		return classMode;
	}
	public void setClassMode(String classMode) {
		this.classMode = classMode;
	}
	public String getEnqstatus() {
		return enqstatus;
	}
	public void setEnqstatus(String enqstatus) {
		this.enqstatus = enqstatus;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	
}
