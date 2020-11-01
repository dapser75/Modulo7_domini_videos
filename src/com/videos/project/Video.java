/*Author: @Daniel Arizu
 * 
 * Date: 26/10/20
 * 
 * Description: Ejercicio correspondiente al modulo 7 de java BACKEND
 * Esta clase contiene la información correspondiente a un video así como los métodos asociados al mismo.
 * 
 */


package com.videos.project;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Video {
	private URL url=null;
	private String tittle;
	private String userid;
	private List <String> tags = new ArrayList<>();

	
	public Video(URL url, String tittle, String userid, List<String> tags) throws Exception{
		this.url=url;
		this.tittle=tittle;
		this.userid=userid;
		this.tags=tags;
	}
	
	
	
	/****************************************************      METODOS GETTERS     ***********************************************************/
	public String getUserId() {
		return userid;
	}
	
	public String getVideo() {
		String getfilm = getUrl() + " Usuario: " + getUserId() + getTittle() + getTags();
		return getfilm;
		
	}
	
	public URL getOnlyUrlclass() {
		return url;
	}
	
	
	public String getOnlyUrl() {
		String geturl = url.toString();
		return geturl;		
	}
	
	public String getUrl() {
		String geturl = "URL: " + url;
		return geturl;		
	}
	
	public String getTittle() {
		String gettittle =  ". Titulo; " + tittle;
		return gettittle;
	}
	
	public String getTags() {
		String gettags = ". Palabras clave: ";
		for (String tag : tags) {
			gettags=gettags + tag + ";";
		}
		return gettags;
	}

}
