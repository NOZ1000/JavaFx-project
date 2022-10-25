package com.solanacrm;

import java.sql.*;

public class DatabaseHandler extends Configs{
    Connection dbConnection;
    public Connection getDbConnection() throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName;
        Class.forName("com.mysql.jdbc.Driver");
        dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);
        return dbConnection;
    }

    public void SUUser(String firstName, String lastName, String login, String pass) throws SQLException, ClassNotFoundException {
        String insert = "INSERT INTO " + UserConst.USER_TABLE + " ( " + UserConst.USERS_FIRSTNAME + ", " + UserConst.USERS_LASTNAME + ", " + UserConst.USERS_LOGIN + ", " +
                UserConst.USERS_PASSWORD + " ) " + "VALUES(?,?,?,?)";
        PreparedStatement prSt = getDbConnection().prepareStatement(insert);
        prSt.setString(1, firstName);
        prSt.setString(2, lastName);
        prSt.setString(3, login);
        prSt.setString(4, pass);

        prSt.executeUpdate();
    }

    public void SUTeacher(String firstName, String lastName, String login, String pass) throws SQLException, ClassNotFoundException {
        String insert = "INSERT INTO " + TeacherConst.TABLE + " ( " + TeacherConst.FIRSTNAME + ", " + TeacherConst.LASTNAME + ", " + TeacherConst.LOGIN + ", " +
                TeacherConst.PASSWORD + " ) " + "VALUES(?,?,?,?)";
        PreparedStatement prSt = getDbConnection().prepareStatement(insert);
        prSt.setString(1, firstName);
        prSt.setString(2, lastName);
        prSt.setString(3, login);
        prSt.setString(4, pass);

        prSt.executeUpdate();
    }

    public ResultSet SIUser(String login, String pass) throws SQLException, ClassNotFoundException {

        ResultSet resSet = null;
        String select = "SELECT * FROM " + UserConst.USER_TABLE + " WHERE " + UserConst.USERS_LOGIN + "=? AND " + UserConst.USERS_PASSWORD + "=?";
        PreparedStatement prSt = getDbConnection().prepareStatement(select);
        prSt.setString(1, login);
        prSt.setString(2, pass);

        resSet = prSt.executeQuery();


        return resSet;
    }

    public ResultSet SITeacher(String login, String pass) throws SQLException, ClassNotFoundException {

        ResultSet resSet = null;
        String select = "SELECT * FROM " + TeacherConst.TABLE + " WHERE " + TeacherConst.LOGIN + "=? AND " + TeacherConst.PASSWORD + "=?";
        PreparedStatement prSt = getDbConnection().prepareStatement(select);
        prSt.setString(1, login);
        prSt.setString(2, pass);

        resSet = prSt.executeQuery();


        return resSet;
    }
}
