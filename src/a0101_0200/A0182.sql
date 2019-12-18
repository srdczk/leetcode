# Write your MySQL query statement below

select distinct Email from Person as p where (select count(*) from Person where p.Email = Email) > 1;