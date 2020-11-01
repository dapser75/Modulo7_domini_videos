/*Author: @Daniel Arizu
 * 
 * Date: 26/10/20
 * 
 * Description: Ejercicio correspondiente al modulo 7 de java BACKEND
 * Esta clase contiene la información correspondiente a un usuario así como los métodos asociados al mismo.
 * 
 */

package com.videos.project;

import java.text.SimpleDateFormat;
import java.util.Date;

public class User {
	private String userid; //alamcenamos el nombre de usuario
	private String name; //almacenamos nombre real
	private String surname; //almacenamos nombre 
	private String password;
	private String accesdatauser;
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	 
	public  User(String userid, String name, String surname, String password) throws Exception{
		this.userid=userid;
		this.name=name;
		this.surname=surname;
		this.password=password;
		this.accesdatauser=sdf.format(new Date());//Guardamos la fecha en ese momento
				
	}
	
	//Metodo de creación para pruebas para modo de pruebas
	public User (String userid, String name, String surname, String password, String accesdatauser) {
		this.userid=userid;
		this.name=name;
		this.surname=surname;
		this.password=password;
		this.accesdatauser=accesdatauser;
	}
	
	//Metodo para la comparción de 2 usuarios
	public boolean equals(User olduser, User newuser) {
		boolean isusercreated=false;
		if (olduser.userid.equals(newuser.userid)) isusercreated=true;
		else isusercreated=false;//retorna false en el caso que el usuario no exista
		return isusercreated; 
	}
	
	//Metodo para retornar todos los campos de un usuario.
	public String getUser() {
		String getuser="";
		getuser=getUsernamecomplete() + ". " + getNameAndSurname() + ". " + getPassword() + ". " + getAccesDataUser() + ".";
		return getuser;
	}
	
	//*********************************    METODOS GETTERS PARA LOS DIFERNTES CAMPOS     *****************************************
		
	public String getUserId() {
		return userid;
	}
	
	public String getOnlyPassword() {
		return password;	
	}
		
	public String getPassword() {
		String getpassword = "Password: " + password;
		return getpassword;	
	}
	
	public String getUsernamecomplete() {
		String getsurname= "Nombre usuario: " + userid;
		return getsurname;
		
	}
	
	public String getNameAndSurname() {
		String getnameandsurname = "Nombre y Apellido: " + name + " " + surname;
		return getnameandsurname;
	}
	
	public String getAccesDataUser() {
		String getaccesdatauser= "Fecha de alta: " + accesdatauser;
		return getaccesdatauser;
	}
		
}
