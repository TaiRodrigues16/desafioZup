package projeto.zup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import projeto.zup.model.Veiculos;

@Repository
public interface VeiculosRepository extends JpaRepository<Veiculos, Long>{

}
