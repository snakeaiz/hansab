package it.hansab.ee.app.repository;

import it.hansab.ee.app.model.Car;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    @Query(value = "SELECT * FROM Car c WHERE c.USER_ID = :id", nativeQuery = true)
    List<Car> findByUserId(@Param("id") Long id);

    @Query("SELECT c FROM Car c WHERE c.numberplate like %?1%")
    Page<Car> findByNumberplate(String numberplateFilter, Pageable pageable);

}
