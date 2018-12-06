package com.ccuk.resources;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ccuk.model.AuditLogResponse;
import com.ccuk.services.AuditLogFacade;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/audit-log-service")
public class AuditLogResource {
	
	private static final Logger logger = LoggerFactory.getLogger(AuditLogResource.class);
	
	@Autowired
	private AuditLogFacade auditLogFacade;
	
	
    @ApiOperation(value = "View a list of content plans which are having end date today onwards")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "AuditLog successfully retrieved"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
    @RequestMapping(value = "/auditlogs", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAuditLogs()
    {
    	AuditLogResponse result = new AuditLogResponse();
    	logger.info("Inside AuditLogResource, calling getAuditLogs service");
    	result = auditLogFacade.getAllLatestAuditLogs();
    	logger.info("finished the execution of getAuditLogs resource {} "+result);
    	return new ResponseEntity<AuditLogResponse>(result,HttpStatus.OK);
    }
}
