package in.rdsit.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.rdsit.entity.CourseEntity;

public interface CourseRepo extends JpaRepository<CourseEntity,Integer>{

}
