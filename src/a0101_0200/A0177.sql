CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  RETURN (
      # Write your MySQL query statement below.
      select distinct Salary from Employee as a where (select count(distinct Salary) from Employee where Salary > a.Salary) = N - 1
  );
END