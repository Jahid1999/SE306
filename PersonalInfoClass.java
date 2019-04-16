package hackathon;

import java.io.Serializable;

public class PersonalInfoClass implements Serializable
{

	private String name;
	private String FatherName;
	private String MotherName;
	private String DOB;
	private String address;
	private String regNo;
	
	public PersonalInfoClass()
	{
		
	}
	
	public PersonalInfoClass(String name,String FN,String MN,String DOB,String hometown,String regNo)
	{
		this.name=name;
		this.FatherName=FN;
		this. MotherName=MN;
		this.DOB=DOB;
		this.address=hometown;
		this.regNo=regNo;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFN() {
		return FatherName;
	}
	public void setFN(String fN) {
		FatherName = fN;
	}
	public String getMN() {
		return  MotherName;
	}
	public void setMN(String mN) {
		 MotherName = mN;
	}
	public String getDOB() {
		return DOB;
	}
	public void setDOB(String dOB) {
		DOB = dOB;
	}
	public String getHomeTown() {
		return address;
	}
	public void setHomeTown(String homeTown) {
		this.address = homeTown;
	}
	public String getRegNo() {
		return regNo;
	}

}
