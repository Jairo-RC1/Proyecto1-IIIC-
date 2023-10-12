/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


public class generalDAO {
  private int id;

  public generalDAO(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
  
  public void insertRecord(String table, String[] columns, Object[] values) {
        DBConnectionJava db = new DBConnectionJava();
        StringBuilder sqlQuery = new StringBuilder("INSERT INTO ");
        sqlQuery.append(table).append(" (");

        for (String column : columns) {
            sqlQuery.append(column).append(", ");
        }

        sqlQuery.setLength(sqlQuery.length() - 2);
        sqlQuery.append(") VALUES (");

        for (int i = 0; i < values.length; i++) {
            sqlQuery.append("?, ");
        }

        sqlQuery.setLength(sqlQuery.length() - 2);
        sqlQuery.append(")");

        try (PreparedStatement preparedStatement = db.getConnection().prepareStatement(sqlQuery.toString())) {
            for (int i = 0; i < values.length; i++) {
                preparedStatement.setObject(i + 1, values[i]);
            }

            preparedStatement.execute();
            JOptionPane.showMessageDialog(null, "Ingresado exitosamente en: " + table);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error, no se consiguio ingresar en: " + table + ": " + e.getMessage());
        } finally {
            db.disconnect();
        }
    }

    public void queryRecords(String table, JTable resultTable) {
        DBConnectionJava db = new DBConnectionJava();
        DefaultTableModel model = new DefaultTableModel();
        resultTable.setModel(model);

        try {
            Statement st = db.getConnection().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM " + table);

            ResultSetMetaData rsmd = rs.getMetaData();
            int numColumns = rsmd.getColumnCount();

            for (int i = 1; i <= numColumns; i++) {
                model.addColumn(rsmd.getColumnName(i));
            }

            while (rs.next()) {
                Object[] row = new Object[numColumns];

                for (int i = 1; i <= numColumns; i++) {
                    row[i - 1] = rs.getObject(i);
                }

                model.addRow(row);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        } finally {
            db.disconnect();
        }
    }

    public void selectRecord(JTable recordTable, JTextField[] fields) {
        try {
            int row = recordTable.getSelectedRow();

            if (row >= 0) {
                for (int i = 0; i < fields.length; i++) {
                    fields[i].setText(recordTable.getValueAt(row, i + 1).toString());
                }

                id = Integer.parseInt(recordTable.getValueAt(row, 0).toString());
            } else {
                JOptionPane.showMessageDialog(null, "Fila no seleccionada");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en seleccionar: " + e.getMessage());
        }
    }

    public void modifyRecord(String table, String[] columns, Object[] values) {
        DBConnectionJava db = new DBConnectionJava();
        StringBuilder sqlQuery = new StringBuilder("UPDATE ");
        sqlQuery.append(table).append(" SET ");

        for (String column : columns) {
            sqlQuery.append(column).append("=?, ");
        }

        sqlQuery.setLength(sqlQuery.length() - 2); // Remove the trailing comma and space
        sqlQuery.append(" WHERE id=?");

        try {
            PreparedStatement preparedStatement = db.getConnection().prepareStatement(sqlQuery.toString());

            for (int i = 0; i < values.length; i++) {
                preparedStatement.setObject(i + 1, values[i]);
            }

            preparedStatement.setInt(values.length + 1, id);

            preparedStatement.execute();
            JOptionPane.showMessageDialog(null, "Modificacion exitosa en: " + table);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en modificar: " + table + ": " + e.getMessage());
        } finally {
            db.disconnect();
        }
    }

    public void deleteRecord(String table) {
        DBConnectionJava db = new DBConnectionJava();
        String sqlQuery = "DELETE FROM " + table + " WHERE id=?";

        try {
            PreparedStatement preparedStatement = db.getConnection().prepareStatement(sqlQuery);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            JOptionPane.showMessageDialog(null, "Eliminado exitosamente en: " + table);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en eliminar: " + table + ": " + e.getMessage());
        } finally {
            db.disconnect();
        }
    }
}
