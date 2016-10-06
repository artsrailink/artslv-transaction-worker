package co.kereta.api.service;

import co.kereta.api.lib.entity.Inventory;
import co.kereta.api.model.InventoryDTO;
import co.kereta.api.model.mapper.InventoryMapper;
import co.kereta.api.repository.InventoryRepository;
import oracle.jdbc.OracleTypes;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by gemuruhgeo on 14/09/16.
 * Inventory Service
 */
@Service
public class InventoryService {
    @Autowired
    private InventoryRepository inventoryRepository;
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private ModelMapper modelMapper;

    public List<InventoryDTO> getDefaultSeat(Integer numOfPassenger){
        SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate);
        simpleJdbcCall.withProcedureName("TESTING_DEFAULT_SEAT3");
        simpleJdbcCall.declareParameters(new SqlParameter("P_JML_PNP",OracleTypes.NUMBER));
        simpleJdbcCall.returningResultSet("P_OUTPUT",new InventoryMapper());

        Map<String,Object> map = simpleJdbcCall.execute(numOfPassenger);
        List<InventoryDTO> inventoryDTOs = (List<InventoryDTO>) map.get("P_OUTPUT");

        return updateInventories(inventoryDTOs);
    }

    public List<InventoryDTO> updateInventories(List<InventoryDTO> inventoryDTO){
        List<Inventory> inventories = inventoryDTO.stream().map(inventoryDTO1 -> modelMapper.map(inventoryDTO1,Inventory.class)).collect(Collectors.toList());
        inventories.forEach(inventory -> inventory.setInvBookStat("1"));
        List<InventoryDTO> result = inventoryRepository.save(inventories).stream().map(inventory -> modelMapper.map(inventory,InventoryDTO.class)).collect(Collectors.toList());
        return result;

    }
}
