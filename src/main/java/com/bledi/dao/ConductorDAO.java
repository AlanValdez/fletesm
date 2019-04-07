package com.bledi.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bledi.dto.ConductorDTO;
import com.bledi.models.Conductor;

@Component
public class ConductorDAO {

	@Autowired
	private ConductorDTO conductorDTO;
	@Autowired
	 private DataSource dataSource;
	
	public List<Conductor> getAllConductors() {
		try (Connection connection = dataSource.getConnection()) {
  	      Statement stmt = connection.createStatement();

  	      ResultSet rs = stmt.executeQuery("select * from conductor");
  	      List<Conductor> myConductors = conductorDTO.conductorToDaoList(rs);
  	      
  	      return myConductors;
  	    } catch (Exception e) {
  	    	e.printStackTrace();  	    
  	    }
		return null;
	}
	
	public List<Conductor> getAllConductors(List<Integer> id_list) {
		try (Connection connection = dataSource.getConnection()) {
  	      Statement stmt = connection.createStatement();
  	      StringBuilder sb = new StringBuilder();
  	      sb.append("SELECT * FROM conductor WHERE conductor_id = ");
  	      int i = 0;
  	      
  	      for (Integer id : id_list) {
  	    	if(i++ == 0) sb.append(id);
  	    	else sb.append(" OR conductor_id = " + id);
  	      }
  	      System.out.println(sb.toString());
  	      ResultSet rs = stmt.executeQuery(sb.toString());
  	      List<Conductor> myConductors = conductorDTO.conductorToDaoList(rs);
  	      
  	      return myConductors;
  	    } catch (Exception e) {
  	    	e.printStackTrace();  	    
  	    }
		return null;
	}
	
	public Conductor getConductorById(int conductor_id) {
		try (Connection connection = dataSource.getConnection()) {
  	      Statement stmt = connection.createStatement();

  	      ResultSet rs = stmt.executeQuery(String.format("select * from conductor WHERE conductor_id = %d", conductor_id));
  	      Conductor myConductor = conductorDTO.conductorToDAO(rs);
  	      
  	      return myConductor;
  	    } catch (Exception e) {
  	    	e.printStackTrace();  	    
  	    }
		return null;
	}
	
	public int createConductor(Conductor conductor) {
		try (Connection connection = dataSource.getConnection()) {
  	      	Statement stmt = connection.createStatement();
	  	    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			String date = format.format(conductor.getDia_naciento());
			String query = String.format("INSERT INTO conductor (nombre, apellidos, dia_nacimiento, genero) VALUES ('%s', '%s', '%s', '%s')",
	  	    				  					conductor.getNombre(), conductor.getApellidos(), date, Character.toUpperCase(conductor.getSexo()));
			 stmt.executeUpdate(
					 query
	  	    );
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
	
	public int updateConductor(Conductor conductor, int conductor_id) {
		try (Connection connection = dataSource.getConnection()) {
  	      	Statement stmt = connection.createStatement();
  	      	
	  	    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			String date = format.format(conductor.getDia_naciento());
			String query = String.format("UPDATE conductor SET nombre = '%s', apellidos = '%s', dia_nacimiento = '%s', genero = '%s' WHERE conductor_id = %d",
	  	    				  					conductor.getNombre(), conductor.getApellidos(), date, Character.toUpperCase(conductor.getSexo()), conductor_id);
			stmt.executeUpdate(query);
  	      return conductor_id;
  	    } catch (Exception e) {
  	    	e.printStackTrace();  
  	    	return 0;
  	    }
	}
}
