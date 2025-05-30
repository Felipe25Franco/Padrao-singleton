public class Autenticacao {

        private static final Autenticacao instance = new Autenticacao();

        private Autenticacao() {}

        public static Autenticacao getInstance() {
        return instance;
        }

        public boolean autenticar(Usuario usuario, String senha) {
                if ("senha123".equals(senha)) {
                        usuario.setAutenticado(true);
                        System.out.println("Usuário autenticado com sucesso!");
                return true;
                } else {
                        usuario.setAutenticado(false);
                        System.out.println("Falha na autenticação.");
                return false;
                }
        }

        public void deslogar(Usuario usuario) {
                usuario.setAutenticado(false);
                System.out.println("Usuário deslogado.");
        }
}