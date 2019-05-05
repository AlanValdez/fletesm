package com.bledi.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bledi.dto.EnvioDTO;
import com.bledi.models.Envio;
@Component
public class EnvioDAO {

	@Autowired
	private EnvioDTO envioDTO;
	@Autowired
	 private DataSource dataSource;
	
	public List<Envio> getAllEnvios() {
		try (Connection connection = dataSource.getConnection()) {
  	      Statement stmt = connection.createStatement();

  	      ResultSet rs = stmt.executeQuery("select envios.*, CONCAT(conductor.nombre,\" \", conductor.apellidos) AS NombreCompleto, trailer.placas  from envios inner join conductor on envios.conductor_id = conductor.conductor_id inner join trailer on envios.trailer_id = trailer.trailer_id;");
  	      List<Envio> myEnvios = envioDTO.DTOtoEnvioList(rs);
  	      
  	      return myEnvios;
  	    } catch (Exception e) {
  	    	e.printStackTrace();  	    
  	    }
		return null;
	}
	
	public Envio getEnviosByTrailerId(int trailer_id) {
		try (Connection connection = dataSource.getConnection()) {
  	      Statement stmt = connection.createStatement();

  	      ResultSet rs = stmt.executeQuery(String.format("select * from envios WHERE trailer_id = %d", trailer_id));
  	      Envio myEnvio = envioDTO.DTOtoEnvio(rs);
  	      
  	      return myEnvio;
  	    } catch (Exception e) {
  	    	e.printStackTrace();  	    
  	    }
		return null;
	}
	
	public Envio getEnviosByConductorId(int conductor_id) {
		try (Connection connection = dataSource.getConnection()) {
  	      Statement stmt = connection.createStatement();

  	      ResultSet rs = stmt.executeQuery(String.format("select * from envios WHERE conductor_id = %d", conductor_id));
  	      Envio myEnvio = envioDTO.DTOtoEnvio(rs);
  	    
  	      return myEnvio;
  	    } catch (Exception e) {
  	    	e.printStackTrace();  	    
  	    }
		return null;
	}
	
	public int createEnvio(Envio envio) {
		try (Connection connection = dataSource.getConnection()) {
  	      	Statement stmt = connection.createStatement();

			String query = String.format("INSERT INTO envios(conductor_id, trailer_id, tipo_carga,cliente,estado,ciudad,direccion,estado_actual) "
										+ "values(%d,%d, '%s', '%s', '%s', '%s', '%s', '%s')",
										envio.getConductor_id(), envio.getTrailer_id(),envio.getTipo_carga(), envio.getCliente(), envio.getEstado(), envio.getCiudad(), envio.getDireccion(), envio.getEstado_actual());
			 stmt.executeUpdate(query);
  	      	return 1;
  	    } catch (Exception e) {
  	    	e.printStackTrace();  
  	    	return 0;
  	    }
	}
	
	public int cerrarEnvio(int conductor_id, int trailer_id) {
		try (Connection connection = dataSource.getConnection()) {
  	      	Statement stmt = connection.createStatement();

      		String query = String.format("UPDATE envios SET estado_actual = 'Terminado' where conductor_id = %d AND trailer_id = %d",conductor_id,trailer_id);
      		stmt.executeUpdate(query);
      		String queryCerrar = String.format("DELETE FROM envios where conductor_id = %d AND trailer_id = %d",conductor_id,trailer_id);
      		stmt.executeUpdate(queryCerrar);
  	      	return 1;
  	    } catch (Exception e) {
  	    	e.printStackTrace();  
  	    	return 0;
  	    }
	}
}
