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
    public void deveRetornarStatusAutenticacaoFalso() {
        Usuario.getInstance().setAutenticado(false);
        assertFalse(Usuario.getInstance().isAutenticado());
   }
}
