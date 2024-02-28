# Travel Agency Software Design

A software system that allows travel agencies to maintain their travel packages' itinerary and
passengers.

# DataModels and Tests

1. DataModels of Classes can be found
   in [DataModels](https://github.com/nivasbasker/IL-VIAGGIO/tree/master/app/src/main/java/com/zio/il_viaggio/datamodels).
2. Test cases written using Junit framework can be found
   in [TestFolder](https://github.com/nivasbasker/IL-VIAGGIO/tree/master/app/src/test/java/com/zio/il_viaggio).

# Design Diagrams

UML class diagrams, Entity Relationship Diagram and Database Schema designs can be found
in [Diagrams](https://github.com/nivasbasker/IL-VIAGGIO/tree/master/diagrams)

# specs

All the below four functions are implemented within respective classes

1. Print itinerary of the travel package
2. Print the passenger list of the travel package
3. Print the details of an individual passenger
4. Print the details of all the activities that still have spaces available, including how many
   spaces are available.

# Assumptions

### overall :

1. As of now, only a static and simple piece software is required
2. No need for a perfect UI, or a functional local database, or dynamic content.

### specific :

1. Primary keys of each class correspondingly: TourPackage-Name, Destination-Name, Activity-Name,
   Passenger-Name
2. Empty constructors and various setter methods are excluded considering that this is gonna be a
   simple static app.
3. A passenger can enroll in at-max one tour package
4. A Destination object is only made when needed to be associated with an tour package
5. An Activity object is only made when needed to be associated with an destination
6. Different type of passengers may execute a same method differently, hence the abstract class
   approach for Passengers.

# Note :

1. I want to highlight that my primary focus was on designing the data models of the system,
   following SOLID principles, Clean Code guidelines and Java code documentations. Consequently,
   there may be limited attention to the UI, database and dynamic content aspects.
2. However, I am more than willing to enhance these areas if required, as I have already designed
   the necessary things for this purpose.
3. The apk of this simple app can be
   found [here](https://github.com/nivasbasker/IL-VIAGGIO/tree/master/outputs), I assure you that
   the APK is safe, and I take full responsibility for its integrity.
    1. The app contains just two pages, of static hardcoded content
    2. First one, prints all the packages along with details of itself and the corresponding
       destinations, activities and passengers.
    3. the second one, prints all the passengers details along the activities they have enrolled
       in (if any)