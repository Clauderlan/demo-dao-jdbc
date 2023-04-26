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

        System.out.println("\n++ Test 3 : seller findAll");
        sellerList = sellerDao.findAll();
        sellerList.forEach(System.out::println);

        System.out.println("\n++ Test 4 : seller insert");
        Seller newSeller = new Seller(null, "Greg","greg@hotmail.com", new Date(), 4000.0, department);
        //sellerDao.insert(newSeller);
        //System.out.println("Inserted. New Seller id -> " + newSeller.getId());

        System.out.println("\n++ Test 5 : seller update");
        newSeller.setName("Ricardao");
        sellerDao.update(newSeller);

    }

}
