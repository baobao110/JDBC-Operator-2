import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class DAO {
	public int add(Node node) {//这里利用分层的思想，将数据类中的数据封装在Node类型的变量中
		String sql="insert text (title,time,weather,context,userId)values('"+node.getTitle()+"', NOW(),'"+node.getWeather()+"','"+node.getContext()+"',"+node.getUserId()+");";
		/*
		 *这里需要特别的注意node的时间不需要事先设置，只需要调用SQL中的NOW()函数就可以获取当前的时间，同时id也不需要设置
		 *因为在设计数据库时将id设置为主键，同时设置id为自增，这样每次添加数据时，可以不用考虑id的值，因为数据库已经自动完成
		 *id 的增加功能 
		 */
		int a=0;
		try {
			a=DATA.update(sql);//sql语句拼接完成后直接调用DATA的静态方法
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
	}
	public int delete(int id) {//进行删除操作时因为在设计数据库时id作为主键，可以直接利用id号进行删除，非常的方便
		String sql="delete from text where id="+id+";";
		int a=0;
		try {
			a=DATA.update(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
	}
	public int  updateTitle(int id,String title) {
		String sql="update text set title='"+title+"' where id="+id+";";
		int a=0;
		try {
			a=DATA.update(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
	}
	public int updateWeather(int id,String weather) {
		String sql="update text set weather='"+weather+"' where id="+id+";";
		int a=0;
		try {
			a=DATA.update(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
	}
	public int  updateContext(int id,String context) {
		String sql="update text set context='"+context+"' where id="+id+";";
		int a=0;
		try {
			a=DATA.update(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
	}
	//前面的三个方法分别对数据库的单个变量通过id的where查询进行修改
	public int  update(Node node) {
		String sql = "update text set title='"+node.getTitle()+"',weather='"+node.getWeather()+"',context='"+node.getContext()+"' where id="+node.getId()+";";
		int a=0;
		try {
			a=DATA.update(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
	}
	//上面是通过Node变量对数据表进行任意的修改
	public Node CheckId(int id) throws SQLException{
		String sql="select * from text where id="+id+";";
		ResultSet a=DATA.execute(sql);
		Node b=new Node();
		while(a.next()) {
			int Id=a.getInt("id");
			String title=a.getString("title");
			java.util.Date time=a.getDate("time");
			String weather=a.getString("weather");
			String context=a.getString("context");
			int userId=a.getInt("userId");
			b.setId(Id);
			b.setTitle(title);
			b.setTime(time);
			b.setWeather(weather);
			b.setContext(context);
			b.setUserId(userId);
		}
		return b;
	}
	/*
	 * 上面是通过id号进行查询，这里需要注意因为id号唯一,所以每次查询只能获取一组数据，这里设置方法的返回类型为Node
	 * 通过一个Node变量保存获取的一组数据
	 * */
	public ArrayList<Node> CheckTitle(String Title) throws SQLException{
		String sql="select * from text where title='"+Title+"';";
		ResultSet a=DATA.execute(sql);
		Node b=new Node();
		ArrayList<Node> c=new ArrayList<Node>();
		try {
				while(a.next()) {
				int Id = a.getInt("id");
				String title=a.getString("title");
				Date time=a.getDate("time");
				String weather=a.getString("weather");
				String context=a.getString("context");
				b.setId(Id);
				b.setTitle(title);
				b.setTime(time);
				b.setWeather(weather);
				b.setContext(context);
				c.add(b);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return c;
		}
	/*
	 * 上面的这个方法可以和前一个做一下比较，发现方法的返回类型不同，这是因为前者通过id号查询，只能获取一组数据
	 * 但是后者不一样,因为后者是通过title查询可能多条数据的title一样，因此不具有唯一性,因此对于多条数据，我们在原来的基础上用集合
	 * ArrayList<Node>进行保存
	 */
	public ArrayList<Node> CheckTitleMore(String Title) throws SQLException{
		String sql="select * from text where title like'%"+Title+"%';";
		ResultSet a=DATA.execute(sql);
		Node b=new Node();
		ArrayList<Node> c=new ArrayList<Node>();
		try {
				while(a.next()) {
				int Id = a.getInt("id");
				String title=a.getString("title");
				java.util.Date time=a.getDate("time");
				String weather=a.getString("weather");
				String context=a.getString("context");
				b.setId(Id);
				b.setTitle(title);
				b.setTime(time);
				b.setWeather(weather);
				b.setContext(context);
				c.add(b);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return c;
		}
	//上面的这个方法名虽然和前者方法名相同，但是内容合适有些区别的，前者是准确查询，但是这里是模糊查询用的不是=,而是Like
	/*public static void main(String[] args) {
		Node a=new Node();
		a.setContext("ddfdf");
		a.setTitle("3er");
		a.setUserId(5);
		a.setWeather("晴天");
		DAO dao=new DAO();
		dao.add(a);
	}*/

}
