<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="ch12.board.BoardDBBean"%>
<%@ page import="java.sql.Timestamp" %>
<%
    request.setCharacterEncoding("utf-8");
%>
<%-- 글쓰기 폼에 입력한 값을갖고 BoardDataBean 클랙스 객체 article을 생성 --%>
<jsp:useBean id="article" scope="page" class="ch12.board.BoardDataBean">
    <jsp:setProperty name="article" property="*" />
</jsp:useBean>
<%
    String id ="";
    try{
        id = (String)session.getAttribute("id"); //세션에서 얻어낸 사용자의 아이디
    }catch(Exception e){}
    
    //폼으로부터 넘어오지 않는 값을 데이터 저장빈 article 에 직접 저장
    article.setWriter(id);
    article.setReg_date(new Timestamp(System.currentTimeMillis()));
    article.setIp(request.getRemoteAddr());
    //DB 처리하기
    BoardDBBean dbPro = BoardDBBean.getInstance();
    //DB 처리빈의 getInsertArticle로 레코드에 추가
    int check = dbPro.insertArticle(article);
    //호출한 write.js 로 처리값 반환
    System.out.println(check+": check의 값");
    out.println(check);
%>