# Parking-a-Lot
Parking Lot System – Object Oriented Design (Java) A scalable and thread-safe Parking Lot System implemented in Java, designed using SOLID principles, clean OOP abstractions, and strategy-based parking logic. This project simulates a real-world parking lot with multiple floors, different vehicle sizes, dynamic spot allocation, ticket-based billing.

# Parking Lot System — Complete System Design Interview Questions

These are the most commonly asked interview questions around a Parking Lot System in:

* LLD (Low-Level Design)
* HLD (High-Level Design)
* OOD (Object-Oriented Design)
* Scalability
* Database Design
* Concurrency
* Microservices
* Distributed Systems

---

# 1. REQUIREMENT GATHERING QUESTIONS

Interviewers usually start here.

## Functional Requirements

### Q1. What are the core features of the parking system?

Expected answer:

* Find parking slot
* Park vehicle
* Generate ticket
* Calculate fees
* Payment processing
* Exit vehicle
* Slot release
* Real-time availability
* Admin management

---

### Q2. What vehicle types should the system support?

Possible answer:

* Bike
* Car
* Truck
* EV

Follow-up:

* Should EV slots have charging support?

---

### Q3. Should the parking system support reservations?

Discussion:

* Reserved slots
* Time-based booking
* Prepaid reservations

---

### Q4. How is parking fee calculated?

Possible strategies:

* Hourly
* Daily
* Flat rate
* Dynamic pricing
* Weekend pricing

This leads to:

* Strategy Pattern

---

### Q5. What happens if parking is full?

Expected:

* Return error
* Waitlist
* Suggest nearby parking lot

---

### Q6. Should the system support multiple parking lots?

Scalability discussion:

* Single lot
* Multi-city parking system

---

### Q7. Should the system support real-time updates?

Examples:

* Mobile app updates
* Display boards
* WebSocket events

---

### Q8. What admin features are needed?

Examples:

* Add/remove slots
* Analytics
* Reports
* Rate management
* Audit logs

---

# 2. OBJECT-ORIENTED DESIGN QUESTIONS

---

## Q9. What are the main entities/classes?

Expected:

* User
* Vehicle
* ParkingLot
* Floor
* Zone
* ParkingSlot
* Ticket
* Payment

---

## Q10. Why did you separate Floor and Zone?

Expected answer:

* Better organization
* Scalability
* Easier slot grouping

---

## Q11. Why is Ticket separated from Payment?

Expected:

* Multiple payment attempts
* Refund support
* Transaction history

---

## Q12. Why use enums?

Expected:

* Type safety
* Avoid invalid states

Examples:

* SlotStatus
* VehicleType
* PaymentStatus

---

## Q13. Which relationships are association vs composition?

Important interview topic.

### Composition

Strong ownership.

Example:

```text
ParkingLot → Floor
Floor → Zone
Zone → ParkingSlot
```

If ParkingLot is deleted:

* floors/zones/slots disappear.

---

### Association

Weak relationship.

Example:

```text
User ↔ Vehicle
Ticket ↔ Payment
```

Objects can exist independently.

---

## Q14. Why use UUID instead of integer IDs?

Expected:

* Distributed systems support
* Unique across services
* Avoid collisions

---

# 3. DESIGN PATTERN QUESTIONS

---

## Q15. Which design patterns did you use?

Expected:

* Singleton
* Factory
* Strategy
* Observer
* State Pattern

---

## Q16. Why Singleton for ParkingLotManager?

Expected:

* Single coordination point
* Centralized slot management

---

## Q17. Why Strategy Pattern for fee calculation?

Expected:

* Dynamic pricing
* Extensible pricing models

---

## Q18. Why Factory Pattern?

Expected:

* Centralized object creation
* Easier extension

---

## Q19. Where can Observer Pattern be used?

Examples:

* Slot updates
* Notifications
* Real-time dashboards

---

## Q20. Explain State Pattern in Ticket lifecycle.

States:

```text
ACTIVE → PAID → CLOSED
```

or

```text
ACTIVE → CANCELLED
```

---

# 4. LOW LEVEL DESIGN QUESTIONS

---

## Q21. How do you find an available slot efficiently?

