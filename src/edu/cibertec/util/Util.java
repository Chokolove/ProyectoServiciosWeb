package edu.cibertec.util;

import org.apache.log4j.Logger;

import edu.cibertec.dto.AccountDTO;
import edu.cibertec.dto.LocNonDaysDTO;
import edu.cibertec.dto.LocWorDayDTO;
import edu.cibertec.dto.LocalDTO;
import edu.cibertec.dto.PartnerDTO;
import edu.cibertec.dto.ReservedDTO;
import edu.cibertec.dto.SoccerFieldDTO;
import edu.cibertec.entity.Account;
import edu.cibertec.entity.Local;
import edu.cibertec.entity.LocalNonWorkingDay;
import edu.cibertec.entity.LocalWorkingWeekDay;
import edu.cibertec.entity.Partner;
import edu.cibertec.entity.Reservation;
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
}
