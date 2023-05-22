package in.rdsit.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="RDSIT_ENQUIRY_STATUS")
public class EnqStatusEntity {
	
	@Id
	@GeneratedValue
	private Integer statusId;
	
	@Column
	private String statusName;

	public Integer getStatusId() {
		return statusId;
	}

	public void setStatusId(Integer statusId) {
		this.statusId = statusId; 
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	public EnqStatusEntity(Integer statusId, String statusName) {
		super();
		this.statusId = statusId;
		this.statusName = statusName;
	}

	public EnqStatusEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
