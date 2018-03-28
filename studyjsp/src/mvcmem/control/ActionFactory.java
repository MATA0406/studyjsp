package mvcmem.control;

import mvcmem.action.Action;
import mvcmem.action.IndexAction;

public class ActionFactory { // 명령어에 해당하는 실제 액션을 생성해줄 Factory
	private static ActionFactory factory;
	
	private ActionFactory() {}
	
	public static synchronized ActionFactory getInstance() {
		if(factory == null) {
			factory = new ActionFactory();
		}
		
		return factory;
	}
	
	public Action getAction(String cmd) {
		Action action = null;
		switch(cmd) {
		case "index":
			action = new IndexAction();
			break;
		/*case "login":
			action = new LoginFormAction();
			break;
		case "loginProc":
			action = new LoginProc();
			break;
		case "logout":
			action = new LogoutAction();
			break;
		case "regForm":
			action = new regFormAction();
			break;
		case "regProc":
			action = new regProcAction();
			break;
		case "modifyForm":
			action = new modifyForm();
			break;
		case "modifyProc":
			action = new modifyProc();
			break;
		case "deleteForm":
			action = new deleteFormAction();
			break;
		case "deleteProc":
			action = new deleteProcAction();
			break;
		case "idCheck":
			action = new idCheckAction();
			break;
		case "ZipCheck":
			action = new ZipCheckAction();
			break;*/
		}
		
		return action;
	}
}
