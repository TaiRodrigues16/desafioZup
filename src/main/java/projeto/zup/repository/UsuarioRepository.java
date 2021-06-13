package projeto.zup.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import projeto.zup.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	@Query("select u from Usuario u where u.cpf like ?1")
	Optional<Usuario> findUsuarioByCpf(String cpf);

    @Query("select u from Usuario u where u.email like ?1")
    Optional<Usuario> findUsuarioByEmail(String email);
}
