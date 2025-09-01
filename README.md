# Timetabling Scheduler in Java

This project implements a basic timetabling system in Java for academic course scheduling.  
It models subjects, professors, and class times, validates schedule conflicts, and provides  
a greedy algorithm to generate new groups that maximize professor ratings while avoiding  
overlapping classes.

## Features
- Object-oriented model for subjects and schedules  
- Conflict detection within and across groups  
- Grouping utilities with simple and weighted scoring  
- Greedy schedule builder that selects the best professors without conflicts  
- Easy to extend with heuristic or metaheuristic algorithms  
  (e.g. simulated annealing, genetic algorithms)

## Installation
Clone the repository:
```bash
git clone https://github.com/your-username/timetabling-scheduler.git
cd timetabling-scheduler
