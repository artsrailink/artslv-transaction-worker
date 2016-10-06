package co.kereta.api.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

import java.time.LocalDateTime;

/**
 * Created by gemuruhgeo on 14/09/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class InventoryDTO {
    private String invId;

    private String scheduleId;

    private String invNoKa;

    private String tripId;

    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime tripDate;

    private String stopId;

    private String invStasiunCode;

    private Integer ivStopOrder;

    private String stamformdetId;

    private String invSfdCode;

    private Integer invSfdOrder;

    private String wagondetId;

    private Integer invWgdRow;

    private String invWgdCol;

    private String subclassId;

    private String invSubclassCode;

    private String invBookStat;

    private String invStatus;

    private String invDomain;

    private String invModifiedBy;

    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime invModifiedOn;

    private String invCols;

    public InventoryDTO() {
    }

    public InventoryDTO(String invId, String scheduleId, String invNoKa, String tripId, LocalDateTime tripDate, String stopId, String invStasiunCode, Integer ivStopOrder, String stamformdetId, String invSfdCode, Integer invSfdOrder, String wagondetId, Integer invWgdRow, String invWgdCol, String subclassId, String invSubclassCode, String invBookStat, String invStatus, String invDomain, String invModifiedBy, LocalDateTime invModifiedOn, String invCols) {
        this.invId = invId;
        this.scheduleId = scheduleId;
        this.invNoKa = invNoKa;
        this.tripId = tripId;
        this.tripDate = tripDate;
        this.stopId = stopId;
        this.invStasiunCode = invStasiunCode;
        this.ivStopOrder = ivStopOrder;
        this.stamformdetId = stamformdetId;
        this.invSfdCode = invSfdCode;
        this.invSfdOrder = invSfdOrder;
        this.wagondetId = wagondetId;
        this.invWgdRow = invWgdRow;
        this.invWgdCol = invWgdCol;
        this.subclassId = subclassId;
        this.invSubclassCode = invSubclassCode;
        this.invBookStat = invBookStat;
        this.invStatus = invStatus;
        this.invDomain = invDomain;
        this.invModifiedBy = invModifiedBy;
        this.invModifiedOn = invModifiedOn;
        this.invCols = invCols;
    }

    public String getInvId() {
        return invId;
    }

    public void setInvId(String invId) {
        this.invId = invId;
    }

    public String getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(String scheduleId) {
        this.scheduleId = scheduleId;
    }

    public String getInvNoKa() {
        return invNoKa;
    }

    public void setInvNoKa(String invNoKa) {
        this.invNoKa = invNoKa;
    }

    public String getTripId() {
        return tripId;
    }

    public void setTripId(String tripId) {
        this.tripId = tripId;
    }

    public LocalDateTime getTripDate() {
        return tripDate;
    }

    public void setTripDate(LocalDateTime tripDate) {
        this.tripDate = tripDate;
    }

    public String getStopId() {
        return stopId;
    }

    public void setStopId(String stopId) {
        this.stopId = stopId;
    }

    public String getInvStasiunCode() {
        return invStasiunCode;
    }

    public void setInvStasiunCode(String invStasiunCode) {
        this.invStasiunCode = invStasiunCode;
    }

    public Integer getIvStopOrder() {
        return ivStopOrder;
    }

    public void setIvStopOrder(Integer ivStopOrder) {
        this.ivStopOrder = ivStopOrder;
    }

    public String getStamformdetId() {
        return stamformdetId;
    }

    public void setStamformdetId(String stamformdetId) {
        this.stamformdetId = stamformdetId;
    }

    public String getInvSfdCode() {
        return invSfdCode;
    }

    public void setInvSfdCode(String invSfdCode) {
        this.invSfdCode = invSfdCode;
    }

    public Integer getInvSfdOrder() {
        return invSfdOrder;
    }

    public void setInvSfdOrder(Integer invSfdOrder) {
        this.invSfdOrder = invSfdOrder;
    }

    public String getWagondetId() {
        return wagondetId;
    }

    public void setWagondetId(String wagondetId) {
        this.wagondetId = wagondetId;
    }

    public Integer getInvWgdRow() {
        return invWgdRow;
    }

    public void setInvWgdRow(Integer invWgdRow) {
        this.invWgdRow = invWgdRow;
    }

    public String getInvWgdCol() {
        return invWgdCol;
    }

    public void setInvWgdCol(String invWgdCol) {
        this.invWgdCol = invWgdCol;
    }

    public String getSubclassId() {
        return subclassId;
    }

    public void setSubclassId(String subclassId) {
        this.subclassId = subclassId;
    }

    public String getInvSubclassCode() {
        return invSubclassCode;
    }

    public void setInvSubclassCode(String invSubclassCode) {
        this.invSubclassCode = invSubclassCode;
    }

    public String getInvBookStat() {
        return invBookStat;
    }

    public void setInvBookStat(String invBookStat) {
        this.invBookStat = invBookStat;
    }

    public String getInvStatus() {
        return invStatus;
    }

    public void setInvStatus(String invStatus) {
        this.invStatus = invStatus;
    }

    public String getInvDomain() {
        return invDomain;
    }

    public void setInvDomain(String invDomain) {
        this.invDomain = invDomain;
    }

    public String getInvModifiedBy() {
        return invModifiedBy;
    }

    public void setInvModifiedBy(String invModifiedBy) {
        this.invModifiedBy = invModifiedBy;
    }

    public LocalDateTime getInvModifiedOn() {
        return invModifiedOn;
    }

    public void setInvModifiedOn(LocalDateTime invModifiedOn) {
        this.invModifiedOn = invModifiedOn;
    }

    public String getInvCols() {
        return invCols;
    }

    public void setInvCols(String invCols) {
        this.invCols = invCols;
    }
}
