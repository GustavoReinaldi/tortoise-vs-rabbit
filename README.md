# TORTOISE VS RABBIT - THREAD

The classic rabbit vs rabbit but now, we can't predict who'll win.

## Introduction

That's a challenge proposed by `Gemini AI` when I prompted:
> _"Give me suggestions of projects to use `Threads`_"

Then, Gemini give me this suggestion:

> [!TIP]
> ### Goal
>
> Create a racing simulator between a tortoise and a hare, using threads to represent the movements of each animal. The hare will have a constant speed, while the tortoise will have a variable speed. The race ends when one of the animals reaches the finish line.
>
> ### Functionalities
> 
> * Simulation of the race in real time, updating the position of the animals on the screen.
> * Control the speed of the hare.
> * Random generation of the turtle's speed with each step.
> * Display of the position of the animals and the elapsed time of the race.
> * Race winner announcement.


## Implementation

The main implementation's rules is:

- We have 3 entity classes that represents the `Race`, the `Rabbit` and the `Tortoise`. `Rabbit` and `Tortoise` extends the abstract class `Player`.

- The abstract class `Player` is a `Runnable` and it is in the method `run()` that we use move our Players.

- The `velocity` of each player determines how fast will be the pauses between each step of it.

- The **winner will be** the **Player** that **finish** the **Race** in **lower time**. We time each player's run.

- The **user inserts** the **number of steps** that **players have to walk**.

## Installation and Running
We aren't using any external Lib yet. We just use maven to build our project and run it.

Use the command `mvn clean install` and after use the command `java -jar target/tortoise-vs-rabbit-threads-1.0-SNAPSHOT.jar`.

That's it!

## Conclusion

I hope you enjoy my implementation. If you have any suggestions or if you are seeing any possible improvement, please, collab with this project.
