package edu.cibertec.util;

import org.apache.log4j.Logger;

import edu.cibertec.dto.AccountDTO;
import edu.cibertec.dto.LocalDTO;
import edu.cibertec.dto.PartnerDTO;
import edu.cibertec.entity.Account;
import edu.cibertec.entity.Local;
import edu.cibertec.entity.Partner;

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
}
