package com.model;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jxl.Sheet;
import jxl.Workbook;
import com.model.giftBeanOP;
import com.model.cusBeanOP;
import com.model.salesBeanOP;
import com.model.dingdanBeanOP;
import com.model.fapiaoBeanOP;
import com.model.duizhangBeanOP;

public class ConnInport {
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

	public ArrayList<giftBean> getgift_xls(String file) {
		ArrayList<giftBean> al = new ArrayList<giftBean>();
		List<giftBean> list = new ArrayList<giftBean>();
		giftBeanOP gbb = new giftBeanOP();
		boolean gb = false;
		try {
			Workbook rwb = Workbook.getWorkbook(new File("/Users/lileilei/Desktop/model/upload/" + file));
			Sheet rs = rwb.getSheet(0);// 或者rwb.getSheet(0)
			int clos = rs.getColumns();// 得到所有的列
			int rows = rs.getRows();// 得到所有的行
			boolean flag;
			giftBean ub = null;
			System.out.println(clos + " rows:" + rows);
			for (int i = 1; i < rows; i++) {// 第一行是表头，不要
				for (int j = 0; j < clos; j++) {
					// 第一个是列数，第二个是行数
					String gift_name = rs.getCell(j++, i).getContents();// 默认最左边编号也算一列
																		// 所以这里得j++
					String gift_num = rs.getCell(j++, i).getContents();
					String gift_value = rs.getCell(j++, i).getContents();
					String jifen = rs.getCell(j++, i).getContents();
					float gift_num1 = Float.parseFloat(gift_num);// string转float
					float gift_value1 = Float.parseFloat(gift_value);// string转float
					float jifen1 = Float.parseFloat(jifen);// string转float
					flag = gbb.creatGift(gift_name, gift_num1, gift_value1, jifen1);

					ub = new giftBean();
					ub.setgift_name(gift_name);
					ub.setgift_num(gift_num1);
					ub.setgift_value(gift_value1);
					ub.setjifen(jifen1);
					if (flag == true) {
						ub.setflag(1);
					} else {
						ub.setflag(0);
					}
					al.add(ub);
					System.out.println("gift_name:" + gift_name + " gift_num:" + gift_num + " gift_value:" + gift_value
							+ " jifen:" + jifen);
					// list.add(new gift(Integer.parseInt(id), name, sex,
					// Integer.parseInt(num)));
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return al;

	}

	public String getdanwei(String danwei_name, String area) {
		String al = null;
		try {
			ct = new ConnDB().getConn();

			String sql = "select ID from danwei where danwei_name=? and area_name=? ";
			ps = ct.prepareStatement(sql);
			ps.setString(1, danwei_name);
			ps.setString(2, area);
			// System.out.println(sql+cus_name+danwei);
			rs = ps.executeQuery();
			while (rs.next()) {
				al = rs.getString(1);
				// System.out.println(al);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			this.close();
		}
		return al;
	}

	public String getkeshi(String keshi_name, String danwei_name) {
		String al = null;
		try {
			ct = new ConnDB().getConn();

			String sql = "select ID from keshi where danwei_name=? and keshi_name=? ";
			ps = ct.prepareStatement(sql);
			ps.setString(1, danwei_name);
			ps.setString(2, keshi_name);
			// System.out.println(sql+cus_name+danwei);
			rs = ps.executeQuery();
			while (rs.next()) {
				al = rs.getString(1);
				// System.out.println(al);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			this.close();
		}
		return al;
	}

	public String getCus(String cus_name, String keshi_name) {
		String al = null;
		try {
			ct = new ConnDB().getConn();

			String sql = "select ID from customer where keshi_name=? and cus_name=? ";
			ps = ct.prepareStatement(sql);
			ps.setString(1, keshi_name);
			ps.setString(2, cus_name);
			// System.out.println(sql+cus_name+danwei);
			rs = ps.executeQuery();
			while (rs.next()) {
				al = rs.getString(1);
				// System.out.println(al);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			this.close();
		}
		return al;
	}

	public String getCus_IDCunzai() {
		String al = null;
		try {
			ct = new ConnDB().getConn();

			String sql = "select cus_ID from customer order by cus_ID desc limit 1";
			ps = ct.prepareStatement(sql);
			//ps.setString(1, cus_ID);
			// ps.setString(2, cus_name);
			// System.out.println(sql+cus_name+danwei);
			rs = ps.executeQuery();
			while (rs.next()) {
				al = rs.getString(1);
				// System.out.println(al);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			this.close();
		}
		return al;
	}

	public String getCusID(String cus_name, String keshi_name) {
		String al = null;
		try {
			ct = new ConnDB().getConn();

			String sql = "select cus_ID from customer where keshi_name=? and cus_name=? ";
			ps = ct.prepareStatement(sql);
			ps.setString(1, keshi_name);
			ps.setString(2, cus_name);
			// System.out.println(sql+cus_name+danwei);
			rs = ps.executeQuery();
			while (rs.next()) {
				al = rs.getString(1);
				// System.out.println(al);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			this.close();
		}
		return al;
	}

	public ArrayList<cusBean> getcus_xls(String file, String area) {
		ArrayList<cusBean> al = new ArrayList<cusBean>();
		cusBeanOP cusb = new cusBeanOP();
		boolean gb = false;
		try {
			Workbook rwb = Workbook.getWorkbook(new File("/Users/lileilei/Desktop/model/upload/" + file));
			Sheet rs = rwb.getSheet(0);// 或者rwb.getSheet(0)
			int clos = rs.getColumns();// 得到所有的列
			int rows = rs.getRows();// 得到所有的行
			boolean flag;
			cusBean cb = null;
			String danwei_name = null;
			String keshi_name = null;
			String area_name = null;
			String cus_ID = null;
			area_name = area.substring(0, area.length() - 4);
			System.out.println(area_name);
			for (int i = 0; i < rows; i++) {
				String str1 = rs.getCell(0, i).getContents();
				if (str1.length() == 0) {
					continue;
				} else {
					// System.out.println(str1);
					String pan1 = str1.substring(0, 1);
					String pan2 = str1.substring(1, 2);
					// System.out.println("\\" + pan1 + "+" + pan2);
					// int chr=pan2.charAt(1);
					if ((!pan1.equals("-")) && (pan2.equals("1") || pan2.equals("2") || pan2.equals("3")
							|| pan2.equals("4") || pan2.equals("5") || pan2.equals("6") || pan2.equals("7")
							|| pan2.equals("8") || pan2.equals("9"))) {// 找到单位的那一行
						String[] s = str1.split(" ");
						danwei_name = s[1];
						// System.out.println(danwei_name);
						String danweiCunzai = null;
						danweiCunzai = getdanwei(danwei_name, area_name);
						if (danweiCunzai == null) {
							danweiBeanOP dOp = new danweiBeanOP();
							dOp.creatdanwei(danwei_name, "待定", "待定", "待定", area_name);
						}
						continue;
					}
					if ((!pan1.equals("-")) && pan2.equals("[")) {// 找到单位那一行
						String[] s = str1.split(" ");
						keshi_name = s[1];
						String keshiCunzai = getkeshi(keshi_name, danwei_name);
						if (keshiCunzai == null) {
							keshiBeanOP kOp = new keshiBeanOP();
							kOp.creatkeshi(keshi_name, "待定", danwei_name);
						}
						continue;
					} else {
						String kkString = str1;
						String cus_name = rs.getCell(1, i).getContents();
						String mobile1 = rs.getCell(2, i).getContents();
						String email = rs.getCell(3, i).getContents();
						String state = rs.getCell(4, i).getContents();
						String cusCunzai = null;
						cusCunzai = getCus(cus_name, keshi_name);
						cb = new cusBean();
						if (cusCunzai == null) {
							int ID;
							cus_ID = getCus_IDCunzai();
							if(cus_ID==null){cus_ID="100000";}
							ID=Integer.parseInt(cus_ID);
							ID=ID+1;
							cus_ID=String.valueOf(ID);

							flag = cusb.creatCus(cus_ID, cus_name, "待定", "待定", mobile1, "待定", "待定", keshi_name, "待定",
									"待定", 0, "待定", 0, 0, "待定", "待定", 1, state, email, danwei_name, area_name);
							if (flag == true) {
								cb.setflag(1);
							} else {
								cb.setflag(0);
							}

						} else {
							cb.setflag(3);
						}
						cb.setcus_ID(cus_ID);
						cb.setname(cus_name);
						cb.setmobile1(mobile1);
						cb.setkeshi_name(keshi_name);
						cb.setdanwei_name(danwei_name);
						cb.setarea_name(area_name);
						cb.setstate(state);
						cb.setemail(email);
						al.add(cb);
						// System.out.println("is customer");
					}

				}
			}

			// System.out.println(clos + " rows:" + rows);
			// for (int i = 0; i < rows; i++) {// 第一行是表头，不要
			// int clos = rs.getColumns();// 得到每行的列数
			// if(clos==1){
			// String str=rs.getCell(2, i).getContents();
			// System.out.println(str);
			// }
			//
			// for (int j = 0; j < clos; j++) {
			// // 第一个是列数，第二个是行数
			// String cus_ID = rs.getCell(j++, i).getContents();// 默认最左边编号也算一列
			// // 所以这里得j++
			// String cus_name = rs.getCell(j++, i).getContents();
			// String sex = rs.getCell(j++, i).getContents();
			// String type = rs.getCell(j++, i).getContents();
			// String mobile1 = rs.getCell(j++, i).getContents();
			// String mobile2 = rs.getCell(j++, i).getContents();
			// String phone = rs.getCell(j++, i).getContents();
			// String keshi_name = rs.getCell(j++, i).getContents();
			// String danwei_name = rs.getCell(j++, i).getContents();
			// String area_name = rs.getCell(j++, i).getContents();
			// String role = rs.getCell(j++, i).getContents();
			// String task = rs.getCell(j++, i).getContents();
			// String advance_money = rs.getCell(j++, i).getContents();
			// String hobby = rs.getCell(j++, i).getContents();
			// String jifen = rs.getCell(j++, i).getContents();
			// String keyan_money = rs.getCell(j++, i).getContents();
			// String chengguo = rs.getCell(j++, i).getContents();
			// String position = rs.getCell(j++, i).getContents();
			// String protity = rs.getCell(j++, i).getContents();
			// String state = rs.getCell(j++, i).getContents();
			// String email = rs.getCell(j++, i).getContents();
			//
			// float advance_money1 = Float.parseFloat(advance_money);//
			// string转float
			// float keyan_money1 = Float.parseFloat(keyan_money);//
			// string转float
			// int jifen1 = Integer.parseInt(jifen);// string转float
			// int protity1 = Integer.parseInt(protity);// string转float
			// flag = cusb.creatCus(cus_ID, cus_name, sex, type, mobile1,
			// mobile2, phone, keshi_name, role, task,
			// advance_money1, hobby, jifen1, keyan_money1, chengguo, position,
			// protity1, state, email,
			// danwei_name, area_name);
			// System.out.println("cus_ID:" + cus_ID + " cus_name:" + cus_name +
			// " mobile1:" + mobile1 + " email:"
			// + email + " ... ");
			// cb = new cusBean();
			// cb.setcus_ID(cus_ID);
			// cb.setname(cus_name);
			// cb.setsex(sex);
			// cb.settype(type);
			// cb.setmobile1(mobile1);
			// cb.setmobile2(mobile2);
			// cb.setphone(phone);
			// cb.setkeshi_name(keshi_name);
			// cb.setdanwei_name(danwei_name);
			// cb.setarea_name(area_name);
			// cb.setrole(role);
			// cb.settask(task);
			// cb.setadvance_money(advance_money1);
			// cb.sethobby(hobby);
			// cb.setjifen(jifen1);
			// cb.setkeyan_money(keyan_money1);
			// cb.setchengguo(chengguo);
			// cb.setposition(position);
			// cb.setprotity(protity1);
			// cb.setstate(state);
			// cb.setemail(email);
			// if (flag == true) {
			// cb.setflag(1);
			// } else {
			// cb.setflag(0);
			// }
			// al.add(cb);
			//
			// // list.add(new gift(Integer.parseInt(id), name, sex,
			// // Integer.parseInt(num)));
			// }
			// }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return al;

	}

	public ArrayList<salesBean> getsales_xls(String file) {
		ArrayList<salesBean> al = new ArrayList<salesBean>();
		salesBeanOP cusb = new salesBeanOP();
		boolean gb = false;
		try {
			Workbook rwb = Workbook.getWorkbook(new File("/Users/lileilei/Desktop/model/upload/" + file));
			Sheet rs = rwb.getSheet(0);// 或者rwb.getSheet(0)
			int clos = rs.getColumns();// 得到所有的列
			int rows = rs.getRows();// 得到所有的行
			boolean flag;
			salesBean cb = null;
			System.out.println(clos + " rows:" + rows);
			for (int i = 1; i < rows; i++) {// 第一行是表头，不要
				for (int j = 0; j < clos; j++) {
					// 第一个是列数，第二个是行数
					String sales_ID = rs.getCell(j++, i).getContents();// 默认最左边编号也算一列
																		// 所以这里得j++
					String sales_name = rs.getCell(j++, i).getContents();
					String sex = rs.getCell(j++, i).getContents();
					String CN_ID = rs.getCell(j++, i).getContents();
					String mobile1 = rs.getCell(j++, i).getContents();
					String mobile2 = rs.getCell(j++, i).getContents();
					String inDate = rs.getCell(j++, i).getContents();
					String duty = rs.getCell(j++, i).getContents();
					String level = rs.getCell(j++, i).getContents();
					String salary = rs.getCell(j++, i).getContents();
					String royalty = rs.getCell(j++, i).getContents();
					String Team_ID = rs.getCell(j++, i).getContents();
					String favorite = rs.getCell(j++, i).getContents();
					String characte = rs.getCell(j++, i).getContents();
					String email = rs.getCell(j++, i).getContents();

					float salary1 = Float.parseFloat(salary);// string转float
					float royalty1 = Float.parseFloat(royalty);// string转float

					flag = cusb.creatSales(sales_ID, sales_name, sex, CN_ID, mobile1, mobile2, inDate, duty, level,
							salary1, royalty1, Team_ID, favorite, characte, email);
					System.out.println("sales_ID:" + sales_ID + " sales_name:" + sales_name + " mobile1:" + mobile1
							+ " email:" + email + "  ...  ");
					cb = new salesBean();
					cb.setsales_ID(sales_ID);
					cb.setname(sales_name);
					cb.setsex(sex);
					cb.setCN_ID(CN_ID);
					cb.setmobile1(mobile1);
					cb.setmobile2(mobile2);
					cb.setinDate(inDate);
					cb.setduty(duty);
					cb.setlevel(level);
					cb.setsalary(salary1);
					cb.setroyalty(royalty1);
					cb.setTeam_ID(Team_ID);
					cb.setfavorite(favorite);
					cb.setcharacter(characte);
					cb.setemail(email);

					if (flag == true) {
						cb.setflag(1);
					} else {
						cb.setflag(0);
					}
					al.add(cb);

					// list.add(new gift(Integer.parseInt(id), name, sex,
					// Integer.parseInt(num)));
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return al;

	}

	public ArrayList<dingdanBean> getdingdan_xls(String file) {
		ArrayList<dingdanBean> al = new ArrayList<dingdanBean>();
		dingdanBeanOP cusb = new dingdanBeanOP();
		boolean gb = false;
		try {
			Workbook rwb = Workbook.getWorkbook(new File("/Users/lileilei/Desktop/model/upload/" + file));
			Sheet rs = rwb.getSheet(0);// 或者rwb.getSheet(0)
			int clos = rs.getColumns();// 得到所有的列
			int rows = rs.getRows();// 得到所有的行
			boolean flag;
			dingdanBean cb = null;
			System.out.println(clos + " rows:" + rows);
			for (int i = 1; i < rows; i++) {// 第一行是表头，不要
				for (int j = 0; j < clos; j++) {
					// 第一个是列数，第二个是行数
					String dingdan_ID = rs.getCell(j++, i).getContents();// 默认最左边编号也算一列
																			// 所以这里得j++
					String date = rs.getCell(j++, i).getContents();
					String type = rs.getCell(j++, i).getContents();
					String cus_ID = rs.getCell(j++, i).getContents();
					String sales_ID = rs.getCell(j++, i).getContents();
					String state = rs.getCell(j++, i).getContents();
					String fapiao_ID = rs.getCell(j++, i).getContents();
					String yangpingmiaoshu = rs.getCell(j++, i).getContents();
					String sample_num = rs.getCell(j++, i).getContents();
					String price = rs.getCell(j++, i).getContents();
					String sell_off = rs.getCell(j++, i).getContents();
					String shoufei_num = rs.getCell(j++, i).getContents();
					String num = rs.getCell(j++, i).getContents();
					String duizhang_ID = rs.getCell(j++, i).getContents();

					float price1 = Float.parseFloat(price);// string转float
					float sell_off1 = Float.parseFloat(sell_off);// string转float
					float num1 = Float.parseFloat(num);// string转float
					int duizhang_ID1 = Integer.parseInt(duizhang_ID);

					flag = cusb.creatDingdan(dingdan_ID, date, type, dingdan_ID, cus_ID, sales_ID, state, fapiao_ID,
							yangpingmiaoshu, sample_num, price1, sell_off1, num1, shoufei_num, duizhang_ID1);
					System.out.println(
							"dingdan_ID:" + dingdan_ID + " date:" + date + " duizhang_ID:" + duizhang_ID + "  ...  ");
					cb = new dingdanBean();
					cb.setdingdan_ID(dingdan_ID);
					cb.setdate(date);
					cb.settype(type);
					cb.setcus_ID(cus_ID);
					cb.setsales_ID(sales_ID);
					cb.setstate(state);
					cb.setfapiao(fapiao_ID);
					cb.setyangpinmiaoshu(yangpingmiaoshu);
					cb.setsample_num(sample_num);
					cb.setprice(price1);
					cb.setsell_off(sell_off1);
					cb.setnum(num1);
					cb.setshoufei_num(shoufei_num);
					cb.setduizhang_ID(duizhang_ID1);

					if (flag == true) {
						cb.setflag(1);
					} else {
						cb.setflag(0);
					}
					al.add(cb);

					// list.add(new gift(Integer.parseInt(id), name, sex,
					// Integer.parseInt(num)));
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return al;

	}

	public ArrayList<fapiaoBean> getfapiao_xls(String file) {
		ArrayList<fapiaoBean> al = new ArrayList<fapiaoBean>();
		fapiaoBeanOP cusb = new fapiaoBeanOP();
		boolean gb = false;
		try {
			Workbook rwb = Workbook.getWorkbook(new File("/Users/lileilei/Desktop/model/upload/" + file));
			Sheet rs = rwb.getSheet(0);// 或者rwb.getSheet(0)
			int clos = rs.getColumns();// 得到所有的列
			int rows = rs.getRows();// 得到所有的行
			boolean flag;
			fapiaoBean cb = null;
			System.out.println(clos + " rows:" + rows);
			for (int i = 1; i < rows; i++) {// 第一行是表头，不要
				for (int j = 0; j < clos; j++) {
					// 第一个是列数，第二个是行数
					String fapiao_ID = rs.getCell(j++, i).getContents();// 默认最左边编号也算一列
																		// 所以这里得j++
					String creat_date = rs.getCell(j++, i).getContents();
					String dingdan_ID = rs.getCell(j++, i).getContents();
					String money = rs.getCell(j++, i).getContents();
					String cus_ID = rs.getCell(j++, i).getContents();
					String sales_ID = rs.getCell(j++, i).getContents();
					String shishou = rs.getCell(j++, i).getContents();
					String state = rs.getCell(j++, i).getContents();
					String fapiaotaitou = rs.getCell(j++, i).getContents();
					String user_ID = rs.getCell(j++, i).getContents();

					float money1 = Float.parseFloat(money);// string转float
					float shishou1 = Float.parseFloat(shishou);// string转float

					flag = cusb.creatFapiao(fapiao_ID, fapiao_ID, creat_date, dingdan_ID, money1, cus_ID, sales_ID,
							shishou1, state, fapiaotaitou, user_ID);
					System.out.println(
							"fapiao_ID:" + fapiao_ID + " date:" + creat_date + " dingdan_ID:" + dingdan_ID + "  ...  ");
					cb = new fapiaoBean();
					cb.setfapiao_ID(fapiao_ID);
					cb.setcreate_date(creat_date);
					cb.setdingdan_ID(dingdan_ID);
					cb.setmoney(money1);
					cb.setcus_ID(cus_ID);
					cb.setsales_ID(sales_ID);
					cb.setshishou(shishou1);
					cb.setstate(state);
					cb.setfapiaotaitou(fapiaotaitou);
					cb.setuser_ID(user_ID);

					if (flag == true) {
						cb.setflag(1);
					} else {
						cb.setflag(0);
					}
					al.add(cb);

					// list.add(new gift(Integer.parseInt(id), name, sex,
					// Integer.parseInt(num)));
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return al;

	}

	public ArrayList<duizhangBean> getduizhang_xls(String file) {
		ArrayList<duizhangBean> al = new ArrayList<duizhangBean>();
		duizhangBeanOP cusb = new duizhangBeanOP();
		boolean gb = false;
		try {
			Workbook rwb = Workbook.getWorkbook(new File("/Users/lileilei/Desktop/model/upload/" + file));
			Sheet rs = rwb.getSheet(0);// 或者rwb.getSheet(0)
			int clos = rs.getColumns();// 得到所有的列
			int rows = rs.getRows();// 得到所有的行
			boolean flag;
			duizhangBean cb = null;
			System.out.println(clos + " rows:" + rows);
			for (int i = 1; i < rows; i++) {// 第一行是表头，不要
				for (int j = 0; j < clos; j++) {
					// 第一个是列数，第二个是行数
					String duizhang_ID = rs.getCell(j++, i).getContents();// 默认最左边编号也算一列
																			// 所以这里得j++
					String fapiao_ID = rs.getCell(j++, i).getContents();
					String date = rs.getCell(j++, i).getContents();
					String user = rs.getCell(j++, i).getContents();
					String danwei_name = rs.getCell(j++, i).getContents();
					String keshi_name = rs.getCell(j++, i).getContents();

					int duizhang_ID1 = Integer.parseInt(duizhang_ID);

					flag = cusb.creat_duizhang(duizhang_ID1, fapiao_ID, date, user, danwei_name, keshi_name);
					System.out.println("duizhang:" + duizhang_ID + " date:" + date + " user:" + user + "  ...  ");
					cb = new duizhangBean();
					cb.setduizhang_ID(duizhang_ID1);
					cb.setfapiao_ID(fapiao_ID);
					cb.setdate(date);
					cb.setusername(user);
					cb.setdanwei_name(danwei_name);
					cb.setkeshi_name(keshi_name);

					if (flag == true) {
						cb.setflag(1);
					} else {
						cb.setflag(0);
					}
					al.add(cb);

					// list.add(new gift(Integer.parseInt(id), name, sex,
					// Integer.parseInt(num)));
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return al;

	}

	public ArrayList<yinwuBean> getyinwu_xls(String file) {
		ArrayList<yinwuBean> al = new ArrayList<yinwuBean>();
		yinwuBeanOP cusb = new yinwuBeanOP();
		boolean gb = false;
		try {
			Workbook rwb = Workbook.getWorkbook(new File("/Users/lileilei/Desktop/model/upload/" + file));
			Sheet rs = rwb.getSheet(0);// 或者rwb.getSheet(0)
			int clos = rs.getColumns();// 得到所有的列
			int rows = rs.getRows();// 得到所有的行
			boolean flag;
			yinwuBean cb = null;
			System.out.println(clos + " rows:" + rows);
			for (int i = 1; i < rows; i++) {// 第一行是表头，不要
				for (int j = 0; j < clos; j++) {
					// 第一个是列数，第二个是行数
					String old_num = rs.getCell(j++, i).getContents();// 默认最左边编号也算一列
																		// 所以这里得j++
					String nouse = rs.getCell(j++, i).getContents();
					String yinwu_name = rs.getCell(j++, i).getContents();
					String use_num = rs.getCell(j++, i).getContents();
					String date = rs.getCell(j++, i).getContents();
					String cus_name = rs.getCell(j++, i).getContents();
					String danwei = rs.getCell(j++, i).getContents();
					String beizhu = rs.getCell(j++, i).getContents();
					// System.out.println(cus_name + danwei);
					cusBean gcl = new cusBean();

					String cus_ID = null;
					cus_ID = getCus_ID(cus_name, danwei);
					// System.out.println(cus_ID);
					if (cus_ID == null) {
						cb = new yinwuBean();
						cb.setFlag(2);
						// cb.setNew_num(new_num);
						cb.setOld_num(old_num);
						cb.setName(yinwu_name);
						cb.setUse_number(use_num);
						cb.setDate(date);
						cb.setCus_name(cus_name);
						cb.setBeizhu(beizhu);
						cb.setDanwei(danwei);
						al.add(cb);
					} else {
						String location = old_num.substring(old_num.length() - 8, old_num.length());
						System.out.println("location=" + location);
						String bianhao = location.substring(location.length() - 3, location.length());
						System.out.println("bianhao=" + bianhao);
						String shijian = location.substring(0, 5);
						System.out.println("shijian=" + shijian);
						String new_num;
						if (beizhu.equals("母液")) {
							new_num = "Y" + shijian + "1" + bianhao;
						} else if (beizhu.equals("非母液")) {
							new_num = "Y" + shijian + "0" + bianhao;
						} else {
							new_num = "读取备注失败";
						}

						flag = cusb.creatYinwu(yinwu_name, new_num, old_num, location, cus_ID, "待修改", "待修改", use_num,
								date, "待修改", beizhu);
						System.out.println(
								"yinwu_name:" + yinwu_name + " date:" + date + " new_num:" + new_num + "  ...  ");
						cb = new yinwuBean();
						cb.setNew_num(new_num);
						cb.setOld_num(old_num);
						cb.setName(yinwu_name);
						cb.setUse_number(use_num);
						cb.setDate(date);
						cb.setCus_name(cus_name);
						cb.setBeizhu(beizhu);
						cb.setDanwei(danwei);

						if (flag == true) {
							cb.setFlag(1);
						} else {
							cb.setFlag(0);
						}
						al.add(cb);
					}

					// list.add(new gift(Integer.parseInt(id), name, sex,
					// Integer.parseInt(num)));
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return al;

	}

	public String getCus_ID(String cus_name, String danwei) {
		String al = null;
		try {
			ct = new ConnDB().getConn();

			String sql = "select cus_ID from customer where cus_name=? and danwei_name=? ";
			ps = ct.prepareStatement(sql);
			ps.setString(1, cus_name);
			ps.setString(2, danwei);
			// System.out.println(sql+cus_name+danwei);
			rs = ps.executeQuery();
			while (rs.next()) {
				al = rs.getString(1);
				// System.out.println(al);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			this.close();
		}
		return al;
	}

	public ArrayList<kaoqingBean> getkaoqing(String file, String date) {
		ArrayList<kaoqingBean> al = new ArrayList<kaoqingBean>();
		// List<kaoqingBean> list = new ArrayList<kaoqingBean>();
		kaoqingBeanOP gbb = new kaoqingBeanOP();
		boolean gb = false;
		try {

			boolean flag;
			kaoqingBean ub = null;
			kaoqingBeanOP ubBeanOP = new kaoqingBeanOP();
			File f = new File(file);
			System.out.println(file);
			// BufferedReader br = new BufferedReader(new FileReader(f));//
			// 构造一个BufferedReader类来读取文件
			InputStreamReader isr = new InputStreamReader(new FileInputStream(f), "GBK");
			BufferedReader br = new BufferedReader(isr);
			String str = null;
			System.out.println(date);
			str = br.readLine();// 第一行是说明，不需要，从第二行开始
			str = br.readLine();
			while (str != null) {
				String[] s = str.split("\"");
				String[] ss = s[1].split(" ");
				String date1 = ss[0];
				String time = ss[1];
				String id = s[3];

				String nameGBK = s[5];
				byte[] temp = nameGBK.getBytes("GBK");
				byte[] newtemp = new String(temp, "GBK").getBytes("utf8");
				String name = new String(newtemp, "utf8");

				if (date1.equals(date)) {
					ub = new kaoqingBean();
					ub.setSales_kaoqingID(id);
					ub.setSales_name(name);
					ub.setDate(date1);
					ub.setTime(time);
					al.add(ub);
					ubBeanOP.creatKaoqing(id, name, date1, time);
				}

				str = br.readLine();
				if (str.equals(")")) {
					break;
				}
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return al;

	}

}