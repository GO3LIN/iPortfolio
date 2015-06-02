package com.iporfilio.beans;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.iportfolio.users.Users;



public class mainUsers {

		public static void main(String[] args)  {
			
	        
	        //aff();
	        adduser();
		}
		/*
		
		public static void printUser(String extra, Users user)
		{
			BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("applicationContext.xml")); 
			
		System.out.println("User :"+user.getPseudo() +" Password :"+ user.getPass() +" email :"+ user.getEmail()+" Password :"+ user.getLastIp());	
		}
		
		public static void aff(){
			 
			BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("applicationContext.xml")); 
	        UsersPL P = (UsersPL) beanFactory.getBean("usersPL");
	        //User A = new User();
	        List<Users> A = P.findAll();
			for(int i=0;i<A.size();i++){
			printUser("Printing User",A.get(i));
			}
			System.out.println("");
			
		}
		

		
		
		//Suppression
		public static void remove() {
			BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("applicationContext.xml")); 
	        UsersPL P = (UsersPL) beanFactory.getBean("usersPL");
	        Users user = new Users();
	        user=P.findUserById(2);
	        P.deleteUser(user);
	        System.out.println("Avec succes sir chouf");
			
		}
		
		
		*/
		
		//Ajouter
		public static void adduser(){
			BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("applicationContext.xml")); 
	        UsersPL P = (UsersPL) beanFactory.getBean("UsersDAO");
			Users B =new Users();

			Date date= new Date();
			Short sh = 3;
			
			//B.setId(3);
			B.setPseudo("testuserid");
			B.setPass("testuser");
			B.setEmail("testuser@testuser");
			B.setLastIp("192.1.1.1");
			B.setDateInscri(new Timestamp(date.getDate()));
			B.setRank(sh);
			System.out.println("Ajouter avec succes!!");
			
			System.out.println("L'utilisateur dont id ="+B.getPseudo() +" Fut ajouter avec succes ");
			P.addUser(B);
			}
		//Modification
		public static void modify()
		{	
			BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("applicationContext.xml")); 
			UsersPL P = (UsersPL) beanFactory.getBean("usersPL");
			/*Users B = P.findUsersById(12);
			B.setNom("admins");
	        P.updateUsers(B); 
	        System.out.println("OK");	
	*/
		}
	

}
