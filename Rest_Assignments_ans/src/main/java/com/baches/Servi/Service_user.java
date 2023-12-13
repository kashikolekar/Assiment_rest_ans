package com.baches.Servi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baches.User.User;
import com.baches.User_dao.User_Dao;

import jakarta.persistence.EntityNotFoundException;


@Service
public class Service_user {

	@Autowired
	private User_Dao dao;
	
	public List<User> getAll()
	{
		return dao.findAll();
	}
	
	public User GetById(Long id)
	{
		return dao.getById(id);
	}
	
	public void DeleteUser(Long id)
	{
		dao.deleteById(id);
	}
	
	public User ADD_DATE(User u)
	{
		
		User u1 = (User) this.dao.save(u);
		return u1;
	}
	
	public User Update(User u,Long id)
	{
		
		System.out.println(u);
		 User existingUser = dao.findById(id).orElse(null);

		    if (existingUser == null) {
		        
		        throw new EntityNotFoundException("User with ID " + id + " not found");
		    }

		    u.setUser_id(id);
		    return dao.save(u);
		
	}
}
