package teste;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import controle.UsuarioDAO;
import modelo.Usuario;

public class UsuarioDAOTest {
	private UsuarioDAO usuarioDao; 
    private Usuario usuario;
    
    public UsuarioDAOTest() {
    	this.usuarioDao = UsuarioDAO.getInstance();
    	this.usuario = new Usuario(0, "Nome", "Email");
    }
    
	@Test
	public void testInsertUsuario() {
		int insertId = usuarioDao.insert(usuario);
		assertTrue(insertId > 0);
	}
	
	@Test
	public void testSelectUsuario() {
		int insertId = usuarioDao.insert(usuario);
        Usuario usuarioInsert = usuarioDao.list().stream()
                .filter(u -> u.getId() == insertId)
                .findFirst()
                .orElse(null);
        assertNotNull(usuarioInsert);	
    }
	
	@Test
	public void testUpdateUsuario() {
		int insertId = usuarioDao.insert(usuario);
		usuario.setId(insertId);
	    usuario.setNome("Novo nome teste");
	    usuario.setEmail("novotest@email.com");
	    assertTrue(usuarioDao.update(usuario));
	    Usuario usuarioUpdate = usuarioDao.list().stream()
	            .filter(u -> u.getId() == insertId)
	            .findFirst()
	            .orElse(null);
	    assertEquals("Novo nome teste", usuarioUpdate.getNome());
	    assertEquals("novotest@email.com", usuarioUpdate.getEmail());
	}
	
	@Test
	public void testDeleteUsuario() {
		int insertId = usuarioDao.insert(usuario);
		usuario.setId(insertId);
        assertTrue(usuarioDao.delete(usuario));
        Usuario usuarioDeleted = usuarioDao.list().stream()
                .filter(u -> u.getId() == insertId)
                .findFirst()
                .orElse(null);
        assertNull(usuarioDeleted);
	}
}

