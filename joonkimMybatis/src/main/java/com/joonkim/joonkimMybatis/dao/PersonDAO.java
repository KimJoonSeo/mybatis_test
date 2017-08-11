package com.joonkim.joonkimMybatis.dao;

import org.apache.ibatis.session.SqlSession;

import com.joonkim.joonkimMybatis.util.MyBatisUtil;
import com.joonkim.joonkimMybatis.vo.Person;

public class PersonDAO {
	public void save(Person person) {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		session.insert("mapper.PersonMapper.insertPerson", person);
		// VillageMapper.xml안 <mapper namespace="">의 값.쿼리ID
		session.commit();
		session.close();
	}

	public void update(Person person) {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		session.update("mapper.PersonMapper.updatePerson", person);
		session.commit();
		session.close();
	}

	public void delete(int id) {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		session.delete("mapper.PersonMapper.deletePerson", id);
		session.commit();
		session.close();
	}

	public Person getData(int id) {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		Person person = session.selectOne("mapper.PersonMapper.selectPerson", id);
		session.close();
		return person;
	}

}
