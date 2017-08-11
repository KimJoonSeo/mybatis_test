package com.joonkim.joonkimMybatis.main;

import com.joonkim.joonkimMybatis.dao.PersonDAO;
import com.joonkim.joonkimMybatis.vo.Person;

public class RunMybatis {

	public static void main(String[] args) {		
		PersonDAO personDAO = new PersonDAO();
		
		Person person = new Person();
		
		person.setId(12);
		person.setName("Steph Curry");
		person.setDept("Sports Management");
		personDAO.save(person);
		
		System.out.println(personDAO.getData(12).getName() + " is saved!");
		System.out.println("---Data saved---");
		
		person.setName("Jimmy Butler");
		person.setDept("Accounting");
		personDAO.update(person);
		
		System.out.println(personDAO.getData(12).getName() + " is updated!");
		System.out.println("---Data updated---");
		
		person = personDAO.getData(12);
		System.out.println(person);
		
		personDAO.delete(12);
		System.out.println("---Data deleted---");
	}
}
