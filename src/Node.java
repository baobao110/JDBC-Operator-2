import java.util.Date;
public class Node {
	private int id;
	private String title;
	private Date time;
	private String weather;
	private String context;
	private int userId;
	
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public String getWeather() {
		return weather;
	}
	public void setWeather(String weather) {
		this.weather = weather;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	@Override
	public String toString() {
		return "Node [id=" + id + ", title=" + title + ", time=" + time + ", weather=" + weather + ", context="
				+ context + ", userId=" + userId + "]";
	}
	
	/*
	 * 定义Node类型，其中的变量对应数据库中的各个变量，这里需要注意的是日期类型的date导入的是java.util.Date
	 * 这里需要格外的注意
	 */
	
}
