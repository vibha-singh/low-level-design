# Key Components of an Airline Management System

1. **Flight Management:** Schedule, routes, and flight details.
2. **Ticket Booking:** Seat reservation, ticket generation, and payment.
3. **Passenger Management:** Passenger details and preferences.
4. **Airport Management:** Airport details and gate assignments.
5. **Crew Management:** Pilots, cabin crew, and their schedules.
6. **Aircraft Management:** Aircraft details and maintenance.
7. **Payment System**: Handle payments and refunds.
8. **Notification System:** Notify passengers about flight status, delays, etc.

# Database Tables

   Here are the essential tables for the system:

Object/Noun will be independent tables:

**Aircraft**

* aircraft_id (PK)
* model
* capacity
* manufacturer

**Airport**

* airport_id (PK)
* name
* code (e.g., JFK, LAX)
* city
* country

**Passenger**

* passenger_id (PK)
* name
* email
* phone
* frequent_flyer_number

Tables consuming above objects:

**Flight**
Consume Aircraft table

1. flight_id (PK)
2. aircraft_id (FK)
3. departure_airport_id (FK)
4. arrival_airport_id (FK)
5. departure_time
6. arrival_time
7. status (e.g., Scheduled, Delayed, Cancelled)



**Ticket**
Consumes Passenger Table and Flight Table

* ticket_id (PK)
* flight_id (FK)
* passenger_id (FK)
* seat_number
* booking_status (e.g., Confirmed, Cancelled)
* price

**Crew**
Dependent on flight Table

* crew_id (PK)
* name
* role (e.g., Pilot, Cabin Crew)
* flight_id (FK)

**Payment**
Dependent on ticket table

* payment_id (PK)
* ticket_id (FK)
* amount
* payment_status (e.g., Success, Failed)
* payment_method (e.g., Credit Card, UPI)

**Notification**
Dependent on passenger Table
* notification_id (PK)
* passenger_id (FK)
* message
* status (e.g., Sent, Pending)

# Design Patterns

   Here are some design patterns that can be applied:

* **Singleton Pattern**: Use for classes like NotificationService or PaymentSystem where only one instance should exist.

* **Factory Pattern**: Use to create objects like Ticket, Flight, or Payment based on different criteria.

* **Observer Pattern**: Use for notifying passengers about flight status changes (e.g., delays, cancellations).

* **Strategy Pattern**: Use for different payment methods (e.g., Credit Card, UPI, Wallet).

* **Facade Pattern**: Use to simplify complex interactions between subsystems (e.g., booking a ticket involves flight, payment, and notification subsystems).

**Classes**
1. Flight
Fields: flightId, aircraft, departureAirport, arrivalAirport, departureTime, arrivalTime, status (enum: FlightStatus).

Methods: getFlightId(), setStatus(), isFlightFull().

2. Aircraft
   Fields: aircraftId, model, capacity, manufacturer.

Methods: getAircraftId(), getCapacity().

3. Airport
   Fields: airportId, name, code, city, country.

Methods: getAirportId(), getCode().

4. Passenger
   Fields: passengerId, name, email, phone, frequentFlyerNumber.

Methods: getPassengerId(), getEmail().

5. Ticket
   Fields: ticketId, flight, passenger, seatNumber, seatClass (enum: SeatClass), price.

Methods: getTicketId(), getPrice().

6. Crew
   Fields: crewId, name, role (enum: CrewRole), flight.

Methods: getCrewId(), getRole().

7. Payment
   Fields: paymentId, ticket, amount, paymentStatus (enum: PaymentStatus), paymentMethod (enum: PaymentMethod).

Methods: getPaymentStatus(), setPaymentStatus().

8. Notification
   Fields: notificationId, passenger, message, isSent.

Methods: markAsSent(), isSent().

9. FlightManagementImpl
   Implements: FlightManagement interface.

Methods: scheduleFlight(), cancelFlight(), updateFlightStatus().

10. TicketBookingImpl
    Implements: TicketBooking interface.

Methods: bookTicket(), cancelTicket(), calculatePrice().

11. PaymentSystemImpl
    Implements: PaymentSystem interface.

Methods: processPayment(), refundPayment().

12. NotificationServiceImpl
    Implements: NotificationService interface.

Methods: sendNotification().


**Interface**

    interface FlightManagement {
    void scheduleFlight(Flight flight);
    void cancelFlight(String flightId);
    void updateFlightStatus(String flightId, FlightStatus status);
    }
    
    interface TicketBooking {
    Ticket bookTicket(Passenger passenger, Flight flight, String seatNumber, SeatClass seatClass);
    void cancelTicket(String ticketId);
    }
    
    interface PaymentSystem {
    boolean processPayment(Payment payment);
    void refundPayment(String paymentId);
    }
    
    interface NotificationService {
    void sendNotification(Passenger passenger, String message);
    }

**Enums**
1. FlightStatus: SCHEDULED, DELAYED, CANCELLED, DEPARTED, ARRIVED.
2. PaymentStatus: SUCCESS, FAILED, PENDING.
3. PaymentMethod: CREDIT_CARD, UPI, WALLET.
4. CrewRole: PILOT, CABIN_CREW, GROUND_STAFF.
5. SeatClass: ECONOMY, BUSINESS, FIRST_CLASS.


4. Design Patterns
   Here are some design patterns that can be applied:

Singleton Pattern

Use for classes like NotificationService or PaymentSystem where only one instance should exist.

Factory Pattern

Use to create objects like Ticket, Flight, or Payment based on different criteria.

Observer Pattern

Use for notifying passengers about flight status changes (e.g., delays, cancellations).

Strategy Pattern

Use for different payment methods (e.g., Credit Card, UPI, Wallet).

Facade Pattern

Use to simplify complex interactions between subsystems (e.g., booking a ticket involves flight, payment, and notification subsystems).



