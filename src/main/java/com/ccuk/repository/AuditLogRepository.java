package com.ccuk.repository;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.ccuk.model.AuditLog;

@Repository
public class AuditLogRepository {

    @Autowired
    private MongoTemplate mongoTemplate;
    
    private static final Logger logger = LoggerFactory.getLogger(AuditLogRepository.class);
	
	public List<AuditLog> getLatestAuditLogs(Date currentDate, Date futureDate)
	{
		logger.info("Inside AuditLogRepository : calling getLatestAuditLogs with Date {} "+new Date());
		Query searchQuery =new Query().addCriteria(where("system").is("Middleware"));
		searchQuery.addCriteria(where("dateScheduled").gte(currentDate).lte(futureDate));
		logger.info("search query formed {} "+searchQuery);
		List<AuditLog> result = mongoTemplate.find(searchQuery, AuditLog.class);
		
		return result;
	}
}
