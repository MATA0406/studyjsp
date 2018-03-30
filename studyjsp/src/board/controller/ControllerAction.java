package board.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.action.CommandAction;


public class ControllerAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private Map<String, Object> commandMap = new HashMap<String, Object>(); // 명령어, 명령어 처리 클래스 저장
	
	// 명령어와 처리클래스가 매핑되어 있는 properties 파일을 읽어서 Map 객체인 commandMap에 저장
	// 명령어와 처리클래스가 매핑되어 있는 properties 파일은 Command.properties파일
	public void init(ServletConfig config)throws ServletException{
		// web.xml에서 propertyConfig에 해당하는 init-param의 값을 읽어옴
		String props = config.getInitParameter("propertyConfig");  // CommandPro.properties
		// 명령어와 처리클래스의 매핑정보를 저장할 Properties 객체 생성
		Properties pr = new Properties();
		FileInputStream f = null;
		String path = config.getServletContext().getRealPath("/WEB-INF"); // C:...... WEB-INF 까지
		try {
			// Command.properties 파일의 내용을 읽어옴
			f = new FileInputStream(new File(path, props));
			// Command.properties 파일의 정보를 Properties객체에 저장
			pr.load(f);
		}catch(IOException e) {
			throw new ServletException(e);
		}finally {
			if( f != null)try {f.close();} catch(IOException e) {}
		}
		
		// Iterator 객체는 Enummeration 객체를 확장시킨 개념의 객체
		Iterator<Object> keyIter = pr.keySet().iterator();
		// 객체를 하나씩 꺼내서 그 객체명으로 Properties 객체에 저장된 객체에 접근
		while(keyIter.hasNext()) {
			String command = (String)keyIter.next(); // key를 저장
			String className = pr.getProperty(command); // key에 대한 값을 저장 즉 클래스명을 저장
			try { // 해당 문자열을 클래스로 만든다
				Class commandClass = Class.forName(className); // className에 해당하는 클래스명를 찾아서 입력
				Object commandInstance = commandClass.newInstance(); // 해당클래스 객체를 생성
				//Map객체인 commandMap에 객체 저장
				commandMap.put(command, commandInstance); // key와 그 key에 해당하는 클래스 객체를 Map에 저장(key, 클래스객체)
			}catch(ClassNotFoundException e) {
				throw new ServletException(e);
			}catch(InstantiationException e) {
				throw new ServletException(e);
			}catch(IllegalAccessException e) {
				throw new ServletException(e);
			}
		}
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestPro(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestPro(request, response);
	}
	
	// 사용자의 요청을 분석해서 해당 작업을 처리
	private void requestPro(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		String view = null;
		CommandAction com = null;
		try {
			String command = request.getRequestURI(); //myWeb에서부터 쭉
			if(command.indexOf(request.getContextPath()) == 0) { // command에서 요청 받은 Context의 위치가 0 이라면
				command = command.substring(request.getContextPath().length()); // Context의 길이만큼 자르고 다시 입력
			}
			
			com = (CommandAction)commandMap.get(command); // 키를 넣어 값을 꺼내온다 즉 ex) /board/list.do - 키 board.action.ListAction - 값
			view = com.requestPro(request, response);				
		}catch(Throwable e) {
			throw new ServletException(e);
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);
	}

}
