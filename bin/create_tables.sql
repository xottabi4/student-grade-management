CREATE TABLE `faculty` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Title` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `grade` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Title` varchar(255) NOT NULL,
  `Grade` int(11) NOT NULL,
  `Description` varchar(255) NOT NULL,
  `Date` varchar(255) NOT NULL,
  `Student_ID` int(11) DEFAULT NULL,
  `Task_ID` int(11) DEFAULT NULL,
  `Group_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `Student_ID` (`Student_ID`),
  KEY `Task_ID` (`Task_ID`),
  KEY `Group_ID` (`Group_ID`),
  CONSTRAINT `grade_ibfk_1` FOREIGN KEY (`Student_ID`) REFERENCES `student` (`ID`),
  CONSTRAINT `grade_ibfk_2` FOREIGN KEY (`Task_ID`) REFERENCES `task` (`ID`),
  CONSTRAINT `grade_ibfk_3` FOREIGN KEY (`Group_ID`) REFERENCES `student_group` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `professor` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(255) NOT NULL,
  `Surname` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `student` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(255) NOT NULL,
  `Surname` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `student_group` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Title` varchar(255) NOT NULL,
  `Course` int(11) NOT NULL,
  `Professor_ID` int(11) DEFAULT NULL,
  `Subject_ID` int(11) DEFAULT NULL,
  `Faculty_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `Professor_ID` (`Professor_ID`),
  KEY `Subject_ID` (`Subject_ID`),
  KEY `Faculty_ID` (`Faculty_ID`),
  CONSTRAINT `student_group_ibfk_1` FOREIGN KEY (`Professor_ID`) REFERENCES `professor` (`ID`),
  CONSTRAINT `student_group_ibfk_2` FOREIGN KEY (`Subject_ID`) REFERENCES `university_subject` (`ID`),
  CONSTRAINT `student_group_ibfk_3` FOREIGN KEY (`Faculty_ID`) REFERENCES `faculty` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `task` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Title` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `university_subject` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Title` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
