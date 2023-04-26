package model.dao.impl;

import db.DB;
import db.DbException;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class SellerDaoJDBC implements SellerDao {

    private Connection connection;

    public SellerDaoJDBC(Connection connection) {
        this.connection = connection;
    }
    @Override
    public void insert(Seller obj) {

    }

    @Override
    public void update(Seller obj) {

    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public Seller findById(Integer id) {

        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try{
            preparedStatement = connection.prepareStatement(
                    "SELECT seller.*,department.Name as DepName "
                    + "FROM seller INNER JOIN department "
                    + "ON seller.DepartmentId = department.Id "
                    + "WHERE seller.Id = ?"
            );
            preparedStatement.setInt(1, id);

            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                System.out.println(resultSet.getString("Name"));

                Seller seller = new Seller(
                        resultSet.getInt("Id"),
                        resultSet.getString("Name"),
                        resultSet.getString("Email"),
                        resultSet.getDate("BirthDate"),
                        resultSet.getDouble("BaseSalary"),
                        new Department(resultSet.getInt("DepartmentId"), resultSet.getString("DepName"))
                );

                return seller;
            }
            return null;


        }catch (SQLException e){
            throw new DbException(e.getMessage());
        }finally {
            DB.closeStatement(preparedStatement);
            DB.closeResultSet(resultSet);
        }

    }

    @Override
    public List<Seller> findAll() {
        return null;
    }

    @Override
    public List<Seller> findByDepartment(Department department) {
        return null;
    }
}
