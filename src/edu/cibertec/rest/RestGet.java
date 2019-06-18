package edu.cibertec.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import edu.cibertec.dto.AccountDTO;
import edu.cibertec.entity.Account;
import edu.cibertec.persistence.service.AccountServiceImpl;
import edu.cibertec.persistence.service.IAccountService;
import edu.cibertec.util.Util;

@Path("/get")
public class RestGet {

	static final Logger log = Logger.getLogger(RestGet.class);

	AccountServiceImpl accService = new AccountServiceImpl();

	//http://localhost:8080/api-rest/get/obtenerDatosAccount/
	@GET
	@Path("/obtenerDatosAccount")
	@Produces(MediaType.APPLICATION_JSON)
	public List<AccountDTO> obtenerDatosAccount() {
		log.info("entro obtenerDatosAccount()");
		List<AccountDTO> listaAccount = new ArrayList<AccountDTO>();
		List<Account> listaAccJPA = new ArrayList<Account>();

		try {
			listaAccJPA = accService.getAccounts();
			for(Account acc:listaAccJPA) {
				listaAccount.add(Util.accJPAtoDTO(acc));
			}
			log.info("Finaliza busqueda");
		} catch (Exception e) {
			log.fatal("Exception: ", e);
		}
		log.info("Saliendo de obtenerDatosAccount()");
		return listaAccount;
	}

	/*
	//http://localhost:8080/api-rest/get/obtenerdatoslocal/
	@GET
	@Path("/obtenerdatoslocal")
	@Produces(MediaType.APPLICATION_JSON)
	public List<LocalDTO> obtenerDatosLocales() {
		log.info("Entro a obtenerDatosLocales()");
		List<LocalDTO> listaLocales = new ArrayList<LocalDTO>();
		List<Local> listJPA = new ArrayList<Local>();

		try {
			listJPA = locService.getLocals();
			for(Local jpa:listJPA) {
				listaLocales.add(Util.localJPAtoDTO(jpa));
			}
			log.info("Finaliza busqueda");
		} catch (Exception e) {
			log.fatal("Exception: ", e);
		}
		log.info("Saliendo de obtenerDatosLocales()");
		return listaLocales;
	}

	//http://localhost:8080/api-rest/get/obtenerdatoslocal/M
	@GET
	@Path("/obtenerdatoslocal/{p_dir}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<LocalDTO> obtenerDatosLocalesDescripcion(@PathParam("p_dir") String dir) {
		log.info("entro obtenerdatoslocalxDesc()");
		List<LocalDTO> listaLocales = new ArrayList<LocalDTO>();
		List<Local> listJPA = new ArrayList<Local>();

		try {
			listJPA = locService.getLocalxDir(dir);

			for(Local loc:listJPA) {
				listaLocales.add(Util.localJPAtoDTO(loc));
			}
			log.info("Finaliza busquedao");

		} catch (Exception e) {
			log.fatal("Exception: ", e);
		}

		log.info("salio obtenerdatoslocalxDesc()");
		return listaLocales;
	}

	//http://localhost:8080/api-rest/get/obetenerResenasLocal/1
	@GET
	@Path("/obetenerResenasLocal/{p_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<ReviewDTO> obetenerRevIdLocal(@PathParam("p_id") int id) {
		log.info("entro obetenerResenasLocal()");
		List<ReviewDTO> review = new ArrayList<ReviewDTO>();
		List<Review> rev = null;
		try {
			rev = revService.getReviewsXLoc(id);
			for(Review revJpa:rev) {
				review.add(Util.reviewJPAtoDTO(revJpa));
			}
			log.info("Finaliza busqueda");
			return review;
		} catch (Exception e) {
			log.fatal("Exception: ", e);
		}
		log.info("salio obetenerResenasLocal()");
		return review;
	}

	//http://localhost:8080/api-rest/get/obetenerRevIdAcc/1
	@GET
	@Path("/obetenerRevIdAcc/{p_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<ReviewDTO> obetenerRevIdAcc(@PathParam("p_id") int id) {
		log.info("entro obetenerRevIdAcc()");
		List<ReviewDTO> review = new ArrayList<ReviewDTO>();
		List<Review> rev = null;
		try {
			rev = revService.getReviewsXAcc(id);
			log.info("tamano: "+rev.size());
			for(Review revJpa:rev) {
				review.add(Util.reviewJPAtoDTO(revJpa));
			}
			log.info("Finaliza busqueda");
			return review;
		} catch (Exception e) {
			log.fatal("Exception: ", e);
		}
		log.info("salio obetenerRevIdAcc()");
		return review;
	}

	//http://localhost:8080/api-rest/get/obtenerDatosAccount/
	@GET
	@Path("/obtenerDatosAccount")
	@Produces(MediaType.APPLICATION_JSON)
	public List<AccountDTO> obtenerDatosAccount() {
		log.info("entro obtenerDatosAccount()");
		List<AccountDTO> listaAccount = new ArrayList<AccountDTO>();
		List<Account> listaAccJPA = new ArrayList<Account>();

		try {
			listaAccJPA = accService.getAccounts();
			for(Account acc:listaAccJPA) {
				listaAccount.add(Util.accJPAtoDTO(acc));
			}
			log.info("Finaliza busqueda");
		} catch (Exception e) {
			log.fatal("Exception: ", e);
		}
		log.info("Saliendo de obtenerDatosAccount()");
		return listaAccount;
	}

	//http://localhost:8080/api-rest/get/obetenerProfileIdAcc/1
	@GET
	@Path("/obetenerProfileIdAcc/{p_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public ProfileDTO obetenerProfileIdAcc(@PathParam("p_id") int id) {
		log.info("entro obetenerProfileIdAcc()");
		ProfileDTO profile = new ProfileDTO();
		Profile profJPA = null;
		try {
			profJPA = profService.getProfile(id);
			profile = Util.profileJPAtoDTO(profJPA);
			log.info("Finaliza busqueda");
		} catch (Exception e) {
			log.fatal("Exception: ", e);
		}
		log.info("salio obetenerProfileIdAcc()");
		return profile;
	}
	/*
	//http://localhost:8080/api-rest/get/obetenerRevXAcc/2&&2
		@GET
		@Path("/obetenerRevXAcc/{p_id_acc}&&{p_id_loc}")
		@Produces(MediaType.APPLICATION_JSON)
		public Review obetenerRevXAcc(@PathParam("p_id_acc") int idLoc, @PathParam("p_id_loc") int idAcc) {
			log.info("entro obetenerRevXAcc()");
			Review rev = new Review();

			List<Review> listaRev = null;

			try {
				listaRev = revService.getReviews();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 

			log.info("salio obetenerRevXAcc()");
			return rev;
		}
	 */












}
