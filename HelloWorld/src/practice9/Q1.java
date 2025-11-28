package practice9;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Emp{
	int empno;
	String ename;
	int deptno;
	int sal;
	int comm;
	public Emp(int empno, String ename,int deptno,int sal,int comm) {
		this.empno = empno;
		this.ename = ename;
		this.deptno = deptno;
		this.sal = sal;
		this.comm = comm;
	}
	public String getName() {
		// TODO Auto-generated method stub
		return ename;
	}
	public int getDeptno() {
		// TODO Auto-generated method stub
		return deptno;
	}
}

public class Q1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Emp> empList = new ArrayList<>();
//						  사원번호, 이름, 부서번호, 급여, 커미션
		empList.add(new Emp(7369,"SMITH",20,800,0));
		empList.add(new Emp(7499,"ALLEN",30,1600,300));
		empList.add(new Emp(7521,"WARD",30,1250,500));
		empList.add(new Emp(7654,"MARTIN",30,1250,1400));
		empList.add(new Emp(7788,"SCOTT",20,3000,0));
		// stream 실습하기
	
		// 1. 사원들의 sal 총합을 출력해보자
		int salsum = empList.stream()
				.mapToInt(emp -> emp.sal)
				.sum();
			System.out.println("급여 총합 :" + salsum );
		// 2. 사원들의 sal 평균을 출력해보자
		double avg = salsum/ empList.size();
		avg = empList.stream()
				.mapToInt(emp -> emp.sal)
				.average().getAsDouble();
			System.out.println("급여 평균 :" + avg );	
		
		// 3. 30번 부서에 있는 사람 수를 출력해보자
		
			long count = empList.stream()
			.filter(emp -> emp.getDeptno() == 30)
			.count();
			System.out.println("30번 부서 인원 :" + count);
			
	// 4. 사원들 중 가장 급여를 많이 받는 사람을 출력해보자
	int max = empList.stream()
	         .mapToInt(e -> e.sal) 
	         .max()
	         .getAsInt();
//	System.out.println("최대값 : " + max);
	empList.stream()
	.filter(emp -> emp.sal == max)
	.forEach(emp -> System.out.println("가장 많이 받는 사원 :"+emp.ename+":"+emp.sal));
	// 5. 사원들 중 가장 급여를 적게 받는 사람을 출력해보자
	int min = empList.stream()
			.mapToInt(
					e -> e.sal)
			.min()
			.getAsInt();
//	System.out.println("최소값 : " + min);
	empList.stream()
	.filter(emp -> emp.sal == min)
	.forEach(emp -> System.out.println("가장 적게 받는 사원 :"+emp.ename+":"+emp.sal));
	
	 Emp maxEmp = empList.stream()
			 .max(Comparator.comparing(emp->emp.sal))
			 .get();
	 System.out.println("가장 많이 받는 사원 :"
			 +maxEmp.ename+":"+maxEmp.sal);
	 
	 Emp minEmp = empList.stream()
			 .min(Comparator.comparing(emp->emp.sal))
			 .get();
	 System.out.println("가장 적게 받는 사원 :"
			 +minEmp.ename+":"+minEmp.sal);
	
	System.out.println("----- 이름 -----");
	// 6.사원 이름의 첫글자만 출력하고 나머지는 *로 출력해보자
	 empList.stream()
     .map(emp -> {
         String name = emp.getName();
         if (name == null || name.isEmpty()) {
             return "";
}
         return name.substring(0, 1) + "*".repeat(name.length() - 1);
})
     .forEach(System.out::println);
	 
	System.out.println("-------");
empList.stream()
.map(emp -> emp.ename.charAt(0)
+ "*".repeat(emp.ename.length()-1)+" ")
.forEach(ename -> 
	System.out.println(ename));
System.out.println("-------");
empList.stream()
.map(emp ->{
	String star ="";
	for(int i=0; i<emp.ename.length()-1;i++){
	star +="*";
}
return emp.ename.charAt(0)+star+" ";
})
.forEach(ename ->
System.out.println(ename));
// 7. sal는 한달 급여이고 사원들의 월 평균 근무일수는 21일,
//		하루 근무시간은 8시간일때 하루 급여와 시급을 출력 해보자
	 
	 System.out.println("----- 하루 급여 -----"); 
	 empList.stream()
	 .mapToDouble(
			 e->e.sal/21)
	 .forEach(System.out::println);
	 
	 System.out.println("-----시급----- ");
	 
	 empList.stream()
	 .mapToDouble(
			 e->e.sal/21/8)
	 .forEach(System.out::println);
	 
	 System.out.println("----- 30부서 월급 많이 받는 사람 -----");
//8 30번 부서에서 가장 sal를 많이 받는 사람을 출력 해보자
	 int maxsal = empList.stream()
				.filter(emp -> emp.getDeptno() == 30)
				.mapToInt(emp ->emp.sal)
				.max().getAsInt();
	 empList.stream()
     .filter(emp -> emp.deptno == 30 && emp.sal == maxsal)
     .map(emp -> emp.ename)   
     .forEach(System.out::println);
	 
//	 Emp maxemp = empList.stream()
//			 .max(Comparator.comparingInt(emp->emp.sal))
//			 .get();
//	 System.out.println("30번 부서에서 가장 많이 받는 사원: " 
////			 +maxEmp30.ename+":"+maxEmp30.sal);
	 
	 
	 
//9. sal와 comm을 더하여 2000이상 받는 사람 수를 출력해보자
long	count2 = empList.stream()
.filter(emp -> emp.sal + emp.comm >= 2000)
.count();
System.out.println(
	"급여와 보너스를 포함하여 2000이상 받는 사원의 수 :"+count2 );
	}
}
