package in.rdsit.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.rdsit.entity.StudentEnqEntity;

public interface StudentEnqRepo extends JpaRepository<StudentEnqEntity,Integer> {

}
