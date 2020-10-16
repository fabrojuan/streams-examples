package ar.com.streams.model;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.function.Predicate;

public class Person {
	
	public enum Sex {
		FEMALE, MALE
	}
	
	String name;
	LocalDate birthday;
	Sex gender;
	String emailAddress;
	
	public Person(String name, LocalDate birthday, Sex gender, String emailAddress) {
		super();
		this.name = name;
		this.birthday = birthday;
		this.gender = gender;
		this.emailAddress = emailAddress;
	}
		
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getBirthday() {
		return birthday;
	}
	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}
	public Sex getGender() {
		return gender;
	}
	public void setGender(Sex gender) {
		this.gender = gender;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
	public int getAge() {
		Period periodo = Period.between(birthday, LocalDate.now());
		return periodo.getYears();
	}
	
	public static int compareByAge(Person a, Person b) {
        return a.birthday.compareTo(b.birthday);
    }
	
	public void printPerson() {
		System.out.println(this.name);
	}
	
}
