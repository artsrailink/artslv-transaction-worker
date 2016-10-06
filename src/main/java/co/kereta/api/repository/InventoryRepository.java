package co.kereta.api.repository;

import co.kereta.api.lib.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by gemuruhgeo on 14/09/16.
 */
public interface InventoryRepository extends JpaRepository<Inventory,String>{
}
