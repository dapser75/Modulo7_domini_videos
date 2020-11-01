package com.videos.persistence;

import java.util.ArrayList;
import java.util.List;

import com.videos.project.User;



public class UsersRepository {
	private static List<User> users= new ArrayList<>();
	
	public UsersRepository() {
		
	}

	//Método para retornar todos los usuarios
	public static List<User> getAllUsers(){
		return new ArrayList<>(users);
	}
	
	
public boolean containsUsers(String newusername) {
	boolean userexists=false;
	if (users.size()>0) {
		for (int i=0; i<users.size();i++) {
			if (users.get(i).getUserId().equals(newusername)) {
				userexists=true;
				break;
			}
		}//end for
	}
	return userexists;
}
	
		
	public void addUser(User user) throws Exception{
		if (user==null) throw new Exception();
		users.add(user);
	}
	

	
	
}
