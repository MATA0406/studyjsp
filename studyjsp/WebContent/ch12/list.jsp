<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="ch12.board.BoardDataBean"%>
<%@ page import="java.util.List"%>
<%@ page import="ch12.board.BoardDBBean"%>

<meta name="viewport" content="width=device-width,initial-scale=1.0" />
<link rel="stylesheet" href="../css/style.css">
<script src="../js/jquery-3.3.1.min.js"></script>
<script src="list.js"></script>

<%
    request.setCharacterEncoding("utf-8");
%>

<%
System.out.println("1111111111111");
    String id = "";
    int pageSize = 3; //한 페이지의 표시할 글의 수
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    
   String pageNum = request.getParameter("pageNum"); //화면에 표시할 페이지 번호 
   System.out.println(pageNum+":받은 페이지 넘버");
   if (pageNum == null)//페이지 번호가 없으면 1페이지의 내용이 화면에 표시
        pageNum = "1";    
    System.out.println("페이지 번호가 없을 시 1 추가 완료");
    int count = 0; // 전체 글의 수
    int currentPage = Integer.parseInt(pageNum); //현재 페이지 숫자로 파싱
    
    System.out.println("현재 페이지 수(currentPage):"+currentPage);
    
    List<BoardDataBean> articleList = null; //글목록을 저장
    BoardDBBean dbPro = BoardDBBean.getInstance();
    count = dbPro.getArticleCount(); //전체 글 수 얻어냄
    System.out.println("전체 글 수:"+count);
    if (count == (currentPage - 1) * pageSize) //글삭제시 반영을위해 !
        currentPage -= 1;
    
    int startRow = (currentPage - 1) * pageSize + 1; //현재 페이지에서의 시작글 번호 .
    
    try {
        if (count > 0) {//테이블에 저장된 글이 있으면 , 테이블에서 글 목록을 가져옴
            articleList = dbPro.getArticle(startRow, pageSize);         
        	
        }
        
        if (articleList.isEmpty()){  //테이블에 저장된 글이 없으면 전체 글수 :0
            count = 0;
            
        }
        System.out.println(count);        
        System.out.println("55555555");
    } catch (Exception e) {}
%>

<div id="list_head" class="box2">
	<h3 class="inline">
		글목록(전체 글:<%=count %>)
	</h3>
	<button id="new">글쓰기</button>
</div>

<%
    if (count == 0) {//게시판에 글이 없는 경우
    	System.out.println("666666666");
%>

<div id="list_article" class="box2">
	<strong>게시판에 저장된 글 없쪙</strong>
</div>

<%
	} else { // 게시판에 글이 있는 경우
%>

<div id="list_article" class="box2">
<%
	//글목록을 반복 처리
	for (int i = 0; i < articleList.size(); i++) {
		BoardDataBean article = articleList.get(i);
%>
	<ul class="article">
		<li class="layout_f">
			<%
			String writer = article.getWriter();
			out.println(writer.substring(0,4)+"****");%>
		<li class="layout_f">
			<%
				int wid = 0;
				if(article.getRe_level()>0){
					wid=5*(article.getRe_level());
			%>
				 <img src="level.gif" width="<%=wid %>">
				 <img src="re.gif"> 
			<%
				}else{
			%>
				<img src="level.gif" width="<%=wid %>" height="16">
			<% } %> 
			<%
				int num = article.getNum();
				int ref = article.getRef();
				int re_step = article.getRe_step();
				int re_level = article.getRe_level();
			%> <%=article.getSubject() %>
			<p class="date"><%=sdf.format(article.getReg_date()) %><br>
			<pre><%=article.getContent() %></pre><br> <%
			try{
				id = (String) session.getAttribute("id");
			}catch(Exception e){}
			%> <%if(id.equals(writer)){ %>
			<button id="edit" name="<%=num+","+pageNum %>" onclick="edit(this)">수정</button>
			<button id="delete" name="<%=num+","+pageNum %>" onclick="del(this)">삭제</button>
			<%}else{ %>
			<button id="reply"
				name="<%=num+","+ref+","+re_step+","+re_level+","+pageNum %>"
				onclick="reply(this)">댓글쓰기</button> 
			<%} %>
	</ul>
<%} %>
</div>
<%} %>

<%-- 페이지 이동 처리 --%>
<div id="jump" class="box3">
<%
	if(count>0){
		int pageCount = count/pageSize + (count%pageSize==0?0:1);
		int startPage = 1;
		int pageBlock = 3;
		
		
		if(currentPage % pageBlock != 0)
			startPage = (int)(currentPage / pageBlock) * pageBlock + 1;
		else
			startPage = ((int)(currentPage/pageBlock)-1) * pageBlock + 1;
		
		int endPage = startPage + pageBlock - 1;
		
		if(endPage > pageCount) endPage = pageCount;
		
		if(startPage > pageBlock){ %>
		<button id="juP" name="<%=startPage - pageBlock %>" onclick="p(this)" class="w2">이전</button>
		&nbsp;
		<%} 
			for(int i = startPage; i <= endPage; i++){
				if(currentPage == i){ %>
					<button id="ju" name="<%=i %>" onclick="p(this)" class="w1"><%=i %></button>
			<%}else{ %>
					<button id="ju" name="<%=i %>" onclick="p(this)" class="w"><%=i %></button>
			<%} %>
			&nbsp;
		<%}
			if(endPage<pageCount){%>
			&nbsp;
			<button id="juN" name="<%=startPage + pageBlock%>" onclick="p(this)" class="w2">다음</button>
		<%
			}
	} // 108라인 if의 것
		%>
</div>
