package co.kereta.api.receiver;

import co.kereta.api.model.DefaultSeatTest;
import co.kereta.api.model.InventoryDTO;
import co.kereta.api.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by gemuruhgeo on 20/09/16.
 */
@Component
public class ManualSeatMessageHandler {
    @Autowired
    private InventoryService inventoryService;

    public void handleMessage(DefaultSeatTest defaultSeatTest){
        Integer number = defaultSeatTest.getNumberOfPnp();
        List<InventoryDTO> inventoryDTOs = inventoryService.getDefaultSeat(number);
        System.out.println(number);
    }
}
