import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private static final String URL = "jdbc:sqlite:clinica.db";

    public static Connection getConnection() {
        Connection cn = null;
        try {
            cn = DriverManager.getConnection(URL);
            System.out.println("✅ Conectado correctamente a SQLite (clinica.db)");
        } catch (SQLException e) {
            System.out.println("❌ Error de conexión: " + e.getMessage());
        }
        return cn;
    }

    public static void crearTablas() {
        String sqlPacientes = "CREATE TABLE IF NOT EXISTS pacientes (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "nombre TEXT NOT NULL, " +
                "documento TEXT NOT NULL, " +
                "telefono TEXT)";
        String sqlMedicos = "CREATE TABLE IF NOT EXISTS medicos (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "nombre TEXT NOT NULL, " +
                "especialidad TEXT)";
        String sqlCitas = "CREATE TABLE IF NOT EXISTS citas (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "paciente_id INTEGER, " +
                "medico_id INTEGER, " +
                "fecha TEXT, " +
                "hora TEXT, " +
                "estado TEXT DEFAULT 'ACTIVA', " +
                "FOREIGN KEY (paciente_id) REFERENCES pacientes(id), " +
                "FOREIGN KEY (medico_id) REFERENCES medicos(id), " +
                "UNIQUE (medico_id, fecha, hora))";

        try (Connection cn = getConnection();
             java.sql.Statement st = cn.createStatement()) {
            st.execute(sqlPacientes);
            st.execute(sqlMedicos);
            st.execute(sqlCitas);
            System.out.println("✅ Tablas verificadas o creadas correctamente.");
        } catch (SQLException e) {
            System.out.println("❌ Error al crear tablas: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        crearTablas();
    }
}
