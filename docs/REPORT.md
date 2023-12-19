






## LDTS_1303 - Pixelated Entities Tactical Showdown [P.E.T.S]

Welcome to the dazzling realm of Pixelated Entities Tactical Showdown (PETS), a riveting turn-based battle game that pits players against each other in an epic clash of strategic prowess. In this pixelated universe, you have the power to assemble a team of three extraordinary PETS, each belonging to one of seven unique types: AquaticAlly, BiomorphicBeast, CelestialGuardian, CyberneticCompanion, LavaLurker, StoneGolem, and ShadowSpecters.


This project was developed for LDTS 2023⁄24 by:
- Afonso Mansilha (up202206002@up.pt),
- Eduardo Cruz (up202205138@up.pt),
- Rodrigo de Sousa (up202205751@up.pt)
## Table of contents
1. [Description](#description)
    1. [Controls](#controls)
    2. [Media](#media)
2. [Implemented features](#implemented-features)
3. [Planned features](#planned-features)
4. [Design](#design)
    1. [Lanterna facade](#lanterna-facade)
    2. [ElementView factory](#factory-elementview)
    3. [ViewFactory](#factory-view)
    4. [ArenaModelLoaderStream factory](#factory-arenamodelloaderstream)
    5. [Menus and games](#state-game)
    6. [ArenaController is the *God of Dynamics*](#command-composite-arenacontroller)
    7. [Movement strategies](#strategy-movement)
    8. [Composite Views](#composite-view)
5. [Code smells and refactoring suggestions](#code-smells)
6. [Testing](#testing)
7. [Self-evaluation](#self-evaluation)

<a name="description"><a/>
## Description

Dive into the awe-inspiring world of PETS, where your tactical decisions will determine the outcome of intense battles. Each Pet boasts a distinct design, a captivating name, and a set of powerful moves, ranging from physical and special attacks to cunning status-inflicting maneuvers. Unleash the full potential of your team and outsmart your opponents with a combination of brute force, strategic planning, and a touch of elemental mastery.

Blastem, a joyful AquaticAlly, gracefully navigating water-themed attacks, can flood the battlefield with its watery might. Angree, a tempestuous BiomorphicBeast, morphs as a tree and manipulates its form to confound foes. Doxxis, an alien CelestialGuardian, with celestial energy at its disposal, bestows divine buffs upon its allies while smiting enemies with otherworldly wrath. Metagrosso, the bulkiest of the CyberneticCompanions, utilizes advanced gadgets to control the flow of battle. Nekizal, a cocky LavaLurker, engulfs adversaries with molten fury.  Nocturnyx, the elusive ShadowSpecters harness the power of darkness, weaving in and out of the shadows to confound and strike at will. Lastly, Big7, the mighty StoneGolem, an unyielding colossus, relies on rugged defense and earth-shaking blows.

Beyond their diverse move sets, each type of PETS possesses unique abilities tied to their elemental nature. Whether it's a defensive buff, a critical hit bonus, or a status ailment immunity, these abilities add an extra layer of strategy to your team-building and battle tactics.

Engage in thrilling battles, challenge friends, and climb the ranks to become the ultimate PETS champion. Choose your team wisely, master the strengths and weaknesses of each type, and embark on an adventure where pixelated entities come to life in a tactical showdown like never before! Are you ready to unleash the power of your PETS?

<a name="controls"><a/>
### CONTROLS

The game is played using the `arrow keys` to move the cursor to the intended action.
<a name="media"><a/>
### MEDIA
<a name="galery"><a/>
#### Menus
| Main Menu                 |
|---------------------------|
| ![](screenshots/menu.png) |

| Team Select (Hovering Pet)       | Team Select (Hovering None)      |
|----------------------------------|----------------------------------|
| ![](screenshots/teamselect1.png) | ![](screenshots/teamselect2.png) | 

#### Pets
| Blastem                             | Angree                            | Metagrosso                                | Doxxis                            | Nekizal                             | Nocturnyx                               | Big7                          |
|-------------------------------------|-----------------------------------|-------------------------------------------|-----------------------------------|-------------------------------------|-----------------------------------------|-------------------------------|
| ![blastem](screenshots/blastem.png) | ![angree](screenshots/angree.png) | ![metagrosso](screenshots/metagrosso.png) | ![doxxis](screenshots/doxxis.png) | ![nekizal](screenshots/nekizal.png) | ![nocturnyx](screenshots/nocturnyx.png) | ![big7](screenshots/big7.png) |


## IMPLEMENTED FEATURES

- **Choose Your Own Team** - Each Player can create their dream Team by picking their favourites from the great Pet selection.
- **Startegy is Key** - Different Pets will have their unique traits which can decide the outcome of the battle, attacks giving twice the damage or even abilities.
- **Single-Player Friendly** - The Battles can be fought agaisnt a CPU

## FUTURE FEATURES

- **Multiplayer**

### DESIGN

### UML Class Diagram

A UML class diagram showcasing used Design Patterns:

![UML class diagram](UML/ClassUML.png)

#### KNOWN CODE SMELLS

> This section should describe 3 to 5 different code smells that you have identified in your current implementation.

### TESTING

Only Unit Testing for Enitity creation and Damage calculation.

### SELF-EVALUATION

- Afonso Mansilha =
- Eduardo Cruz = 
- Rodrigo de Sousa =
