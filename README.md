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

# Assumptions

### overall :

1. As of now, only a static and simple piece software is required
2. No need for a perfect UI

### specific :

1. Primary keys of each class correspondingly: TourPackage-Name, Destination-Name, Activity-Name,
   Passenger-Name
2. A passenger can enroll in at-max one tour package
3. A Destination object is only made when needed to be associated with an tour package
4. An Activity object is only made when needed to be associated with an destination
5. Different type of passengers may execute a same method differently, hence the abstract class
   approach.

# Note :

1. I want to highlight that my primary focus was on designing the data models of the system.
   Consequently, there may be limited attention to the UI and dynamic content aspects.
2. However, I am more than willing to enhance these areas if required, as I have already designed
   the necessary database entities.
3. The apk of this simple app can be found [here](https://github.com/nivasbasker/IL-VIAGGIO/tree/master/outputs), I assure you that the APK is safe, and I take
   full responsibility for its integrity.
    1. The app contains just two pages, of static hardcoded content,
    2. First one, prints all the packages along with details of itself and the corresponding destinations,
       activities and passengers.
    3. the second one, prints all the passengers details along the activities they have enrolled in (
       if any)
