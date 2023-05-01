package com.kafka.productor.Repository;

import com.kafka.productor.Model.Reporte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;


public interface ReporteRepository extends JpaRepository <Reporte, Long> {


    @Transactional
    List<Reporte> findByEstado (String estado);

    @Query(value = "select * from pruebas.control_msg where estado = :estado limit 4", nativeQuery=true)
    List<Reporte> buscarEstado (String estado);

}
