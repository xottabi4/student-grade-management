INSERT INTO user(username,password,active,name,surname)
VALUES ('mkyong','123456', true,'a','a'),
 ('alex','123456', true,'a','a'),
 ('asd','123456', true,'a','a');

insert into user_type(user_id,Type_name)
Values ((SELECT ID from user WHERE username='mkyong'),'professor'),
((SELECT id from user WHERE username='alex'),'student'),
((SELECT ID from user WHERE username='asd'),'student');

INSERT INTO faculty(Title)
VALUES ('IT'),('EPF'),('Tulki');

INSERT INTO task(Title)
VALUES ('MD'),('KD'),('Eksāmens');



INSERT INTO university_subject(Title,Faculty_ID)
VALUES ('Matemātika',1),('Fizika',1),('tulkosana no krievu val',3),('pasaules ekonomika',2);




INSERT INTO student_group(Title,Course,Professor_ID,Subject_ID,Faculty_ID)
VALUES 
('1.grupa IT Matem 1kurss',1,1,1,1),
('2.grupa IT Matem 1kurss',1,1,1,1),
('1.grupa EPF pasaules ekonom 2kurss',2,1,4,2),
('1.grupa Tulki tulkosana no krievu val 3kurss',3,1,3,3),
('1.grupa IT Matem 1kurss',2,1,1,1);




INSERT INTO grade(Title,Grade,Date,Description,Student_ID,Task_ID,Group_ID)
VALUES ('Title',10, 'Date','Description',2,1,1),
 ('Title',9, 'Date','Description',3,1,1);


select * from faculty;
select * from student_group;
select * from university_subject;
select * from task;
select * from user;
select * from grade;
select * from user_type;
select * from all_groups;
-- insert into all_groups(Student_ID,Student_group_ID)
-- VALUES
-- (3,2);
-- ALTER TABLE all_groups MODIFY ID INT(11) NOT NULL AUTO_INCREMENT;
-- DELETE FROM task WHERE ID >0;
-- ALTER TABLE task AUTO_INCREMENT=1;
-- delete from grade where ID=2;

-- UPDATE student_group
-- SET Title='1.grupa IT Matem 2kurss'
-- WHERE ID=5;

-- SET FOREIGN_KEY_CHECKS=0; DROP TABLE university_subject; SET FOREIGN_KEY_CHECKS=1;