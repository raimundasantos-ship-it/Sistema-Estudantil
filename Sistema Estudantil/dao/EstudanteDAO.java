package dao;

import modelo.Estudante;
import util.Conexao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.List;

public class EstudanteDAO {

    private Connection conexao;

    public EstudanteDAO() {
       this.conexao = Conexao.getConnection();
    }

    // Cadastrar estudante
    public boolean cadastrar(Estudante estudante) {

        String sql = "INSERT INTO estudante (matricula, nome_completo, data_nascimento) VALUES (?, ?, ?)";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, estudante.getMatricula());
            stmt.setString(2, estudante.getNomeCompleto());
            stmt.setDate(3, Date.valueOf(estudante.getDataNascimento()));

            stmt.executeUpdate();

            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Consultar estudante pela matrícula
    public Estudante consultar(String matricula) {

        String sql = "SELECT * FROM estudante WHERE matricula = ?";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, matricula);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {

                return new Estudante(
                        rs.getString("matricula"),
                        rs.getString("nome_completo"),
                        rs.getDate("data_nascimento").toLocalDate()
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    // Editar estudante
    public boolean editar(Estudante estudante) {

        String sql = "UPDATE estudante SET nome_completo = ?, data_nascimento = ? WHERE matricula = ?";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, estudante.getNomeCompleto());
            stmt.setDate(2, Date.valueOf(estudante.getDataNascimento()));
            stmt.setString(3, estudante.getMatricula());

            stmt.executeUpdate();

            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Excluir estudante
    public boolean excluir(String matricula) {

        String sql = "DELETE FROM estudante WHERE matricula = ?";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, matricula);

            stmt.executeUpdate();

            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Listar todos os estudantes
    public List<Estudante> listar() {

        List<Estudante> estudantes = new ArrayList<>();

        String sql = "SELECT * FROM estudante";

        try (Statement stmt = conexao.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {

                Estudante estudante = new Estudante(
                        rs.getString("matricula"),
                        rs.getString("nome_completo"),
                        rs.getDate("data_nascimento").toLocalDate()
                );

                estudantes.add(estudante);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return estudantes;
    }
}