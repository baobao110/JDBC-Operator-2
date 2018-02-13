package use;

import java.sql.SQLException;

public class UserTest {
	public static void main(String[] args) {
		UserDAO use=new UserDAO();
		user root=new user();
		/*root.setName("reut");
		root.setPassword("23232");
		System.out.println(use.add(root)==1?"注册成功":"注册失败");*/
	/*	try {
			root=use.CheckName("reut");
			root.setPassword("3322");
			use.updatePassWord(root);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(use.updatePassWord(root)==1?"修改成功":"修改失败");*/
		
	}
}
