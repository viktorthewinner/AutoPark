/** Clasa pentru 331AA
 * @author Plamadeala Victor
 * @version 10 Decembrie 2025
 */

package com.example.demo.repository;

import com.example.demo.model.Masina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface MasinaRepository extends JpaRepository<Masina, Integer> {

    List<Masina> findByMarca(String marca);

    List<Masina> findByCumparatorIsNull();
}