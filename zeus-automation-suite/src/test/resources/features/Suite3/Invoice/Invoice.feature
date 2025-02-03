Feature: Invoice feature
  This feature verifies all combinations of Invoice functionality

  @RegressionTest @Smoke
  Scenario: 01 Event TD to SP -- Accept-Repaired-Complete-Approve -- Invoice-Open-Submitted-Rejected-Submitted-Accepted-Paid
    Given Create a Event-- TD -- Feature - Invoice
      | EquipmentType | EquipmentProvider |
      | Power Unit    | AutoTruck         |
    When Enter Service details -- Create
      | EquipmentType | System | Assembly        | Component             | Position     | WorkAccomplished | Reason                 |
      | Power Unit    | Brakes | Electric Brakes | Electric Brakes (EBS) | Front Center | Adjust           | Abuse Caused by Driver |
    Then Get Event information from -- TD
    And Verify Event Status
      | StatusType  | TenandType | Status | Page      |
      | eventLog    | TD         | Open   | EventInfo |
    And Assign TD event to -- AutoTruck SP -- Payment Method - Cash
    And Verify Event Status
      | StatusType  | TenandType | Status    | Page      |
      | eventLog    | SP         | Submitted | EventInfo |
    And EventAction -- Accept -- by -- SP
    And Verify Event Status
      | StatusType  | TenandType | Status     | Page      |
      | eventLog    | SP         | In Process | EventInfo |
    And EventAction -- Repair -- by -- SP
    And Verify Event Status
      | StatusType  | TenandType | Status     | Page      |
      | eventLog    | SP         | Repaired | EventInfo |
    And EventAction -- Complete -- by -- SP
    And Verify Event Status
      | StatusType  | TenandType | Status     | Page      |
      | eventLog    | TD         | Completed | EventInfo |
    And EventAction -- Approve -- by -- TD
    And Verify Event Status
      | StatusType  | TenandType | Status   | Page      |
      | eventLog    | SP         | Approved | EventInfo |
    And Submit -- Invoice
      | InvoiceNumber | Amount     | Payer         |Status |ViewInvoice1|
      | INV1-123      | $100.00    |  AutoTruck TD |Open   |AUTOTRUCK TD|
    And TD Invoice Dashboard Validation -- Submit - AutoTruck TD - AutoTruck SP
    And Verify Event Status
      | StatusType  | TenandType | Status   | Page      |
      | eventLog    | TD         | Approved | EventInfo |
    And Accept -- Invoice
      | InvoiceNumber | Amount | Payee        | Status   |ViewInvoice1|
      | INV1-123      | $100.00| AutoTruck SP | Submitted|AUTOTRUCK TD|
    And SP Invoice Dashboard Validation -- Accepted - AutoTruck TD - AutoTruck SP
    And Verify Event Status
      | StatusType  | TenandType | Status   | Page      |
      | eventLog    | TD         | Approved | EventInfo |
    And MarkAsPaid -- Invoice
      | InvoiceNumber | Amount | Payee        | Status  |ViewInvoice1|
      | INV1-123      | $100.00| AutoTruck SP | Accepted|AUTOTRUCK TD|
    And SP Invoice Dashboard Validation -- Paid - AutoTruck TD - AutoTruck SP
    And Verify Event Status
      | StatusType  | TenandType | Status   | Page      |
      | eventLog    | SP         | Approved | EventInfo |
    And Paid -- Invoice
      | InvoiceNumber | Amount     | Payer         | Status |ViewInvoice1|
      | INV1-123      | $100.00    |  AutoTruck TD | Paid   |AUTOTRUCK TD|

  @RegressionTest
  Scenario: 02 Event from TD to CC to SP(TD to CC(Reject) > TD to SP) --Single Service line--Assign--Reject--Assign--Accept--Complete--Approve
    Given Create a Event-- TD -- Feature - Invoice
      | EquipmentType | EquipmentProvider |
      | Chassis    | AutoTruck         |
    When Enter Service details -- Create
      | EquipmentType | System | SubSystem | Service                  | Defect  | Location |
      | Chassis       | Brakes | Airline   | Air Hose - Replace w/new | Missing | Front    |
    Then Get Event information from -- TD
    And Verify Event Status
      | StatusType | TenandType | Status | Page      |
      | Single     | TD         | Open   | EventInfo |
    And Assign TD event to -- AutoTruck CC -- Payment Method - Cash
    And Verify Event Status
      | StatusType | TenandType | Status    | Page      |
      | eventLog   | CC         | Submitted | EventInfo |
    And EventAction -- Accept -- by -- CC
    And Verify Event Status
      | StatusType | TenandType | Status     | Page      |
      | eventLog   | CC         | In Process | EventInfo |
    And AssignSecondTime CC event to -- AutoTruck SP -- Payment Method - Check
    And Verify Event Status
      | StatusType | TenandType | Status    | Page      |
      | dispatchLog| SP         | Submitted | EventInfo |
    And EventAction -- Accept -- by -- SP
    And Verify Event Status
      | StatusType | TenandType | Status     | Page      |
      | eventLog   | SP         | In Process | EventInfo |
    And EventAction -- Repair -- by -- SP
    And Verify Event Status
      | StatusType  | TenandType | Status     | Page      |
      | eventLog    | SP         | Repaired | EventInfo |
    And EventAction -- Complete -- by -- SP
    And Verify Event Status
      | StatusType  | TenandType | Status     | Page      |
      | eventLog    | TD         | Completed | EventInfo |
    And EventAction -- Approve -- by -- TD
    And Verify Event Status
      | StatusType  | TenandType | Status   | Page      |
      | eventLog    | CC         | Approved | EventInfo |
    And Submit -- Invoice
      | InvoiceNumber | Amount     | Payer         |Status |ViewInvoice1|
      | INV2-123      | $100.00    |  AutoTruck TD |Open   |AUTOTRUCK TD|
    And Verify Event Status
      | StatusType  | TenandType | Status   | Page      | NoInvoice |
      | eventLog    | SP         | Approved | EventInfo | Yes       |
    And Verify Event Status
      | StatusType  | TenandType | Status   | Page      |
      | eventLog    | TD         | Approved | EventInfo |
    And Accept -- Invoice
      | InvoiceNumber | Amount | Payee        | Status   |ViewInvoice1|
      | INV2-123      | $100.00| AutoTruck CC | Submitted|AUTOTRUCK TD|
    And MarkAsPaid -- Invoice
      | InvoiceNumber | Amount | Payee        | Status  |ViewInvoice1|
      | INV2-123      | $100.00| AutoTruck CC | Accepted|AUTOTRUCK TD|
    And Verify Event Status
      | StatusType  | TenandType | Status   | Page      |
      | eventLog    | CC         | Approved | EventInfo |
    And Paid -- Invoice
      | InvoiceNumber | Amount     | Payer         | Status |ViewInvoice1|
      | INV2-123      | $100.00    |  AutoTruck TD | Paid   |AUTOTRUCK TD|

  @RegressionTest
  Scenario: 03 Event Fleet to SP when EP is different than TD -- Accept-Repaired-Complete-Approve -- Invoice-Open-Submitted-Accepted-Paid (Here 2 invoice are generated: 1 for TD and 1 for EP)
    Given Create a Event-- Fleet -- Feature - FSCSPAuthority
      | CustomerName | EquipmentType | EquipmentProvider |
      | AutoTruck TD | Container    | AutoTruck   |
    When Enter Service details -- Create
      | EquipmentType | System | SubSystem | Service                | Defect                 | Location |
      | Container     | OTR Service | OTR Labor   | Service Call - Mechanical | Per Contract | Complete    |
    Then Get Event information from -- Fleet
    And Verify Event Status
      | StatusType  | TenandType | Status | Page      |
      | eventLog    | Fleet      | Open   | EventInfo |
    And AssignDuplicate Fleet event to -- AutoTruck SP -- Payment Method - Cash
    And Verify Event Status
      | StatusType  | TenandType | Status    | Page      |
      | eventLog    | SP        | Submitted | EventInfo |
    And EventAction -- Accept -- by -- SP
    And Verify Event Status
      | StatusType  | TenandType | Status     | Page      |
      | eventLog    | SP        | In Process | EventInfo |
    And EventAction -- Repair -- by -- SP
    And Verify Event Status
      | StatusType  | TenandType | Status     | Page      |
      | eventLog    | SP        | Repaired | EventInfo |
    And EventAction -- Complete2 -- by -- SP
    And Verify Event Status
      | StatusType  | TenandType | Status     | Page      |
      | eventLog    | Fleet      | Completed | EventInfo |
    And EventAction -- Approve -- by -- Fleet
    And Verify Event Status
      | StatusType  | TenandType | Status   | Page      |
      | eventStatus | Fleet      | Approved | Dashboard |
      | eventLog    | SP        | Approved | EventInfo |
    And Submit -- Invoice
      | InvoiceNumber | Amount     | Payer         |Status | EPInvoice|ViewInvoice1|ViewInvoice2|
      | INV3-123      | $100.00    |  AutoTruck FLEET |Open   | Generate Invoice - AUTOTRUCK |AUTOTRUCK FLEET|AutoTruck|
    And Verify Event Status
      | StatusType  | TenandType | Status   | Page      |
      | eventLog    | FLEET      | Approved | EventInfo |
    And Accept -- Invoice
      | InvoiceNumber | Amount | Payee        | Status   |ViewInvoice1|
      | INV3-123      | $100.00| AutoTruck SP | Submitted|AUTOTRUCK FLEET|
    And MarkAsPaid -- Invoice
      | InvoiceNumber | Amount | Payee        | Status  |ViewInvoice1|
      | INV3-123      | $100.00| AutoTruck SP | Accepted|AUTOTRUCK FLEET|

  @RegressionTest
  Scenario: 04 Event TD to NPSP -- Accept-Repaired-Complete-Approve -- Invoice-Open-Submitted-Rejected-Submitted-Accepted-Paid
    Given Create a Event-- TD -- Feature - Invoice
      | CustomerName | EquipmentType | EquipmentProvider |
      | AutoTruck TD  | Container     | AutoTruck         |
    When Enter Service details -- Create
      | EquipmentType | System | SubSystem | Service                | Defect                 | Location |
      | Container     | Reefer | Exhaust   | Exhaust - ReplaceW/New | Associated with Repairs | Front    |
    Then Get Event information from -- TD
    And Verify Event Status
      | StatusType  | TenandType | Status | Page      |
      | eventLog    | TD         | Open   | EventInfo |
    And OverrideNPSP TD event to -- AutoTruckNPSP -- Payment Method - Cash
    And EventAction -- Accept -- by -- TD
    And Verify Event Status
      | StatusType  | TenandType | Status | Page      |
      | eventLog    | TD         | In Process   | EventInfo |
    And EventAction -- Repair -- by -- TD
    And EventAction -- Complete -- by -- TD
    And Verify Event Status
      | StatusType  | TenandType | Status     | Page      |
      | eventLog    | TD         |  Completed | EventInfo |
    And EventAction -- Approve -- by -- TD
    And Verify Event Status
      | StatusType  | TenandType | Status    | Page      |
      | eventLog    | TD         |  Approved | EventInfo |
    And Submit -- Invoice
      | InvoiceNumber | Amount     | Payer         |Status |ViewInvoice1|
      | INV4-123      | $100.00    |  AutoTruck TD |Open   |AUTOTRUCK TD|
    And Reject -- Invoice
      | InvoiceNumber | Amount | Payee        | Status   |ViewInvoice1|
      | INV4-123      | $100.00| AutoTruck SP | Submitted|AUTOTRUCK TD|
    And Submit -- Invoice
      | InvoiceNumber | Amount | Payee        | Status   |ViewInvoice1|
      | INV4-123      | $105.00| AutoTruck SP | Rejected |AUTOTRUCK TD|
    And Accept -- Invoice
      | InvoiceNumber | Amount | Payee        | Status    |ViewInvoice1|
      | INV4-123      | $105.00| AutoTruck SP | Submitted |AUTOTRUCK TD|
    And MarkAsPaid -- Invoice
      | InvoiceNumber | Amount | Payee        | Status  |ViewInvoice1|
      | INV4-123      | $105.00| AutoTruck SP | Accepted|AUTOTRUCK TD|
    And Paid -- Invoice
      | InvoiceNumber | Amount     | Payer         | Status |ViewInvoice1|
      | INV4-123      | $105.00    |  AutoTruck TD | Paid   |AUTOTRUCK TD|


  @RegressionTest
  Scenario: 05 Event TD to CC to SP -- Generate invoice on repaired -- Resend invoice request validation.
    Given Create a Event-- TD -- Feature - Invoice
      | CustomerName | EquipmentType | EquipmentProvider |
      | AutoTruck TD  | Trailer       | AutoTruck         |
    When Enter Service details -- Create
      | EquipmentType | System | Assembly              | Component              | Position     | WorkAccomplished | Reason      |
      | Trailer       | Brakes | Brake Master Cylinder | Boot - Master Cylinder | Front Center | Adjust           | Abandonment |
    Then Get Event information from -- TD
    And Verify Event Status
      | StatusType | TenandType | Status | Page      |
      | Single     | TD         | Open   | EventInfo |
    And OverrideNPSP TD event to -- AutoTruck CC1 -- Payment Method - Cash
    And Verify Event Status
      | StatusType | TenandType | Status    | Page      |
      | eventLog   | CC1         | Submitted | EventInfo |
    And EventAction -- Accept -- by -- CC1
    And Verify Event Status
      | StatusType | TenandType | Status     | Page      |
      | eventLog   | CC1         | In Process | EventInfo |
    And AssignAll CC1 event to -- AutoTruck SP1 -- Payment Method - Check
    And Verify Event Status
      | StatusType | TenandType | Status    | Page      |
      | dispatchLog| SP1         | Submitted | EventInfo |
    And EventAction -- Accept -- by -- SP1
    And Verify Event Status
      | StatusType | TenandType | Status     | Page      |
      | eventLog   | SP1         | In Process | EventInfo |
    And EventAction -- Repair -- by -- SP1
    And Verify Event Status
      | StatusType  | TenandType | Status     | Page      |
      | eventLog    | SP1         | Repaired | EventInfo |
    And EventAction -- Complete -- by -- SP1
    And Verify Event Status
      | StatusType  | TenandType | Status     | Page      | ValidateResendInvoice|
      | eventLog    | CC1        | Completed | EventInfo  | AUTOTRUCK SP1        |
    And Verify Event Status
      | StatusType  | TenandType | Status     | Page      |
      | eventLog    | SP1         | Completed | EventInfo |
    And Submit -- Invoice
      | InvoiceNumber | Amount     | Payer         |Status |ViewInvoice1|
      | INV5-123      | $100.00    |  AutoTruck CC1 |Open  |AUTOTRUCKCC1|
    And Verify Event Status
      | StatusType  | TenandType | Status   | Page      |
      | eventLog    | CC1        | Completed | EventInfo |
    And Accept -- Invoice
      | InvoiceNumber | Amount | Payee        | Status   |ViewInvoice1|
      | INV5-123      | $100.00| AutoTruck SP1 | Submitted|AUTOTRUCKCC1|
    And MarkAsPaid -- Invoice
      | InvoiceNumber | Amount | Payee        | Status  |ViewInvoice1|
      | INV5-123      | $100.00| AutoTruck SP1 | Accepted|AUTOTRUCKCC1|
    And Verify Event Status
      | StatusType  | TenandType | Status   | Page      |
      | eventLog    | SP1         | Completed | EventInfo |
    And Paid -- Invoice
      | InvoiceNumber | Amount     | Payer         | Status |ViewInvoice1|
      | INV5-123      | $100.00    |  AutoTruck CC1 | Paid  |AUTOTRUCKCC1|
