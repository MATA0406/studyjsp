var xhrObject; 

function createXHR(){ //XMLHttpRequest객체를 생성하는 메소드
  if(window.ActiveXObject)  
	xhrObject = new ActiveXObject("Microsoft.XMLHTTP"); 
  else if(window.XMLHttpRequest) 
    xhrObject = new XMLHttpRequest(); 
}

function startMethod(){//클라이언트로부터 이벤트가 발생시 실행되는 메소드
  createXHR(); //createXHR()메소드 호출
  xhrObject.onreadystatechange = resultProcess; //응답결과 처리메소드
  xhrObject.open("Get", "xhrTest3.txt", "true");//서버의 요청설정 
  xhrObject.send(null);//서버로 요청을 보냄
}

function processJSON(){ //JSON파일을 처리하는 메소드
  var str = "<table border='1'>";

  //서버의 응답을 텍스트파일로 받아서 result 변수에 저장  
  var result = xhrObject.responseText; 
  //eval()함수와 "(",")"을 결합해서 result를 객체구조를 생성
  var objResult = eval( '(' + result + ')'); 
	
  //members의 value 수를 얻어낸다.
  var num = objResult.members.length; 
  for(var i=0; i< num ; i++){ //value의 수만큼 반복 - 한행 처리
	str += "<tr>";
	//JSON파일에서 members의 i번째에 해당하는 memberNumber 값을 얻어냄  
	str += "<td>" + objResult.members[i].memberNumber + "</td>";
	//JSON파일에서 members의 i번째에 해당하는 irum 값을 얻어냄
	str += "<td>" + objResult.members[i].irum + "</td>"; 
	//JSON파일에서 members의 i번째에 해당하는 picture의 값을 얻어냄
	str += "<td><img src='" + objResult.members[i].picture; 
	str += "' width='50' height='60'/></td></tr>";
  }
  str += "</table>"; 
  //id속성의 값이 "resultArea"인 엘리먼트의 내용으로 표시
  document.getElementById("resultArea").innerHTML = str; 
}

function resultProcess(){//응답결과가 오면 자동으로 실행
  if(xhrObject.readyState == 4) 
	if(xhrObject.status == 200) 
		processJSON();  //JSON파일을 처리하는 메소드 호
}
