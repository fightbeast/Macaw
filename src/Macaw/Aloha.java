package Macaw;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.HashMap;
import java.util.Map;

public class Aloha {

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
		int total_package = 0;
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
			int temcount = 0;
			for (int k = 0;k < MaxNode ; k++ ) {
				if (list.get(k).time >= count * slot && list.get(k).time < (count + 1) * slot) {
					total_package += 1;
					temcount += 1;
				}else{
					continue;
				}
			}
			count++;
			if (temcount == 0) {
				continue;
			}else if (temcount == 1) {
				success_package += 1;
				list.get(0).set(r.nextInt(randTime) + 1 + count * slot);
				if (success_package > successPost) {
					break;
				}
			}else if (temcount > 1) {
				for (int j = 0;j < temcount ;j++ ) {
					list.get(j).set(r.nextInt(randTime) + 1 + count * slot);
				}
			}
			Collections.sort(list,comparator);
		}
		String throughout, load;
		throughout = String.valueOf(1.0 * success_package  / count);
		load = String.valueOf(1.0 * total_package / count);
		map.put("throughout", throughout);
		map.put("load", load);
		return map;
	}
}