package Macaw;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.HashMap;
import java.util.Map;

public class Tdma {

	public static int base = 1;
	public int MaxNode;
	public final int randTime = 1024;
	private int successPost = 1000;
	public final int slot = 2;
	private List<Data> list;

	public void setNum(int num){
		this.MaxNode = num;
	}


	public Map<String, String> GetStatus(){
		Map<String, String> map = new HashMap<String, String>();
		Random r = new Random();
		int success_package = 0;
		list = new ArrayList<Data>();

		for (int i = 0 ;i < MaxNode ; i++ ) {
			Data d = new Data(r.nextInt(randTime)+1);
			list.add(d);
		}
		
		Comparator<Data> comparator = new Comparator<Data>() {  
            public int compare(Data d1, Data d2) {                    
                    return d1.time - d2.time;  
            }             
        };        
        Collections.sort(list,comparator);  
		int count = 0;
		while (true) {
			int slot_number = 5;
			for(int k = 0;k < MaxNode ; k++ ) {
				if (list.get(k).time == count && k == slot_number) {
					success_package += 1;
					list.get(k).set(r.nextInt(randTime) + count + 1);
				}
				else if(list.get(k).time == count && k != slot_number){
					list.get(k).set(count + 1);
				}
				else{
					continue;
				}
				}
			if(success_package > successPost){
				break;
			}
			count++;
			Collections.sort(list,comparator);
		}
		String throughout;
		throughout = String.valueOf(1.0 * success_package  / count);
//		Maxnode = String.valueOf(MaxNode);
		map.put("throughout", throughout);
//		map.put("Maxnode", Maxnode);
		return map;
	}
}
