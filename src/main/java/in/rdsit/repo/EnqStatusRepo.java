package in.rdsit.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.rdsit.entity.EnqStatusEntity;

public interface EnqStatusRepo extends JpaRepository<EnqStatusEntity,Integer> {

}
