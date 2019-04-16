package hackathon;

import java.io.Serializable;

public class AcademicInfoClass implements Serializable
{
	
	private String regNo;
	private String semester;
	private String year;
	private String password;
	
	private double cgpa;
	
	public AcademicInfoClass(String regNo, String semester, String year, double cgpa,String password) 
	{
		this.regNo = regNo;
		this.semester = semester;
		this.year = year;
		this.cgpa = cgpa;
		this.password=password;
		
	}
	public String getRegNo() {
		return regNo;
	}
	
	public String getSemester() {
		return semester;
	}
	public void setSemester(String semester) {
		this.semester = semester;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public double getCgpa() {
		return cgpa;
	}
	public void setCgpa(double cgpa) {
		this.cgpa = cgpa;
	}

}