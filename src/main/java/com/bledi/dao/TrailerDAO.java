package com.bledi.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bledi.dto.TrailerDTO;
import com.bledi.models.Trailer;
@Component
public class TrailerDAO {

	@Autowired
	private TrailerDTO trailerDTO;
	@Autowired
	 private DataSource dataSource;
	
	public List<Trailer> getAllTrailers() {
		try (Connection connection = dataSource.getConnection()) {
  	      Statement stmt = connection.createStatement();

  	      ResultSet rs = stmt.executeQuery("select * from trailer");
  	      List<Trailer> myTrailers = trailerDTO.DTOtoTrailerList(rs);
  	      
  	      return myTrailers;
  	    } catch (Exception e) {
  	    	e.printStackTrace();  	    
  	    }
		return null;
	}
	
	public List<Trailer> getAllTrailers(List<Integer> id_list) {
		try (Connection connection = dataSource.getConnection()) {
  	      Statement stmt = connection.createStatement();
  	      StringBuilder sb = new StringBuilder();
  	      sb.append("SELECT * FROM trailer WHERE trailer_id = ");
  	      int i = 0;
  	      
  	      for (Integer id : id_list) {
  	    	if(i++ == 0) sb.append(id);
  	    	else sb.append(" OR trailer_id = " + id);
  	      }
  	      ResultSet rs = stmt.executeQuery(sb.toString());
  	      List<Trailer> myTrailers = trailerDTO.DTOtoTrailerList(rs);
  	      
  	      return myTrailers;
  	    } catch (Exception e) {
  	    	e.printStackTrace();  	    
  	    }
		return null;
	}
	
	public Trailer getTrailerById(int trailer_id) {
		try (Connection connection = dataSource.getConnection()) {
  	      Statement stmt = connection.createStatement();

  	      ResultSet rs = stmt.executeQuery(String.format("select * from trailer WHERE trailer_id = %d", trailer_id));
  	      Trailer myConductor = trailerDTO.DTOtoTrailer(rs);
  	      
  	      return myConductor;
  	    } catch (Exception e) {
  	    	e.printStackTrace();  	    
  	    }
		return null;
	}
	
	public int createTrailer(Trailer trailer) {
		try (Connection connection = dataSource.getConnection()) {
  	      	Statement stmt = connection.createStatement();
  	      	
			String query = String.format("INSERT INTO trailer (placas, capacidad_toneladas) VALUES ('%s', %f)", trailer.getPlacas(), trailer.getcapacidad_toneladas());
			 stmt.executeUpdate(query);
			 ResultSet rs = stmt.executeQuery("SELECT LAST_INSERT_ID()");
			int conductor_id = 0;
			while (rs.next()) {
			  conductor_id = rs.getInt("LAST_INSERT_ID()");
  	      	}
  	      	return conductor_id;
  	    } catch (Exception e) {
  	    	e.printStackTrace();  
  	    	return 0;
  	    }
	}
	
	public int updateTrailer(Trailer trailer, int trailer_id) {
		try (Connection connection = dataSource.getConnection()) {
  	      	Statement stmt = connection.createStatement();

			String query = String.format("UPDATE trailer Set placas = '%s', capacidad_toneladas = %f  Where trailer_id = %d", trailer.getPlacas(), trailer.getcapacidad_toneladas(), trailer_id);
			stmt.executeUpdate(query);
  	      return trailer_id;
  	    } catch (Exception e) {
  	    	e.printStackTrace();  
  	    	return 0;
  	    }
	}
}
