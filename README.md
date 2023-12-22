## LDTS_1303 - Pixelated Entities Tactical Showdown [P.E.T.S]

Welcome to the dazzling realm of Pixelated Entities Tactical Showdown (PETS), a riveting turn-based battle game that pits players against each other in an epic clash of strategic prowess. In this pixelated universe, you have the power to assemble a team of three extraordinary PETS, each belonging to one of seven unique types: AquaticAlly, BiomorphicBeast, CelestialGuardian, CyberneticCompanion, LavaLurker, StoneGolem, and ShadowSpecters.


This project was developed for LDTS 2023⁄24 by:
 - Afonso Mansilha (up202206002@up.pt), 
 - Eduardo Cruz (up202205138@up.pt),
 - Rodrigo de Sousa (up202205751@up.pt)

## Install

Go to the Releases page and download the latest release.

Unzip and on the Root folder do:

    ./gradlew run

## Description

Dive into the awe-inspiring world of PETS, where your tactical decisions will determine the outcome of intense battles. Each Pet boasts a distinct design, a captivating name, and a set of powerful moves, ranging from physical and special attacks to cunning status-inflicting maneuvers. Unleash the full potential of your team and outsmart your opponents with a combination of brute force, strategic planning, and a touch of elemental mastery.

Blastem, a joyful AquaticAlly, gracefully navigating water-themed attacks, can flood the battlefield with its watery might. Angree, a tempestuous BiomorphicBeast, morphs as a tree and manipulates its form to confound foes. Doxxis, an alien CelestialGuardian, with celestial energy at its disposal, bestows divine buffs upon its allies while smiting enemies with otherworldly wrath. Metagrosso, the bulkiest of the CyberneticCompanions, utilizes advanced gadgets to control the flow of battle. Nekizal, a cocky LavaLurker, engulfs adversaries with molten fury.  Nocturnyx, the elusive ShadowSpecters harness the power of darkness, weaving in and out of the shadows to confound and strike at will. Lastly, Big7, the mighty StoneGolem, an unyielding colossus, relies on rugged defense and earth-shaking blows.

Beyond their diverse move sets, each type of PETS possesses unique abilities tied to their elemental nature. Whether it's a defensive buff, a critical hit bonus, or a status ailment immunity, these abilities add an extra layer of strategy to your team-building and battle tactics.

Engage in thrilling battles, challenge friends, and climb the ranks to become the ultimate PETS champion. Choose your team wisely, master the strengths and weaknesses of each type, and embark on an adventure where pixelated entities come to life in a tactical showdown like never before! Are you ready to unleash the power of your PETS?


### Controls

- The game is played using the `arrow keys` to move the cursor to the intended action.


### Media

#### Menus
| Main Menu                      |
|--------------------------------|
| ![](docs/screenshots/menu.png) |

| Team Select (Hovering Pet)            | Team Select (Hovering None)           |
|---------------------------------------|---------------------------------------|
| ![](docs/screenshots/teamselect1.png) | ![](docs/screenshots/teamselect2.png) | 

#### Pets
| Blastem                                  | Angree                                 | Metagrosso                                     | Doxxis                                 | Nekizal                                  | Nocturnyx                                    | Big7                               |
|------------------------------------------|----------------------------------------|------------------------------------------------|----------------------------------------|------------------------------------------|----------------------------------------------|------------------------------------|
| ![blastem](docs/screenshots/blastem.png) | ![angree](docs/screenshots/angree.png) | ![metagrosso](docs/screenshots/metagrosso.png) | ![doxxis](docs/screenshots/doxxis.png) | ![nekizal](docs/screenshots/nekizal.png) | ![nocturnyx](docs/screenshots/nocturnyx.png) | ![big7](docs/screenshots/big7.png) |


## Implemented Features

- **Choose Your Own Team** - Each Player can create their dream Team by picking their favourites from the great Pet selection.
- **Startegy is Key** - Different Pets will have their unique traits which can decide the outcome of the battle, attacks giving twice the damage or even abilities.
- **Single-Player Friendly** - The Battles can be fought agaisnt a CPU

## How To Play

### Single-Player vs Multiplayer

Choosing the option Play will allow you to play against a CPU, with difficulty of your choosing, either Easy, Medium or Hard.
Multiplayer allows you to play 1v1, each player taking turns choosing their Party and Moves.

### Choosing your Party

This is a crucial part of the Battle's strategy. Having a balanced Party in terms of Stats and Types can help you from getting into trouble.
Select 3 Pets of your choosing to move on to the Battle.

### Types of Pet

There are 7 Species of Pets: AquaticAlly, BiomorphicBeast, CelestialGuardian, LavaLurker, ShadowSpecter and StoneGolem.
Moves of certain Elements do more Damage to certain Species and receive a boost if the Attacker has a matching Specie to the Attack's Element.
Aquatic is strong agaisnt Lava, which is strong against Bio, being strong against Stone, which in turn is good against Shadow, having an advantage
against Celestial, which defeats Cybernetic and finally wins against Aquatic.

### Battle

At the start of each Round, each player decides to either attack or switch.

#### Attacking

Players should choose the attack that will yield the most amount of damage in order to KO the enemy team.
#### Switching

When in a typing disadvantage, players may choose to switch their current Pet for another one in the Party.
In doing so, they are losing an attacking round, while the enemy may still attack, inflicting damage to the newly selected Pet,
possibly KOing them.

### Winning

The player which KOs all the enemy's Pets while having at least one alive wins!
