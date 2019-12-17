# Write your MySQL query statement below

select distinct a.Num as ConsecutiveNums from Logs as a, Logs as b, Logs as c where a.Num = b.Num and a.Num = c.Num and a.id = b.id + 1 and b.id = c.id + 1;