Expected:

* Index by vehicle type
* Priority queues
* Maps

Bad answer:

* Iterate over all slots every time

---

## Q22. What data structures would you use?

Examples:

| Use Case         | Data Structure    |
| ---------------- | ----------------- |
| Fast slot lookup | HashMap           |
| Ordered slots    | TreeSet           |
| Available slots  | PriorityQueue     |
| Ticket lookup    | ConcurrentHashMap |

---

## Q23. How do you prevent double booking?

Critical concurrency question.

Expected:

* Locking
* Atomic transactions
* Distributed locks

Examples:

```java
ReentrantLock
synchronized
Redis lock
```

---

## Q24. How do you handle concurrent vehicle entry?

Expected:

* Thread-safe slot allocation
* Transaction boundaries

---

## Q25. What happens if two users select same slot simultaneously?

Expected:

* Optimistic locking
* Pessimistic locking
* Compare-and-set operations

---

# 5. DATABASE DESIGN QUESTIONS

---

## Q26. Design the database schema.

Expected tables:

* users
* vehicles
* parking_lots
* floors
* zones
* parking_slots
* tickets
* payments

---

## Q27. What indexes would you add?

Expected:

```sql
INDEX(slot_status)
INDEX(vehicle_type)
INDEX(ticket_status)
INDEX(entry_time)
```

---

## Q28. Why normalize the schema?

Expected:

* Reduce duplication
* Better consistency

---

## Q29. Would you use SQL or NoSQL?

Discussion:

### SQL

Good for:

* Transactions
* Payments
* Relational data

### NoSQL

Good for:

* Real-time analytics
* Sensor events

---

## Q30. How would you store slot history?

Expected:

* Separate history table
* Event sourcing

---

# 6. HIGH LEVEL DESIGN QUESTIONS

---

## Q31. How would you scale the parking system?

Expected:

* Microservices
* Horizontal scaling
* Caching

---

## Q32. Which microservices would you create?

Examples:

* User Service
* Parking Service
* Ticket Service
* Payment Service
* Notification Service

---

## Q33. Why separate Ticket Service and Payment Service?

Expected:

* Independent scaling
* Fault isolation

---

## Q34. What is the role of API Gateway?

Expected:

* Routing
* Authentication
* Rate limiting

---

## Q35. Why use Kafka/RabbitMQ?

Expected:

* Async communication
* Event-driven architecture

Events:

```text
slot_occupied
ticket_generated
payment_success
slot_released
```

---

## Q36. Where would Redis be used?

Examples:

* Active tickets
* Slot availability
* Fast reads

---

## Q37. Why use WebSocket/MQTT?

Expected:

* Real-time updates

Examples:

* Display boards
* Mobile apps

---

# 7. PAYMENT QUESTIONS

---

## Q38. How do you ensure payment consistency?

Expected:

* ACID transactions
* Idempotency keys

---

## Q39. What if payment succeeds but ticket update fails?

Expected:

* Retry mechanism
* Saga pattern
* Event compensation

---

## Q40. How do refunds work?

Expected:

* Refund status
* Audit logs
* Payment history

---

# 8. DISTRIBUTED SYSTEM QUESTIONS

---

## Q41. How do you handle service failures?

Expected:

* Circuit breaker
* Retry
* Fallback

---

## Q42. How do you ensure high availability?

Expected:

* Replication
* Load balancing
* Failover

---

## Q43. How would you deploy globally?

Expected:

* Multi-region deployment
* CDN
* Geo-routing

---

## Q44. What happens if Redis goes down?

Expected:

* DB fallback
* Cache rebuild

---

## Q45. How would you monitor the system?

Expected:

* Prometheus
* Grafana
* ELK Stack

---

# 9. API DESIGN QUESTIONS

---

## Q46. Design APIs for parking entry.

Example:

```http
POST /tickets/entry
```

---

## Q47. API for available slots?

```http
GET /slots/available
```

---

## Q48. API for payment?

```http
POST /payments/create
```

---

## Q49. How would authentication work?

Expected:

* JWT
* OAuth

---

# 10. SECURITY QUESTIONS

---

## Q50. How do you secure payment APIs?

Expected:

