
public interface Model {
	void add(String title,String weather,String context);
	void Modify(int id,String title,String weather,String context);
	 void delete(int id);
}
//这里设计接口Model,书写的方法在Service必须全部能够实现
