# Write your MySQL query statement below

select id, (select student from seat where case when p.id % 2 = 1 and (select count(*) from seat) = p.id then id = p.id when p.id % 2 = 1 and (select count(*) from seat) != p.id then id = p.id + 1  else id = p.id - 1 end) as student from seat as p;