* HTTPS
* Encryption
* Tokenization

---

## Q51. How do you prevent unauthorized admin access?

Expected:

* RBAC
* JWT roles

---

# 11. REAL-TIME & IoT QUESTIONS

---

## Q52. How would sensors integrate?

Expected:

* IoT devices
* MQTT
* Event streaming

---

## Q53. How does ANPR (Automatic Number Plate Recognition) work?

Expected:

* Camera → OCR → Vehicle detection

---

## Q54. What if sensor data is delayed?

Expected:

* Retry
* Timeout
* Manual override

---

# 12. EDGE CASE QUESTIONS

---

## Q55. What if a vehicle loses ticket?

Expected:

* Search by plate number
* Admin override

---

## Q56. What if vehicle overstays?

Expected:

* Penalty fee

---

## Q57. What if exit gate crashes?

Expected:

* Manual processing
* Recovery queue

---

## Q58. What if internet is down?

Expected:

* Offline mode
* Local caching

---

# 13. SCALABILITY QUESTIONS

---

## Q59. How would system support millions of vehicles?

Expected:

* Sharding
* Caching
* Event-driven architecture

---

## Q60. Bottlenecks in your design?

Expected:

* Slot allocation
* Payment service
* Database contention

---

# 14. INTERVIEW FOLLOW-UP QUESTIONS

---

## Q61. How would you improve slot search complexity?

Expected:

```text
O(1) or O(log n)
```

instead of:

```text
O(n)
```

---

## Q62. How would you support dynamic pricing?

Expected:

* Config service
* Pricing engine

---

## Q63. How would you implement reservation expiry?

Expected:

* Scheduler
* Redis TTL

---

## Q64. How would you audit admin actions?

Expected:

* Audit logs table
* Immutable events

---

## Q65. How would you support EV charging slots?

Expected:

* Additional metadata
* Charging session entity

---

# 15. ADVANCED QUESTIONS

---

## Q66. Explain CAP theorem in this system.

Expected:

* Consistency vs availability

---

## Q67. Would you choose eventual consistency anywhere?

Expected:

* Analytics
* Notifications

---

## Q68. How would you implement distributed locking?

Expected:

* Redis RedLock
* Zookeeper

---

## Q69. Explain optimistic vs pessimistic locking.

Very common interview question.

---

## Q70. How would you implement retry policies?

Expected:

* Exponential backoff

---

# 16. MACHINE CODING ROUND QUESTIONS

---

## Q71. Implement slot allocation logic.

---

## Q72. Implement fee calculation strategy.

---

## Q73. Implement thread-safe parking.

---

## Q74. Design extensible pricing system.

---

## Q75. Implement observer-based notifications.

---

# 17. BEHAVIORAL + ARCHITECTURAL QUESTIONS

---

## Q76. Why microservices instead of monolith?

---

## Q77. When is monolith better?

---

## Q78. Biggest challenge in this system?

---

## Q79. Tradeoffs between consistency and performance?

---

## Q80. How would you redesign if traffic grows 100x?

---

# MOST IMPORTANT QUESTIONS (HIGH PROBABILITY)

These are asked most frequently:

1. Find available slot efficiently
2. Prevent double booking
3. Fee calculation design
4. Design patterns used
5. SQL schema
6. Concurrency handling
7. Scaling architecture
8. Redis usage
9. Kafka usage
10. API design
11. Thread safety
12. Payment consistency
13. Slot allocation optimization
14. Locking strategy
15. Real-time updates

---

# BEST INTERVIEW PREPARATION STRATEGY

Prepare in this order:

## Step 1 — Requirements

Clarify:

* Functional
* Non-functional

---

## Step 2 — Core Entities

Explain:

* User
* Vehicle
* Slot
* Ticket
* Payment

---

## Step 3 — Relationships

Explain:

* Composition
* Association
* Multiplicity

---

## Step 4 — Design Patterns

Explain WHY each pattern is used.

---

## Step 5 — Scalability

Discuss:

* Cache
* Queue
* DB
* Microservices

---

## Step 6 — Concurrency

Most important for senior interviews.

Discuss:

* Locks
* Transactions
* Race conditions

---


