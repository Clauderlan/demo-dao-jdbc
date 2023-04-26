package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {
    public static void main(String[] args) {
        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

        System.out.println("Test 01 -> INSERT");
        Department department = new Department(null, "Geraldaum da Massa");
        //departmentDao.insert(department);
        System.out.println(department.getId());


        System.out.println("Test 02 -> UPDATE");
        department.setId(13);
        department.setName("Claudiorr");
        departmentDao.update(department);

    }
}
