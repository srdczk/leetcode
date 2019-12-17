# Write your MySQL query statement below

select Score, (select count(distinct Score) from Scores where p.Score <= Score) as Rank from Scores as p order by Score desc;