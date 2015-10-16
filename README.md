# Algorithm - Elevator Standby Problem

## Story

I don't like to wait, so I don't like my office building elevator, which seems always spend my time to wait for comes up even it's in idle.

However it aroused my interest to think about how to design a pleasure one.

## Target

Elevator to make peoples wait time shortest.

## Condition

*	only auto-move while empty
*	the building have 9 floors, from 1 to 9

## Input format

```
	from:to,number_of_people
```
	
## Output format

```
	nth of floor to standby
```

---
## Algorithm 1

Always move to the floor with max score, score = (nth floor - 1) * number_of_people. Which means more people, higher score; higher floor, higher score.

**Example**

**Input**

```
	1:3,1
	1:6,4
	1:7,3
	1:9,2
```
	
**output**

```
	6
```

**Input**

```
	1:3,1
	1:6,4
	1:7,3
	1:9,2
	7:6,2
	6:1,4
```
	
**Output**

```
	9
```

**Issue:**

1. If much more people are not come to the building yet, lift should standby at 1th not nth.
2. Didn't considered usage frequency and dispersiveness.

---
## Algorithm 2

Solve Algorithm 1 issue1 by:

Get how many people take lift yesterday (may the average from history, or the estimate case of work day/holiday), count on the 1th floor initial.
The score of history records relate to the floor people went, higher floor, higher score.  

**Input/output**

	see source code.

**Issue:**

1. Doesn't count on time. For example even a few of people are not coming yet but sooner (like in the morning), lift may standby at 1th as well regardless the people in the building.

---
## Algorithm 3 (TODO)

Redesign score calculation, rank by:

Factor1: right now the most possibility of nth floor which people use lift.

Factor2: floor#. If 2 records from low to high, should boost the record with lower "from" a little bit. Vise versa.   

---	
## Others TODO

* Prove less waiting can benefit less running and more saving? (A/B testing)  
* Negative floor  
* Multi elevator  
