package com.anzen.conexion.basedatos;

import java.net.UnknownHostException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext; 

import com.anzen.beans.ConexionBean;
import com.anzen.config.ConfigBean;
import com.anzen.interfaces.IConexion;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;

public class Conexion  implements IConexion{
	
	/**
	 * Declaracion de ApplicationContext
	 */
	
//	ApplicationContext appContext=new AnnotationConfigApplicationContext(ConfigBean.class);
//	ConexionBean conexion=null;
	MongoClient client;
	
	
	public MongoClient conexion() {
		System.out.println("en Conexión ");
//		 conexion=(ConexionBean) appContext.getBean("iconexionbd"); 
			try {

				// Conexion a MongoDB
				client= new MongoClient("127.0.0.1", 27017);
	 
			} catch (UnknownHostException e) {
				e.printStackTrace();
			} catch (MongoException e) {
				e.printStackTrace();
			}
			
			return client;
	}
	
	/**
	 * Este metodo retorna la conexion de la base de datos 
	 * Retorna un valor de tipo MongoClient
	 */
 
 
	
	 

}
