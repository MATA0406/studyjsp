create table member(
id varchar2(50) not null primary key,
passwd varchar2(16) not null,
name varchar2(10) not null,
reg_date date not null
);


select * from member;


alter table member
add(address varchar2(100) not null,
tel varchar2(20) not null);


insert into member(id, passwd, name, reg_date, address, tel)
values('wlsgh46','1234','정진호',SYSDATE,'서울시','010-1111-1111');

insert into member(id, passwd, name, reg_date, address, tel)
values('1234','1234','1234',sysdate,'서울시','010-1234-4321');

commit;
