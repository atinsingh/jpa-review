package io.pragra.jpareview.repo;

import io.pragra.jpareview.entity.PriceDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceRepo extends JpaRepository<PriceDetails, Long> {
}
