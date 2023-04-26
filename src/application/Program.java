package application;

import db.DB;
import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.sql.Connection;
import java.util.Date;
import java.util.List;

public class Program {

    public static void main(String[] args) {

        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println("++ Test 1 : seller findById ++");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller.toString());

        System.out.println("\n++ Test 2 : seller findbydepartment");
        Department department = new Department(2, null);
        List<Seller> sellerList = sellerDao.findByDepartment(department);

        sellerList.forEach(System.out::println);
    }

}
