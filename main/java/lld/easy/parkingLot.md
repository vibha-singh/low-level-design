

1) Key Components
    Parking Lot: Represents the entire parking area with multiple floors and spots.
    Parking Floor: A single floor in the parking lot with multiple parking spots.
    Parking Spot: Individual spots where vehicles can be parked.
    Vehicle: Represents the vehicles that can park in the lot (e.g., car, bike, truck).
    Ticket: Generated when a vehicle enters the parking lot and is used for payment and exit.
    Payment System: Handles payment processing for parking fees.
    Entrance and Exit Gates: Control the flow of vehicles entering and exiting the lot.
    Admin System: Manages the parking lot (e.g., adding/removing spots, monitoring occupancy).

2) Database Tables
   Here are the essential database tables for the system:

    **ParkingLot**

    id (Primary Key)
    name
    address
    total_floors

    **ParkingFloor**

    id (Primary Key)
    parking_lot_id (Foreign Key to ParkingLot)
    floor_number
    total_spots

    **ParkingSpot**

    id (Primary Key)
    floor_id (Foreign Key to ParkingFloor)
    spot_number
    spot_type (e.g., CAR, BIKE, TRUCK)
    is_occupied (Boolean)

    **Vehicle**

    id (Primary Key)
    license_plate
    vehicle_type (e.g., CAR, BIKE, TRUCK)
    ticket_id (Foreign Key to Ticket)

    **Ticket**

    id (Primary Key)
    vehicle_id (Foreign Key to Vehicle)
    entry_time
    exit_time
    total_cost
    payment_status (e.g., PAID, UNPAID)

    **Payment**

    id (Primary Key)
    ticket_id (Foreign Key to Ticket)
    amount
    payment_method (e.g., CASH, CREDIT_CARD, UPI)
    payment_time

    **Admin**

    id (Primary Key)
    name
    email
    password_hash

3) Design Patterns
    Singleton Pattern: Use for the ParkingLot class to ensure only one instance of the parking lot exists.
    Factory Pattern: Use to create different types of vehicles (e.g., Car, Bike, Truck).
    Observer Pattern: Use to notify the admin system when the parking lot is full or when a spot becomes available.
    Strategy Pattern: Use for the payment system to support multiple payment methods (e.g., cash, credit card, UPI).
    State Pattern: Use to manage the state of a parking spot (e.g., occupied, available).
4) 