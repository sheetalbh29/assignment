package bean;

import java.util.Arrays;

public class User {
	String username;
	String password;
	String topic;
	int age;

	public User() {
		super();
	}

	public User(String username, String password, String topic, int age) {
		super();
		this.username = username;
		this.password = password;
		this.topic = topic;
		this.age = age;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", topic=" + topic + ", age=" + age + "]";
	}

	public boolean isValidAge() throws InvalidAgeException{
		if(age<18)
			throw new InvalidAgeException();
	
		else
			return true;
	}
}
