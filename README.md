# OOPS with Java – Assignment 2

## Project Title
**Online Auction Platform**

## Student Details
- Roll Number: Y138
- Department: Cyber Security (CY)
- Subject: Object Oriented Programming with Java
- Assignment Number: 2

## Project Description
A console-based Java application to list auction items, place bids, determine the winner, close auctions, and generate an invoice.

## OOPS Concepts
1. **Inheritance:** `VerifiedSeller` extends `User`.
2. **Method Overloading:** `AuctionService.placeBid()` has two signatures.
3. **Method Overriding:** `VerifiedSeller` overrides `display()` and `calculateFee()`.
4. **Polymorphism:** A `User` reference refers to a `VerifiedSeller` object.
5. **Encapsulation:** Fields are private and accessed through methods.

## Source Files
- `src/User.java`
- `src/VerifiedSeller.java`
- `src/Item.java`
- `src/Bid.java`
- `src/AuctionService.java`
- `src/AuctionAppMain.java`

## Run in Eclipse
1. Create a Java project.
2. Copy the six source files into the project's `src` folder.
3. Open `AuctionAppMain.java`.
4. Choose **Run As → Java Application**.
5. View the output in the Eclipse Console.

## Note
This is a learning demonstration, not a real payment or production auction system.
