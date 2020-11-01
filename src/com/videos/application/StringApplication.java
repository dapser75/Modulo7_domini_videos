/*@Author: Daniel Arizu
 * 
 * 
 * 
 * Comments: Clase creada para el tratamiento de los diferentes strings en toda la aplicación
 * 
 * 
 * 
 * 
 */

package com.videos.application;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

public class StringApplication {
	
	public void StringApplication() {
			
	}
	
	
	//Metodo para verificar si un string tiene espacios interiores
	public boolean SpacesIWithSpaces(String word, String wordentry) {
		boolean havespaces=false;
		if ((word.isBlank()) ||(word.isEmpty()))  havespaces=true;
		else {
			for (int i = 0;i < word.length();i++) {
				if (Character.isSpace(word.charAt(i))) havespaces=true;
			}
		}
		if (havespaces) System.out.println("\nEntrada incorrecta; el "+ wordentry + " no puede ser nulo ni tener espacios en blanco");
		return havespaces;
	
	}//Fin metodo SapcesWith
	
	//Método para verificar entradas no validas de caracteres
	public boolean CharacterNotOK(String word) {
		boolean characternotok=true;
		for (int i=0; i<word.length();i++) {
			if (!Character.isLetterOrDigit(word.charAt(i))) {
				System.out.println("\nEntrada de datos incorrectas solo puede contener letras y numeros.");
				characternotok=false;
				break;
			}
		}//fin for	
		return characternotok;
	}
	
}
