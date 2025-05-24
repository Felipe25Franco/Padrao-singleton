import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UsuarioTest {
    @Test
    public void deveRetornarNomeCliente() {
        Usuario.getInstance().setNomeCliente("Carlos Silva");
        assertEquals("Carlos Silva", Usuario.getInstance().getNomeCliente());
    }

    @Test
    public void deveRetornarNumeroConta() {
        Usuario.getInstance().setNumeroConta("123456-7");
        assertEquals("123456-7", Usuario.getInstance().getNumeroConta());
    }

    @Test
    public void deveRetornarStatusAutenticacao() {
        Usuario.getInstance().setAutenticado(true);
        assertTrue(Usuario.getInstance().isAutenticado());
    }

    @Test
    public void deveManterMesmoEstadoNaMesmaInstancia() {
        Usuario sessao1 = Usuario.getInstance();
        Usuario sessao2 = Usuario.getInstance();

        sessao1.setNomeCliente("Maria");
        assertEquals("Maria", sessao2.getNomeCliente());
        assertSame(sessao1, sessao2);
    }
}
