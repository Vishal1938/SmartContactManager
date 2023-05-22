package in.rdsit.service;

import java.util.List;

import in.rdsit.binding.DashboardResponse;
import in.rdsit.binding.EnquiryForm;
import in.rdsit.binding.EnquirySearchCriteria;
import in.rdsit.entity.StudentEnqEntity;

public interface EnquiryService {
	
	public DashboardResponse getDashboardData(Integer UserId);
	
	public String addEnquiry(EnquiryForm form);
	
	public List<StudentEnqEntity> getEnquiries();
	
    public List<String> getCourses();
	
	public List<String> getEnqStatuses();
	
	public boolean saveEnquiry(EnquiryForm form);
	
	public List<StudentEnqEntity> getFilteredEnqs(EnquirySearchCriteria criteria,Integer userId);

	
	
}
