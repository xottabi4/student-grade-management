-- INSERT INTO user_type (Type_name) VALUES ('student'),('professor');
	

INSERT INTO user(username,password,active,name,surname)
VALUES ('mkyong','123456', true,'a','a');
INSERT INTO user(username,password,active,name,surname)
VALUES ('alex','123456', true,'a','a');
delete from user where ID = 13;
ALTER TABLE user AUTO_INCREMENT=3;
INSERT INTO user(username,password,active,name,surname)
VALUES ('asd','123456', true,'a','a');
select * from user;
delete from user where ID>2;
insert into user_type(user_id,Type_name)
Values ((SELECT ID from user WHERE username='mkyong'),'professor');
insert into user_type(user_id,Type_name)

Values ((SELECT id from user WHERE username='alex'),'student');
select * from user_type;

insert into user_type(user_id,Type_name)
Values ((SELECT ID from user WHERE username='asd'),'student');

ALTER TABLE grade AUTO_INCREMENT=1;

INSERT INTO grade(Title,Grade,Date,Description,Student_ID,Task_ID,Group_ID)
VALUES ('Title',10, 'Date','Description',2,1,1);
INSERT INTO grade(Title,Grade,Date,Description,Student_ID,Task_ID,Group_ID)
VALUES ('Title',9, 'Date','Description',3,1,1);

delete from grade where ID=2;
delete from all_groups where ID>0;


INSERT INTO faculty(Title)
VALUES ('IT'),('EPF'),('Tulki');

ALTER TABLE all_groups AUTO_INCREMENT=1;
INSERT INTO all_groups(ID,Student_ID,Student_group_ID)
VALUES (2,3,1);

INSERT INTO university_subject(Title,Faculty_ID)
VALUES ('Matemātika',1),('Fizika',1),('tulkosana no krievu val',3),('pasaules ekonomika',2);

INSERT INTO student_group(Title,Course,Professor_ID,Subject_ID,Faculty_ID)
VALUES 
('1.grupa IT Matem 1kurss',1,1,1,1),
('2.grupa IT Matem 1kurss',1,1,1,1),
('1.grupa EPF pasaules ekonom 2kurss',2,1,4,2),
('1.grupa Tulki tulkosana no krievu val 3kurss',3,1,3,3);

INSERT INTO student_group(Title,Course,Professor_ID,Subject_ID,Faculty_ID)
VALUES 
('1.grupa IT Matem 1kurss',2,1,1,1);
UPDATE student_group
SET Title='1.grupa IT Matem 2kurss'
WHERE ID=5;

INSERT INTO task(Title)
VALUES ('MD'),('KD'),('Eksāmens');

select * from faculty;
select * from student_group;
select * from university_subject;
select * from task;
select * from user;
select * from all_groups;
select * from grade;
select * from user_type;

DELETE FROM task

WHERE ID >0;
ALTER TABLE task AUTO_INCREMENT=1;

SET FOREIGN_KEY_CHECKS=0; DROP TABLE university_subject; SET FOREIGN_KEY_CHECKS=1;
ALTER TABLE xyz CHANGE manufacurerid manufacturerid INT;