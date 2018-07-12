import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DemandMoney {


static List<Integer> path1 = Arrays.asList(1,1,2,3,4,5);
	static List<Integer> path2 = Arrays.asList(2,4,3,6,5,6);
	static List<Integer> money = Arrays.asList(20,40,30,60,50,60);
static List<Integer> main = Arrays.asList(1,2,3,4,5,6);
	static int n = 6;
	static Integer sum = -1;
	static Integer maxSum = -1;
	static Integer graph[][] = new Integer[n][n];
	public static void main(String args[]){
		
		
		for( int i = 0 ; i < n ; i++){
			for( int j = 0 ; j < n ; j++){
				if(i!=j)
					graph[i][j]=0;
				else
					graph[i][j]=1;
			}
		}
		
		for (int i = 0 ; i < path1.size() ; i++){
			graph[path1.get(i)-1][path2.get(i)-1] = 1 ;
			graph[path2.get(i)-1][path1.get(i)-1] = 1 ;
		}
		
		
		DemandMoney obj = new DemandMoney();
		System.out.println("1) " + main);
		obj.recursive(main,0);
		
		for( int i = 0 ; i < n ; i++){
			for( int j = 0 ; j < n ; j++){
				System.out.print(graph[i][j] + "\t");
			}
			System.out.println();
		}
		System.out.println(maxSum);
	}
	
	public void recursive(List<Integer> list,Integer sum){
		if(list.size() == 1){
			int val = sum + money.get(list.get(0)-1); 
			if(val > maxSum){
				maxSum = val;
			}
		}else if(list.isEmpty()){
			if(sum > maxSum){
				maxSum = sum;
			}
		}else{
			for(int index = 0; index < list.size() ; index++){
				System.out.println("loop: " + list);
				Integer cash = money.get(list.get(index)-1);
				List<Integer>alist = removeAdjacents(list,list.get(index)-1);
				recursive(alist,sum +cash);
			}
			 
		}
	}
	
	public List<Integer> removeAdjacents(List<Integer> list, int index){
		System.out.println("Removed adjs: " + list);
		List<Integer> ans = new ArrayList<Integer>();
		for(int i = 0 ; i< list.size() ; i++){
			if(graph[index][list.get(i)-1] == 0){
				ans.add(list.get(i));
			}
		}
		System.out.println("Removed adjs: " + ans);
		return ans;
	}
}
