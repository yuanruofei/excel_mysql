package entity;

import jxl.write.DateTime;

public class Tb_Student {
	private int id;
	private String name;
	private String sex;
	private int age;
	private String register_date;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getRegister_date() {
		return register_date;
	}
	public void setRegister_date(String register_date) {
		this.register_date = register_date;
	}
	
	public Tb_Student() {
		super();
	}
	public Tb_Student(int id, String name, String sex, int age,
			String register_date) {
		super();
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.register_date = register_date;
	}
	
	@Override
	public String toString() {
		return "Tb_Student [id=" + id + ", name=" + name + ", sex=" + sex
				+ ", age=" + age + ", register_date=" + register_date + "]";
	}
	
	
}
