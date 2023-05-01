package com.kafka.consumidor.Repository;

import com.kafka.consumidor.Model.Reporte;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReporteRepository extends JpaRepository <Reporte, Long> {
}
