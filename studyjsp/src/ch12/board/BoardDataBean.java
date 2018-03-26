package ch12.board;

import java.sql.Timestamp;

public class BoardDataBean {
	private int num; //�� ��ȣ
    private String writer ; // �ۼ���
    private String subject; // ����
    private String content; // �� ����
    private String passwd; // �� ��й�ȣ 
    private Timestamp reg_date;
    private int readcount;  //��ȸ��
    private String ip; // ip�ּ�
    private int ref; // ���� �׷� ��ȣ
    private int re_step ; // ����۰� �亯���� ����
    private int re_level; // �� ������ �鿩���� ����
	
    public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public Timestamp getReg_date() {
		return reg_date;
	}
	public void setReg_date(Timestamp reg_date) {
		this.reg_date = reg_date;
	}
	public int getReadcount() {
		return readcount;
	}
	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public int getRef() {
		return ref;
	}
	public void setRef(int ref) {
		this.ref = ref;
	}
	public int getRe_step() {
		return re_step;
	}
	public void setRe_step(int ref_step) {
		this.re_step = ref_step;
	}
	public int getRe_level() {
		return re_level;
	}
	public void setRe_level(int re_level) {
		this.re_level = re_level;
	}
}
