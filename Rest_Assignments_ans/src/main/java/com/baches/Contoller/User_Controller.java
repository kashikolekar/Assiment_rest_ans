package com.baches.Contoller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.baches.Servi.Service_user;
import com.baches.User.User;






@RestController
public class User_Controller {
	
	@Autowired
	private Service_user ser;
	
	
	@GetMapping("/user")
	public ResponseEntity<List<User>>  getBooks()
	{

		 
	List<User> list = ser.getAll();
	if(list.size()==0)
	{
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	return ResponseEntity.status(HttpStatus.CREATED).body(list);
	
	
	}
	
	@GetMapping("/user/{id}")
	public ResponseEntity<User> getUser(@PathVariable("id") Long id)
	{
		
		 User user = ser.GetById(id);
		 if(user==null)
		 {
			 return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		 }
		 return ResponseEntity.of(Optional.of(user));
	}
	
	
	
	
	@PostMapping("/user")
	public ResponseEntity<User> addBook(@RequestBody User u)
	{
		
		
		try {
		User u1 = this.ser.ADD_DATE(u);
		 return  ResponseEntity.of(Optional.of(u1));
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
		}
		
	}
	
	@DeleteMapping("/user/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable("id") Long id)
	{
		try {
	  this.ser.DeleteUser(id);
	  return ResponseEntity.status(HttpStatus.OK).build();
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
	}
	
	@PutMapping("/user/{id}")
	public ResponseEntity<User> updateUser(@RequestBody User updatedUser, @PathVariable("id") Long id) {
	    try {
	        System.out.println("in");
	        if (updatedUser == null) {
	            return ResponseEntity.badRequest().body(null);
	        }

	        System.out.println(updatedUser);
	        
	        User user = ser.Update(updatedUser, id);

	        
	        System.out.println(user);
	        
	        if (user != null) {
	            return ResponseEntity.ok(user);
	        } else {
	            
	            return ResponseEntity.notFound().build();
	        }
	    } catch (Exception e) {
	        
	        e.printStackTrace();
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	    }
	}

}
