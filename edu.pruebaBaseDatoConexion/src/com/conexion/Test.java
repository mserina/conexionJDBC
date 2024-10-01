package com.conexion;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Test {
	
	public static void main(String[] args) {
		try {
			//Se crea un objeto de la tipo Connection
			Connection con = Conexion.crearConexion();
			//Se crea un objeto de Statement(que es el que nos permite hacer consultas) a partir del objeto Connection
			Statement  consulta = con.createStatement();
			
			//Se crea la sintaxis de la query y lo metemos en un string
			String query = "SELECT * FROM public.\"pruebaJDBC\"";
			//Dicho string se lo pasaremos de parametro al metodo ejecutar consulta, el valor se guardara dentro de una variable de tipo ResultSet
			ResultSet resultadoQuery = consulta.executeQuery(query);
			
			//Aqui se iran recopliando los registros e imprimiendolos
			while (resultadoQuery.next()) {
				int id = resultadoQuery.getInt("id");
				String nombre = resultadoQuery.getString("nombre");
				int edad = resultadoQuery.getInt("edad");
                System.out.println("ID: " + id + ", Nombre: " + nombre + ", Edad: " + edad);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
