
# 3. 表连接查询练习
## 1.查询李四学习的课程，考试分数，课程的授课老师
```sql
select student.sname,course.cname,sc.score,teacher.tname from course inner join sc on sc.cid=course.cid inner join teacher on teacher.ttd=course.tid inner join student on student.sid=sc.sid where sc.sid=1002;
```
## 2.查询王五有哪些课程没选，显示这些课程名称
```sql
select cname from course where cid not in ((select cid from sc where sid=1003));
```
## 3.查询所有同学的学号、姓名、选课数、总成绩
```sql
select student.sid,student.sname,count(sc.cid),sum(sc.score) from student inner join sc on student.sid=sc.sid group by student.sid;
```

## 4.查询所有课程成绩都小于等于60分的同学的学号、姓名；
```sql
select student.sid,student.sname,sc.score from student inner join sc on student.sid=sc.sid having sc.score<=60;
```

## 5.查询没有学全所有课的同学的学号、姓名；
```sql 
select sc.sid,student.sname from student inner join sc on student.sid = sc.sid group by sc.sid having count(*) < 7;
```
## 6.查询每门课程选修人数，格式为课程名称，人数；
```sql
select course.cname,count(*) from sc inner join course on sc.cid = course.cid group by course.cname;
```

## 7.查询出只选修了一门课程的全部学生的学号和姓名 ；
```sql
select sc.sid,student.sname from sc inner join student on sc.sid = student.sid group by sc.sid,student.sid having count(*) = 1;
```

## 8.查询每门课程的平均成绩，结果按平均成绩升序排列，平均成绩相同时，按课程号降序排列
```sql
select sc.cid,course.cname,avg(sc.score) from sc inner join course on sc.cid = course.cid group by course.cname,sc.cid order by avg(sc.score) asc,sc.cid desc;
```

## 9.查询学生平均成绩大于80的所有学生的学号、姓名和平均成绩
```sql
select sc.sid,student.sname,avg(sc.score) from sc inner join student on sc.sid = student.sid group by sc.sid,student.sname having avg(sc.score)>80;
```

## 10.查询课程相同且成绩相同的的学生的学号、课程号、学生成绩
```sql
select cid,score from sc group by cid,score having count(*) > 1;
```
## 11.查询全部学生都选修的课程的课程号和课程名
```sql
select sc.cid,course.cname from sc inner join course on sc.cid = course.cid group by sc.cid,course.cname having count(*) = 7;
```

## 12.查询两门以上不及格课程的同学的学号及其平均成绩
```sql
select sid,avg(score) from sc where score < 60 group by sid having count(sid) >= 2;
```

# 4.子查询练习
## 1.查询所有课程成绩都小于等于60分的同学的学号、姓名
```sql
select sid,sname fron student where sid not in(select sid from sc where score <= 60 );
```
## 2.查询没有学全所有课的同学的学号、姓名
```sql
select sc.sid, student.sname from sc inner join student on sc.sid = student.sid group by sc.sid,student.sname having  count(sc.sid) < (select count(*) from course);
```
## 3.查询每门课程选修人数，格式为课程名称，人数
```sql
select course.cname,count(sc.cid) from sc inner join course on sc.cid = course.cid group by sc.cid,course.cname;
```
## 4.查询全部学生都选修的课程的课程号和课程名
```sql
select sc.cid,course.cname from sc inner join course on sc.cid = course.cid group by sc.cid ,course.cname having count(sc.cid) = (select count(*) from course);
```
## 5.查询两门以上不及格课程的同学的学号及其平均成绩
```sql
select sid,avg(score) from sc where score < 60 group by sid having count(sid)>2;  
```
## 6.查询2号课程成绩比1号课程成绩低的学生的学号、姓名
```sql
select sname from student where sid in 
(select a.sid  from 
(select sid,score 1号成绩 from sc where cid = 1) a
inner join 
(select sid,score 2号成绩 from sc where cid = 2) b 
on a.sid = b.sid 
group by a.sid ,a.1号成绩,b.2号成绩 
having a.1号成绩>b.2号成绩);
```
## 7.查询学过1号课程并且也学过编号2号课程的同学的学号、姓名
```sql
select sid ,sname from student where sid in 
(select a.sid  from 
(select sid,score 1号成绩 from sc where cid = 1) a
inner join 
(select sid,score 2号成绩 from sc where cid = 2) b 
on a.sid = b.sid 
);
```
## 8.查询没学过“叶平”老师课的同学的学号、姓名
```sql
select sid,sname from student 
where sid not in
(select sid from sc where cid not in
(select cid from course where tid in
(select ttd from teacher where tname like '叶平')) 
group by sid);



```