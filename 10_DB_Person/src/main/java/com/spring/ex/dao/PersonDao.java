package com.spring.ex.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.spring.ex.dto.PersonDto;

public class PersonDao {

	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	String id = "jspid";
	String pw = "jsppw";

	private PreparedStatement ps = null;
	private ResultSet rs = null;
	private Connection conn = null;
	private static PersonDao instance;

	private PersonDao() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,id,pw);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static PersonDao getInstance() {
		if(instance == null) {
			instance = new PersonDao();
		}
		return instance;
	}

	public int write(String id2, String name, String age) {
		int cnt=-1;
		String sql="insert into person(num,id,name,age) "
				+ "values(person_seq.nextval,?,?,?)";
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, id2);
			ps.setString(2, name);
			ps.setString(3, age);
			cnt=ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(ps!=null) {
					ps.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		System.out.println("insert °¹¼ö:"+cnt);
		return cnt;

	}//write

	public ArrayList<PersonDto> list() {

		ArrayList<PersonDto> list = new ArrayList<PersonDto>();
		String sql = "select * from person order by num";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				PersonDto dt = new PersonDto();
				dt.setNum(rs.getInt("num"));
				dt.setId(rs.getString("id"));
				dt.setName(rs.getString("name"));
				dt.setAge(rs.getInt("age"));
				list.add(dt);
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null)
					rs.close();
				if(ps!=null)
					ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}//

	public PersonDto contentView(String num) {
		PersonDto pdto=new PersonDto();
		String sql="select * from person where num=?";
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, Integer.parseInt(num));
			rs=ps.executeQuery();
			if(rs.next()) {
				pdto.setNum(rs.getInt("num"));
				pdto.setId(rs.getString("id"));
				pdto.setName(rs.getString("name"));
				pdto.setAge(rs.getInt("age"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null)
					rs.close();
				if(ps!=null)
					ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}	
		return pdto;
	}//

	public void modify(String num, String name, String age) {
		int cnt = -1;

		String sql = "update person set name=?,age=? where num=?";

		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1,name);
			ps.setString(2,age);
			ps.setString(3,num);

			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(ps!=null)
					ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public int deleteList(String num) {
		int cnt=-1;
		String sql="delete from person where num=?";
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1,Integer.parseInt(num));

			cnt=ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}  finally {
			try {
				if(ps!=null) {
					ps.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return cnt;

	}
}
