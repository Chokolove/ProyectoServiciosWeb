package edu.cibertec.rest;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
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

import edu.cibertec.dto.CustomerAdvDTO;
import edu.cibertec.dto.CustomerDTO;
import edu.cibertec.dto.GuestInsertDTO;
import edu.cibertec.dto.LoginDTO;
import edu.cibertec.dto.ReservInsertDTO;
import edu.cibertec.dto.ReviewInsertDTO;
import edu.cibertec.entity.Account;
import edu.cibertec.entity.Customer;
import edu.cibertec.entity.Guest;
import edu.cibertec.entity.Local;
import edu.cibertec.entity.Reservation;
import edu.cibertec.entity.Review;
import edu.cibertec.entity.SoccerField;
import edu.cibertec.persistence.service.AccountServiceImpl;
import edu.cibertec.persistence.service.CustomerServiceImpl;
import edu.cibertec.persistence.service.GuestServiceImpl;
import edu.cibertec.persistence.service.LocalServiceImpl;
import edu.cibertec.persistence.service.ReservationServiceImpl;
import edu.cibertec.persistence.service.ResviewServiceImpl;
import edu.cibertec.persistence.service.SoccerFieldServiceImpl;
import edu.cibertec.util.Util;

@Path("/post")
public class RestPost {

	AccountServiceImpl accService = new AccountServiceImpl();
	SoccerFieldServiceImpl socService = new SoccerFieldServiceImpl();
	ReservationServiceImpl resService = new ReservationServiceImpl();
	CustomerServiceImpl cusService = new CustomerServiceImpl();
	ResviewServiceImpl revService = new ResviewServiceImpl();
	LocalServiceImpl locService = new LocalServiceImpl();
	GuestServiceImpl guestService = new GuestServiceImpl();

	static final Logger log = Logger.getLogger(RestPost.class);

	//http://localhost:8080/api-rest/post/postReserv/
	@POST
	@Path("/postReserv")
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces(MediaType.APPLICATION_JSON)
	public String postReserv( ReservInsertDTO res) {
		log.info("entro POST: postReserv()");
		String result = "";
		JsonObject json = new JsonObject();
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

			json.addProperty("message", "");
			json.addProperty("response", true);
			log.info("Registro Reservation completo");
			result = json.toString();
			log.info("salio POST: postReserv()");
			return result;

		} catch (Exception e) {
			log.fatal("Exception: ", e);
			json.addProperty("message", "Algo salio mal...");
			json.addProperty("response", false);
			result = json.toString();
			log.info("salio POST: postReserv()");
			return result;
		}

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

	//http://localhost:8080/api-rest/post/validacionCustomer/
	@POST
	@Path("/validacionCustomer")
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces(MediaType.APPLICATION_JSON)
	public String validacionCustomer( CustomerDTO usu) {
		log.info("Entrando a POST: validacionCustomer()");

		JsonObject json = new JsonObject();
		String result = "";

		log.info("---Inicia validacion de Correo---");

		List<Customer> listaCusJPA = new ArrayList<Customer>();
		try {
			listaCusJPA = cusService.getCustomers();
			for(Customer cus:listaCusJPA) {
				if(usu.getEmail().equals(cus.getEmail()) || usu.getPhone()==cus.getPhone()) {

					json.addProperty("message", "El email/numero ingresado ya se encuentra registrado");
					json.addProperty("response", false);
					log.error("El email ingresado ya se encuentra registrado");
					result = json.toString();
					return result;
				}
			}

			json.addProperty("message", "Email/Numero Disponible");
			json.addProperty("response", true);
			result = json.toString();
			log.info("El email/numero disponible");

			log.info("---Finaliza busqueda cuentas---");
		} catch (Exception e) {
			log.fatal("Exception: ", e);
		}
		log.info("---Finaliza validacion de Customer---");
		return result;
	}

