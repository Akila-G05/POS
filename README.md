# POS — Shop Application

A Java Swing point-of-sale and inventory management desktop application built with
Apache Ant in NetBeans. Handles authentication, billing, purchasing (GRN), inventory
master data, and customer/employee/supplier records with MySQL as the backend.

## Features

- **Authentication** — email/password sign-in against the `employee` table with email
  format validation
- **Sales / Billing** — auto-generated invoice numbers, line-item cart with live totals,
  discounts, multiple payment methods, cash payment with automatic change/balance
  calculation, and **printable invoices** via JasperReports
- **Loyalty points** — customers earn 1% of the invoice total and can withdraw points at
  checkout
- **Automatic stock deduction** — quantities decrement as invoices are saved
- **Purchasing / GRN** — Goods Received Notes with supplier, batch-level line items
  (qty, buying/selling price, MFD/EXP), paid amount with pending-balance highlighting,
  and batch merging into stock
- **Inventory master** — brand and product CRUD, stock list, dynamic multi-criteria search
  (product, price range, expiry range) and 9 sort modes
- **Master data CRUD** — employees (with NIC/mobile/email uniqueness, type and gender),
  customers (search, sort, invoice counts, loyalty points), suppliers (with total GRNs
  and pending payments), supplier companies, and employee addresses with city lookup
- **Dark modern UI** — FlatLaf `FlatMoonlightContrastIJTheme` look and feel

## Project Structure

```
shop_app/
├── src/
│   ├── gui/           # Swing forms: Signin, Home, Invoice, GRN, Stock,
│   │                  #   Employee/Customer/Supplier/Company/Address registration
│   ├── model/         # MySQL connection helper + POJOs (GRNItem, InoviceItems)
│   ├── report/        # shop2.jasper — compiled invoice template
│   └── resources/     # (empty) reserved for bundled assets
├── db/
│   └── init.sql       # Full schema + seed data for the `shop_db` database
├── lib/               # Third-party JARs (MySQL driver, FlatLaf, JasperReports, ...)
├── nbproject/         # NetBeans project configuration
├── test/              # Test sources
└── build.xml          # Apache Ant build script
```

**Entry point:** `gui.Signin` (select it as the main class in NetBeans — `main.class` is
unset in `project.properties`)

## Design

- **Package-based layering:** `gui` holds the presentation layer (Swing forms with SQL and
  business logic inline); `model` holds the data layer — a shared connection helper plus
  POJOs for invoice and GRN line items. Deliberately lightweight, prototype-grade
  architecture rather than strict MVC
- **Static connection singleton:** `model.MySQL` opens one shared `Connection` in a static
  initializer and exposes `execute(String)`, which branches on the query prefix (`SELECT`
  → `executeQuery`, otherwise `executeUpdate`) and returns a raw `ResultSet`
- **In-memory collections as state:** `HashMap` serves as the invoice cart, the GRN item
  map, and id→label lookup maps (brands, payment methods, cities, employee types, genders)
- **Callback-style coupling:** child windows receive a back-reference to their parent form
  and push selected values directly into the parent's widgets via component getters
- **Static session store:** the signed-in employee email is held in a static field on
  `Signin` and read by other screens
- **Generated views:** all windows are NetBeans GUI Designer forms (`.form`) with
  generated `initComponents()` and `GroupLayout`

## Technologies

| Technology | Purpose |
|---|---|
| Java SE 8 | Core application language |
| Java Swing | Desktop UI (NetBeans GUI Designer, `JTable`, `JOptionPane`, `JDialog`) |
| FlatLaf 3.1.1 (+ IntelliJ themes) | Dark look and feel |
| MySQL + Connector/J 8.0.24 | Database & JDBC connectivity (`shop_db`) |
| JasperReports 6.x | Invoice generation and printing |
| OpenPDF | PDF support (JasperReports dependency) |
| Apache Ant | Build system (NetBeans project) |
| AbsoluteLayout | NetBeans GUI designer layout library |

## Getting Started

### Prerequisites

- JDK 8 or later
- NetBeans (recommended, for opening the project)
- MySQL Server with a database named `shop_db`

### Database configuration

Import the schema and seed data:

```sh
mysql -u root -p < db/init.sql
```

Then update the connection settings in `src/model/MySQL.java` (JDBC URL, username, and
password) to match your local MySQL setup.

> **Note:** `db/init.sql` seeds employee accounts with plaintext passwords, NICs, and phone
> numbers. Change or remove them before using this database anywhere but your local machine.

### Build & Run

```sh
ant clean jar
java -jar dist/shop_app.jar
```

Or open the project in NetBeans, set `gui.Signin` as the main class, and press **F6**.

> **Note:** invoice printing loads the report template from the relative path
> `src/report/shop2.jasper`, so run the app with the project root as the working directory.