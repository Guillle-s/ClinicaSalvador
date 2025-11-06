import java.sql.*;
import javax.swing.*;

public class CitaAppSingle {

    private static final String DB_URL = "jdbc:sqlite:clinica.db";

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        return DriverManager.getConnection(DB_URL);
    }

    private static void crearTablasSiNoExisten() {
        String sql = "CREATE TABLE IF NOT EXISTS citas ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "paciente TEXT NOT NULL, "
                + "fecha TEXT NOT NULL, "
                + "hora TEXT NOT NULL, "
                + "motivo TEXT)";
        try (Connection cn = getConnection(); Statement st = cn.createStatement()) {
            st.execute(sql);
            System.out.println("Tablas creadas/verificadas correctamente en clinica.db");
        } catch (Exception e) {
            System.err.println("Error creando tablas: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void registrarCitaDialog() {
        try {
            String paciente = JOptionPane.showInputDialog("Nombre del paciente:");
            if (paciente == null) return;
            String fecha = JOptionPane.showInputDialog("Fecha (YYYY-MM-DD):");
            if (fecha == null) return;
            String hora = JOptionPane.showInputDialog("Hora (HH:MM):");
            if (hora == null) return;
            String motivo = JOptionPane.showInputDialog("Motivo (opcional):");
            if (motivo == null) motivo = "";

            String sql = "INSERT INTO citas (paciente, fecha, hora, motivo) VALUES (?, ?, ?, ?)";
            try (Connection cn = getConnection(); PreparedStatement ps = cn.prepareStatement(sql)) {
                ps.setString(1, paciente.trim());
                ps.setString(2, fecha.trim());
                ps.setString(3, hora.trim());
                ps.setString(4, motivo.trim());
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Cita registrada correctamente.");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "SQL Error al registrar: " + ex.getMessage());
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Driver SQLite no encontrado: " + ex.getMessage());
            ex.printStackTrace();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    private static void listarCitasDialog() {
        String sql = "SELECT id, paciente, fecha, hora, motivo FROM citas ORDER BY id";
        StringBuilder sb = new StringBuilder();
        try (Connection cn = getConnection(); Statement st = cn.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                sb.append("ID: ").append(rs.getInt("id"))
                  .append(" | Paciente: ").append(rs.getString("paciente"))
                  .append(" | Fecha: ").append(rs.getString("fecha"))
                  .append(" | Hora: ").append(rs.getString("hora"))
                  .append(" | Motivo: ").append(rs.getString("motivo"))
                  .append("\n");
            }
            String out = sb.length() == 0 ? "No hay citas registradas." : sb.toString();
            JTextArea ta = new JTextArea(out);
            ta.setEditable(false);
            JOptionPane.showMessageDialog(null, new JScrollPane(ta), "Listado de citas", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "SQL Error al listar: " + ex.getMessage());
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Driver SQLite no encontrado: " + ex.getMessage());
            ex.printStackTrace();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        crearTablasSiNoExisten();
        while (true) {
            String opcion = JOptionPane.showInputDialog(
                "CLÍNICA SALVADOR (SQLite)\n1 - Registrar cita\n2 - Listar citas\n3 - Salir\nElija opción:"
            );
            if (opcion == null) break;
            opcion = opcion.trim();
            if (opcion.equals("1")) registrarCitaDialog();
            else if (opcion.equals("2")) listarCitasDialog();
            else if (opcion.equals("3")) { JOptionPane.showMessageDialog(null, "Saliendo..."); break; }
            else JOptionPane.showMessageDialog(null, "Opción inválida.");
        }
        System.exit(0);
    }
}
