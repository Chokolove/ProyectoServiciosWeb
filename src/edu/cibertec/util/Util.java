package edu.cibertec.util;

import org.apache.log4j.Logger;

import edu.cibertec.dto.AccountDTO;
import edu.cibertec.dto.CustomerDTO;
import edu.cibertec.dto.GuestInsertDTO;
import edu.cibertec.dto.LocNonDaysDTO;
import edu.cibertec.dto.LocWorDayDTO;
import edu.cibertec.dto.LocalDTO;
import edu.cibertec.dto.PartnerDTO;
import edu.cibertec.dto.ReservedAdvDTO;
import edu.cibertec.dto.ReservedDTO;
import edu.cibertec.dto.ReviewDTO;
import edu.cibertec.dto.SoccerFieldDTO;
import edu.cibertec.entity.Account;
import edu.cibertec.entity.Customer;
import edu.cibertec.entity.Guest;
import edu.cibertec.entity.Local;
import edu.cibertec.entity.LocalNonWorkingDay;
import edu.cibertec.entity.LocalWorkingWeekDay;
import edu.cibertec.entity.Partner;
import edu.cibertec.entity.Reservation;
import edu.cibertec.entity.Review;
import edu.cibertec.entity.SoccerField;

public class Util {
	
	static final Logger log = Logger.getLogger(Util.class);
	
	public static AccountDTO accJPAtoDTO (Account acc) {
		AccountDTO dto = new AccountDTO();
		
		dto.setId(acc.getId());
		dto.setConfirmedAt(acc.getConfirmedAt());
		dto.setLastLogin(acc.getLastLogin());
		dto.setLockedAt(acc.getLockedAt());
		
		log.info("Id: "+dto.getId());
		log.info("ConfirmedAt"+dto.getConfirmedAt());
		log.info("LastLogin"+dto.getLastLogin());
		log.info("LockedAt"+dto.getLockedAt());
		
		
		return dto;
	}
	
	public static LocalDTO localJPAtoDTO (Local loc) {
		LocalDTO dto = new LocalDTO();
		
		dto.setId(loc.getId());
		dto.setName(loc.getName());
		dto.setDescription(loc.getDescription());
		dto.setAddress(loc.getAddress());
		dto.setLatitude(loc.getLatitude());
		dto.setLongitude(loc.getLongitude());
		dto.setAnticipation(loc.getAnticipation());
		
		
		log.info("ID:        "+dto.getId());
		log.info("NAME:      "+dto.getName());
		log.info("ADDRESS:   "+dto.getAddress());
		log.info("LATITUDE:  "+dto.getLatitude());
		log.info("LONGITUDE: "+dto.getLongitude());
		
		
		return dto;
	}
	
	public static PartnerDTO partnerJPAtoDTO (Partner par) {
		PartnerDTO dto = new PartnerDTO();
		dto.setId(par.getId());
		dto.setAccount(Util.accJPAtoDTO(par.getAccount()));
		dto.setFirstName(par.getFirstName());
		dto.setLastName(par.getLastName());
		dto.setCreatedAt(par.getCreatedAt());
		
		
		log.info("ID:        "+dto.getId());
		log.info("NAME:      "+dto.getFirstName());
		log.info("LASTNAME:  "+dto.getLastName());
		
		
		return dto;
	}
	public static LocWorDayDTO LocWorDayJPAtoDTO (LocalWorkingWeekDay loc) {
		LocWorDayDTO dto = new LocWorDayDTO();
		dto.setDay(loc.getDay());
		dto.setEnd(loc.getEnd());
		dto.setStart(loc.getStart());
		log.info("ID:   "+loc.getId());
		log.info("DAY:  "+loc.getDay());
		log.info("START:"+loc.getStart());
		log.info("END:  "+loc.getEnd());
		
		return dto;
	}
	public static LocNonDaysDTO LocNonDaysJPAtoDTO (LocalNonWorkingDay loc) {
		LocNonDaysDTO dto = new LocNonDaysDTO();
		dto.setDate(loc.getDate());
		dto.setReasion(loc.getReason());
		
		log.info("ID:   "+loc.getId());
		log.info("Date:  "+loc.getDate());
		log.info("Reason:"+loc.getReason());
		
		return dto;
	}
	
