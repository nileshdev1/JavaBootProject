package org.nk.repo;

import org.nk.model.PurchaseOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseOrderRepository extends JpaRepository<PurchaseOrder, Integer> {

}
