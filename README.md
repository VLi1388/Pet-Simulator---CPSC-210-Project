# My Personal Project: Pet Simulator

This application allows a player to adopt pets, and take care of their pets by managing the status of their pets. Detailed operations of the application are specified as the following:

#### Possible features
- The player can adopt a pet/new pet
- The player can have up to three pets, but they will start with only one pet 
- The player has a profile that documents their *currently owned pets*
- Each pet has its own profile, which consists of *species*, *mood*, *hunger*, *thirst*, *accessories*, *discovered preferences*, and *location*
- Interaction with pets: players can **feed** and **interact** (eg. play fetch) with pets
- In game time system: pet status changes as time passes. Players need to take action to restore stats

This game is intended to be used as a relaxation for anyone who needs a break from work or daily tasks. This project came to mind as I have always been interested in game development, and seeing this assignment, I thought it would be the perfect opportunity to explore and implement some of the game ideas I have had in mind already. 

## User Storeis
- As a user, I want to be able to add a pet to my collection of pets by specifying the name and species
- As a user, I want to be able to view the list of pets I currently own
- As a user, I want to be able to see a pets current status
- As a user, I want to be able to equip my pet with accessories and add the accessories to my pets profile
- As a user, I want to be able to view the accessories my pet has equipped  
- As a user, I want to be able to feed or interact with my pet, and see the changes be reflected in my pets status
- As a user, when I quit the simulator, I want to be reminded to save my player profile to file and have the option to do so or not
- As a user, when I start the simulator, I want to be given the option to load my player profile from file.

# Instructions for Grader

- You can generate the first required action related to the user story "adding multiple Xs to a Y" by 
    1. load save or create a new game at the home screen 
    2. view one of your pets under the *player profile* tab
    3. make sure that the player inventory has accessories by clicking the *check inventory* button
    4. you can click the *interact* button in the *view pet x* pop up window to obtain accessories
    5. select the *equip accessories* button, this can add multiple accessories to that pet 
- You can generate the second required action related to the user story "adding multiple Xs to a Y" by...
    1. view one of your pets under the *player profile* tab
    2. select the *unequip accessories* button, this can remove multiple accessories from that pet 
- You can locate my visual component by looking at the *home* tab screen
- You can save the state of my application by clicking the *save* button in the *save* tab
- You can reload the state of my application by clicking the *load game* button in the *home* tab or the *load* button in the *load* tab