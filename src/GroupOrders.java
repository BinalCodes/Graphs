import java.util.ArrayList;
import java.util.List;

public class GroupOrders {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> o1 = new ArrayList<String>();
		o1.add("A");
		o1.add("B");
		o1.add("Z");
		
		List<String> o2 = new ArrayList<String>();
		o2.add("B");
		o2.add("C");
		
		List<String> o3 = new ArrayList<>();
		o3.add("R");
		o3.add("Z");
		List<Orders> list = new ArrayList<>();
		list.add(new Orders("O1", o1));
		list.add(new Orders("O2", o2));
		list.add(new Orders("O3", o3));
	}

}
class Orders{
	String orderId;
	List<String> items;
	Orders(String id, List<String> items){
		this.orderId = id;
		this.items = items;
	}
}
