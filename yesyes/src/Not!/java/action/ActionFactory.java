package action;

public class ActionFactory {
	private static ActionFactory instance = new ActionFactory();

	private ActionFactory() {

	}

	public static ActionFactory getInstance() {
		return instance;
	}

	public Action getAction(String command) {
		Action action = null;
		System.out.println("ActionFactory가 받은 command :: " + command); // 디버깅용

		// command에 따라 적절한 Action 객체를 생성하여 반환.
		if (command.equals("/register.do")) {
			// /register.do 요청이 오면 RegisterAction을 만듬.
			action = new RegisterAction();
			 // /login.do 요청이 오면 LoginAction을 만듬.
		} else if (command.equals("/login.do")) {
			action = new LoginAction();
		}else if (command.equals("/son.do")) { 
			action = new SonAction();
		}
	
		return action;
	}
}