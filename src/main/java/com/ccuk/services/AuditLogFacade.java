package com.ccuk.services;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccuk.model.AuditLog;
import com.ccuk.model.AuditLogResponse;
import com.ccuk.model.ScheduleSummary;
import com.ccuk.repository.AuditLogRepository;


@Service
public class AuditLogFacade {

	private static final Logger logger = LoggerFactory.getLogger(AuditLogFacade.class);
	
	int noOfDays =8;
	//public static final DateTimeFormatter DATE_TIME_FORMATER = DateTimeFormatter.ofPattern(DATE_FORMAT);
	
	@Autowired
	private AuditLogRepository auditLogRepository;
	
	public AuditLogResponse getAllLatestAuditLogs() 
	{
		logger.info("Inside AuditLogFacade, calling getAllLatestAuditLogs method");
		Date temp = new Date();
		Set<ScheduleSummary> scheduleSummaryList = new HashSet<>();
		Set<AuditLog> auditLogResList = new HashSet<>();
		Set<Date> availableDates = new HashSet<>();
		AuditLogResponse result = new AuditLogResponse();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String dateStr = null;
		Date currentDate =new Date(temp.getYear(), temp.getMonth(), temp.getDate());
		Date futureDate =new Date(temp.getYear(), temp.getMonth(), temp.getDate()+noOfDays);
		List<Date> dateChecker = new ArrayList<>();		
		for(int i=0;i<=noOfDays;i++)
		{
			Date newDate = new Date(temp.getYear(), temp.getMonth(), temp.getDate()+i);
			dateChecker.add(newDate);
		}
		
		
		List<AuditLog> auditLogList = auditLogRepository.getLatestAuditLogs(currentDate,futureDate);
		for (AuditLog auditLog : auditLogList) {
			List<Date> scheduledDate = auditLog.getDateScheduled();
			scheduledDate = removeTime(scheduledDate);
			for (Date date : dateChecker) {
				ScheduleSummary scheduleSummary = new ScheduleSummary();
				if(scheduledDate.contains(date))
				{
					dateStr = dateFormat.format(date);
					scheduleSummary.setDate(dateStr);
					scheduleSummary.setStatus(true);
					availableDates.add(date);
					scheduleSummaryList.add(scheduleSummary);
					auditLogResList.add(auditLog);
				}
			}
		}
		
		dateChecker.removeAll(availableDates);
		if(dateChecker.size()>0)
		{
			for (Date date : dateChecker) {
				ScheduleSummary scheduleSummaryfalse = new ScheduleSummary();
				dateStr = dateFormat.format(date);
				scheduleSummaryfalse.setDate(dateStr);
				scheduleSummaryfalse.setStatus(false);
				scheduleSummaryList.add(scheduleSummaryfalse);
			}
		}
		
		List<ScheduleSummary> listScheduleSummary = new ArrayList<>(scheduleSummaryList);
		List<AuditLog> listAuditLogRes = new ArrayList<>(auditLogResList);
		result.setAuditRecords(listAuditLogRes);
		Collections.sort(listScheduleSummary);
		result.setScheduleSummary(listScheduleSummary);
		logger.info("Inside AuditLogFacade, exexution finished for getAllLatestAuditLogs method with result {} "+result);
		return result;
	}

	private List<Date> removeTime(List<Date> dateList)
	{
		List<Date> result = new ArrayList<>();
		for (Date date : dateList) {
	        Calendar cal = Calendar.getInstance();
	        cal.setTime(date);
	        cal.set(Calendar.HOUR_OF_DAY, 0);
	        cal.set(Calendar.MINUTE, 0);
	        cal.set(Calendar.SECOND, 0);
	        cal.set(Calendar.MILLISECOND, 0);
	        result.add(cal.getTime());	
		}
		return result;	
	}
	
	private Date StringToDate(String Date) throws ParseException
	{
		 Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(Date); 
		 return date1;
		
	}
}
