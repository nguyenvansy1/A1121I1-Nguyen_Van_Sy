use ss1_qlsv;

delete from teacher where id=1;
ALTER TABLE teacher ADD PRIMARY KEY(id);

select * from teacher;