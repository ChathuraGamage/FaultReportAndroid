package com.faultreport.app;

public class Report {
	
	
	private String place;
	private String reporterid;
	private int category;
	private String Description;
	private String reportid;
	
	public Report(int category) {
		super();
		this.category = category;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getReporterid() {
		return reporterid;
	}

	public void setReporterid(String reporterid) {
		this.reporterid = reporterid;
	}

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getReportid() {
		return reportid;
	}

	public void setReportid(String reportid) {
		this.reportid = reportid;
	}
	

}
