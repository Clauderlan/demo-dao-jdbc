package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;
import java.util.Date;

public class Program {

    public static void main(String[] args) {

        Department department = new Department(1, "TestMan");
        Seller seller = new Seller(1, "TestMan", "Testman@gmail.com", new Date(), 3000.0, department);
        System.out.println(department);
        System.out.println();
        System.out.println(seller);

        SellerDao sellerDao = DaoFactory.createSellerDao();

    }

}
