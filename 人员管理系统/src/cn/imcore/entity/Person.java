package cn.imcore.entity;

public class Person {
	private int pId;
	private String pName;
	private String pAge;
	private String pSex;
	private String pAddr;
	
	public Person() {
		
	}
	
	public Person(int pId, String pName, String pAge, String pSex, String pAddr) {
		super();
		this.pId = pId;
		this.pName = pName;
		this.pAge = pAge;
		this.pSex = pSex;
		this.pAddr = pAddr;
	}
	public int getpId() {
		return pId;
	}
	public void setpId(int pId) {
		this.pId = pId;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public String getpAge() {
		return pAge;
	}
	public void setpAge(String pAge) {
		this.pAge = pAge;
	}
	public String getpSex() {
		return pSex;
	}
	public void setpSex(String pSex) {
		this.pSex = pSex;
	}
	public String getpAddr() {
		return pAddr;
	}
	public void setpAddr(String pAddr) {
		this.pAddr = pAddr;
	}
	
	

}
