package edu.cibertec.util;

import org.apache.log4j.Logger;

import edu.cibertec.dto.AccountDTO;
import edu.cibertec.entity.Account;

public class Util {
	
	static final Logger log = Logger.getLogger(Util.class);
	
	public static AccountDTO accJPAtoDTO (Account acc) {
		AccountDTO dto = new AccountDTO();
		
		dto.setId(acc.getId());
		dto.setPassword(acc.getPassword());
		dto.setConfirmedAt(acc.getConfirmedAt());
		dto.setLastLogin(acc.getLastLogin());
		dto.setLockedAt(acc.getLockedAt());
		
		log.info("Id: "+dto.getId());
		log.info("ConfirmedAt"+dto.getConfirmedAt());
		log.info("LastLogin"+dto.getLastLogin());
		log.info("LockedAt"+dto.getLockedAt());
		
		
		return dto;
	}
}
