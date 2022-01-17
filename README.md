# Nereids 
Java App Nereids - 3rd Semester DMST 2021-2022


promo video: https://youtu.be/oVRh6B_aBkM


Compilation instructions: mvn install or mvn clean install


Instructions for running the program: java -jar nereids-1.0.0-SNAPSHOT.jar


Game Instructions: 

  After a brief appearance of our logo, we jump in the introductory screen, in which we press the "START" button. Right after that, the game instructions appear. To proceed we need to hit the "Next" button, which leads us to the Player Choice screen. 
  
  9 different Nereids are given in a panel on the left side of the screen. Each of them, has different combination of characteristics. We are able to view every nereid's characteristics by selecting it from the nine-nereid panel. The selected nereid's characteristics automatically appear on the right side of the screen. When we feel decided on a nereid, we press the "Choose her" button on the bottom right. We get to chose a total of 3 different nereids, depending on which characteristics and in which amount are the most useful from our point of view. The characteristics of the 3 chosen nereids add up and thus we get the total characteristics.
  
  The game starts and the 3 chosen nereids get on the ship appearing on the left side of the screen. We use the pointer keys to navigate the ship up and down. 
  In order to win the game we need to go through 8 levels of challenges. During each of them, 3 different difficulties appear on the screen and the ship slowly approaches them. Each different difficulty requires a unique amount of characteristics to be overcome. We quickly have to navigate the ship to the safer difficulty option. Should we have the needed characteristics, they get removed and we overcome the difficulty, with the score increasing by 1. Otherwise the score decreases as much as the number of the characteristics missing. 
  
  After completing the 8 sets of challenges, the ship reaches victorious its destination: Sicily, unless the score drops to 0 during the game, which leads to defeat.
  
  On the top there is a menu bar with a drop-down menu. Pressing the "Options" button, we may restart the game regardless of the state we are in or even terminate it.
  

Structure of the repository: 

-- Java classes: /src/main/java/gr/aueb/dmst/nereids (21 classes)

-- Resources: /src/main/resources

     -- /src/main/resources/backgrounds
     
     -- /src/main/resources/boat
     
     -- /src/main/resources/fonts
     
     -- /src/main/resources/logo
     
     -- /src/main/resources/maps
     
     -- /src/main/resources/ostacles
     
     -- /src/main/resources/sounds
     
     -- /src/main/resources/tiles
     
     -- /src/main/resources/ui
     
-- Test classes: /src/test/java 

    -- gr.aueb.dmst.nereids (12 classes)
