package com.bledi.dto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.bledi.models.Envio;

@Component
public class EnvioDTO {

	public Envio DTOtoEnvio (ResultSet rs) {
		try {
			Envio envio = null;
			while (rs.next()) {
				int conductor_id = rs.getInt("conductor_id");
				int trailer_id = rs.getInt("trailer_id");
				String tipo_carga = rs.getString("tipo_carga");
				Date fecha_salida = rs.getDate("fecha_salida");
				String cliente = rs.getString("cliente");
				String estado = rs.getString("estado");
				String ciudad = rs.getString("ciudad");
				String direccion = rs.getString("direccion");
				String estado_actual = rs.getString("estado_actual");
				envio = new Envio(conductor_id, trailer_id, tipo_carga,cliente, estado_actual, estado, ciudad, direccion, fecha_salida);
    	      }

			return envio;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return null;
	}
	
	public List<Envio> DTOtoEnvioList (ResultSet rs) {
		try {
			List<Envio> envioList = new ArrayList<>();
			while (rs.next()) {
				int conductor_id = rs.getInt("conductor_id");
				int trailer_id = rs.getInt("trailer_id");
				String tipo_carga = rs.getString("tipo_carga");
				Date fecha_salida = rs.getDate("fecha_salida");
				String cliente = rs.getString("cliente");
				String estado = rs.getString("estado");
				String ciudad = rs.getString("ciudad");
				String direccion = rs.getString("direccion");
				String estado_actual = rs.getString("estado_actual");
				envioList.add(new Envio(conductor_id, trailer_id, tipo_carga,cliente, estado_actual, estado, ciudad, direccion, fecha_salida));
    	      }

			return envioList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return null;
	}
}
