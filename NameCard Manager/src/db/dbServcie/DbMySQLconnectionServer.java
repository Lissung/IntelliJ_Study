package db.dbServcie;

import java.sql.Connection;

public interface DbMySQLconnectionServer {

    public Connection getConnection() throws Exception;

}
