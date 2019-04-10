package com.bledi.dto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.bledi.models.Trailer;
@Component
public class TrailerDTO {

	public Trailer DTOtoTrailer (ResultSet rs) {
		try {
			Trailer trailer = null;
			while (rs.next()) {
				int trailer_id = rs.getInt("trailer_id");
				String placas = rs.getString("placas");
				Float capacidad = rs.getFloat("capacidad_toneladas");
				trailer = new Trailer(trailer_id,placas, capacidad);
    	      }

			return trailer;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return null;
	}
	
	public List<Trailer> DTOtoTrailerList (ResultSet rs) {
		try {
			List<Trailer> trailerList = new ArrayList<>();
			
			while (rs.next()) {
				int trailer_id = rs.getInt("trailer_id");
				String placas = rs.getString("placas");
				Float capacidad = rs.getFloat("capacidad_toneladas");
				trailerList.add(new Trailer(trailer_id,placas, capacidad));
    	      }
			
			return trailerList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return null;
	}
}
