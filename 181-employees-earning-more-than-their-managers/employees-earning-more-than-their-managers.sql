-- Write your PostgreSQL query statement below
SELECT e.name AS Employee FROM Employee e
JOIN Employee s ON e.managerId = s.id
WHERE e.salary > s.salary;