package edu.cibertec.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import edu.cibertec.dto.LoginDTO;
import edu.cibertec.dto.ProfileDTO;
import edu.cibertec.dto.UsuarioDTO;
import edu.cibertec.entity.Account;
import edu.cibertec.entity.Profile;
import edu.cibertec.persistence.service.AccountServiceImpl;
import edu.cibertec.persistence.service.ProfileServiceImpl;
import edu.cibertec.util.Util;

@Path("/post")
public class RestPost {

	AccountServiceImpl accService = new AccountServiceImpl();
	ProfileServiceImpl profService = new ProfileServiceImpl();


	static final Logger log = Logger.getLogger(RestPost.class);

	//http://localhost:8080/api-rest/post/login/
	@POST
	@Path("/login")
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces(MediaType.APPLICATION_JSON)
	public String validarLogin( LoginDTO login) {
		log.info("Entrando a POST: validarLogin()");
		List<Account> listaAccJPA = null;
		String result = "";
		ProfileDTO dto = new ProfileDTO();
		Profile jpa = new Profile();
		JsonObject json = new JsonObject();
		JsonElement profileDTO = null;
		try {
			listaAccJPA = accService.getAccounts();
			for(Account acc:listaAccJPA) {
				if(login.getEmail().equals(acc.getEmail()) && login.getPassword().equals(acc.getPassword())) {


					jpa = profService.getProfile(acc.getId());
					dto = Util.profileJPAtoDTO(jpa);

					profileDTO= new Gson().toJsonTree(dto);

					json.add("profile", profileDTO);
					json.addProperty("response", true);

					result = json.toString();

					log.info(result);
					log.info("Saliendo a POST: validarLogin()");
					return result; 
				} 
			}
		} catch (Exception e) {

			log.fatal("Exception: ", e);
			return null;

		}
		json.addProperty("profile", "");
		json.addProperty("response", false);
		result = json.toString();

		log.info("No se encontro registro");
		log.info("Saliendo a POST: validarLogin()");
		return result;
	}

	//http://localhost:8080/api-rest/post/signUp/
	@POST
	@Path("/signUp")
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces(MediaType.APPLICATION_JSON)
	public String signUp( UsuarioDTO usu) {
		log.info("entro POST: signUp()");
		
		JsonObject json = new JsonObject();
		String result = "";
		
		log.info("---Inicia validacion de Correo---");
		
		List<Account> listaAccJPA = new ArrayList<Account>();
		try {
			listaAccJPA = accService.getAccounts();
			for(Account acc:listaAccJPA) {
				if(usu.getEmail().equals(acc.getEmail())) {

					json.addProperty("profile", "");
					json.addProperty("message", "El email ingresado ya se encuentra registrado");
					json.addProperty("response", false);
					log.error("El email ingresado ya se encuentra registrado");
					result = json.toString();
					return result;
				}
			}
			log.info("Finaliza busqueda cuentas");
		} catch (Exception e) {
			log.fatal("Exception: ", e);
		}
		log.info("---Finaliza validacion de Correo---");
		
		log.info("---Empieza insercion de Account---");
		
		Account account = new Account();
		account.setEmail(usu.getEmail());
		account.setPassword(usu.getPassword());
		account.setAccType(2);
		account.setStatus(1);
		
		try {
			accService.registrar(account);
		} catch (Exception e) {
			log.fatal("Exception: ", e);
		}
		log.info("---Finaliza insercion de Account---");

		log.info("---Empieza insercion de Profile---");
		
		Profile profile = new Profile();
		
		
		
		profile.setAccount(account);
		profile.setFullName(usu.getFullName());
		profile.setPhone1(usu.getPhone1());
		profile.setPhone2(usu.getPhone2());
		profile.setPhone3(usu.getPhone3());
		profile.setDni(usu.getDni());
		
		try {
			profService.registrar(profile);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.fatal("Exception: ", e);
		}
		
		log.info("---Finaliza insercion de Profile---");
		
		log.info("---Empieza creacion de Respuesta---");
		
		JsonElement profileDTO = null;
		profileDTO =  new Gson().toJsonTree(Util.profileJPAtoDTO(profile));
		
		json.add("profile",profileDTO);
		json.addProperty("message", "");
		json.addProperty("response", true);

		result = json.toString();
		
		
		log.info("---Finaliza creacion de Respuesta---");

		log.info("salio POST: signUp()");
		return result;
	}


}
