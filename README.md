# 🛒 Fawry Quantum Internship Challenge 3

This is a console-based Java application that simulates a simple e-commerce system, developed as part of the Fawry Rise Journey Full Stack Development Internship Challenge.

---

## 📌 Challenge Summary

The application allows customers to:

- Browse and purchase different types of products
- Add items to a shopping cart
- Perform a checkout with real-time validations
- View shipping and receipt details printed to the console

---

## ✅ Features Implemented

- Product definition with:
  - Name, price, quantity
  - Expirable/non-expirable
  - Shippable/non-shippable with weight

- Cart functionality:
  - Add products with specific quantity (not exceeding stock)
  - Prevent adding expired or out-of-stock items

- Checkout:
  - Validates cart contents and customer balance
  - Prints shipping summary (only shippable items)
  - Prints checkout receipt (only shippable items)
  - Deducts from customer balance
  - Reduces product stock

- Shipping service:
  - Accepts a list of `Shippable` items via an interface
  - Calculates total shipping weight
  - Prints a formatted shipment notice

---

## 🧾 Sample Console Output

```text
** Shipment notice **
2x Cheese        400g
1x Biscuits      700g
Total package weight 1.1kg

** Checkout receipt **
2x Cheese        200
1x Biscuits      150
----------------------
Subtotal         350
Shipping         30
Amount           380
🧠 Technologies Used
Java SE (Object-Oriented Design)

No frameworks (pure Java)

Console-based interface

Modular structure with separation of concerns

📁 Project Structure
css
Copy
Edit
src/
├── com.example/
│   ├── Main.java
│   ├── Model/
│   │   ├── Product.java
│   │   ├── Customer.java
│   │   ├── CartItem.java
│   │   └── Shippable.java
│   └── Service/
│       ├── CartService.java
│       ├── CheckoutService.java
│       └── ShippingService.java
🔄 How to Run
Clone the repository or download the source files.

Open the project in any Java IDE (IntelliJ, Eclipse, VS Code, etc.)

Make sure the entry point is set to com.example.Main

Run the application.

View the console output.

📌 Notes
Java is used as recommended in the challenge.

No AI-generated content was used.

Console examples strictly follow the format provided by Fawry.

All required edge cases are handled.

👤 Developed by
Jana Ahmed Mohamed
