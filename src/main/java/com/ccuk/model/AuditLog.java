package com.ccuk.model;

import java.util.*;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import com.ccuk.model.enums.CountryCode;
import com.fasterxml.jackson.annotation.JsonFormat;

@Document(collection="auditlog")
public class AuditLog {
	
	private String id;
	private String uniqueId;
	private String annexFileName;
	private boolean annexStatus;
	private String scheduleFileName;
	private boolean scheduleStatus;
	private String username;
	private String system;
	
	@JsonFormat(pattern="dd/MM/yyyy")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private Date submittedDateTime;
	
	@JsonFormat(pattern="dd/MM/yyyy")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private List<Date> dateScheduled;
	private CountryCode countryCode;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUniqueId() {
		return uniqueId;
	}
	public void setUniqueId(String uniqueId) {
		this.uniqueId = uniqueId;
	}
	public String getAnnexFileName() {
		return annexFileName;
	}
	public void setAnnexFileName(String annexFileName) {
		this.annexFileName = annexFileName;
	}
	public boolean isAnnexStatus() {
		return annexStatus;
	}
	public void setAnnexStatus(boolean annexStatus) {
		this.annexStatus = annexStatus;
	}
	public String getScheduleFileName() {
		return scheduleFileName;
	}
	public void setScheduleFileName(String scheduleFileName) {
		this.scheduleFileName = scheduleFileName;
	}
	public boolean isScheduleStatus() {
		return scheduleStatus;
	}
	public void setScheduleStatus(boolean scheduleStatus) {
		this.scheduleStatus = scheduleStatus;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getSystem() {
		return system;
	}
	public void setSystem(String system) {
		this.system = system;
	}
	public Date getSubmittedDateTime() {
		return submittedDateTime;
	}
	public void setSubmittedDateTime(Date submittedDateTime) {
		this.submittedDateTime = submittedDateTime;
	}
	public List<Date> getDateScheduled() {
		return dateScheduled;
	}
	public void setDateScheduled(List<Date> dateScheduled) {
		this.dateScheduled = dateScheduled;
	}
	
	public CountryCode getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(CountryCode countryCode) {
		this.countryCode = countryCode;
	}
	@Override
	public String toString() {
		return "AuditLog [id=" + id + ", uniqueId=" + uniqueId + ", annexFileName=" + annexFileName + ", annexStatus="
				+ annexStatus + ", scheduleFileName=" + scheduleFileName + ", scheduleStatus=" + scheduleStatus
				+ ", username=" + username + ", system=" + system + ", submittedDateTime=" + submittedDateTime
				+ ", dateScheduled=" + dateScheduled + ", countryCode=" + countryCode + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((annexFileName == null) ? 0 : annexFileName.hashCode());
		result = prime * result + (annexStatus ? 1231 : 1237);
		result = prime * result + ((countryCode == null) ? 0 : countryCode.hashCode());
		result = prime * result + ((dateScheduled == null) ? 0 : dateScheduled.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((scheduleFileName == null) ? 0 : scheduleFileName.hashCode());
		result = prime * result + (scheduleStatus ? 1231 : 1237);
		result = prime * result + ((submittedDateTime == null) ? 0 : submittedDateTime.hashCode());
		result = prime * result + ((system == null) ? 0 : system.hashCode());
		result = prime * result + ((uniqueId == null) ? 0 : uniqueId.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AuditLog other = (AuditLog) obj;
		if (annexFileName == null) {
			if (other.annexFileName != null)
				return false;
		} else if (!annexFileName.equals(other.annexFileName))
			return false;
		if (annexStatus != other.annexStatus)
			return false;
		if (countryCode != other.countryCode)
			return false;
		if (dateScheduled == null) {
			if (other.dateScheduled != null)
				return false;
		} else if (!dateScheduled.equals(other.dateScheduled))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (scheduleFileName == null) {
			if (other.scheduleFileName != null)
				return false;
		} else if (!scheduleFileName.equals(other.scheduleFileName))
			return false;
		if (scheduleStatus != other.scheduleStatus)
			return false;
		if (submittedDateTime == null) {
			if (other.submittedDateTime != null)
				return false;
		} else if (!submittedDateTime.equals(other.submittedDateTime))
			return false;
		if (system == null) {
			if (other.system != null)
				return false;
		} else if (!system.equals(other.system))
			return false;
		if (uniqueId == null) {
			if (other.uniqueId != null)
				return false;
		} else if (!uniqueId.equals(other.uniqueId))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	
}
