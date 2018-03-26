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




create table memberr(
    num number not null primary key,
    name varchar2(15) not null,
    tel varchar2(20) not null,
    subject varchar2(20),
    constraint mem_FK foreign key(subject) REFERENCES class(subjectname)
);

create table class(
    cnum number not null primary key,
    subjectname varchar2(15) unique,
    teacher varchar2(15) not null,
    count number not null
);

insert into memberr(num,name,tel,subject)
   values('1','정진호','01057220406','수영');

select * from memberr;

update memberr set tel='01011111111' where num=1;

delete from memberr where num=1;

commit;












