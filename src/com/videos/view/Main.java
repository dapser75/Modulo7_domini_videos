/*Author: @Daniel Arizu
 * 
 * Date: 26/10/20
 * 
 * Description: Ejercicio correspondiente al modulo 7 de java BACKEND
 * En esta clase se controla el Menu principal con las diferentes opciones que posemos ejecutar
 * 
 */

package com.videos.view;

import java.util.Scanner;

import com.videos.application.ShowInformation;
import com.videos.application.UsersApplication;
import com.videos.application.VideosApplication;

public class Main {

	static Scanner registro = new Scanner(System.in);
	
	private static UsersApplication controlleruser=new  UsersApplication();
	private static VideosApplication controllervideos=new VideosApplication();
	private static ShowInformation controlshwoinformation = new ShowInformation();
	public static void main(String[] args) throws Exception {
		
		int inputoptionmenu;
		FuncionamientoDelPrograma(); //eliminar si no procede
		controlleruser.UsersDefault(); //Llamada para cargar datos iniciales de USUARIOS de ejemplo 
		controllervideos.VideosDefault();//Llamada para cargar datos iniciales  DE VIDEOS de ejemplo
		do {
			viewMenu();
			inputoptionmenu=inputMenu();
			switch (inputoptionmenu)
			{
				case 0:
					System.out.println("\n\nFIN DEL PROGRAMA.");
					break;
				case 1://Desarollo entrada de usuarios
					controlleruser.NewUserInput();//Llamada a los usuarios para entrada de datos
					//inputUsers
					break;
				case 2://Desarrollo entrada de videos
					controllervideos.NewVideo();
					break;
				
				case 3://Mostrar usuarios
					controlshwoinformation.ShowAllUsers();
					break;
				case 4://Mostrar peliculas
					controlshwoinformation.ShowAllVideos();
					break;
					
				case 5: //Mostrar usuario y peliculas
					controlshwoinformation.showAllVideosFromInputUser();
					//outputUsersAndFilms
					break;
				case 6: //Mostar peliculas asociadas a un TAG
					controlshwoinformation.ShowAllVideosFromTag();
					
					break;
								
				default:
					System.out.println("Opción no válida!!");
					break;
			}	//Fin switch-case
		}while(inputoptionmenu!=0);
		
	}//Fin metodo main
	
	

	//entrada de datos y control que sea de tipo int
	public static int inputMenu() {
		int inputmenu=0;
		try {
			inputmenu=registro.nextInt();
		}
		catch (Exception e) { //Control de excepciones conforme se introduce un numero
			registro.nextLine();
			inputmenu=9; //Valor añadido para entrar en el apartado default del switch-case
		}
		return inputmenu;
	}
	
	//Método para mostrar el menu principal
	public static void viewMenu() {
		System.out.println("\t\t\tMenu DOMINI VIDEOCLUB IT ACADEMY");
		System.out.println("\n\n\t\t 1 .- Dar de alta nuevo USUARIO.");
		System.out.println("\t\t 2 .- Dar de alta el nuevo VIDEO.");
		System.out.println("\n\t\t 3.- Mostrar usuarios.");
		System.out.println("\t\t 4.- Mostrar peliculas.");
		System.out.println("\n\t\t 5.- Mostrar usuario y peliculas asociadas.");
		System.out.println("\t\t 6.- Mostrar peliculas asociadas a un TAG.");
		System.out.println("\n\n\t\t 0 .- EXIT - Fin del programa:");
		System.out.println("\n\n\t\t Escoge una opción para continuar:_");
	}

	//Método para explicar el funcionemineto de la aplicación
	private static void FuncionamientoDelPrograma() {
		System.out.println("*************    FUCNIONAMIENTO DE LA APLICACIÓN     *************");
		System.out.println("\n LA APLICACION MUESTRA UN MENU PARA INTERACTUAR AÑADIENDO USUARIOS Y VIDEOS BAJO LAS SIGUIENTES CONSIDERACIONES:");
		System.out.println("\n\t -NO PUEDE HABER USUARIOS REPETIDOS:");
		System.out.println("\n\t -NO PUEDE HABER VIDEOS REPETIDOS (CON LA MISMA URL):");
		System.out.println("\n LA APLICACIÓN CARGA INICALMENTE UNA SERIE DE DATOS. ANULAR LINEAS 29 Y 30 DE LA CALSE MAIN PARA INHABILITAR");
	}
	
		
}
