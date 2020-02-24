package com.healthcare.Patient.Managment.System.entity;

import java.sql.Timestamp;

import javax.persistence.*;

import org.hibernate.annotations.Immutable;

@Entity
@Immutable
@Table(name="patient_info_for_helpdesk")
public class OfficeWorkPatientInfoView {

	@Column(name="id")
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@Column(name="Insurance_id")
	private int insuranceId;
	@Column(name="patient_name")
	private String patientName;
	@Column(name="proc_starting_date")
	private Timestamp procStartingDate;
	@Column(name="proc_end_date")
	private Timestamp procEndDate;
	@Column(name="examination_room")
	private String examinationRoom;
	@Column(name="pcp_name")
	private String pcpName;
	@Column(name="assisting_nurse")
	private String assistingNurse;
	
	public int getInsuranceId() {
		return insuranceId;
	}
	public String getPatientName() {
		return patientName;
	}
	public Timestamp getProcStartingDate() {
		return procStartingDate;
	}
	public Timestamp getProcEndDate() {
		return procEndDate;
	}
	public String getExaminationRoom() {
		return examinationRoom;
	}
	public String getPcpName() {
		return pcpName;
	}
	public String getAssistingNurse() {
		return assistingNurse;
	}
	
	
	}
