package utils;

import java.io.PrintWriter;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.jsp.JspWriter;

public class JSFunction {
	// static 메서드이기 때문에 서언하지 않아도 사용할 수 있다
	public static void alertLocation(String msg, String url, JspWriter out) {
		try {
			String script = "" + "<script>" + "alert('" + msg + "');" // 메시지창에 msg 출력하는 기능
					+ "location.href='" + url + "'" // a태그처럼 url로 이동기능
					+ "</script>";
			// JSFunction 클래스에서 out을 사용할 수 있도록 하는 기능
			out.println(script);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void alertBack(String msg, JspWriter out) {
		try {
			String script = "" + "<script>" + "alert('" + msg + "');" // 메시지 출력
					+ "histry.back();" // 뒤로가기 실행
					+ "</script>";
			out.println(script);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void alertLocation(HttpServletResponse resp, String msg, String url) {
		try {
			String script = "" + "<script>" + "alert('" + msg + "');" // 메시지창에 msg 출력하는 기능
					+ "location.href='" + url + "'" // a태그처럼 url로 이동기능
					+ "</script>";
			// JSFunction 클래스에서 out을 사용할 수 있도록 하는 기능
			resp.setContentType("text/html;charset=UTF-8");
			PrintWriter out=resp.getWriter();
			out.println(script);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void alertBack(HttpServletResponse resp, String msg) {
		try {
			String script = "" + "<script>" + "alert('" + msg + "');" // 메시지 출력
					+ "histry.back();" // 뒤로가기 실행
					+ "</script>";
			resp.setContentType("text/html;charset=UTF-8");
			PrintWriter out=resp.getWriter();
			out.println(script);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}