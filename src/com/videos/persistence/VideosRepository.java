/*Author: @Daniel Arizu
 * 
 * Date: 26/10/20
 * 
 * Description: Ejercicio correspondiente al modulo 7 de java BACKEND
 * 
 * 
 * Esta clase contiene la información correspondiente a todos los videos que se almacenan en la aplicación.
 * 
 */

package com.videos.persistence;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.videos.project.Video;

public class VideosRepository {

	
	private static List<Video> videos= new ArrayList<>();
	
	//Metodo de creación
	public VideosRepository() {

	}
	
	public void add(Video video) throws Exception{
		if (video==null) throw new Exception();
		videos.add(video);
	}

	
	public static List<Video> getAllVideos(){
		return new ArrayList<>(videos);
	}
	
	//Metodo para verificar si un video existe
	public boolean containsVideo (URL newurl) {
		boolean videoexists=false;
		for (int i=0;i<videos.size();i++) {
			if(videos.get(i).getOnlyUrlclass().equals(newurl)){
				System.out.println("\nLa dirección URL ya existe; por favor ingrese otra. ");
				System.out.println("\nEstos son los datos del video URL: " + videos.get(i).getOnlyUrl() + " y Usuario: " + videos.get(i).getUserId());
				videoexists=true;
				break;
			}
		}
		return videoexists;
	}

	
	
	
	
	
	
}
