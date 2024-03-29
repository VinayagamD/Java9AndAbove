CREATE SCHEMA  SchoolManagements;
USE SchoolManagements;

CREATE TABLE attendances(
  id INTEGER AUTO_INCREMENT NOT NULL ,
  attendance_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  teacher_name VARCHAR(100) NOT NULL ,
  student_name VARCHAR(100) NOT NULL ,
  present BOOLEAN DEFAULT FALSE,
  subject VARCHAR(75) NOT NULL ,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  CONSTRAINT  attendance_pk PRIMARY KEY (id)
);
