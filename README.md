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

## Phase 4: Task 2
Actions performed: load save, view pet 1, unequip accessories from pet 1, view pet 2, equip accessories for pet 2, adopt pet 3, save game

Tue Aug 06 17:27:38 PDT 2024
Player profile loaded from file ./data/player.json

Tue Aug 06 17:27:38 PDT 2024
B&W Socks was added to Billy's inventory

Tue Aug 06 17:27:38 PDT 2024
Red Bow Tie was added to Billy's inventory

Tue Aug 06 17:27:38 PDT 2024
Galaxy Hat was added to Billy's inventory

Tue Aug 06 17:27:38 PDT 2024
Silver Pendant was added to Billy's inventory

Tue Aug 06 17:27:38 PDT 2024
Galaxy Hat was added to Billy's inventory

Tue Aug 06 17:27:38 PDT 2024
B&W Socks was added to Billy's inventory

Tue Aug 06 17:27:38 PDT 2024
Red Bow Tie was added to Billy's inventory

Tue Aug 06 17:27:38 PDT 2024
Created new pet: Milk

Tue Aug 06 17:27:38 PDT 2024
Milk was equipped with:   Galaxy Hat

Tue Aug 06 17:27:38 PDT 2024
Billy adopted a new pet: Milk

Tue Aug 06 17:27:38 PDT 2024
Created new pet: Joe

Tue Aug 06 17:27:38 PDT 2024
Joe was equipped with:   Galaxy Hat   B&W Socks   Galaxy Hat

Tue Aug 06 17:27:38 PDT 2024
Billy adopted a new pet: Joe

Tue Aug 06 17:27:46 PDT 2024
Milk was unequipped with:   Galaxy Hat

Tue Aug 06 17:27:46 PDT 2024
Galaxy Hat was added to Billy's inventory

Tue Aug 06 17:28:14 PDT 2024
Joe was equipped with:   B&W Socks   Silver Pendant

Tue Aug 06 17:28:14 PDT 2024
B&W Socks was removed from Billy's inventory

Tue Aug 06 17:28:14 PDT 2024
Silver Pendant was removed from Billy's inventory

Tue Aug 06 17:28:32 PDT 2024
Created new pet: Bob

Tue Aug 06 17:28:32 PDT 2024
Billy adopted a new pet: Bob

Tue Aug 06 17:28:35 PDT 2024
Billy's profile saved to file ./data/player.json