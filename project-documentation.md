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

Admins should be able to have all of the following functionality:
- Pull up a list of all parking spaces by Garage (Empty parking spaces are not stored in the app)
- Search for a parked vehicle to determine what space it is in by finding all vehicles of a certain make
- For any of the types (Garages, Users, Vehicles, Parking Spaces) they should be able to find all, or find by ID
- Admins should also be able to add or delete things in the database (Garages, Vehicles, Parking Spaces, Users, etc.)

The design has already been done for you, you simply need to make the classes work by adding in the correct annotations, and functionality.

Good Luck!