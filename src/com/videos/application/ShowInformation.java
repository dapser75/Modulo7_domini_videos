/*@Author: Daniel Arizu
 * 
 * Date 27/10/2020
 * 
 * 
 * Description: Ejercicio correspondiente al modulo 7 de java BACKEND
 * 
 * Esta clase contiene los métodos y comprobaciones asociadas mostrar los diferentes datos almacenados.
 * 
 * 
 */

package com.videos.application;

import java.util.List;
import java.util.Scanner;

import com.videos.persistence.UsersRepository;
import com.videos.persistence.VideosRepository;
import com.videos.project.User;
import com.videos.project.Video;




public class ShowInformation {
	static Scanner registro = new Scanner(System.in);
	
	//private UsersRepository users=new UsersRepository();
	private List <User> userslist=UsersRepository.getAllUsers();
	private List<Video> videoslist= VideosRepository.getAllVideos();
	private VideosApplication inputuser = new VideosApplication();
	private UsersApplication inputtag = new UsersApplication();
	
	public boolean RefreshRepository() {
		videoslist=VideosRepository.getAllVideos();
		userslist=UsersRepository.getAllUsers();
		if (videoslist.isEmpty() || userslist.isEmpty()) {
			System.out.println("\n NO HAY DATOS QUE MOSTRAR.");
			return false;
		}
		else return true;
		
	}
	
	public void ShowAllVideos(){
		if (RefreshRepository()) {
			for ( int i =0; i<videoslist.size();i++) {
				System.out.println("\nVideo Nº " + i + videoslist.get(i).getVideo());
			}//end for
		}
	}
	
	public void ShowAllUsers() {
		if (RefreshRepository()) {
			for ( int i =0; i<userslist.size();i++) {
				System.out.println("\nUSUARIO: " + userslist.get(i).getUser());
			}//end for
		}
	}
	
	//En este método chequeamos que el usuario exista. Se llama a otro método para pedir nombre
	//y contraseña. En caso que no este sale del menú.
	public void showAllVideosFromInputUser() {
		String userid="";
		if (RefreshRepository()) {
			if(inputuser.InputUser()) ShowAllVideosFromUser(userid);
		}
	}

	//En este método se muestran los videos del usuario asociado
	private void ShowAllVideosFromUser(String userid) {
		for (int i=0; i<userslist.size();) {
			if (userslist.get(i).getUserId().equals(userid)) System.out.println("\n" + userslist.get(i).getUser());
				break;
		}
		for(int i=0;i<videoslist.size();i++) {
			if(videoslist.get(i).getUserId().contains(userid)) //Se recorre la liosta buscando el userID seleccionado previamente.
				System.out.println("\n\t- " + videoslist.get(i).getVideo());
		}
	}
	
	//Método para mostrar todos los videos asociados a un determinado TAG
	public void ShowAllVideosFromTag() {
		String tag="";
		if (RefreshRepository()) {
			tag=inputtag.InputWord("\nInserte el TAG de buscqueda:");
			for ( int i =0; i<videoslist.size();i++) {
				if (videoslist.get(i).getTags().contains(tag))
					System.out.println("\nVideo Nº " + i + videoslist.get(i).getVideo());
			}//end for
		}
	}

}//Fin clase
