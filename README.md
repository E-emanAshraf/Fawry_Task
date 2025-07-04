# **🛒 Java E-Commerce System**

This task simulates a basic e-commerce checkout system using Object-Oriented Programming in Java. It models products, carts, customers, and a checkout process with features like product expiration and shipping.

_____________________________________________________________________________________________________________________________
# ***✅ Features***

    1)Product Definition

        - Name, price, quantity

        - Some products expire (e.g., Cheese, Biscuits)

        - Some products require shipping (e.g., TV, Cheese)

    2)Shipping System

        - Items that implement ShippableItem interface provide a name and weight

        - Shipping fee: 10 units per item

        - Calculates total package weight

    3)Cart Functionality

        - Add items in specified quantity

        - Quantity must not exceed available stock

    4)Checkout Process

        - Subtotal, shipping fee, and total cost

        - Updates customer balance

        - Displays detailed receipt and shipment notice

    5)Error Handling

        Throws error if:

            - Cart is empty

            - Insufficient balance

            - Product is expired or out of stock


# ***📦 Class Overview***

    - Product (abstract): Base class for all products

    - ExpiringProduct: Products with an expiration date and weight

    - NonExpiringProduct: Products that don't expire, may or may not be shippable

    - ShippableItem (interface): For items that can be shipped (provides getName() and getWeight())

    - Cart: Holds products with quantities

    - Customer: Holds name and balance

    - Clerk: Processes checkout logic and prints receipts

    - Main: Demonstrates the system in action


# ***📚 Java Concepts Used***

    - Abstraction

    - Inheritance

    - Interfaces

    - Encapsulation

    - Polymorphism
