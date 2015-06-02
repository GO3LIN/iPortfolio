package com.iporfilio.beans;

import java.util.List;

import com.iportfolio.users.*;


public class UsersPL {
	private UsersDAO usersDAO; 

    public UsersDAO getUserDAO() { 
        return usersDAO; 
    } 

    public void setUserDAO(UsersDAO userDAO) { 
        this.usersDAO = userDAO; 
    } 
    
    public void addUser(Users user) { 
    	usersDAO.save(user); 
    } 
    
    public Users findUserById(Integer id) { 
        return usersDAO.findById(id); 
    } 
    
    
    public void updateUser(Users user) { 
    	usersDAO.merge(user); 
    } 
    
    public void deleteUser(Users user) { 
    	usersDAO.delete(user); 
    } 
    public List findAll()
    { return usersDAO.findAll();}



}

