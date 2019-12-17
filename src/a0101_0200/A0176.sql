
 select max(Salary) as SecondHighestSalary from Employee where Salary != (select distinct max(Salary) from Employee);