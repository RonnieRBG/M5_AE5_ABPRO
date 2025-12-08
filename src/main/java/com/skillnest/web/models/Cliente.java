package com.skillnest.web.models;

public class Cliente {
	
	public int id;
	public String nombre;
	

	public String descripcion;
	public int telefono;
	
	
	
	public Cliente(int id, String nombre, String descripcion, int telefono) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.telefono = telefono;
	}


	public Cliente(String nombre, String descripcion, int telefono) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.telefono = telefono;
	}


	public Cliente() {
		super();
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public int getTelefono() {
		return telefono;
	}


	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}
	
	
	
	
}
