- Where and why you have used a @OneToMany annotation
I have used @OneToMany in the Car and Member Entity because they have a OneToMany relationship with the Reservation Entity. For each single car and or member, we can create multiple reservations.

- Where and why you have used a @ManyToOne annotation
I have used @ManyToOne annotation in the Reservation Entity, both on the Car and Member variable, as each reservation can only be connected to a single car and member at the same time.
So many reservations have one car and one member each.

- The purpose of the CascadeType, FetchType and mappedBy attributes you can use with one-to-many
CascadeType decides what data should be deleted when "related" data is deleted in a different table.
Fetchtype defines how much data is pulled from the database. Whether its only the specific data u asked for, or everything that is linked to that data.
MappedBy defines the key in a different table in the database. This mabbedBy is used on the @OneToMany annotation. 

- How/where you have (if done) added user defined queries to you repositories
Have not done any. (Yet)

- a few words, explaining what you had to do on your Azure App Service in order to make your Spring Boot App connect to your Azure MySqlDatabase
Had to add the environment variables on Azure, so it can use the variables set up in application.properties. 

- a few words about where you have used inheritance in your project, and how it's reflected in your database
Used in the entitity classes. Extended AdminDetails class in all 3 up until we added security to the member class. Admindetails is used for creationDate and editDate.

- What are the pros & cons of using the Single Table Strategy for inheritance?
Pros: 
- It is simple and managable, as you have less tables for the same amount of data.

Cons:
-Less flexible. If you need to add new data to a table fx. Adding another column it can become tricky if you want to keep all of it in the same table still. 
-A lot of null fields that are redundant.

- how are passwords stored in the database with the changes suggested in part-6 of the exercise
They are stored as a hashed string with the length of 60 characters. That is the standard length after the BCryptPasswordEncoder has been used.
These passwords can later be "compared" to authenticate for login without the password ever being turned back into the original.