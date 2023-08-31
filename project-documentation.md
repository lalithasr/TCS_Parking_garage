# Parking Garage Application
This application is the backend support for a mobile parking application. 
The application will have the following:
- Garages 
- Parking Spaces
- Users: some of which will be admins and the rest will be customers 
- Vehicles which are owned by customers and parked in the garage

A user will enter into the garage, download the mobile app, if they havent done so already, then they will create an account, and fill out the parking space information.

When they app receives a user registration it will add it to the database with the role of Customer. Only an Admin can assign a User have the role of Admin.

When someone fills out the parking space information they will need the following data:

## Vehicle:
- Make (searchable dropdown)
- License Plate Information
- Color

## Parking Space
- Garage (searchable dropdown)
- Floor (that they are parked on)
- Parking Space Number

That information will be sent to the app so that the Vehicle and Parking Space information can be stored.

When a user leaves the parking space they will have to swipe their phone at the exit which will then delete the parking space information.

## Business Rules
Write business rules in the service layer to prevent a user from adding a parking space to a level that does not exist in the garage. For example, if the garage only has 4 floors than adding a parking space on floor 5 of that garage should throw an exception.

Another business rule would be to prevent a user from adding a parking space that does not exist on that floor. For this example I have that each floor has 1 to 100 parking spaces. So adding a parking space that does not fall within that range should produce an error.

When a User is added to the system they should automatically be assigned the role of Customer.

## Admin Functionality
Admins should be able to have all of the following functionality:
- Pull up a list of all parking spaces by Garage (Empty parking spaces are not stored in the app)
- Search for a parked vehicle to determine what space it is in by finding all vehicles of a certain make
- For any of the types (Garages, Users, Vehicles, Parking Spaces) they should be able to find all, or find by ID
- Admins should also be able to add or delete things in the database (Garages, Vehicles, Parking Spaces, Users, etc.)

The design has already been done for you, you simply need to make the classes work by adding in the correct annotations, and functionality.

- Make all of the services work.
- Entities have the proper settings and annotations.
- Repositories have the proper extends and annotations
- Services will be stubbed out for you just complete the code and provide the proper annotations.
- Lastly Controllers will reference the URLs just complete the code and provide the proper annotations.

Tips:
- Study the schema.sql and data.sql files to help you understand the underlying database. 

Good Luck!