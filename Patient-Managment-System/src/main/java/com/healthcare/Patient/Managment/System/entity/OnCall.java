package com.healthcare.Patient.Managment.System.entity;
import javax.persistence.*;

@Entity
@Table(name="on_call")
public class OnCall {

	@EmbeddedId
	private OnCallId onCallId;

	public OnCall() {
		super();
	}

	public OnCallId getOnCallId() {
		return onCallId;
	}

	public void setOnCallId(OnCallId onCallId) {
		this.onCallId = onCallId;
	}
}
