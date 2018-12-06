package com.ccuk.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class ScheduleSummary implements Comparable<ScheduleSummary>{

	private String date;
	private boolean status;
	
	@JsonIgnore
	private Date formattedDate;
	
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	public Date getFormattedDate() throws ParseException {
		 Date formattedDate=new SimpleDateFormat("dd/MM/yyyy").parse(date); 
		 return formattedDate;
	}
	public void setFormattedDate(Date formattedDate) {
		this.formattedDate = formattedDate;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + (status ? 1231 : 1237);
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
		ScheduleSummary other = (ScheduleSummary) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (status != other.status)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "ScheduleSummary [date=" + date + ", status=" + status + "]";
	}
	@Override
	public int compareTo(ScheduleSummary obj) {
		// TODO Auto-generated method stub
		int result =0;
		try {
			result= this.getFormattedDate().compareTo(obj.getFormattedDate());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result; 
	}	
}
