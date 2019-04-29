# CSCI_memorizationGame

Project name: memorization game

Team member: Yu Li
             Adil Sadik
             
Memorization game integrated with Google Firebase

The game is about remembering the card pattern on differnet positons and find similar ones. The least time that each players consumed for each difficulty level would be uploaded to the cloud database. The game also gives a rank of users base on their best game time.

Google Firebase stores data about:
1. Firebase Realtime database:time that each user used to complete differnt level of game. Data updated when they use shorter time to complete game.
2. Firebase user authentication: user log in and register

Files under this directory: CSCI_memorizationGame/app/src/main/java/com/mms/memorizationgame/

1.All adapters for recycler view is in one folder called Adapter.

2.activity_login.java, RegisterActivity: for user log in and register

3.constants: constants holder

4.Home: a container of game, holds some basic operation such as "back press", which is the back button in the bottom of an android screen.

5.Result: shows whether game result after user playing it.

6.Start: the very first page that navigate users to different levels of games after log in.

7.User: prototype of user profile, which is mainly used to transmit and get data from Google firebase.

8. EasyLevel, HardLevel: game with different level

9. Easyrank, Hardrank: rank in different level

10. sortByItemEasy, sortByItemHard: differnt sorting algorithm with different level



Apk of this game can be downloaded on https://drive.google.com/file/d/1aHiGfyHKEOGhORvKR0mAmTHNWwEt9HQD/view?usp=sharing
Nexus 5 with API 28 is recommended
