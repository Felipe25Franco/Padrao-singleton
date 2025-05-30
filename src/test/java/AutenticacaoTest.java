import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AutenticacaoTest {

    private Usuario usuario;
    private Autenticacao autenticacao;

    @BeforeEach
    void setUp() {
        // Configurações iniciais antes de cada teste
        usuario = Usuario.getInstance();
        usuario.setNomeCliente("João Silva");
        usuario.setNumeroConta("123456789");
        autenticacao = Autenticacao.getInstance();
    }

    @Test
    void deveAutenticarUsuarioComSenhaCorreta() {
        // Testa a autenticação com a senha correta
        boolean autenticado = autenticacao.autenticar(usuario, "senha123");

        assertTrue(autenticado, "O usuário deveria estar autenticado com a senha correta.");
        assertTrue(usuario.isAutenticado(), "O status de autenticação do usuário deveria ser true.");
    }

    @Test
    void naoDeveAutenticarUsuarioComSenhaIncorreta() {
        // Testa a autenticação com a senha incorreta
        boolean autenticado = autenticacao.autenticar(usuario, "senhaErrada");

        assertFalse(autenticado, "O usuário não deveria estar autenticado com a senha incorreta.");
        assertFalse(usuario.isAutenticado(), "O status de autenticação do usuário deveria ser false.");
    }

    @Test
    void deveDeslogarUsuario() {
        // Primeiramente autenticar o usuário
        autenticacao.autenticar(usuario, "senha123");
        assertTrue(usuario.isAutenticado(), "O usuário deveria estar autenticado.");

        // Agora, deslogar o usuário
        autenticacao.deslogar(usuario);
        assertFalse(usuario.isAutenticado(), "O status de autenticação do usuário deveria ser false após o logout.");
    }
}