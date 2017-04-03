CREATE TABLE students (
  id            INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
  first_name    VARCHAR(30),
  last_name     VARCHAR(50),
  PRIMARY KEY (id)
);

CREATE TABLE classes (
  code          VARCHAR(15) NOT NULL,
  title         VARCHAR(30),
  description   VARCHAR(250),
  PRIMARY KEY (code)
);

CREATE TABLE students_classes (
  student_id    INTEGER,
  class_code    VARCHAR(15),
  PRIMARY KEY (student_id, class_code),
  CONSTRAINT student_fk  FOREIGN KEY (student_id) REFERENCES students (id) ON DELETE CASCADE,
  CONSTRAINT classes_fk  FOREIGN KEY (class_code) REFERENCES classes (code) ON DELETE CASCADE
);