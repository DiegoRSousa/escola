package br.com.alura.escola.academico.infra.aluno;

import br.com.alura.escola.academico.domain.aluno.Aluno;
import br.com.alura.escola.academico.domain.aluno.AlunoRepository;
import br.com.alura.escola.academico.domain.aluno.FabricaDeAluno;
import br.com.alura.escola.shared.domain.Cpf;
import br.com.alura.escola.academico.domain.aluno.Telefone;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlunoRepositoryJDBC implements AlunoRepository {

    private final Connection connection;

    public AlunoRepositoryJDBC(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void matricular(Aluno aluno) {

        try {
            String sql = "insert into aluno values (?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, aluno.getCpf().getNumero());
            ps.setString(2, aluno.getNome());
            ps.setString(3, aluno.getEmail().getEndereco());
            ps.execute();

            sql = "insert into telefone values(?, ?)";
            ps = connection.prepareStatement(sql);
            for(Telefone telefone : aluno.getTelefones()) {
                ps.setString(1, telefone.getDdd());
                ps.setString(2, telefone.getNumero());
                ps.execute();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public Aluno buscarPorCpf(Cpf cpf) {
        try {
            String sql = "select id, nome, email from aluno where cpf = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, cpf.getNumero());
            ResultSet rs = ps.executeQuery();
            if(!rs.next())
                return null;
            String nome = rs.getString("nome");
            String email = rs.getString("email");
            FabricaDeAluno fabricaDeAluno = new FabricaDeAluno();
            fabricaDeAluno = fabricaDeAluno.comNomeCpfEmail(nome, email, cpf.getNumero());

            Long id = rs.getLong("id");
            sql = "select ddd, numero from telefone where aluno = ?";
            ps = connection.prepareStatement(sql);
            ps.setLong(1, id);
            rs = ps.executeQuery();
            while(rs.next()) {
                String numero = rs.getString("numero");
                String ddd = rs.getString("ddd");
                fabricaDeAluno.comTelefone(ddd, numero);
            }

            return fabricaDeAluno.criar();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Aluno> listarTodosAlunos() {

        List<Aluno> alunos = new ArrayList<>();
        try {
            String sql = " select nome, cpf, email";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            FabricaDeAluno fabricaDeAluno = new FabricaDeAluno();
            while(rs.next()) {
                String nome = rs.getString("nome");
                String email = rs.getString("email");
                String cpf = rs.getString("cpf");
                alunos.add(fabricaDeAluno.comNomeCpfEmail(nome, email, cpf).criar());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return alunos;
    }
}
