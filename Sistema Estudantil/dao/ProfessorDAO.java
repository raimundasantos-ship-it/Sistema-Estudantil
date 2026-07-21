package dao;

import modelo.Professor;
import util.Conexao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.List;

public class ProfessorDAO {

    private Connection conexao;

    public ProfessorDAO() {
        this.conexao = Conexao.getConnection();
    }

    // Cadastrar professor
    public boolean cadastrar(Professor professor) {

        String sql = "INSERT INTO professor (matricula, nome_completo, data_nascimento, especialidade) VALUES (?, ?, ?, ?)";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, professor.getMatricula());
            stmt.setString(2, professor.getNomeCompleto());
            stmt.setDate(3, Date.valueOf(professor.getDataNascimento()));
            stmt.setString(4, professor.getEspecialidade());

            stmt.executeUpdate();

            return true;

        } catch (SQLException e) {

            e.printStackTrace();
            return false;
        }
    }

    // Consultar professor
    public Professor consultar(String matricula) {

        String sql = "SELECT * FROM professor WHERE matricula = ?";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, matricula);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {

                return new Professor(
                        rs.getString("matricula"),
                        rs.getString("nome_completo"),
                        rs.getDate("data_nascimento").toLocalDate(),
                        rs.getString("especialidade")
                );
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return null;
    }

    // Editar professor
    public boolean editar(Professor professor) {

        String sql = "UPDATE professor SET nome_completo = ?, data_nascimento = ?, especialidade = ? WHERE matricula = ?";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, professor.getNomeCompleto());
            stmt.setDate(2, Date.valueOf(professor.getDataNascimento()));
            stmt.setString(3, professor.getEspecialidade());
            stmt.setString(4, professor.getMatricula());

            stmt.executeUpdate();

            return true;

        } catch (SQLException e) {

            e.printStackTrace();
            return false;
        }
    }

    // Excluir professor
    public boolean excluir(String matricula) {

        String sql = "DELETE FROM professor WHERE matricula = ?";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, matricula);

            stmt.executeUpdate();

            return true;

        } catch (SQLException e) {

            e.printStackTrace();
            return false;
        }
    }

    // Listar professores
    public List<Professor> listar() {

        List<Professor> professores = new ArrayList<>();

        String sql = "SELECT * FROM professor";

        try (Statement stmt = conexao.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {

                Professor professor = new Professor(
                        rs.getString("matricula"),
                        rs.getString("nome_completo"),
                        rs.getDate("data_nascimento").toLocalDate(),
                        rs.getString("especialidade")
                );

                professores.add(professor);
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return professores;
    }
}
