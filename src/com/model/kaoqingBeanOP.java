package com.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class kaoqingBeanOP {
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

	public boolean creatKaoqing(String sales_kaoqingID,String sales_name,String date,String time) {
		boolean b = false;

		try {
			ct = new ConnDB().getConn();
			ps = ct.prepareStatement(
					"insert into kaoqing (sales_kaoqingID,sales_name,date,time) values (?,?,?,?)");
			ps.setString(1, sales_kaoqingID);
			ps.setString(2, sales_name);
			ps.setString(3, date);
			ps.setString(4, time);
			

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

	public boolean modifyCus(String cus_ID, String name, String sex, String type, String mobile1, String mobile2,
			String phone, String keshi_name, String role, String task, float advance_money, String hobby, int jifen,
			float keyan_money, String chengguo, String position, int protity, String state, String email) {
		boolean b = false;

		try {
			ct = new ConnDB().getConn();
			ps = ct.prepareStatement(
					"update customer set cus_name=?,sex=?,type=?,mobile1=?,mobile2=?,phone=?,keshi_name=?,"
							+ "role=?,task=?,advance_money=?,hobby=?,jifen=?,keyan_money=?,chengguo=?,position=?,protity=?,"
							+ "state=?,email=? where cus_ID=?");

			ps.setString(1, name);
			ps.setString(2, sex);
			ps.setString(3, type);
			ps.setString(4, mobile1);
			ps.setString(5, mobile2);
			ps.setString(6, phone);
			ps.setString(7, keshi_name);
			ps.setString(8, role);
			ps.setString(9, task);
			ps.setFloat(10, advance_money);
			ps.setString(11, hobby);
			ps.setInt(12, jifen);
			ps.setFloat(13, keyan_money);
			ps.setString(14, chengguo);
			ps.setString(15, position);
			ps.setInt(16, protity);
			ps.setString(17, state);
			ps.setString(18, email);
			ps.setString(19, cus_ID);

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

	public boolean cus_jifenModify_gift(String cus_ID, String gift_name, float gift_num) {
		boolean b = false;

		try {
			ct = new ConnDB().getConn();
			ps = ct.prepareStatement("update customer " + "set customer.jifen=customer.jifen- "
					+ "((select jifen from gift where gift_name=? )*? ) " + "where customer.cus_ID=? ");

			ps.setString(1, gift_name);
			ps.setFloat(2, gift_num);
			ps.setString(3, cus_ID);

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

	public boolean cus_jifenModify_shoukuan(String cus_ID, float shihsou) {
		boolean b = false;

		try {
			ct = new ConnDB().getConn();
			ps = ct.prepareStatement(
					"update customer " + "set customer.jifen=customer.jifen+? where customer.cus_ID=? ");

			ps.setFloat(1, shihsou);
			ps.setString(2, cus_ID);

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

	public ArrayList<kaoqingBean> getKaoqing(String date) {
		ArrayList<kaoqingBean> al = new ArrayList<kaoqingBean>();
		kaoqingBean ub = null;

		try {
			ct = new ConnDB().getConn();
			String sql = "select * from kaoqing where date = "+date+" ";
			ps = ct.prepareStatement(sql);
			
			rs = ps.executeQuery();

			while (rs.next()) {

				ub = new kaoqingBean();

				ub.setID(rs.getLong(1));
				ub.setSales_kaoqingID(rs.getString(2));
				ub.setSales_name(rs.getString(3));
				ub.setDate(rs.getString(4));
				ub.setTime(rs.getString(5));

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

	public ArrayList<cusBean> getCus_cus_ID(String cus_ID) {
		ArrayList<cusBean> al = new ArrayList<cusBean>();
		cusBean ub = null;

		try {
			ct = new ConnDB().getConn();

			String sql = "select * from customer where cus_ID like '%" + cus_ID + "%'  order by cus_ID ";
			ps = ct.prepareStatement(sql);

			rs = ps.executeQuery();

			while (rs.next()) {

				ub = new cusBean();

				ub.setID(rs.getLong(1));
				ub.setcus_ID(rs.getString(2));
				ub.setname(rs.getString(3));
				ub.setsex(rs.getString(4));
				ub.settype(rs.getString(5));
				ub.setmobile1(rs.getString(6));
				ub.setmobile2(rs.getString(7));
				ub.setphone(rs.getString(8));
				ub.setkeshi_name(rs.getString(9));
				ub.setdanwei_name(rs.getString(10));
				ub.setarea_name(rs.getString(11));
				ub.setrole(rs.getString(12));
				ub.settask(rs.getString(13));
				ub.setadvance_money(rs.getFloat(14));
				ub.sethobby(rs.getString(15));
				ub.setjifen(rs.getInt(16));
				ub.setkeyan_money(rs.getFloat(17));
				ub.setchengguo(rs.getString(18));
				ub.setposition(rs.getString(19));
				ub.setprotity(rs.getInt(20));
				ub.setstate(rs.getString(21));
				ub.setemail(rs.getString(22));

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

	public ArrayList<cusBean> getCus_name(String cus_name) {
		ArrayList<cusBean> al = new ArrayList<cusBean>();
		cusBean ub = null;

		try {
			ct = new ConnDB().getConn();

			String sql = "select * from customer where cus_name like '%" + cus_name + "%'  order by cus_name ";
			ps = ct.prepareStatement(sql);

			rs = ps.executeQuery();

			while (rs.next()) {

				ub = new cusBean();

				ub.setID(rs.getLong(1));
				ub.setcus_ID(rs.getString(2));
				ub.setname(rs.getString(3));
				ub.setsex(rs.getString(4));
				ub.settype(rs.getString(5));
				ub.setmobile1(rs.getString(6));
				ub.setmobile2(rs.getString(7));
				ub.setphone(rs.getString(8));
				ub.setkeshi_name(rs.getString(9));
				ub.setdanwei_name(rs.getString(10));
				ub.setarea_name(rs.getString(11));
				ub.setrole(rs.getString(12));
				ub.settask(rs.getString(13));
				ub.setadvance_money(rs.getFloat(14));
				ub.sethobby(rs.getString(15));
				ub.setjifen(rs.getInt(16));
				ub.setkeyan_money(rs.getFloat(17));
				ub.setchengguo(rs.getString(18));
				ub.setposition(rs.getString(19));
				ub.setprotity(rs.getInt(20));
				ub.setstate(rs.getString(21));
				ub.setemail(rs.getString(22));

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

	public ArrayList<cusBean> getCus_mobile1(String mobile1) {
		ArrayList<cusBean> al = new ArrayList<cusBean>();
		cusBean ub = null;

		try {
			ct = new ConnDB().getConn();

			String sql = "select * from customer where mobile1 like '%" + mobile1 + "%'  order by mobile1 ";
			ps = ct.prepareStatement(sql);

			rs = ps.executeQuery();

			while (rs.next()) {

				ub = new cusBean();

				ub.setID(rs.getLong(1));
				ub.setcus_ID(rs.getString(2));
				ub.setname(rs.getString(3));
				ub.setsex(rs.getString(4));
				ub.settype(rs.getString(5));
				ub.setmobile1(rs.getString(6));
				ub.setmobile2(rs.getString(7));
				ub.setphone(rs.getString(8));
				ub.setkeshi_name(rs.getString(9));
				ub.setdanwei_name(rs.getString(10));
				ub.setarea_name(rs.getString(11));
				ub.setrole(rs.getString(12));
				ub.settask(rs.getString(13));
				ub.setadvance_money(rs.getFloat(14));
				ub.sethobby(rs.getString(15));
				ub.setjifen(rs.getInt(16));
				ub.setkeyan_money(rs.getFloat(17));
				ub.setchengguo(rs.getString(18));
				ub.setposition(rs.getString(19));
				ub.setprotity(rs.getInt(20));
				ub.setstate(rs.getString(21));
				ub.setemail(rs.getString(22));

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

	public boolean cus_delete(String cus_ID) {
		boolean b = false;

		try {
			ct = new ConnDB().getConn();
			ps = ct.prepareStatement("delete from customer where cus_ID=?");
			ps.setString(1, cus_ID);

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

	public cusBean cus_ID_cunzai(String cus_ID) {
		cusBean ub = null;

		try {
			ct = new ConnDB().getConn();
			ps = ct.prepareStatement("select cus_name from customer where cus_ID=?");
			ps.setString(1, cus_ID);
			rs = ps.executeQuery();

			while (rs.next()) {
				ub = new cusBean();
				ub.setname(rs.getString(1));

			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			this.close();
		}
		return ub;
	}

	public ArrayList<cusBean> getcus_duo(String cus_ID, String cus_name, String keshi_name, String danwei_name) {
		ArrayList<cusBean> al = new ArrayList<cusBean>();
		cusBean ub = null;

		try {
			ct = new ConnDB().getConn();

			String sql = "select * from customer where cus_ID like '%" + cus_ID + "%' and cus_name like '%" + cus_name
					+ "%' and " + "keshi_name like '%" + keshi_name + "%' and danwei_name like '%" + danwei_name
					+ "%' order by cus_ID";
			ps = ct.prepareStatement(sql);

			rs = ps.executeQuery();

			while (rs.next()) {

				ub = new cusBean();

				ub.setID(rs.getLong(1));
				ub.setcus_ID(rs.getString(2));
				ub.setname(rs.getString(3));
				ub.setsex(rs.getString(4));
				ub.settype(rs.getString(5));
				ub.setmobile1(rs.getString(6));
				ub.setmobile2(rs.getString(7));
				ub.setphone(rs.getString(8));
				ub.setkeshi_name(rs.getString(9));
				ub.setdanwei_name(rs.getString(10));
				ub.setarea_name(rs.getString(11));
				ub.setrole(rs.getString(12));
				ub.settask(rs.getString(13));
				ub.setadvance_money(rs.getFloat(14));
				ub.sethobby(rs.getString(15));
				ub.setjifen(rs.getInt(16));
				ub.setkeyan_money(rs.getFloat(17));
				ub.setchengguo(rs.getString(18));
				ub.setposition(rs.getString(19));
				ub.setprotity(rs.getInt(20));
				ub.setstate(rs.getString(21));
				ub.setemail(rs.getString(22));

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