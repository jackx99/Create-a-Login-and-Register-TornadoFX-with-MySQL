package utilities

import model.User
import java.sql.Connection
import java.sql.DriverManager

class Database {

    var connection: Connection

    init {
        Class.forName("com.mysql.cj.jdbc.Driver")
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/account", "root", "12345678")
    }

    fun insertNewUser(user: User): Int {
        val preparedStatement = connection.prepareStatement("INSERT INTO user(name, username, password) VALUES(?, ?, ?)")
        preparedStatement.setString(1, user.name)
        preparedStatement.setString(2, user.username)
        preparedStatement.setString(3, user.password)
        val rowCount = preparedStatement.executeUpdate()
        preparedStatement.close()
        return rowCount
    }

    fun selectName(username: String): String {
        val preparedStatement = connection.prepareStatement("SELECT * FROM user WHERE username = ?")
        preparedStatement.setString(1, username)
        val resultSet = preparedStatement.executeQuery()
        resultSet.next()
        val name = resultSet.getString("name") ?: ""
        preparedStatement.close()
        return name
    }


}