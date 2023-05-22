package in.rdsit.binding;

public class EnquiryForm {
	
	private String studentName;
	
	private Long phno;
	
	private String courseName;
	
	private String courseMode;
	
	private String enqStatus;

	public EnquiryForm() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EnquiryForm(String studentName, Long phno, String courseName, String courseMode, String enqStatus) {
		super();
		this.studentName = studentName;
		this.phno = phno;
		this.courseName = courseName;
		this.courseMode = courseMode;
		this.enqStatus = enqStatus;
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

	public String getCourseMode() {
		return courseMode;
	}

	public void setCourseMode(String courseMode) {
		this.courseMode = courseMode;
	}

	public String getEnqStatus() {
		return enqStatus;
	}

	public void setEnqStatus(String enqStatus) {
		this.enqStatus = enqStatus;
	}
	
	

}
