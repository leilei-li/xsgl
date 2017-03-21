package com.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.tools.DocumentationTool.Location;

public class yinwuBeanOP {
	private ResultSet rs = null;
	private Connection ct = null;
	private PreparedStatement ps = null;

	public void close() {

		try {
			if (rs != null) {
				rs.close();
				rs = null;
			}
			if (ps != null) {
				ps.close();
				ps = null;
			}
			if (!ct.isClosed()) {
				ct.close();
				ct = null;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public boolean creatYinwu(String name, String new_num, String old_num, String location, String cus_ID, String state, String nongdu,
			String use_number, String date, String yinwu_laiyuan,String beizhu) {
		boolean b = false;

		try {
			ct = new ConnDB().getConn();
			ps = ct.prepareStatement(
					"insert into yinwu (name,new_num,old_num,location,cus_ID,state,nongdu,use_number,date,yinwu_laiyuan,beizhu) values (?,?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1, name);
			ps.setString(2, new_num);
			ps.setString(3, old_num);
			ps.setString(4, location);
			ps.setString(5, cus_ID);
			ps.setString(6, state);
			ps.setString(7, nongdu);
			ps.setString(8, use_number);
			ps.setString(9, date);
			ps.setString(10, yinwu_laiyuan);
			ps.setString(11, beizhu);

			int a = ps.executeUpdate();

			if (a == 1)
				b = true;

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			this.close();
		}
		return b;
	}

	public yinwuBean getYinwu_new_num(String new_num) {
		yinwuBean b = null;

		try {
			ct = new ConnDB().getConn();
			ps = ct.prepareStatement("select ID from yinwu where new_num= ? ");
			ps.setString(1, new_num);
			rs = ps.executeQuery();

			while (rs.next()) {
				b = new yinwuBean();
				b.setID(rs.getLong(1));

			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			this.close();
		}
		return b;
	}

	public yinwuBean getYinwu_location(String location) {
		yinwuBean b = null;

		try {
			ct = new ConnDB().getConn();
			ps = ct.prepareStatement("select location from yinwu where location= ? ");
			ps.setString(1, location);
			rs = ps.executeQuery();

			while (rs.next()) {
				b = new yinwuBean();
				b.setID(rs.getLong(1));

			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			this.close();
		}
		return b;
	}

	public ArrayList<yinwuBean> getYinwu(String new_num, String old_num, String start_date, String end_date,
			String keshi, String danwei, String cus_name, String name) {
		ArrayList<yinwuBean> al = new ArrayList<yinwuBean>();
		yinwuBean ub = null;

		try {
			ct = new ConnDB().getConn();
			String sql = "select yinwu.*,customer.cus_name,customer.keshi_name,customer.danwei_name from yinwu "
					+ "inner join customer on customer.cus_ID=yinwu.cus_ID and customer.keshi_name like '%" + keshi
					+ "%' and customer.danwei_name like '%" + danwei + "%' and customer.cus_name like '%" + cus_name
					+ "%'" + "where new_num like '%" + new_num + "%' and old_num like '%" + old_num + "%' "
					+ "and date between " + start_date + " and " + end_date + " and name like '%" + name + "%' "
							+ "order by ID desc ;";
			ps = ct.prepareStatement(sql);

			rs = ps.executeQuery();

			while (rs.next()) {

				ub = new yinwuBean();

				ub.setID(rs.getLong(1));
				ub.setName(rs.getString(2));
				ub.setNew_num(rs.getString(3));
				ub.setOld_num(rs.getString(4));
				ub.setLocation(rs.getString(5));
				ub.setCus_ID(rs.getString(6));
				ub.setState(rs.getString(7));
				ub.setNongdu(rs.getString(8));
				ub.setUse_number(rs.getString(9));
				ub.setDate(rs.getString(10));
				ub.setYinwu_laiyuan(rs.getString(11));
				ub.setBeizhu(rs.getString(12));
				ub.setCus_name(rs.getString(13));
				ub.setKeshi(rs.getString(14));
				ub.setDanwei(rs.getString(15));

				al.add(ub);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			this.close();
		}
		return al;
	}

}