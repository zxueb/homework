# 2.单表查询练习
## 1.查询姓“李”的老师的个数
```sql
select tname from teacher where tname like'李%';
```
## 2.查询男女生人数个数
```sql
select SEX ,count(SEX) from student group by SEX;
```
## 3.查询同名同姓学生名单，并统计同名人数
```sql
select sname,count(sname) from student group by sname;
```
## 4.1981年出生的学生名单
```sql
select * from student where year(birthday) like '1981'; 
```
## 5.查询平均成绩大于60分的同学的学号和平均成绩
```sql
select sid ,avg(score) from sc group by sid having avg(score)>60;
```
## 6.求选了课程的学生人数
```sql
select count(cid) from sc;
```
## 7.查询至少选修两门课程的学生学号
```sql
select sid,count(cid) from sc group by sid having count(cid)>1;
```
## 8.查询各科成绩最高和最低的分。以如下形式显示：课程ID，最高分，最低分
```sql
select cid ,max(score),min(score) from sc group by cid;
```
## 9.统计每门课程的学生选修人数。要求输出课程号和选修人数，查询结果按人数降序排列，若人数相同，按课程号升序排列
```sql
select cid,count(sid) from sc group by cid order by count(sid) desc,cid asc;
```
# 以下练习针对部门员工表，请导入scott.sql的数据
## 1.打印入职时间超过38年的员工信息
```sql
select year(hiredate) from emp where 2018-year(hiredate)>38;
```
## 2.把hiredate列看做是员工的生日,求本月过生日的员工
```sql
select ename ,hiredate from emp where month(hiredate)= month(now());
```
## 3.把hiredate列看做是员工的生日,求下月过生日的员工
```sql
select ename ,hiredate from emp where month(hiredate)= month(date_add(now(),interval 1 month));
```
## 4.求1980年下半年入职的员工
```sql
    select ename,hiredate from emp where year(hiredate)=1980 having month(hiredate)>=6 and month(hiredate)<=12;
```
## 5.请用两种的方式查询所有名字长度为4的员工的员工编号,姓名
```sql
select empno,ename from emp where length(ename)=4;
select empno,ename from emp having length(ename)=4;
```
## 6.显示各种职位的最低工资
```sql
select job,min(sal) from emp group by job;
```
## 7.求1980年各个月入职的的员工个数
```sql
select count(hiredate),month(hiredate) from emp where year(hiredate)=1981 group by month(hiredate);
```
## 8.查询每个部门的最高工资
```sql
select deptno,max(sal) from emp group by deptno;
```

## 9.查询每个部门,每种职位的最高工资
```sql
select deptno,job,max(sal) from emp group by deptno,job;
```
## 10.查询各部门的总工资和平均工资
```sql
select deptno, sum(sal), avg(sal) from emp group by deptno;
```
## 11.查询10号部门,20号部门的平均工资（尝试用多种写法）
```sql
select deptno,avg(sal) from emp group by deptno having deptno=10 or deptno=20;

select deptno,avg(sal) from emp where deptno=10 or deptno=20 group by deptno;
```
## 12.查询平均工资高于2000元的部门编号和平均工资
```sql
select deptno,avg(sal) from emp group by deptno having avg(sal>2000);
```
## 13.统计公司里经理的人数
```sql
select job,count(*) from emp group by job having job='manager';
```
## 14.查询工资最高的3名员工信息
```sql
select * from emp order by sal desc limit 3;
```
## 15.查询工资由高到低第6到第10的员工信息
```sql
select * from emp order by sal desc limit 5,5;
```
# 3. 表连接查询练习
## 1.查询李四学习的课程，考试分数，课程的授课老师
```sql
select student.sname,course.cname,sc.score,teacher.tname from course inner join sc on sc.cid=course.cid inner join teacher on teacher.ttd=course.tid inner join student on student.sid=sc.sid where sc.sid=1002;
```
## 2.查询王五有哪些课程没选，显示这些课程名称
```sql
select sc.sid,course.cid from sc inner join course on sc.cid=course.cid group by cid,sid having sc.sid=1003;
select * from course where cid<>1 and cid!=2;
```

## 3.查询所有同学的学号、姓名、选课数、总成绩
```sql
select student.sid,student.sname,count(sc.cid),sum(sc.score) from student inner join sc on student.sid=sc.sid group by student.sid;
```

## 4.查询所有课程成绩都小于等于60分的同学的学号、姓名；
```sql
select student.sid,student.sname,sc.score from student inner join sc on student.sid=sc.sid having sc.score<=60;
```

查询没有学全所有课的同学的学号、姓名；

查询每门课程选修人数，格式为课程名称，人数；

查询出只选修了一门课程的全部学生的学号和姓名 ；

查询每门课程的平均成绩，结果按平均成绩升序排列，平均成绩相同时，按课程号降序排列

查询学生平均成绩大于80的所有学生的学号、姓名和平均成绩

查询课程相同且成绩相同的的学生的学号、课程号、学生成绩

查询全部学生都选修的课程的课程号和课程名

查询两门以上不及格课程的同学的学号及其平均成绩