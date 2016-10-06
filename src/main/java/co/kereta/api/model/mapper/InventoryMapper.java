package co.kereta.api.model.mapper;

import co.kereta.api.model.InventoryDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by gemuruhgeo on 14/09/16.
 */
public class InventoryMapper implements RowMapper<InventoryDTO>{
    @Override
    public InventoryDTO mapRow(ResultSet resultSet, int i) throws SQLException {
        InventoryDTO inventoryDTO = new InventoryDTO(resultSet.getString("C_INVENTORY_ID"),
                resultSet.getString("C_SCHEDULE_ID"),
                resultSet.getString("C_INVENTORY_NOKA"),
                resultSet.getString("C_TRIP_ID"),
                resultSet.getTimestamp("C_INVENTORY_TRIPDATE").toLocalDateTime(),
                resultSet.getString("C_STOP_ID"),
                resultSet.getString("C_INVENTORY_STASIUNCODE"),
                resultSet.getInt("C_INVENTORY_STOPORDER"),
                resultSet.getString("C_STAMFORMDET_ID"),
                resultSet.getString("C_INVENTORY_SFDCODE"),
                resultSet.getInt("C_INVENTORY_SFDORDER"),
                resultSet.getString("C_WAGONDET_ID"),
                resultSet.getInt("C_INVENTORY_WGDROW"),
                resultSet.getString("C_INVENTORY_WGDCOL"),
                resultSet.getString("C_SUBCLASS_ID"),
                resultSet.getString("C_INVENTORY_SUBCLASSCODE"),
                resultSet.getString("C_INVENTORY_BOOKSTAT"),
                resultSet.getString("C_INVENTORY_STATUS"),
                resultSet.getString("C_INVENTORY_DOMAIN"),
                resultSet.getString("C_INVENTORY_MODIFIEDBY"),
                resultSet.getTimestamp("C_INVENTORY_MODIFIEDON").toLocalDateTime(),
                resultSet.getString("C_INVENTORY_COLS"));
        return inventoryDTO;
    }
}
