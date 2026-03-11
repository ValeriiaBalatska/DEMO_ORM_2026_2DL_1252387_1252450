# DEMO_ORM - Rent a Car 🚗

A Java Maven project demonstrating JPA2/Hibernate ORM with an H2 relational database.  
Built for the EAPLI course (PL1-PL2) following a **4-layer architecture** and the **DDD Repository pattern**.

## Architecture

```
presentation/    → UI classes (menus, user interaction)
application/     → Service classes (business logic coordination)
domain/          → Entity classes (JPA-annotated domain model)
persistence/     → Repository interfaces & JPA implementations
util/            → Utility classes (Console, DateTime)
```

## Domain Model

```
CarGroup 1 ──── * Car
Car 1 ──── 1 RentalContract
RentalContract * ──── 1 Client
RentalContract 1 ──── * AuthorizedDriver
RentalContract 1 ──── 1 Payment
```

**Inheritance strategies:**
- `Client` → `CorporateClient` / `IndividualClient` - **Single Table**
- `Payment` → `CreditPayment` / `CheckPayment` - **Table Per Class**

## Features

| # | Feature |
|---|---------|
| 1 | Register Car Group |
| 2 | List all Car Groups |
| 3 | Search Car Group by ID |
| 4 | Search Car Group by Name |
| 5 | Search Car Group by Class |
| 6 | Register Car |
| 7 | List all Cars |
| 8 | Search Car by License Plate |
| 9 | Search Cars by Car Group |
| 10 | Register Client (Corporate / Individual) |
| 11 | List all Clients |
| 12 | Register Rental Contract (with Authorized Drivers + Payment) |
| 13 | List all Rental Contracts |
| 14 | Search Rental Contract by ID |

## Tech Stack

- **Java 17+**
- **Hibernate 6.4.4** (JPA provider)
- **H2 Database** (embedded, file-based)
- **Jakarta Persistence API 3.1**
- **Maven** (build tool)

## How to Run

1. Open the project in **IntelliJ IDEA**
2. Let Maven resolve dependencies
3. Run `isep.eapli.demoorm.DemoORM` (right-click → Run)
4. Use the console menu to interact with the application

## Seed Data

The application starts with pre-loaded data (`import.sql`):
- 3 Car Groups (Economy, Premium, Van)
- 3 Cars (AA-00-BB, CC-11-DD, EE-22-FF)
- 2 Clients (1 Corporate, 1 Individual)

> **Note:** Data resets on each restart (`hbm2ddl.auto=create`). Change to `update` in `persistence.xml` to persist data across restarts.

## Authors

Daniyar Zhumatayev (1252387), Valeriia Balatska (1252450)

EAPLI - ISEP - PL1-PL2 (2DL)