	public static SoccerFieldDTO SoccerFieldJADVPAtoDTO (SoccerField soc) {
		SoccerFieldDTO dto = new SoccerFieldDTO();
		
		dto.setId(soc.getId());
		dto.setDescription(soc.getDescription());
		dto.setLocal(Util.localJPAtoDTO(soc.getLocal()));
		dto.setPrice(soc.getPrice());
		
		log.info("ID: "+soc.getId());
		log.info("DES:"+soc.getDescription());
		
		return dto;
	}
	public static SoccerFieldDTO SoccerFieldJPAtoDTO (SoccerField soc) {
		SoccerFieldDTO dto = new SoccerFieldDTO();
		
		dto.setId(soc.getId());
		dto.setDescription(soc.getDescription());
		dto.setPrice(soc.getPrice());
		
		log.info("ID: "+soc.getId());
		log.info("DES:"+soc.getDescription());
		
		return dto;
	}
	public static ReservedDTO ReservedJPAtoDTO (Reservation res) {
		ReservedDTO dto = new ReservedDTO();
		
		dto.setDay(res.getDate());
		dto.setStart(res.getStart());
		dto.setEnd(res.getEnd());
		
		log.info(""+res.getId());
		log.info(""+res.getDate());
		log.info(""+res.getStart());
		log.info(""+res.getEnd());
		
		return dto;
	}
	
	public static ReservedAdvDTO ReservedAdvJPAtoDTO (Reservation res) {
		ReservedAdvDTO dto = new ReservedAdvDTO();
		
		dto.setDay(res.getDate());
		dto.setStart(res.getStart());
		dto.setEnd(res.getEnd());
		dto.setSoccerFieldDTO(Util.SoccerFieldJADVPAtoDTO(res.getSoccerField()));
		dto.setChargeId(res.getChargeId());
		dto.setChargeAmount(res.getChargeAmount());
		dto.setCreatedAt(res.getCreatedAt());
		
		log.info(""+res.getId());
		log.info(""+res.getDate());
		log.info(""+res.getStart());
		log.info(""+res.getEnd());
		
		return dto;
	}
	
	public static CustomerDTO CustomerJPAtoDTO(Customer cus) {
		CustomerDTO dto = new CustomerDTO();
		
		dto.setId(cus.getId());
		dto.setAccount(Util.accJPAtoDTO(cus.getAccount()));
		dto.setFirstName(cus.getFirstName());
		dto.setLastName(cus.getLastName());
		dto.setBirthday(cus.getBirthday());
		dto.setPhone(cus.getPhone());
		dto.setEmail(cus.getEmail());
		
		log.info(""+dto.getId());
		log.info(""+dto.getFirstName());
		log.info(""+dto.getPhone());
		log.info(""+dto.getEmail());
		
		
		return dto;
	}
	public static ReviewDTO reviewJPAtoDTO (Review rev) {
		ReviewDTO dto = new ReviewDTO();
		
		dto.setId(rev.getId());
		dto.setCustomer(Util.CustomerJPAtoDTO(rev.getCustomer()));
		dto.setStars(rev.getStars());
		dto.setCommentary(rev.getCommentary());
		
		log.info(""+dto.getId());
		log.info(""+dto.getCustomer().getFirstName()+ " "+dto.getCustomer().getLastName());
		log.info(""+dto.getCommentary());
		log.info(""+dto.getStars());
		
		return dto;
	}
	public static Guest guestDTOtoJPA(GuestInsertDTO dto) {
		Guest guest= new Guest();
		
		guest.setId(dto.getId());
		guest.setCreatedAt(dto.getCreatedAt());
		guest.setEmail(dto.getEmail());
		guest.setFirstName(dto.getFirstName());
		guest.setLastName(dto.getLastName());
		guest.setPhone(dto.getPhone());
		
		log.info(""+dto.getId());
		log.info(""+dto.getEmail());
		log.info(""+dto.getFirstName());
		log.info(""+dto.getLastName());
		
		return guest;
	}
}
