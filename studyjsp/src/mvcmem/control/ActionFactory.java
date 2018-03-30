package mvcmem.control;

import mvcmem.action.Action;
import mvcmem.action.DeleteFormAction;
import mvcmem.action.DeleteProcAction;
import mvcmem.action.IdCheckAction;
import mvcmem.action.IndexAction;
import mvcmem.action.LoginFormAction;
import mvcmem.action.LoginProcAction;
import mvcmem.action.LogoutAction;
import mvcmem.action.ModifyFormAction;
import mvcmem.action.ModifyProcAction;
import mvcmem.action.RegFormAction;
import mvcmem.action.RegProcAction;
import mvcmem.action.ZipCheckAction;

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
		case "login":
			action = new LoginFormAction();
			break;
		case "loginProc":
			action = new LoginProcAction();
			break;
		case "logout":
			action = new LogoutAction();
			break;
		case "regForm":
			action = new RegFormAction();
			break;
		case "regProc":
			action = new RegProcAction();
			break;
		case "modifyForm":
			action = new ModifyFormAction();
			break;
		case "modifyProc":
			action = new ModifyProcAction();
			break;
		case "deleteForm":
			action = new DeleteFormAction();
			break;
		case "deleteProc":
			action = new DeleteProcAction();
			break;
		case "idCheck":
			action = new IdCheckAction();
			break;
		case "zipCheck":
			action = new ZipCheckAction();
			break;
		}
		
		return action;
	}
}
