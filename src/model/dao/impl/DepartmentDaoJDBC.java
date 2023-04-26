package model.dao.impl;

import db.DB;
import db.DbException;
import model.dao.DepartmentDao;
import model.entities.Department;

import java.sql.*;
import java.util.List;

public class DepartmentDaoJDBC implements DepartmentDao {

    private Connection connection;
    public DepartmentDaoJDBC(Connection connection){
        this.connection = connection;
    }
    @Override
    public void insert(Department obj) {

        PreparedStatement preparedStatement = null;
        try{
            preparedStatement = connection.prepareStatement(
                    "INSERT INTO department "
                    + "(Name) "
                    + "VALUES (?)", Statement.RETURN_GENERATED_KEYS
            );

            preparedStatement.setString(1,obj.getName());
            int rowsAffected = preparedStatement.executeUpdate();
            if(rowsAffected > 0){
                ResultSet resultSet = preparedStatement.getGeneratedKeys();
                if(resultSet.next()) obj.setId(resultSet.getInt(1));
                resultSet.close();
            }else{
                throw new SQLException("Insert error : No rows affected.");
            }


        }catch (SQLException e){
            throw new DbException(e.getMessage());
        }finally {
            DB.closeStatement(preparedStatement);
        }

    }

    @Override
    public void update(Department obj) {

        PreparedStatement preparedStatement = null;
        try{
            preparedStatement = connection.prepareStatement(
                    "UPDATE department "
                    + "SET Name = ? "
                    + "WHERE Id = ?"
            );
            preparedStatement.setString(1, obj.getName());
            preparedStatement.setInt(2, obj.getId());

            preparedStatement.executeUpdate();

        }catch (SQLException e){
            throw new DbException(e.getMessage());
        }
        finally {
            DB.closeStatement(preparedStatement);
        }
    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public Department findById(Integer id) {
        return null;
    }

    @Override
    public List<Department> findAll() {
        return null;
    }
}