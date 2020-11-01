/*@Author: Daniel Arizu
 * 
 * Date 27/10/2020
 * 
 * 
 * Description: Ejercicio correspondiente al modulo 7 de java BACKEND
 * 
 * Esta clase contiene los métodos y comprobaciones asociadas a los videos.
 * 
 * 
 */

package com.videos.application;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.videos.persistence.VideosRepository;
import com.videos.persistence.UsersRepository;
import com.videos.project.User;
import com.videos.project.Video;

public class VideosApplication {

	static Scanner registro = new Scanner(System.in);
	
	private UsersRepository users=new UsersRepository();
	private VideosRepository videosrepository= new VideosRepository();
	private UsersApplication user = new UsersApplication();
	private List <User> userslist=UsersRepository.getAllUsers();
	
	private String userid ="";
	
	//_Metodo para la entrada del video
	public void NewVideo()throws Exception{
		userslist=UsersRepository.getAllUsers();
		URL url=null;
		String tittle="";
		List <String> tag;
	//	String newid="";
		if (userslist.isEmpty()) { //Verificamos primero que haya usuarios creados
			System.out.println("No hay usuarios en el sistema, primero se debe crear un usuario.");
		}
		else {
			if (InputUser()) { //Introducir usuario
				url=(InputVideoUrl());
				tittle=InputVideoTittle();
				tag=InputTags();
				saveVideo (url, tittle, userid, tag);
			}
		}
	}
	
	private void saveVideo (URL url, String tittle, String userid, List <String> tag) {
		try {
			Video video = new Video (url, tittle, userid, tag); //Creamos el video
			videosrepository.add(video); //La añadimos al repositorio
		}
		catch (Exception e){
			System.out.println("\nERROR: ERROR: Se ha producido un error al crear el video. Por favor intentelo de nuevo.");
		}
		
	}
	
	

	private List<String> InputTags() throws Exception{
		List <String> tag = new ArrayList<String>();
		String tags="";
		do {
			do {
				System.out.println("\nIntroduce los tags correspondientes al video separados por comas ',': ");
				tags=registro.nextLine().toUpperCase();
			}while(tags.isBlank() || tags.isEmpty());
			tag=ConvertTagToList(tags);
		}while(tag.isEmpty());
		return tag;
	}

	
		private List<String> ConvertTagToList(String tags) throws Exception{
		List <String> tag =new ArrayList<String>();
		try {
			tag =Arrays.asList(tags.split(","));
			System.out.println("\n                  " + tag.size());  //*****************************BORRAR
			
		}
		catch(Exception e) {
			System.out.println("\nERROR: Los tags no pueden ser nulos o estar vacios.");
			tag.clear();
		}
		return tag;
	}
		
		
	//Método para la entrada del titulo del video
	private String InputVideoTittle() {
		String tittle="";
		do {
			System.out.println("Introduce el titulo del video");
			tittle=registro.nextLine().trim().toUpperCase();
		}while(tittle.isBlank() || tittle.isEmpty());
		return tittle;
	}


	//Método para la entrada de la URL del video
	private URL InputVideoUrl() {
		URL url=null;
		String urlinput="";
		boolean controlurlok=false;
		do {
			try {
				System.out.println("\nIntroduce la url del video.");
				urlinput=registro.nextLine().trim();
				urlinput.toLowerCase();
				url=new URL(urlinput);
				controlurlok=true;
			}
			catch (Exception e){
				System.out.println("\nLa dirección URL no es válida.");
				controlurlok=false;
			}//fin try-catch
		}while((!controlurlok) || (videosrepository.containsVideo(url)));
		return url;
	}
	
	//Metodo para introducir el usuario. Verifiacmoas previamente si el usuario está registtrado
	public boolean InputUser() {
		String password="";
		userid =user.InputUserId();
		if (!users.containsUsers(userid)) {
			System.out.println("\nEl nombre de usuario no está registrado.");
			return false;
		}
		else {
			System.out.println("\nIntroduce el PASSWORD: ");
			password=registro.nextLine().trim();
			if (!CheckUser(password)) return false;
			else return true;
		}
	}
	
