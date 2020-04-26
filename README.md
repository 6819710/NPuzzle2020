# NPuzzle2020
James P. Galovic - 6819710
Solution to nPuzzler Problem for COS30019

## Introduction
This repository contains the solution developed for COS30019 - Intro to artificial intelegance, Assignment 1, Option A: nPuzzler.
I have opted to complete this option as I had completed Option B in my Previous Attempt

## Search Algorithems
This program implements the following Search Algorithms fully developed by me:

* AS ("A Star"): Use both the cost to reach the goal from the current node and the cost to reach this node to evaluate the node.
* Depth-first Search: Select one option, try it, go back when ther are no more options.

This program also implements the following Search Algorithems:

* Breadth-first Search: Expand all options one level at a time.
* Greedy Best-first: Use only the cost to reach the goal from the current node to evaluate the node.

## Featurs/Bugs/Missing

### Notable Features
The included batch file nPuzzler should be used to run this application, providing it with the following command argments: filename search_method, when launching the programs you can slect from any of the above-mentioned algorithms, simply use the correct code, DFS, BFS, GBFS, AS.

The program display's the number of iterations and path generated.

The program has been expanded to run NM Puzzle designs

The program has been expanded to include Print methods for displaying puzzle state. (can be used for animating the final output)...   Presently disabled due to clearsreen issues within Java
If used it would display the corect path, step by step, with each step in the following style:
1 2 3
4   5
6 7 8

### Bugs & Missing Features
Currently the program does not output anything while running through the algorithems (only once completed). this would be a usability concern as the user cannot simply tell that the program is running, only once path finding has completed or error occured

The DFS Algorithm crashes and runs out of memory, I assume it is caused by an error in the "searched list" comparison, allowing the state to loop out of control.

A DFS Algorithem works on iterating down each valid path in tern then backtracking if the path runs into a dead end and is not correct. if the depth of the tree is too deep or as mentioned above the states are not correctly marked off, the system will simply run out of usable memory, because the previous iteration holds active data for when the forward iterations roll back with either a solution or to try next path.

## Acknowledgements/Resorces
Both the bredth-first search and depth-first search algorithms are taught in the unit, Data Structures and Patterns, the algorithems were developed based on knowledge learned in that unit.
