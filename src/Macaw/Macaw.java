package Macaw;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.HashMap;
import java.util.Map;

public class Macaw {

	public static int base = 1;
	public int MaxNode;
	public int trans_time;
	public int BO = 2;
	public int BOmin = 2;
	public int BOmax = 64;
	public int randtime = 1024;
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
			Data d = new Data(r.nextInt(randtime)+1,2);
			list.add(d);
		}
		       
        Collections.sort(list,new Comparator<Data>(){  
            public int compare(Data d1, Data d2) {                    
                    return d1.time - d2.time;  
            }
            });  
		int count = 0;
		int trans_time = 0;
		while (true) {
			int temcount = 0;
			if(trans_time == 0){
			for (int k = 0;k < MaxNode ; k++ ) {
				if (list.get(k).time == count) {
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
				BO = Math.max(BOmin,list.get(0).BO-1);
				trans_time = 4*r.nextInt(20)+4;
				for (int k = 0;k < MaxNode ; k++ ) {
					list.get(k).setBO(BO);
					list.get(k).set(r.nextInt((int)Math.floor(Math.pow(2,list.get(k).BO))) + count + trans_time);}
				if (success_package > successPost) {
					break;
				}
			}else if (temcount > 1) {
				BO = Math.min(BOmax,(int)Math.floor(list.get(0).BO*1.5));
				for (int j = 0;j < temcount ;j++ ) {
					list.get(j).setBO(BO);
					list.get(j).set(r.nextInt((int)Math.floor(Math.pow(2,list.get(j).BO))) + count);;
				}
			}
	        Collections.sort(list,new Comparator<Data>(){  
	            public int compare(Data d1, Data d2) {                    
	                    return d1.time - d2.time;  
	            }
	            });}
			else{
				for (int j = 0;j < MaxNode ;j++ ) {
					if (list.get(j).time == count) {
						total_package += 1;
						temcount += 1;
				}else{
					continue;
				}
			}
				if(trans_time != 0){
					count++;
					trans_time--;
					}
				}
			
		}
		String throughout, load;
		throughout = String.valueOf(1.0 * 40 * success_package  / count);
		load = String.valueOf(1.0 * 44 * total_package / count);
		map.put("throughout", throughout);
		map.put("load", load);
		return map;
	}
}