	//Chequeamos el usuario y la contraseña.
	private boolean CheckUser(String password) {
		boolean unserpasswordisok=false;
		for (int i=0;i<userslist.size();i++) {
			if ((userslist.get(i).getUserId().equals(userid)) &&
					(userslist.get(i).getOnlyPassword().equals(password))){
				unserpasswordisok=true;
				break;
			}
		}
		if(!unserpasswordisok) System.out.println("\nNombre de ususario o contraseñas incorrectos.");
		return unserpasswordisok;		
	}

	
	// **************************************************  Método para cargar datos iniciales ******************************************************************* 

	public void VideosDefault() throws Exception {
		//Usuario USERID1
		try {
			videosrepository.add(new Video(new URL("http://wwww.itacademy.com/modulo7/video1/"), "VIDEO1 USERID1", "USERID1", 
					Arrays.asList("MOTOR","GOLPE","ROJO", "COCHE","ACCIDENTE","NIÑO","RUSIA","DRIFT")));
			videosrepository.add(new Video(new URL("http://wwww.itacademy.com/modulo7/video2/"), "VIDEO2 USERID1", "USERID1", 
					Arrays.asList("BICI","BICICLETA","CAIDA", "OSTIA","MONTAÑA", "ARBOL")));
			videosrepository.add(new Video(new URL("http://wwww.itacademy.com/modulo7/video3/"), "VIDEO3 USERID1", "USERID1", 
					Arrays.asList("MOTOR","GOLPE","DRIFT","ACCIDENTE", "VEHICULO","ACCIDENTE","HOMBRE","RUSIA")));
			videosrepository.add(new Video(new URL("http://wwww.itacademy.com/modulo7/video4/"), "VIDEO4 USERID1", "USERID1", 
					Arrays.asList("ESCALADA","PARED","LIBRE", "PIRINEOS","HUESCA","RESCATE","NIEVE")));
			
			//Usuario USERID2
			videosrepository.add(new Video(new URL("http://wwww.itacademy.com/modulo7/video5/"), "VIDEO1 USERID2", "USERID2", 
					Arrays.asList("MOTOR","GOLPE","ROJO", "MOTO","ACCIDENTE","ARRABASADA","BARCELONA","CABALLITO")));
			videosrepository.add(new Video(new URL("http://wwww.itacademy.com/modulo7/video6/"), "VIDEO2 USERID2", "USERID2", 
					Arrays.asList("MOTOR","HONDA","CURVA", "MOTO","CAIDA","ARRABASADA","BARCELONA","INVERTIDO")));
			videosrepository.add(new Video(new URL("http://wwww.itacademy.com/modulo7/video7/"), "VIDEO3 USERID2", "USERID2", 
					Arrays.asList("MOTOR","KAWASAKI", "MOTO","ADELANTAR","ARRABASADA","BARCELONA","INVERTIDO","VELOCIDAD")));
			videosrepository.add(new Video(new URL("http://wwww.itacademy.com/modulo7/video8/"), "VIDEO4 USERID2", "USERID2", 
					Arrays.asList("ESQUI","NIEVE","DEPORTE", "SNOW","BLANCO","ALPES","INVIERNO","SALTO")));
			
			//Usuario USERID3
			videosrepository.add(new Video(new URL("http://wwww.itacademy.com/modulo7/video9/"), "VIDEO1 USERID3", "USERID3", 
					Arrays.asList("ESQUI","NIEVE","DEPORTE", "SNOW","BLANCO","SIERRANEVADA","INVIERNO","SALTO")));
			videosrepository.add(new Video(new URL("http://wwww.itacademy.com/modulo7/video10/"), "VIDEO2 USERID3", "USERID3", 
					Arrays.asList("ESQUI","NIEVE","DEPORTE", "SNOW","BLANCO","TRINEO","NIÑOS","ACCIDENTE","INVIERNO","SALTO")));

		}
		catch(Exception e) {
			System.out.println("\nERROR: Se ha producido un error en la carga automatica de datos de VIDEOS; por favor pruebelo manualmente.");
			
			
		}
		
		
		
	}
	
	
	
}
