# java-assignment-1

aim:

To create a game where play picks to cards, if they match the they get a point, the goal is to get all the cards to match.

what my program needs to do

- to randomly allocate cards to in a x by x format.
- to select two cards and determine if they match
    - if not they place flip them facing down again
- To say “you win” when all cards are paired

- bonus for me:
    - implement a limit to the number of failed tries


My plan-
    the card format will be a 4 by 4 and it will be based to colour matches, so in total 16 cards and 8 pairs.To start. 
    

04/10/2025

https://youtu.be/Zan-si4oiL0?si=ZaJhh1kO_JGqXyeg

Learning to create a Gui and learning how to create and operate button using ActionListener 

https://youtu.be/gkqNh-XGJlY?si=Iz87v2xKUyth8Ozf

Leanred how to implement an image as a button

Summary: Initially I struggled to setup my github, I couldn't figure out hwo to obtain and gpg key and had to research. Eventually figuring it out I started with learning how to make buttons and a gui frame slowly implementing other features to like images and making a 4 by 4 grid layout. Although I struggled with making multiple buttons, I realised it's basically making and array and using the for loop which i have experience with in python, that being said Java is a lot less straightforward. Ending today with a 4 by 4 grid layout with a total of 16 cards.



07/10/2025

With help of websites like stack overflow and prior knowledge, I learned how to operate the action performed. My plan is to make whilst the buttons are being created in the for loop I will randomly assign it an attribute in pairs.


10/10/2025


After looking through countless websites and examples, I finally figured how to randomly asign fruits to each button. I started by creating a list called fruits, that held the names of each fruit i wanted to use. In the function assignPairs I started of creating an empty list to which i added two of each element from Fruits. Then I used the collections.shuffle to shuffle the element in the frutis_pairs list and append them to randomised list which is what will be used in the action performed function.

In the actionperformed I created a variable called assigned_pair to see the assigned pair to each button and made sure everything was in order up to here. 

