### **dnslookup**
### **README.md**

```markdown
# DNS Lookup Java Project

A simple Java program to perform DNS lookup for A records and MX records.

## Description

This program takes a website name as input from the user and performs a DNS lookup to retrieve the A records and MX records. The A records are retrieved using the `InetAddress` class, while the MX records are retrieved using the `InitialDirContext` class.

## Usage

1. Compile the program using `javac`:
   ```bash
   javac DNSLookup.java
   ```
2. Run the program using `java`:
   ```bash
   java DNSLookup
   ```
3. Enter the name of the website when prompted:
   ```
   Enter the name of the website: example.com
   ```
4. The program will display the A records and MX records for the entered website.

## Requirements

* Java Development Kit (JDK) 8 or later
* `javax.naming` package for DNS lookup

## Example Output

```
A_Record_IP_1 = 192.0.2.1
A_Record_IP_2 = 192.0.2.2
MX_Record_1 = mail.example.com
MX_Record_2 = mail2.example.com
```

## Notes

* This program uses the `InetAddress` class to retrieve the A records, which is a built-in Java class.
* The `InitialDirContext` class is used to retrieve the MX records, which is part of the `javax.naming` package.
* This program is for educational purposes only and should not be used for production environments without proper testing and validation.
```

Let me know if you need further modifications or additions!
