package com.anzen.beans;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.anzen.conexion.basedatos.Conexion;
import com.anzen.config.ConfigBean;
import com.anzen.interfaces.IConexion;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
 

public class Test {
	
	
	public static void main(String[] args) {
//		ApplicationContext appContext;//=new ClassPathXmlApplicationContext("ApiPersistenciaMOngodb/src/main/resources/conexion.xml");
//		appContext=new AnnotationConfigApplicationContext(ConfigBean.class);
 
//		ConexionBean conexion=(ConexionBean) appContext.getBean("iconexionbd");
		
		Conexion conexion=new Conexion(); 
		System.out.println("rest conexion   "+conexion.conexion());
		Test test=new Test();
		Map<String,Object> map=new HashMap();
		map.put("id",1); 
//		String result=test.alta(conexion.conexion(),"rey","persona",map);
//		System.out.println("resultados  "+result);
		
//		((ConfigurableApplicationContext) conexion).close();
		
		String result1=test.consulta(conexion.conexion(),"rey","persona",map);
		System.out.println("Result   "+result1);
		 
	}
	 
	 
	public String alta(MongoClient mCliente, String nombreDB, String nombreTabla, Map<String,Object> map){
 		  
		BasicDBObject object=new BasicDBObject();
		 
        DB db= mCliente.getDB(nombreDB);
        DBCollection table= db.getCollection(nombreTabla); 
  
        Iterator it = map.keySet().iterator();
		while(it.hasNext()){
		  Object key = it.next();
		  object.put(key.toString(), map.get(key));
		} 
		try{
			table.insert(object);
		}catch (Exception e) {
			return "Error: "+e.getMessage();
		}
		 return "OK";
	}
	
	public String consulta( MongoClient mCliente, String nombreDB, String nombreTabla,
						   Map<String,Object> map){
		
		BasicDBObject basicDBObject=new BasicDBObject();
  
		DB db= mCliente.getDB(nombreDB);  
        DBCollection table= db.getCollection(nombreTabla); 
        
        Map<String,Object> mapa= new HashMap<String, Object>();
        Map<String,Object> result= new HashMap<String, Object>();
        Iterator it = map.keySet().iterator();
		while(it.hasNext()){
		  Object key = it.next(); 
		  basicDBObject.put(key.toString(), map.get(key));
		} 
		 
        DBCursor cursor=table.find(basicDBObject); 
         
         
        while(cursor.hasNext()) {
        	DBObject key = cursor.next();
        	String id= key.get("_id").toString();
        	Set<String> keyset=key.keySet();
        	for (String s: keyset){
        		if (!s.equals("_id")){
        			mapa.put(s, key.get(s)); 
        		}
        		result.put(id, mapa);
        	}  
        }
       
         System.out.println("result: " + result);
		 return "OK";
	}

}
