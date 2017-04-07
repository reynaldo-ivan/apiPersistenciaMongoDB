package com.anzen.beans;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.anzen.conexion.basedatos.Conexion;
import com.anzen.interfaces.IConexion;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;

public class ConexionBean {
	
	 
	private IConexion conexion=new Conexion();
	private MongoClient mongo;
	private JSONArray jsonarray; 
	private DB basedatos;
	private DBCollection table;
	private BasicDBObject searchQuery;
	private DBCursor cursor;
	private BasicDBObject obj;
	private JSONObject Jsonobj;
	
	
	
 
	public IConexion getConexion() {
		return conexion;
	}

	public void setConexion(IConexion conexion) {
		this.conexion = conexion;
	}

	public MongoClient getMongo() {
		return mongo;
	}

	public void setMongo(MongoClient mongo) {
		this.mongo = mongo;
	}

	public JSONArray getJsonarray() {
		return jsonarray;
	}

	public void setJsonarray(JSONArray jsonarray) {
		this.jsonarray = jsonarray;
	} 
	
	public DB getBasedatos() {
		return basedatos;
	}

	public void setBasedatos(DB basedatos) {
		this.basedatos = basedatos;
	}

	public DBCollection getTable() {
		return table;
	}

	public void setTable(DBCollection table) {
		this.table = table;
	}

	public BasicDBObject getSearchQuery() {
		return searchQuery;
	}

	public void setSearchQuery(BasicDBObject searchQuery) {
		this.searchQuery = searchQuery;
	}

	public DBCursor getCursor() {
		return cursor;
	}

	public void setCursor(DBCursor cursor) {
		this.cursor = cursor;
	}

	public BasicDBObject getObj() {
		return obj;
	}

	public void setObj(BasicDBObject obj) {
		this.obj = obj;
	}

	public JSONObject getJsonobj() {
		return Jsonobj;
	}

	public void setJsonobj(JSONObject jsonobj) {
		Jsonobj = jsonobj;
	}
	
	
	
	 
	
	

}
