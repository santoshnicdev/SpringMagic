package com.san.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.san.bo.CustomerBo;

public class CustomerDaoImple implements CustomerDao {
	private DataSource datasource;
	private static final String SQL = "insert into customer(id,cname,city,pamt,intrest) values(?,?,?,?,?)";

	public CustomerDaoImple(DataSource datasource) {
		this.datasource = datasource;
	}

	@Override
	public int insert(CustomerBo cbo) throws SQLException {
		Connection con = datasource.getConnection();

		PreparedStatement stmt = con.prepareStatement(SQL);
		stmt.setInt(1, cbo.getCno());
		stmt.setString(2, cbo.getName());
		stmt.setString(3, cbo.getCcity());
		stmt.setFloat(4, cbo.getPamt());
		stmt.setFloat(5, cbo.getIntrest());
		int succ = (int) stmt.executeUpdate();
		return succ;
	}

}
