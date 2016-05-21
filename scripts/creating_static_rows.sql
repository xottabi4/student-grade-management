-- INSERT INTO user_type (Type_name) VALUES ('student'),('professor');
	

INSERT INTO user(username,password,active,name,surname)
VALUES ('mkyong','123456', true,'a','a');
INSERT INTO user(username,password,active,name,surname)
VALUES ('alex','123456', true,'a','a');
select * from user;
delete from user where ID>2;
insert into user_type(user_id,Type_name)
Values ((SELECT ID from user WHERE username='mkyong'),'professor');
insert into user_type(user_id,Type_name)
Values ((SELECT id from user WHERE username='alex'),'student');
select * from user_type;


INSERT INTO grade(Title,Grade,Date,Description,Student_ID,Task_ID,Group_ID)
VALUES ('Title',10, 'Date','Description',2,1,1);


INSERT INTO faculty(Title)
VALUES ('IT'),('EPF'),('Tulki');

select * from faculty;
select * from student_group;
select * from university_subject;
select * from user;

DELETE FROM faculty
WHERE ID >2;
ALTER TABLE faculty AUTO_INCREMENT=1