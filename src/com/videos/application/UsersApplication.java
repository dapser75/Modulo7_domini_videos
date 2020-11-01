/*@Author: Daniel Arizu
 * 
 * Date 27/10/2020
 * 
 * 
 * Description: Ejercicio correspondiente al modulo 7 de java BACKEND
 * 
 * Esta clase contiene los métodos y comprobaciones asociadas a los usuarios.
 * 
 * 
 */


package com.videos.application;

import java.util.Scanner;

import com.videos.persistence.UsersRepository;
import com.videos.project.User;

public class UsersApplication {
	static Scanner registro = new Scanner(System.in);
	private UsersRepository userrepository = new UsersRepository();
	
	private StringApplication checkstring = new StringApplication(); //Objeto creado para el tratamiento de Strings
	
	
	//Método para solicitar los diferentes datos
	public void NewUserInput() throws Exception{
		String userid="";
		String name="";
		String surname="";
		String password="";
		boolean existsusercontrol=false;
		do {
			userid=InputUserId();
			existsusercontrol=userrepository.containsUsers(userid);
			if (existsusercontrol) System.out.println("\nEl nombre de usuario "+ userid + " ya existe; por favor ingrese otro.");
		}while(existsusercontrol);//(userrepository.containsUsers(userid));//Verificamos si existe el nombre de usuario
		
		//Llamada a los métodos para introducir datos
		name=InputWord("\nIntroduzca el NOMBRE nombre del usuario: "); 
		surname=InputWord("\nIntroduzca el APELLIDO nombre del usuario: ");
		password=InputPassword();
		userCreated(userid, name, surname, password);
	}
	
	
	//Método para crear el usuario e instertarlo en el repositorio.
	public void userCreated(String userid, String name, String surname, String password) throws Exception {
		try {
			User newuser = new User(userid, name, surname, password);
			userrepository.addUser(newuser);
		}catch (Exception e) {
			System.out.println("\nERROR: Se ha producido un error al crear el usuario. Por favor intentelo de nuevo.");
	
		}
	}
	
	//Metodo para introduxir 
	public String InputUserId() {
		String userid="";
		do {
			System.out.println("\nIntroduzca el identificador de usuario (UserID): ");
			userid = registro.nextLine().trim().toUpperCase();
		}while(checkstring.SpacesIWithSpaces(userid, "UserID") ||(!checkstring.CharacterNotOK(userid)));
		return userid;
	}
	
	public String InputPassword() {
		String password="";
		do {
			System.out.println("\nIntroduzca el password del usuario: ");
			password = registro.nextLine().trim();
		}while(checkstring.SpacesIWithSpaces(password, "password"));
		return password;
	}

	public String InputWord(String word) {
		String wordin="";
		do {
			System.out.println(word);
			wordin = registro.nextLine().trim().toUpperCase();
		}while (wordin.isBlank() || wordin.isEmpty());
		return wordin;
	}

	
	//********************************* ENTRADA DE DATOS POR DEFECTO ************************************************/
	public void UsersDefault() throws Exception {
		try {
			userrepository.addUser(new User("USERID1", "NAME1", "APELLIDO1", "12345","01/10/2020"));
			userrepository.addUser(new User("USERID2", "NAME2", "APELLIDO2", "12345","05/10/2020"));
			userrepository.addUser(new User("USERID3", "NAME3", "APELLIDO3", "12345","15/10/2020"));
			userrepository.addUser(new User("USERID4", "NAME4", "APELLIDO4", "12345","01/10/2018"));
		}
		catch(Exception e) {
			System.out.println("\nERROR: Se ha producido un error en la carga automatica de datos de USUARIOS; por favor pruebelo manualmente.");
				
		}
	}
}
