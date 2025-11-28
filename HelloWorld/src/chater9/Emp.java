package chater9;

import java.time.LocalDate;

public class Emp {

	
	private String ename;// 사원번호
	private String job; // 사원 이름
	private int empno;//직책
	private int mgr;// 직속상사의 사원번호
	private LocalDate hireDate;// 고용일
	private double sal;// 급여
	private double comm; // 급여외 수당
	private int deptno; // 부서 번호
	
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
		if (ename.length() > 10) {
			System.out.println("10글자 미만으로 입력하세요.");
			this.ename = " ";
			return;
		}
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
		if (job.length() > 9) {
			System.out.println("직책 은 9글자 이하로 입력하세요.");
			this.job = " ";
			return;
		}
	}
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	
	if (empno < 0 || empno > 9999) {
		System.out.println();
		this.empno = 0;
	}
		return;
	}
	public int getMgr() {
		return mgr;
	}
	public void setMgr(int mgr) {
		this.mgr = mgr;
	
	if (mgr < 0 || mgr > 9999) {
		System.out.println();
		this.mgr = 0;
	}
		return;
	}
	
	public LocalDate getHireDate() {
		return hireDate;
	}
	public void setHireDate(LocalDate hireDate) {
		this.hireDate = hireDate;
	}
	public double getSal() {
		return sal;
	}
	public void setSal(Double sal) {
		// sal를 문자열 자료형으로 변경
		String salToStr = sal.toString();
		// sal에 있는 소수점의 위치를 index에 저장
		int index = salToStr.indexOf(".");
		// sal에 소수점 뒤에있는 문자열만 잘라서 저장
		salToStr = salToStr.substring(index+1);
		if(sal<0|| sal>9999999.99|| salToStr.length()>2) {
			System.out.println("급여는 정수부7자 실수부 2자 까지만 입력 가능합니다.");
			this.sal = 0.0;
			return;
		}
		this.sal = sal;
	}
	public double getComm() {
		return comm;
	}
	public void setComm(Double comm) {
		String salToStr = comm.toString();
		int index = salToStr.indexOf(".");
		salToStr = salToStr.substring(index+1);
		if(comm<0|| comm>9999999.99|| salToStr.length()>2) {
			System.out.println("급여는 정수부7자 실수부 2자 까지만 입력 가능합니다.");
			this.comm = 0.0;
			return;
		}
		
		this.comm = comm;
	}

	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	if (deptno < 0 || deptno > 9999) {
		System.out.println();
		this.deptno = 0;
	}
		return;
	}
	
	
	
	
	










}



