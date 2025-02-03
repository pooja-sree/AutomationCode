package org.reach24.Reach24NEP.dtos;

import java.util.List;

import io.cucumber.datatable.DataTable;

public class EventDetailsDTO {

	private String eventId;
	private String alphaNumEventID;
	private String truckDispatch;
	private String status;
	private String eventLogStatus;
	private String dispatchLogStatus;
	private String technicianLogStatus;
	private boolean loaded;
	private boolean driverWithUnit;
	private boolean refrigerated;
	private String serviceCenter;
	private String techstatus;
	// Void
	private String voidReason;
	private String voidStatus;
	//Crosswalk
	private String crosswalkData;

	// Equipment
	private String equipmentType;
	private String equipmentNumber;
	private String chassisNumber;
	private String containerNumber;
	private String tractorNumber;
	private String trailerNumber;
	private String equipmentProvider;
	private String associatedTractorNumber;
	private String associatedContainerNumber;
	private String associatedChassisNumber;
	private String associatedTrailerNumber;
	// Address
	private String address;
    private String caller;
	// DriverDetails
	private String driverName;
	private String driverPhoneNumber;
	// Billing
	private String referenceNumber;
	// Services
	private List<Services> services;
	
	//DVIR data
	private String dvirNumber;
	private String dvirStatus;
	private String equipmentStatus;
	
	public String getEventId() {
		return eventId;
	}
	
	private String customerName;
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public void setEventId(String eventId) {
		this.eventId = eventId;
	}
	public String getAlphaNumEventID() {
		return alphaNumEventID;
	}
	public void setAlphaNumEventID(String alphaNumEventID) {
		this.alphaNumEventID = alphaNumEventID;
	}
	public String getTruckDispatch() {
		return truckDispatch;
	}
	public void setTruckDispatch(String truckDispatch) {
		this.truckDispatch = truckDispatch;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getEventLogStatus() {
		return status;
	}
	public void setEventLogStatus(String eventLogStatus) {
		this.eventLogStatus = eventLogStatus;
	}
	public String getDispatchLogStatus() {
		return dispatchLogStatus;
	}
	public void setDispatchLogStatus(String dispatchLogStatus) {
		this.dispatchLogStatus = dispatchLogStatus;
	}
	public String getTechnicianLogStatus() {
		return technicianLogStatus;
	}
	public void setTechnicianLogStatus(String technicianLogStatus) {
		this.technicianLogStatus = technicianLogStatus;
	}
	public boolean isLoaded() {
		return loaded;
	}
	public void setLoaded(boolean loaded) {
		this.loaded = loaded;
	}
	public boolean isDriverWithUnit() {
		return driverWithUnit;
	}
	public void setDriverWithUnit(boolean driverWithUnit) {
		this.driverWithUnit = driverWithUnit;
	}
	public boolean isRefrigerated() {
		return refrigerated;
	}
	public void setRefrigerated(boolean refrigerated) {
		this.refrigerated = refrigerated;
	}
	public String getServiceCenter() {
		return serviceCenter;
	}
	public void setServiceCenter(String serviceCenter) {
		this.serviceCenter = serviceCenter;
	}
	public String getTechstatus() {
		return techstatus;
	}
	public void setTechstatus(String techstatus) {
		this.techstatus = techstatus;
	}
	public String getEquipmentType() {
		return equipmentType;
	}
	public void setEquipmentType(String equipmentType) {
		this.equipmentType = equipmentType;
	}
	public String getEquipmentNumber() {
		return equipmentNumber;
	}
	public void setEquipmentNumber(String equipmentNumber) {
		this.equipmentNumber = equipmentNumber;
	}
	public String getChassisNumber() {
		return chassisNumber;
	}
	public void setChassisNumber(String chassisNumber) {
		this.chassisNumber = chassisNumber;
	}
	public String getContainerNumber() {
		return containerNumber;
	}
	public void setContainerNumber(String containerNumber) {
		this.containerNumber = containerNumber;
	}
	public String getTractorNumber() {
		return tractorNumber;
	}
	public void setTractorNumber(String tractorNumber) {
		this.tractorNumber = tractorNumber;
	}
	public String getTrailerNumber() {
		return trailerNumber;
	}
	public void setTrailerNumber(String trailerNumber) {
		this.trailerNumber = trailerNumber;
	}
	public String getEquipmentProvider() {
		return equipmentProvider;
	}
	public void setEquipmentProvider(String equipmentProvider) {
		this.equipmentProvider = equipmentProvider;
	}
	public String getAssociatedTractorNumber() {
		return associatedTractorNumber;
	}
	public void setAssociatedTractorNumber(String associatedTractorNumber) {
		this.associatedTractorNumber = associatedTractorNumber;
	}
	public String getAssociatedContainerNumber() {
		return associatedContainerNumber;
	}
	public void setAssociatedContainerNumber(String associatedContainerNumber) {
		this.associatedContainerNumber = associatedContainerNumber;
	}
	public String getAssociatedChassisNumber() {
		return associatedChassisNumber;
	}
	public void setAssociatedChassisNumber(String associatedChassisNumber) {
		this.associatedChassisNumber = associatedChassisNumber;
	}
	public String getAssociatedTrailerNumber() {
		return associatedTrailerNumber;
	}
	public void setAssociatedTrailerNumber(String associatedTrailerNumber) {
		this.associatedTrailerNumber = associatedTrailerNumber;
	}
	public String getCaller() {
		return caller;
	}
	public void setCaller(String caller) {
		this.caller = caller;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getDriverName() {
		return driverName;
	}
	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}
	public String getDriverPhoneNumber() {
		return driverPhoneNumber;
	}
	public void setDriverPhoneNumber(String driverPhoneNumber) {
		this.driverPhoneNumber = driverPhoneNumber;
	}
	public String getReferenceNumber() {
		return referenceNumber;
	}
	public void setReferenceNumber(String referenceNumber) {
		this.referenceNumber = referenceNumber;
	}
	public List<Services> getServices() {
		return services;
	}
	public void setServices(List<Services> services) {
		this.services = services;
	}
	public String getDvirNumber() {
		return dvirNumber;
	}
	public void setDvirNumber(String dvirNumber) {
		this.dvirNumber = dvirNumber;
	}
	public String getDvirStatus() {
		return dvirStatus;
	}
	public void setDvirStatus(String dvirStatus) {
		this.dvirStatus = dvirStatus;
	}
	public String getEquipmentStatus() {
		return equipmentStatus;
	}
	public void setEquipmentStatus(String equipmentStatus) {
		this.equipmentStatus = equipmentStatus;
	}
	public String getVoidReason() {
		return voidReason;
	}
	public void setVoidReason(String voidReason) {
		this.voidReason = voidReason;
	}
	public String getVoidStatus() {
		return voidStatus;
	}
	public void setVoidStatus(String voidStatus) {
		this.voidStatus = voidStatus;
	}
	
	public String getCrosswalkData() {
		return crosswalkData;
	}
	public void setCrosswalkData(String crosswalkData) {
		this.crosswalkData = crosswalkData;
	}
}
