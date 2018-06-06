package MongoDB;
import java.io.*;

/*
 * 
 * MVC model
 * (Model)
 * 
 * 
 * 
 */


public class MongoBeans implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String year_;
	private String duration_;
	private String natio_;
	private String name_;
	private String age_;
	private String title_;
	
	//constructor
	public MongoBeans(){
		this.year_ = "";
		this.duration_ = "";
		this.natio_ = "";
		this.name_ = "";
		this.age_ = "";
		this.title_ = ""; 
	}
	
	public MongoBeans(String title, String year, String duration, String natio, String name, String age){
		this.year_ = year;
		this.duration_ = duration;
		this.natio_ = natio;
		this.name_ = name;
		this.age_ = age;
		this.title_ = title;
	}
	
	//year
	public void setyear(String year) {
		this.year_ = year;
	}
	public String getyear(){
		return this.year_;
	}
	
	//duration
	public void setduration(String duration){
		this.duration_ = duration;
	}
	
	public String getduration() {
		return this.duration_;
	}
	
	//natio
	public void setnatio(String natio) {
		this.natio_ = natio;
	}
	
	public String getnatio() {
		return this.natio_;
	}
	
	//name
	public void setname(String name) {
		this.name_ = name;
		
	}
	public String getname() {
		return this.name_;
	}
	
	//age 
	public void setage(String age) {
		this.age_ = age;
	}
	public String getage() {
		return this.age_;
	}
	
	//title
	public void settitle(String title) {
		this.title_ = title;
	}
	public String gettitle() {
		return this.title_;
	}

}