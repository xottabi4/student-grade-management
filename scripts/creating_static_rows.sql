-- INSERT INTO user_type (Type_name) VALUES ('student'),('professor');
	

INSERT INTO user(username,password,active,name,surname)
VALUES ('mkyong','123456', true,'a','a'),
('alex','123456', true,'a','a'),
('asd','123456', true,'a','a');

insert into user_type(user_id,Type_name)
Values ((SELECT ID from user WHERE username='mkyong'),'professor'),
((SELECT id from user WHERE username='alex'),'student'),
((SELECT ID from user WHERE username='asd'),'student');

INSERT INTO task(Title)
VALUES ('MD'),('KD'),('Eksāmens');

INSERT INTO faculty(Title)
VALUES ('IT'),('EPF'),('Tulki');

INSERT INTO university_subject(Title,Faculty_ID)
VALUES ('Matemātika',1),('Fizika',1),('tulkosana no krievu val',3),('pasaules ekonomika',2);

INSERT INTO student_group(Title,Course,Professor_ID,Subject_ID,Faculty_ID)
VALUES 
('1.grupa IT Matem 1kurss',1,1,1,1),
('2.grupa IT Matem 1kurss',1,1,1,1),
('1.grupa EPF pasaules ekonom 2kurss',2,1,4,2),
('1.grupa Tulki tulkosana no krievu val 3kurss',3,1,3,3),
('1.grupa IT Matem 1kurss',2,1,1,1);


INSERT INTO grade(Title,Grade,Description,Student_ID,Task_ID,Group_ID)
VALUES ('Title',10,'Description',2,1,1),
('Title',9,'Description',3,1,1);

INSERT INTO all_groups(ID,Student_ID,Student_group_ID)
VALUES (2,3,1);


-- UPDATE student_group
-- SET Title='1.grupa IT Matem 2kurss'
-- WHERE ID=5;



select * from faculty;
select * from student_group;
select * from university_subject;
select * from task;
select * from user;
select * from all_groups;
select * from grade;
select * from user_type;

-- delete from user where ID = 13;
-- ALTER TABLE user AUTO_INCREMENT=3;
-- DELETE FROM task;
-- 
-- ALTER TABLE grade MODIFY COLUMN Date TIMESTAMP DEFAULT CURRENT_TIMESTAMP;
-- 
-- ALTER TABLE task AUTO_INCREMENT=1;
-- ALTER TABLE grade DROP COLUMN Date;
-- ALTER TABLE grade ADD COLUMN Date TIMESTAMP 
-- DEFAULT CURRENT_TIMESTAMP; 
-- SET FOREIGN_KEY_CHECKS=0; DROP TABLE university_subject; SET FOREIGN_KEY_CHECKS=1;
-- ALTER TABLE xyz CHANGE manufacurerid manufacturerid INT;