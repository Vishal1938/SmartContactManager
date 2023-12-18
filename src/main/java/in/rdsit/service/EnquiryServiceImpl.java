package in.rdsit.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.rdsit.binding.DashboardResponse;
import in.rdsit.binding.EnquiryForm;
import in.rdsit.binding.EnquirySearchCriteria;
import in.rdsit.entity.CourseEntity;
import in.rdsit.entity.EnqStatusEntity;
import in.rdsit.entity.StudentEnqEntity;
import in.rdsit.entity.UserDtlsEntity;
import in.rdsit.repo.CourseRepo;
import in.rdsit.repo.EnqStatusRepo;
import in.rdsit.repo.StudentEnqRepo;
import in.rdsit.repo.UserDtlsRepo;
import jakarta.servlet.http.HttpSession;

@Service
public class EnquiryServiceImpl  implements EnquiryService {
	
	@Autowired
	private UserDtlsRepo repo;
	
	@Autowired
	private CourseRepo courseRepo;
	
	@Autowired
	private EnqStatusRepo enqStatusRepo;
	
	@Autowired
	private StudentEnqRepo enqRepo;
	
	@Autowired
	private HttpSession session;

	@Override
	public DashboardResponse getDashboardData(Integer UserId) {
		// TODO Auto-generated method stub
		
		DashboardResponse response=new DashboardResponse();
		Optional<UserDtlsEntity> findById=repo.findById(UserId);
		
		if(findById.isPresent()) {
			UserDtlsEntity userEntity=findById.get();
			List<StudentEnqEntity> enquiries=userEntity.getEnquiries();
			
			Integer totaCnt=enquiries.size();			
			Integer enrolledCnt=enquiries.stream().filter(e->e.getEnqstatus().equals("Enrolled")).collect(Collectors.toList()).size();
			Integer lostCnt=enquiries.stream().filter(e->e.getEnqstatus().equals("LOST")).collect(Collectors.toList()).size();
			
			response.setEnrolledCnt(enrolledCnt);
			response.setLostCnt(lostCnt);
			response.setTotalEnquiries(totaCnt);
		}
		return response;
	}

	@Override
	public String addEnquiry(EnquiryForm form) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StudentEnqEntity> getEnquiries() {
		// TODO Auto-generated method stub
		Integer user=(Integer)session.getAttribute("userId");
		Optional<UserDtlsEntity> findById=repo.findById(user);
		
		if(findById.isPresent()) {
		UserDtlsEntity entity=	findById.get();
		List<StudentEnqEntity> enquiries=entity.getEnquiries();
		return enquiries;
		}
		return null;
	}

	@Override
	public List<String> getCourses() {
		// TODO Auto-generated method stub
		List<CourseEntity> findAll=courseRepo.findAll();
		List<String> courses=new ArrayList<String>();
		for(CourseEntity course:findAll)
		courses.add(course.getCourseName());
		
		return courses;
	}

	@Override
	public List<String> getEnqStatuses() {
		// TODO Auto-generated method stub
		List<EnqStatusEntity> findAll=enqStatusRepo.findAll();
		List<String> enqStatus=new ArrayList<>();
		for(EnqStatusEntity statuses:findAll ) {
			enqStatus.add(statuses.getStatusName());
		}
		return enqStatus;
	}

	@Override
	public boolean saveEnquiry(EnquiryForm form) {
		// TODO Auto-generated method stub
		StudentEnqEntity enqEntity=new StudentEnqEntity();
		BeanUtils.copyProperties(form, enqEntity);
	    Integer user= (Integer) session.getAttribute("userId");
	    
		UserDtlsEntity entity=repo.findById(user).get();
		
		enqEntity.setUserDtls(entity);
		enqRepo.save(enqEntity);
		return true;
		
	}

	@Override
	public List<StudentEnqEntity> getFilteredEnqs(EnquirySearchCriteria criteria, Integer userId) {
		// TODO Auto-generated method stub
		Integer user=(Integer)session.getAttribute("userId");
		Optional<UserDtlsEntity> findById=repo.findById(user);
		
		if(findById.isPresent()) {
		UserDtlsEntity entity=	findById.get();
		List<StudentEnqEntity> enquiries=entity.getEnquiries();
		
		if(null !=criteria.getCourseName() || "".equals(criteria.getCourseName())) {
			enquiries=enquiries.stream().filter(e->e.getCourseName().equals(criteria.getCourseName())).collect(Collectors.toList());
		}
		
		if(null !=criteria.getClassMode() || "".equals(criteria.getClassMode())) {
			enquiries=enquiries.stream().filter(e->e.getClassMode().equals(criteria.getClassMode())).collect(Collectors.toList());
		}
		
		if(null !=criteria.getEnqStatus() || "".equals(criteria.getEnqStatus())) {
			enquiries=enquiries.stream().filter(e->e.getEnqstatus().equals(criteria.getEnqStatus())).collect(Collectors.toList());
		}
		return enquiries;
		
		}
		return null;
	}
	
	
}
