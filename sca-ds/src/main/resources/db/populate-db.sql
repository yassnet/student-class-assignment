INSERT INTO students (first_name, last_name)
VALUES
        ('Yassir', 'Aguila'),
        ('Wilfredo', 'Aguila')
        ;

INSERT INTO classes (code, title, description)
VALUES
        ('RED-514-V2-P1', 'Network Security', 'Provide to student the ability to manage networks in terms of information security.'),
        ('RED-515-V2-P1', 'Network Management', 'Provide the student with a well-founded knowledge about network management.')
        ;

INSERT INTO students_classes (student_id, class_code)
VALUES
        (1, 'RED-514-V2-P1'),
        (2, 'RED-514-V2-P1')
        ;