Design and Implement a Parking Lot System

Steps:
0. Overview
1. Gather/Clarify Requirements
2. Class Diagram
3. Schema Design
4. Code a Feature

0. Overview
   0.1 Overview of the Problem
   0.2 Entity Design or S/W System Design
   0.3 Persist the Data?
   0.4 Interaction with Client (CMD Line, HardCode, RestAPIs)

1. Gather/Clarify Requirements
   1. PL has Multiple Floors
   2. Different Parking Slots for different Vehicle Types
   3. Different Gate for Entry and Exit
   4. A Token is generated at entry gate
   5. A Payment Receipt is generated at exit gate
   6. Slot is assigned at the time of generate token
   7. Fee cal algo can be dynamic (Strategy Pattern)
   8. Diff Mode of Payment (Cash, Card, UPI)
   9. How a slot can be assigned can be configurable (Strategy Pattern) based on availability
   10. Slot has vehicle type, no other vehicle can be parked
   11. Reserved Parking Slot for (Staff, Women, Disabled)

2. Class Diagram (Structure + UserJourney)
    2.1 Visualizing the requirements (Entity) Outside and Inside of an Entity.
    2.2 Nouns

Classes:

Parking Lot:
- id
- floors
- address
- allowedVehicleTypes
- entryGate
- exitGate
- feeCalculationStrategy
- slotAssignmentStrategy

Parking Floor:
- id
- floorId
- slots
- allowedVehicleType
- status

EntryGate:
- id
- gateId
- status
- operator

ExitGate:
- id
- gateId
- status
- operator

Gate: (Combine Both Entry/Exit Gate)
- id
- gateId
- status
- operator
- GateType : enum

ParkingSlot:
- id
- slotId
- floorId
- vehicleType
- status

Vehicle:
- id
- vehicleNumber
- ownerName
- vehicleType
- ownerMobileNumber

Operator:
- id
- name
- employeeId

Token:
- id
- tokenNumber
- vehicleId
- entryGateId
- entryDateTime
- parkingSlot
- operator

Bill:
- id
- token
- exitGateId
- price
- exitDateTime
- operator
- List<Payment>

Payment:
- id
- mode: enum
- amount
- dateTime
- paymentId
- referenceId
- status: enum

3. Schema Design
    Three Steps to design Schema:
    1. Classes (Entities) -> Tables
    2. Primitive Attributes (Specific to that class only) -> Columns
    3. Non-Primitive Attributes (Compare Two Entities and Store Ref Id)
                                -> relation -> Cardinality

Tables:

PL : F
1 : M
1 : 1
R: 1 : M

parking_lots:
id | address | fee_cal_str_id | slot_assign_str_id | capacity

parking_floors:
id | parking_floor_id | parking_lot_id | capacity | status_id

gates:
id | gate_id | parking_lot_id | status_id | gate_type_id | operator_id

parking_slots:
id | slot_id | parking_floor_id | status_id

vehicles:
id | vehicle_number | owner_name | owner_mobile_number | vehicle_type_id

operators:
id | name | employee_id

bills:
id | exit_time | price | gate_id | token_id | payment_mode

payments:
id | bill_id |price | time | reference_id

tokens:
id | token_number | entry_time | parking_slot_id | vehicle_id | gate_id

vehicle_types: id | name

parking_lot_vehicle_types: id | parking_lot_id | vehicle_type_id

parking_floor_vehicle_types: id | parking_floor_id | vehicle_type_id

parking_floor_status: id | name

gate_status: id | name

gate_type: id | name

payment_mode: id | name


4. Code a Feature
    1. create a model for each entity.
        1.1 Find model which it is CRUD. Eg: issueToken (Create)
        1.2 Name that controller on that model (In controller we don't take params directly, we use Objects for 3rd Parties)
    2. Create DTOs for each entity.