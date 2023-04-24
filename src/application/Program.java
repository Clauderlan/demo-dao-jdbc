package application;



import db.DB;
import entities.Department;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Program {

    public static void main(String[] args) {

        Department department = new Department(1, "TestMan");
        System.out.println(department);

    }

}
