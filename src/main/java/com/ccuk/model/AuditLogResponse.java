package com.ccuk.model;

import java.util.List;

public class AuditLogResponse {

	private List<ScheduleSummary> scheduleSummary;
	private List<AuditLog> auditRecords;
	
	public List<ScheduleSummary> getScheduleSummary() {
		return scheduleSummary;
	}
	public void setScheduleSummary(List<ScheduleSummary> scheduleSummary) {
		this.scheduleSummary = scheduleSummary;
	}
	public List<AuditLog> getAuditRecords() {
		return auditRecords;
	}
	public void setAuditRecords(List<AuditLog> auditRecords) {
		this.auditRecords = auditRecords;
	}
	
	@Override
	public String toString() {
		return "AuditLogResponse [scheduleSummary=" + scheduleSummary + ", auditRecords=" + auditRecords + "]";
	}
	
	
}