	//http://localhost:8080/api-rest/post/signUp/
	@POST
	@Path("/signUp")
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces(MediaType.APPLICATION_JSON)
	public String signUp( CustomerAdvDTO cus) {
		LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        String formatDateTime = now.format(formatter);
		
		log.info("entro POST: signUp()");

		JsonObject json = new JsonObject();
		String result = "";

		log.info("---Empieza insercion de Account---");

		Account account = new Account();
		account.setPassword(cus.getPass());
		account.setConfirmedAt(formatDateTime);

		try {
			account = accService.registrar(account);
		} catch (Exception e) {
			log.fatal("Exception: ", e);
			json.addProperty("message", "Algo salio mal al registrar Account...");
			json.addProperty("response", false);
			result = json.toString();
			log.info("salio POST: postReserv()");
			return result;
		}
		log.info("---Finaliza insercion de Account---");

		log.info("---Empieza insercion de Profile---");

		Customer customer = new Customer();

		customer.setAccount(account);
		customer.setBirthday(cus.getBirthday());
		
		

		customer.setCreatedAt(formatDateTime);
		customer.setEmail(cus.getEmail());
		customer.setFirstName(cus.getFirstName());
		customer.setLastName(cus.getLastName());
		customer.setPhone(cus.getPhone());


		try {
			customer = cusService.registrar(customer);
			log.info(customer.getId());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.fatal("Exception: ", e);
			json.addProperty("message", "Algo salio mal al registrar Customer...");
			json.addProperty("response", false);
			result = json.toString();
			log.info("salio POST: postReserv()");
			return result;
		}

		log.info("---Finaliza insercion de Profile---");

		log.info("---Empieza creacion de Respuesta---");

		JsonElement cusDTO = null;
		cusDTO =  new Gson().toJsonTree(Util.CustomerJPAtoDTO(customer));

		json.add("Customer",cusDTO);
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
	public String postReview( ReviewInsertDTO rev) {
		log.info("entro POST: postReview()");

		JsonObject json = new JsonObject();
		String result = "";
		Review revInsert = new Review();
		List<Review> listReviewXLocal = new ArrayList<Review>();
		List<Local>locals = new ArrayList<Local>();
		List<Customer>customers = new ArrayList<Customer>();
		try {
			listReviewXLocal = revService.getReviewsXLocal(rev.getLocalId());
			locals = locService.getLocals();
			customers = cusService.getCustomers();
			for(Review r:listReviewXLocal) {
				if(rev.getLocalId()==r.getLocal().getId() && rev.getCustomerId()==r.getCustomer().getId()) {
					revInsert.setId(r.getId());
					for(Local l:locals) {
						if(rev.getLocalId()==l.getId()) {
							revInsert.setLocal(l);
							break;
						} 
					}
					if(revInsert.getLocal().equals(null)) {
						//Solo para validar local
					}
					for(Customer c: customers) {
						if(rev.getCustomerId()==c.getId()) {
							revInsert.setCustomer(c);
							break;
						}
					}if(revInsert.getCustomer().equals(null)) {
						//solo para validar Customer
					}
					revInsert.setCommentary(rev.getCommentary());
					revInsert.setStars(rev.getStars());
					log.info("Objeto creado");
					log.info("Actualizando Review..");
					revInsert = revService.actualizar(revInsert);
					log.info("ID Review: "+revInsert.getId());


					json.addProperty("message", "Review actualizado");
					json.addProperty("response", true);
					result = json.toString();
					log.info("Review actualizado");
					log.info("salio POST: postReview()");
					return result;

				}
			}
			for(Local l:locals) {
				if(rev.getLocalId()==l.getId()) {
					revInsert.setLocal(l);
					break;
				} 
			}
			if(revInsert.getLocal().equals(null)) {
				//Solo para validar local
			}
			for(Customer c: customers) {
				if(rev.getCustomerId()==c.getId()) {
					revInsert.setCustomer(c);
					break;
				}
			}if(revInsert.getCustomer().equals(null)) {
				//solo para validar Customer
			}

			revInsert.setCommentary(rev.getCommentary());
			revInsert.setStars(rev.getStars());
			log.info("Objeto creado");
			log.info("Insertando Review..");

			revInsert = revService.registrar(revInsert);
			log.info("ID Review: "+revInsert.getId());

			json.addProperty("message", "");
			json.addProperty("response", true);
			log.info("Registro Review completo");
			result = json.toString();
			log.info("salio POST: postReview()");
			return result;


		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.fatal("Exception: ", e);
			json.addProperty("message", "Algo salio mal...");
			json.addProperty("response", false);
			result = json.toString();
			log.info("salio POST: postReview()");
			return result;
		}


	}
	
	
	
	//http://localhost:8080/api-rest/post/signGuest/
		@POST
		@Path("/signGuest")
		@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
		@Produces(MediaType.APPLICATION_JSON)
		public String signGuest( GuestInsertDTO guestInsertDTO) {
			LocalDateTime now = LocalDateTime.now();
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
	        String formatDateTime = now.format(formatter);
			
			log.info("entro POST: signGuest()");

			JsonObject json = new JsonObject();
			String result = "";

			log.info("---Empieza Insercion de Guest---");

			Guest guest = new Guest();
			guest = Util.guestDTOtoJPA(guestInsertDTO);

			try {
				guest = guestService.registrar(guest);
			} catch (Exception e) {
				log.fatal("Exception: ", e);
				json.addProperty("message", "Algo salio mal al registrar Guest...");
				json.addProperty("response", false);
				result = json.toString();
				log.info("salio POST: signGuest()");
				return result;
			}
			log.info("---Finaliza insercion de Guest---");

			json.addProperty("message", "");
			json.addProperty("response", true);
			result = json.toString();

			log.info("salio POST: signGuest()");
			return result;
		}
	
	
}
