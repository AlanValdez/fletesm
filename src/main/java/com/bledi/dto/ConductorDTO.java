package com.bledi.dto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.bledi.models.Conductor;

@Component
public class ConductorDTO {

	public ConductorDTO() {
	}
	
	public Conductor conductorToDAO (ResultSet rs) {
		try {
			Conductor conduc = null;
			while (rs.next()) {
				int nombre = rs.getInt("conductor_id");
				String nombres = rs.getString("nombre");
				String apellidos;
				apellidos = rs.getString("apellidos");
				Date dia_naciento = rs.getDate("dia_nacimiento");
				char sexo = rs.getString("genero").charAt(0);
				conduc = new Conductor(nombre,nombres, apellidos, dia_naciento, sexo);
    	      }

			return conduc;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return null;
	}
	
	public List<Conductor> conductorToDaoList (ResultSet rs) {
		try {
			List<Conductor> conductorList = new ArrayList<>();
			
			while (rs.next()) {
				int nombre = rs.getInt("conductor_id");
				String nombres = rs.getString("nombre");
				String apellidos;
				apellidos = rs.getString("apellidos");
				Date dia_naciento = rs.getDate("dia_nacimiento");
				char sexo = rs.getString("genero").charAt(0);
				conductorList.add(new Conductor(nombre,nombres, apellidos, dia_naciento, sexo));
    	      }
			
			return conductorList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return null;
	}
	
}
