package application;
import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.dao.impl.SellerDaoJDBC;
import model.entities.Department;
import model.entities.Seller;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SellerDao sellerDao = DaoFactory.createSellerDao();
        Scanner sc = new Scanner(System.in);

        System.out.println("=== TEST 1: seller findById ===");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);

        System.out.println("\n=== TEST 2: seller findByDepartment ===");
        Department department = new Department(2, null);
        List<Seller> list = sellerDao.findByDepartment(department);
        System.out.println(list);

        System.out.println("\n=== TEST 3: seller findAll ===");
        list = sellerDao.findAll();
        System.out.println(list);

        System.out.println("\n=== TEST 4: seller insert ===");
        Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, department);
        sellerDao.insert(newSeller);
        System.out.println("Inserted! New id = " + newSeller.getId());

        System.out.println("\n=== TEST 5: seller update ===");
        seller = sellerDao.findById(1);
        seller.setName("Mary Jane");
        sellerDao.update(seller);
        System.out.println("Update completed!");

        System.out.println("\n=== TEST 6: seller delete ===");
        System.out.print("Enter id for delete test: ");
        int id = sc.nextInt();
        sellerDao.deleteById(id);
        System.out.println("Delete completed!");
        sc.close();
    }
}