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

import edu.cibertec.dto.CustomerDTO;
import edu.cibertec.dto.LoginDTO;
import edu.cibertec.dto.ReservInsertDTO;
import edu.cibertec.entity.Account;
import edu.cibertec.entity.Customer;
import edu.cibertec.entity.Guest;
import edu.cibertec.entity.Reservation;
import edu.cibertec.entity.SoccerField;
import edu.cibertec.persistence.service.AccountServiceImpl;
import edu.cibertec.persistence.service.CustomerServiceImpl;
import edu.cibertec.persistence.service.ReservationServiceImpl;
import edu.cibertec.persistence.service.SoccerFieldServiceImpl;
import edu.cibertec.util.Util;

@Path("/post")
public class RestPost {


	SoccerFieldServiceImpl socService = new SoccerFieldServiceImpl();
	ReservationServiceImpl resService = new ReservationServiceImpl();
	CustomerServiceImpl cusService = new CustomerServiceImpl();
	static final Logger log = Logger.getLogger(RestPost.class);

	//http://localhost:8080/api-rest/post/postReserv/
	@POST
	@Path("/postReserv")
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces(MediaType.APPLICATION_JSON)
	public String postReserv( ReservInsertDTO res) {
		log.info("entro POST: postReserv()");
		String result = "";
		List<SoccerField> listSoccerField = new ArrayList<SoccerField>();
		Reservation reservation = new Reservation();
		try {
			listSoccerField = socService.getSoccerFields();
			for (SoccerField sf:listSoccerField) {
				if(sf.getId()==res.getSoccerFieldId()) {
					reservation.setSoccerField(sf);
				}
			}
			reservation.setReserverId(res.getReserverId());
			reservation.setReserverType(res.getReserverType());
			reservation.setDate(res.getDay());
			reservation.setStart(res.getStart());
			reservation.setEnd(res.getEnd());
			reservation.setChargeId(res.getChargeId());
			reservation.setCreatedAt(res.getCreateDate());
			reservation.setChargeAmount(res.getChargeAmount());
			log.info("--Objeto creado--");

			reservation = resService.registrar(reservation);
			log.info("ID: "+reservation.getId());
			result ="Registro Reservation completo";

		} catch (Exception e) {
			log.fatal("Exception: ", e);
		}


		log.info("salio POST: postReserv()");
		return result;
	}




	//http://localhost:8080/api-rest/post/login/
	@POST
	@Path("/login")
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces(MediaType.APPLICATION_JSON)
	public String validarLogin( LoginDTO login) {
		log.info("Entrando a POST: validarLogin()");
		String result="";
		List<Customer> lstCustomer = new ArrayList<Customer>();
		JsonObject json = new JsonObject();
		JsonElement jsonCust = null;
		CustomerDTO cusDTO = new CustomerDTO();
		try {
			lstCustomer=cusService.getCustomers();
			for(Customer cus:lstCustomer) {
				if(login.getLogin().indexOf("@")==-1) {
					log.info("Logica validacion/telf");
					if(login.getLogin().equals(""+cus.getPhone()) && login.getPass().equals(cus.getAccount().getPassword())) {
						cusDTO = Util.CustomerJPAtoDTO(cus);
						jsonCust = new Gson().toJsonTree(cusDTO);
						json.add("Customer", jsonCust);
						json.addProperty("response", true);
						result = json.toString();
						return result;
					} 

				}else {
					log.info("Logica validacion/email");
					if(login.getLogin().equals(cus.getEmail()) && login.getPass().equals(cus.getAccount().getPassword())) {
						cusDTO = Util.CustomerJPAtoDTO(cus);
						jsonCust = new Gson().toJsonTree(cusDTO);
						json.add("Customer", jsonCust);
						json.addProperty("response", true);
						result = json.toString();
						return result;
					} 

				}
			}
			json.addProperty("Customer", "null");
			json.addProperty("response", false);
			result = json.toString();
			return result;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.fatal("Exception: ", e);
		}

		log.info("Saliendo a POST: validarLogin()");
		return result;
	}
	/*
	//http://localhost:8080/api-rest/post/validacionEmail/
	@POST
	@Path("/validacionEmail")
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces(MediaType.APPLICATION_JSON)
	public String validacionEmail( UsuarioDTO usu) {
		log.info("Entrando a POST: validarLogin()");

		JsonObject json = new JsonObject();
		String result = "";

		log.info("---Inicia validacion de Correo---");

		List<Account> listaAccJPA = new ArrayList<Account>();
		try {
			listaAccJPA = accService.getAccounts();
			for(Account acc:listaAccJPA) {
				if(usu.getEmail().equals(acc.getEmail())) {

					json.addProperty("message", "El email ingresado ya se encuentra registrado");
					json.addProperty("response", false);
					log.error("El email ingresado ya se encuentra registrado");
					result = json.toString();
					return result;
				}
			}

			json.addProperty("message", "Email Disponible");
			json.addProperty("response", true);
			result = json.toString();
			log.info("El email disponible");

			log.info("---Finaliza busqueda cuentas---");
		} catch (Exception e) {
			log.fatal("Exception: ", e);
		}
		log.info("---Finaliza validacion de Correo---");
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



	//http://localhost:8080/api-rest/post/postReview/
	@POST
	@Path("/postReview")
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces(MediaType.APPLICATION_JSON)
	public String postReview( ReviewInsert rev) {
		log.info("entro POST: postReview()");

		JsonObject json = new JsonObject();
		String result = "";
		Review revJPA = new Review();

		List<Account> listAcc = null;
		List<Local> listLoc = null;

		try {
			listAcc = accService.getAccounts();
			listLoc = locService.getLocals();

			for(Account acc:listAcc) {
				if(rev.getAccount_id()==acc.getId()) {
					revJPA.setAccount(acc);
				}
			}

			for(Local loc:listLoc) {
				if(rev.getLocal_id()==loc.getId()) {
					revJPA.setLocal(loc);
				}
			}

			revJPA.setStars(rev.getStars());
			revJPA.setCommentary(rev.getCommentary());

			revService.registrar(revJPA);

		} catch (Exception e) {
			log.fatal("Exception: ", e);
		}


		json.addProperty("message", "");
		json.addProperty("response", true);

		result = json.toString();



		log.info("salio POST: postReview()");
		return result;
	}

	//http://localhost:8080/api-rest/post/updateReview/
		@POST
		@Path("/updateReview")
		@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
		@Produces(MediaType.APPLICATION_JSON)
		public String updateReview( ReviewInsert rev) {
			log.info("entro POST: updateReview()");

			JsonObject json = new JsonObject();
			String result = "";
			Review revJPA = new Review();

			List<Account> listAcc = null;
			List<Local> listLoc = null;

			try {
				listAcc = accService.getAccounts();
				listLoc = locService.getLocals();

				for(Account acc:listAcc) {
					if(rev.getAccount_id()==acc.getId()) {
						revJPA.setAccount(acc);
					}
				}

				for(Local loc:listLoc) {
					if(rev.getLocal_id()==loc.getId()) {
						revJPA.setLocal(loc);
					}
				}

				revJPA.setStars(rev.getStars());
				revJPA.setCommentary(rev.getCommentary());

				revService.actualizar(revJPA);

			} catch (Exception e) {
				log.fatal("Exception: ", e);
			}

			JsonElement revJson = null;
			revJson = new Gson().toJsonTree(Util.reviewJPAtoDTO(revJPA));

			json.add("review", revJson);
			json.addProperty("message", "");
			json.addProperty("response", true);

			result = json.toString();



			log.info("salio POST: updateReview()");
			return result;
		}
	 */
}
