# Caniaberal_Final_Project_OOP_WasteManagementSystm

# Project Overview
The Waste Management System is Java-based designed to help users efficiently track and manage different types of waste. The system incorporates critical Java concepts such as object-oriented programming, collections, and user input handling. Users can add waste items, view them, delete items, and receive disposal advice tailored to the waste category. This project is one of the many examples of Java programming, showcasing principles like encapsulation, abstraction, polymorphism and method overriding. 





# Object-Oriented Principles


Encapsulation: Fields in the WasteItem class are private, with public getter methods to access them, ensuring data integrity.

Abstraction: The WasteItem class defines common functionality for all waste types, while specific disposal advice is provided by its subclasses (Recyclable, NonRecyclable, and Compostable).

Polymorphism: The system uses polymorphism to handle different waste types. A WasteItem reference can point to any of its subclass objects (e.g., Recyclable, NonRecyclable) and call the appropriate overridden methods for disposal advice.

Method Overriding: The disposalAdvice method in the WasteItem class is overridden by its subclasses (Recyclable, NonRecyclable, Compostable) to provide category-specific disposal advice.






# Sustainable Development Goals
The Waste Management System aligns with SDG 12: Responsible Consumption and Production. By promoting efficient waste tracking and providing clear disposal advice, this project encourages sustainable waste management practices, reducing environmental impact and promoting awareness of proper disposal methods.

# Instructions
1. **Run the program**:
   * Launch the system to access its features.

2. **Choose an option**:
   * Select one of the following options from the menu:
     1. Add Waste
     2. View Waste
     3. Delete Waste
     4. View Disposal Advice
     5. Analyze Waste
     6. Exit

3. **Add Waste**:
   * Enter the name of the waste item.
   * Provide its weight in kilograms.
   * Choose a category:
     - Recyclable
     - Non-Recyclable
     - Compostable

4. **View Waste**:
   * View a list of all recorded waste items, along with their details such as name, weight, and category.

5. **Delete Waste**:
   * Select an item from the list to remove it from the system.

6. **View Disposal Advice**:
   * Receive specific advice on how to properly dispose of each recorded waste item.

7. **Analyze Waste**:
   * Calculate the total weight of all waste items recorded in the system.

8. **Exit**:
   * Exit the application when finished.

By following these instructions, users can effectively manage and analyze waste, promoting responsible and sustainable practices.
