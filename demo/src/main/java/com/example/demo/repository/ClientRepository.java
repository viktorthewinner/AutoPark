/** Clasa pentru 331AA
 * @author Plamadeala Victor
 * @version 10 Decembrie 2025
 */

package com.example.demo.repository;

import com.example.demo.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

    Optional<Client> findByCnp(String cnp);
}