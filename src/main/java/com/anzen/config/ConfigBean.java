package com.anzen.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.anzen.beans.ConexionBean;
import com.anzen.conexion.basedatos.Conexion;
import com.anzen.interfaces.IConexion;

@Configuration
public class ConfigBean {
	
	@Bean(name="iconexionbd")
	public IConexion conexionBean(){
		
		return new Conexion();
	}
	
//	@Bean(name="conexion")
//	public IConexion conexion(){
//		return new Conexion();
//	}

}
