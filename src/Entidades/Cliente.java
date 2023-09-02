package Entidades;

public class Cliente {
	private int id;
	private String nombre;
	private String email;
	
	public Cliente(int id, String nombre, String email) {
		this.id = id;
		this.nombre = nombre;
		this.email = email;
	}
	
	//Deberíamos agregar setters?

	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public String getEmail() {
		return email;
	}
}
