
select Department,Employee,salary from (
    select d.name as Department,e.name as Employee,e.salary as Salary,DENSE_RANK() OVER(PARTITION BY e.departmentId ORDER BY e.salary DESC) as rnk
     from Employee e
      left join Department d on e.departmentId=d.Id
      ) as x
 where rnk<=3;
