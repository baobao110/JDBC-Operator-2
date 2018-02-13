package use;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class UserDAO {
	public int add(user use) {
		int a=0;
		String sql="insert user (name,password,time)values('"+use.getName()+"','"+use.getPassword()+"',NOW());";
		try {
			a=DATA.update(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return a;
	}
	public void delete(int id) {
		String sql="delete from user where id="+id+";";
		try {
			DATA.update(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public int updatePassWord(user use) {
		String sql="update user set password='"+use.getPassword()+"' where id="+use.getId()+";";
		int a=0;
		try {
			a=DATA.update(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return a;
	}
	public void updateName(user use) {
		String sql="update user set name='"+use.getName()+"' where id="+use.getId()+";";
		try {
			DATA.update(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void update(user use) {
		String sql = "update user set name='"+use.getName()+"',password='"+use.getPassword()+"' where id="+use.getId()+";";
		try {
			DATA.update(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public user CheckId(int id) throws SQLException{
		String sql="select * from user where id="+id+";";
		ResultSet a=DATA.execute(sql);
		user b=new user();
		while(a.next()) {
			int Id=a.getInt("id");
			String name=a.getString("name");
			java.util.Date time=a.getDate("time");
			String password=a.getString("password");
			b.setId(id);
			b.setName(name);
			b.setPassword(password);
			b.setTime(time);
			
		}
		return b;
	}
	public user CheckName(String Name) throws SQLException{
		String sql="select * from user where name='"+Name+"';";
		ResultSet a=DATA.execute(sql);
		user b=new user();
		try {
				while(a.next()) {
				int Id = a.getInt("id");
				String name=a.getString("name");
				String password=a.getString("password");
				Date time=a.getDate("time");
				b.setId(Id);
				b.setName(name);
				b.setPassword(password);
				b.setTime(time);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return b;
		}
	public ArrayList<user> CheckNameMore(String Name) throws SQLException{
		String sql="select * from user where title like'%"+Name+"%';";
		ResultSet a=DATA.execute(sql);
		user b=new user();
		ArrayList<user> c=new ArrayList<user>();
		try {
			while(a.next()) {
				int Id = a.getInt("id");
				String name=a.getString("name");
				String password=a.getString("password");
				Date time=a.getDate("time");
				b.setId(Id);
				b.setName(name);
				b.setPassword(password);
				b.setTime(time);
				c.add(b);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return c;
		}
	}
