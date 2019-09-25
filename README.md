# Tetris
**Tetris project with database connection**
forked from [PSNB92/Tetris](https://github.com/PSNB92/Tetris)

For the database connection to work, it needs a file inside `src/bd/` named `BDSQLServer.java` to connect to the database.
This is the file template for **MSSQLServer**:
```java
package bd;

import bd.core.*;

public class BDSQLServer
{
    public static final MeuPreparedStatement COMANDO;

    static
    {
    	MeuPreparedStatement comando = null;

    	try
        {
            comando =
            new MeuPreparedStatement (
            "com.microsoft.sqlserver.jdbc.SQLServerDriver",
            "jdbc:sqlserver://SERVER:PORT;databasename=DATABASE_NAME", // replace SERVER, PORT and DATABASE_NAME
            "USERNAME", "PASSWORD"); // replace USERNAME and PASSWORD
        }
        catch (Exception e)
        {
            System.err.println ("Database connection failed: " + e);
            System.exit(0);
        }
        
        COMANDO = comando;
    }
}
```

It is also needed to change the SQL command at `src/bd/daos/Pontuacoes.java` so that it inserts into the right table.
