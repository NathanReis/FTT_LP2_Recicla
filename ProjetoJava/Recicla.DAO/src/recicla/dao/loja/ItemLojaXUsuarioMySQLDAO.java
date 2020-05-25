package recicla.dao.loja;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import recicla.comuns.crud.basis.Entidade;
import recicla.comuns.vos.ItemLojaXUsuario;
import recicla.dao.basis.MySQLDAO;

public class ItemLojaXUsuarioMySQLDAO <E extends Entidade> extends MySQLDAO {
    public ItemLojaXUsuarioMySQLDAO() {
        super(ItemLojaXUsuario.class);
        
        setTabela("ItensLojaXUsuarios");
    }
    
    @Override
    protected String getComandoInserir() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void atualizar(Entidade entidade) throws SQLException {
        try (Connection conexao = DriverManager.getConnection(getStringConexao(), getUsuario(), getSenha())) {
            try (PreparedStatement stmt = conexao.prepareStatement(getComandoAtualizar())) {
                stmt.setInt(1, ((ItemLojaXUsuario)entidade).getQuantidade());
                stmt.setInt(2, ((ItemLojaXUsuario)entidade).getItemLojaId());
                stmt.setInt(3, ((ItemLojaXUsuario)entidade).getUsuarioId());

                stmt.executeUpdate();
            }
        }
    }
    
    @Override
    protected String getComandoAtualizar() {
        return "UPDATE " + getTabela() + " SET Quantidade = ? WHERE ItemLojaId = ? AND UsuarioId = ?";
    }
    
    @Override
    public void deletar(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    protected String getComandoDeletar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    protected E preencherEntidade(ResultSet rs) throws SQLException {
        ItemLojaXUsuario entidade = new ItemLojaXUsuario();

        entidade.setItemLojaId(rs.getInt("ItemLojaId"));
        entidade.setUsuarioId(rs.getInt("UsuarioId"));
        entidade.setQuantidade(rs.getInt("Quantidade"));

        return (E)entidade;
    }
}
