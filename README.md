# Prisoner's dilemma Hackathon Project
## Expose
A small hackathon project in which a group of friends can develop several small algorithms that then compete against each other in the context of the Prisoner's dilemma.

## Introduction
The aim of the project is for each participant to develop a small algorithm which, based on its previous decisions and those of its counterpart, repeatedly decides whether to betray or cover up for its counterpart. The aim is to be sentenced to as few years in prison as possible.
If you have never dealt with the prisoner's dilemma before, you can read up on it here:
https://en.wikipedia.org/wiki/Prisoner%27s_dilemma

## Prisoner's Dilemma
The prisoner's dilemma is about deciding whether to betray or cover up without knowing your accomplice's decision. Four combinations result from your own decision and that of your accomplice:

|A/B|A stays silent|A testifies|
|---|---|---|
|B stays silent| A = 1, B = 1| A = 0, B = 3 |
|B testifies | A = 3, B = 0 | A = 2, B = 2 |

The values correspond to the years that the respective prisoner must spend in prison based on the combination.
The return value of the function, which each participant must develop (more on this later), is a Boolean, which is used to indicate whether you are covering up (`false`) or betraying (`true`) your accomplice in this round.

## Evaluation
The aim of this hackathon project is to develop an algorithm that, in a duel with the others, gets as few years in prison as possible. 
You get years in prison based on the combination of your own decision and that of your opponent, as shown in the table. However, it is noticeable that the wisest decision here would be to always betray your opponent. This is why there are also the shared years in prison. At the end of each duel, the prison years of both opponents are added together, divided by two and added to their respective results.
It is therefore best not to betray each other from a mutual point of view. However, it is worth betraying your opponent from your own perspective. However, this is penalised by the shared prison years if your opponent also betrays you. This results in the dilemma and challenge of deciding when it is wise to betray your accomplice in order to gain an advantage for yourself and when it is wise to co-operate in order not to harm yourself without being betrayed by your opponent.

## The Algorithm
Each participant must develop an algorithm with the following signature:
``` java
public Boolean makeDecision(ArrayList<Boolean> myDecisions, ArrayList<Boolean> opponentDecisions)
```
Each algorithm competes against every other algorithm. A certain number of rounds are played per duel (more on this later).  To make a decision, you receive two array lists containing your own previous decisions in this duel and those of your opponent. A `Boolean` must be returned that indicates how you decide in this round: `true` = betrayed, `false` = covering up.
On the basis of his own saved decisions and those of his counterpart, the algorithm can develop a strategy as to how he should decide.

## Procedure Of The Hackathon
- each participant receives a letter to identify their class (letter replaces the X listed everywhere).

- each participant creates their own `PrisonerX` class.  This can be done in a second repository, which can be found under this link:
In the repository, everyone can create their own branch and develop their own class. Tests are provided to check the rough correctness of the developed algorithm. More about this in the repository's own README file.

- the leader of the hackathon collects the individual classes after the development time and copies them into the `Prisoner` package (there are currently a few sample dummy classes here that can be tested in advance and should then be removed).
An object of each class must be created for the `Main` class and added to the `prisoners` array.

- when calling the `evaluation` function in the `Main` class, the number of rounds to be played per duel can be set by passing an integer (default value 10,000).

- when the `Main` class is executed, the `Results.md `file is created, which contains the results of the hackathon.

## The Results
The results of the hackathon can be found in the generated `Results.md` file. 
First, the ranking list shows who won after the total prison years (own prison years plus the shared prison years) or what the respective place is that has been achieved.
This is followed by the rankings of who would have won based only on their own prison years or on the shared prison years.
In addition, a table is generated for each participant, from which you can read how your own algorithm has performed against the other algorithms and how your own overall result is made up.

## Tipps

- before starting development, participants should be asked to ensure that their algorithm is not based on looping over the entire array list each time it is executed. This can greatly increase the runtime required for evaluation.
In the `PrisonerX` class, each participant can define its own class variables and develop its own auxiliary functions that store intermediate results.
Each `PrisonerX` class contains a `reset()` function that is automatically executed after each duel and can be reset in the class variables in order to be able to start again from the initial value at the next duel.

- the participants should be made aware that their algorithm should also be able to cope with an empty array list during the first execution of a duel (however, this is also checked by testing in the other repository).

- a few dummy classes are included in this project right from the start. They can be used to familiarize yourself with the evaluation of the hackathon and to determine which number of rounds per duel results in an appropriate runtime.