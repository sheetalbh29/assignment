package Answer2;

import java.util.Arrays;

public class User {
	private String firstName;
	private String surName;
	private String loginName;
	private String password;
	private int age;
	private String[] topics;
	public User(String firstName, String surName, String loginName,String password,int age, String[] topics) {
		super();
		this.firstName = firstName;
		this.surName = surName;
		this.loginName = loginName;
		this.password=password;
		this.age = age;
		this.topics = topics;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getSurName() {
		return surName;
	}
	public void setSurName(String surName) {
		this.surName = surName;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getpassword() {
		return password;
	}
	public void setpassword(String password) {
		this.password = password;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String[] getTopics() {
		return topics;
	}
	public void setTopics(String[] topics) {
		this.topics = topics;
	}
	@Override
	public String toString() {
		return "Users [firstName=" + firstName + ", surName=" + surName + ", loginName=" + loginName + ", password = "+password+", age=" + age
				+ ", topics=" + Arrays.toString(topics) + "]";
	}

}
