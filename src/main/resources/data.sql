INSERT INTO Project(id, name, created_date) VALUES (1, 'Project 1', '2019-06-13');
INSERT INTO Project(id, name, created_date) VALUES (2, 'Project 2', '2019-06-14');
INSERT INTO Project(id, name, created_date) VALUES (3, 'Project 3', '2019-06-15');

INSERT INTO Task(id, name, date_created, due_date, description, project_id) VALUES (101, 'Task 1', '2019-06-13', '2019-07-13', 'Task 1 Description', 1);
INSERT INTO Task(id, name, date_created, due_date, description, project_id) VALUES (102, 'Task 2', '2019-06-13', '2019-06-15', 'Task 2 Description', 1);
INSERT INTO Task(id, name, date_created, due_date, description, project_id) VALUES (103, 'Task 3', '2019-06-13', '2019-07-13', 'Task 3 Description', 1);
INSERT INTO Task(id, name, date_created, due_date, description, project_id) VALUES (104, 'Task 4', '2019-06-13', '2019-06-25', 'Task 4 Description', 2);