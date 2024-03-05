package com.sangheon.realEstate.repository;

import java.sql.SQLException;

public interface EmailAuthenticationRepository {
	
	boolean existsByEmail(String email) throws SQLException;
	
	void save(String email, String authenrticationCode) throws SQLException;
	
}
