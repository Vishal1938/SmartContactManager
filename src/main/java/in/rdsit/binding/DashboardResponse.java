package in.rdsit.binding;

public class DashboardResponse {

	private Integer totalEnquiries;
	
	private Integer enrolledCnt;
	
	private Integer lostCnt;

	public Integer getTotalEnquiries() {
		return totalEnquiries;
	}

	public void setTotalEnquiries(Integer totalEnquiries) {
		this.totalEnquiries = totalEnquiries;
	}

	public Integer getEnrolledCnt() {
		return enrolledCnt;
	}

	public void setEnrolledCnt(Integer enrolledCnt) {
		this.enrolledCnt = enrolledCnt;
	}

	public Integer getLostCnt() {
		return lostCnt;
	}

	public void setLostCnt(Integer lostCnt) {
		this.lostCnt = lostCnt;
	}

	public DashboardResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DashboardResponse(Integer totalEnquiries, Integer enrolledCnt, Integer lostCnt) {
		super();
		this.totalEnquiries = totalEnquiries;
		this.enrolledCnt = enrolledCnt;
		this.lostCnt = lostCnt;
	}
	
}
