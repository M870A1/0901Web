import java.util.TreeSet;

public class Ex08_TreeSet {

	public static void main(String[] args) {

		
		TreeSet<Integer> numTree = new TreeSet<>();
// 중복 제거, 숫자는 크기순 으로 오름차순 정렬됨 
// 중복 제거, 문자는 사전순 으로 오름차순 정렬됨 
		
		numTree.add(5);
		numTree.add(2);
		numTree.add(3);
		numTree.add(1);
		numTree.add(4);
		numTree.add(5);
		numTree.add(2);
		numTree.add(3);
		numTree.add(1);
		numTree.add(4);
		System.out.println("객체 수 : " + numTree.size());
		
		for (int t : numTree) {
			System.out.println(t);
		}
	}

}
