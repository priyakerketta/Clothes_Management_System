package com.cloth_management.Repository;

import com.cloth_management.Models.Category;
import com.cloth_management.Models.Employee;
import com.cloth_management.Models.EmployeePhoneNo;
import com.cloth_management.Models.UserPhoneNo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public int AddEmployee(Employee employee) {
        return jdbcTemplate.update("INSERT INTO employees (emp_fname,emp_lname,emp_email,emp_gender,emp_join_date)"+
                " VALUES (?,?,?,?,?)",new Object[] {employee.getEmp_fname(),employee.getEmp_lname(),
                employee.getEmp_email(),employee.getEmp_gender(),employee.getEmp_join_date()});
    }

    @Override
    public int DeleteEmployee(int emp_id) {
        return jdbcTemplate.update("DELETE FROM employees where emp_id=?",emp_id);
    }

    @Override
    public int UpdateEmployee(Employee employee, int emp_id) {
        return jdbcTemplate.update("UPDATE employees SET emp_fname=?,emp_lname=?,emp_email=?,"+
                "emp_gender=?,emp_join_date=?  WHERE emp_id=?", new Object[]{employee.getEmp_fname(),
                employee.getEmp_lname(),employee.getEmp_email(),employee.getEmp_gender(),employee.getEmp_join_date(),emp_id});
    }

    @Override
    public List<Employee> ListEmployees() {
        return jdbcTemplate.query("SELECT * FROM employees",new BeanPropertyRowMapper<Employee>(Employee.class));
    }

    @Override
    public Employee GetEmployee(int emp_id) {
        return jdbcTemplate.queryForObject("SELECT * FROM employees where emp_id=?",
                new BeanPropertyRowMapper<Employee>(Employee.class),emp_id);
    }

    @Override
    public List<EmployeePhoneNo> getPhones(int emp_id) {

        return jdbcTemplate.query("SELECT * FROM employees_phone_no WHERE emp_id = ?", new RowMapper<EmployeePhoneNo>() {
            @Override
            public EmployeePhoneNo mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new EmployeePhoneNo(rs.getString("emp_phoneno"), rs.getInt("emp_id"));
            }
        },emp_id);
    }

    @Override
    public Boolean addPhone(int emp_id, String emp_phoneno) {

        jdbcTemplate.update("INSERT INTO emp_phone_no(emp_phoneno,emp_id) VALUES (?,?)", emp_phoneno, emp_id);
        return true;
    }
}
