# All Pairs Shortest Path

An implementation of the Floyd-Warshall All Pairs shortest path algorithm.

Outputs each of the iterations of the algorithm to help verify your own implementation or walkthough of the algorithm
## Expected file input structure
The input graph is simply specified as below (in data/tut07.txt), where the first line contains the label of the vertices and then each subsequent line is for each vertex (in index order) the outgoing weighted edges with pairs of vertex index and edge weight.  A vertex with no out going edges will have only its own index with a weight of 0 (e.g. vertex 6 below) 

```
A B C D E F G
0 0 2 2 3 1
1 0 0 4 4 2
2 0 3 3 5 3
3 0 1 2 4 1 6 2
4 0 6 3
5 0 3 2 6 4
6 0

```

## Expected Output
From the above graph specification, the below would be the output from running the program.  Note that "infinity" is defined here to be 1000 to avoid an integer wrap around, so if edges weights and distances are larger than 1000 then this value would need to be modified.

```
0-path
D
  0  -  2  1  -  -  -
  4  0  -  -  2  -  -
  -  -  0  3  -  3  -
  -  2  -  0  1  -  2
  -  -  -  -  0  -  3
  -  -  -  2  -  0  4
  -  -  -  -  -  -  0
P
 A - C D - - -
 A B - - E - -
 - - C D - F -
 - B - D E - G
 - - - - E - G
 - - - D - F G
 - - - - - - G
1-path with A
checking: A->A = 0, A->A->A = 0
checking: A->B = 1000, A->A->B = 1000
checking: A->C = 2, A->A->C = 2
checking: A->D = 1, A->A->D = 1
checking: A->E = 1000, A->A->E = 1000
checking: A->F = 1000, A->A->F = 1000
checking: A->G = 1000, A->A->G = 1000
checking: B->A = 4, B->A->A = 4
checking: B->B = 0, B->A->B = 1004
checking: B->C = 1000, B->A->C = 6  shorter path!
checking: B->D = 1000, B->A->D = 5  shorter path!
checking: B->E = 2, B->A->E = 1004
checking: B->F = 1000, B->A->F = 1004
checking: B->G = 1000, B->A->G = 1004
checking: C->A = 1000, C->A->A = 1000
checking: C->B = 1000, C->A->B = 2000
checking: C->C = 0, C->A->C = 1002
checking: C->D = 3, C->A->D = 1001
checking: C->E = 1000, C->A->E = 2000
checking: C->F = 3, C->A->F = 2000
checking: C->G = 1000, C->A->G = 2000
checking: D->A = 1000, D->A->A = 1000
checking: D->B = 2, D->A->B = 2000
checking: D->C = 1000, D->A->C = 1002
checking: D->D = 0, D->A->D = 1001
checking: D->E = 1, D->A->E = 2000
checking: D->F = 1000, D->A->F = 2000
checking: D->G = 2, D->A->G = 2000
checking: E->A = 1000, E->A->A = 1000
checking: E->B = 1000, E->A->B = 2000
checking: E->C = 1000, E->A->C = 1002
checking: E->D = 1000, E->A->D = 1001
checking: E->E = 0, E->A->E = 2000
checking: E->F = 1000, E->A->F = 2000
checking: E->G = 3, E->A->G = 2000
checking: F->A = 1000, F->A->A = 1000
checking: F->B = 1000, F->A->B = 2000
checking: F->C = 1000, F->A->C = 1002
checking: F->D = 2, F->A->D = 1001
checking: F->E = 1000, F->A->E = 2000
checking: F->F = 0, F->A->F = 2000
checking: F->G = 4, F->A->G = 2000
checking: G->A = 1000, G->A->A = 1000
checking: G->B = 1000, G->A->B = 2000
checking: G->C = 1000, G->A->C = 1002
checking: G->D = 1000, G->A->D = 1001
checking: G->E = 1000, G->A->E = 2000
checking: G->F = 1000, G->A->F = 2000
checking: G->G = 0, G->A->G = 2000
D
  0  -  2  1  -  -  -
  4  0  6  5  2  -  -
  -  -  0  3  -  3  -
  -  2  -  0  1  -  2
  -  -  -  -  0  -  3
  -  -  -  2  -  0  4
  -  -  -  -  -  -  0
P
 A - C D - - -
 A B A A E - -
 - - C D - F -
 - B - D E - G
 - - - - E - G
 - - - D - F G
 - - - - - - G
2-path with B
checking: A->A = 0, A->B->A = 1004
checking: A->B = 1000, A->B->B = 1000
checking: A->C = 2, A->B->C = 1006
checking: A->D = 1, A->B->D = 1005
checking: A->E = 1000, A->B->E = 1002
checking: A->F = 1000, A->B->F = 2000
checking: A->G = 1000, A->B->G = 2000
checking: B->A = 4, B->B->A = 4
checking: B->B = 0, B->B->B = 0
checking: B->C = 6, B->B->C = 6
checking: B->D = 5, B->B->D = 5
checking: B->E = 2, B->B->E = 2
checking: B->F = 1000, B->B->F = 1000
checking: B->G = 1000, B->B->G = 1000
checking: C->A = 1000, C->B->A = 1004
checking: C->B = 1000, C->B->B = 1000
checking: C->C = 0, C->B->C = 1006
checking: C->D = 3, C->B->D = 1005
checking: C->E = 1000, C->B->E = 1002
checking: C->F = 3, C->B->F = 2000
checking: C->G = 1000, C->B->G = 2000
checking: D->A = 1000, D->B->A = 6  shorter path!
checking: D->B = 2, D->B->B = 2
checking: D->C = 1000, D->B->C = 8  shorter path!
checking: D->D = 0, D->B->D = 7
checking: D->E = 1, D->B->E = 4
checking: D->F = 1000, D->B->F = 1002
checking: D->G = 2, D->B->G = 1002
checking: E->A = 1000, E->B->A = 1004
checking: E->B = 1000, E->B->B = 1000
checking: E->C = 1000, E->B->C = 1006
checking: E->D = 1000, E->B->D = 1005
checking: E->E = 0, E->B->E = 1002
checking: E->F = 1000, E->B->F = 2000
checking: E->G = 3, E->B->G = 2000
checking: F->A = 1000, F->B->A = 1004
checking: F->B = 1000, F->B->B = 1000
checking: F->C = 1000, F->B->C = 1006
checking: F->D = 2, F->B->D = 1005
checking: F->E = 1000, F->B->E = 1002
checking: F->F = 0, F->B->F = 2000
checking: F->G = 4, F->B->G = 2000
checking: G->A = 1000, G->B->A = 1004
checking: G->B = 1000, G->B->B = 1000
checking: G->C = 1000, G->B->C = 1006
checking: G->D = 1000, G->B->D = 1005
checking: G->E = 1000, G->B->E = 1002
checking: G->F = 1000, G->B->F = 2000
checking: G->G = 0, G->B->G = 2000
D
  0  -  2  1  -  -  -
  4  0  6  5  2  -  -
  -  -  0  3  -  3  -
  6  2  8  0  1  -  2
  -  -  -  -  0  -  3
  -  -  -  2  -  0  4
  -  -  -  -  -  -  0
P
 A - C D - - -
 A B A A E - -
 - - C D - F -
 B B B D E - G
 - - - - E - G
 - - - D - F G
 - - - - - - G
3-path with C
checking: A->A = 0, A->C->A = 1002
checking: A->B = 1000, A->C->B = 1002
checking: A->C = 2, A->C->C = 2
checking: A->D = 1, A->C->D = 5
checking: A->E = 1000, A->C->E = 1002
checking: A->F = 1000, A->C->F = 5  shorter path!
checking: A->G = 1000, A->C->G = 1002
checking: B->A = 4, B->C->A = 1006
checking: B->B = 0, B->C->B = 1006
checking: B->C = 6, B->C->C = 6
checking: B->D = 5, B->C->D = 9
checking: B->E = 2, B->C->E = 1006
checking: B->F = 1000, B->C->F = 9  shorter path!
checking: B->G = 1000, B->C->G = 1006
checking: C->A = 1000, C->C->A = 1000
checking: C->B = 1000, C->C->B = 1000
checking: C->C = 0, C->C->C = 0
checking: C->D = 3, C->C->D = 3
checking: C->E = 1000, C->C->E = 1000
checking: C->F = 3, C->C->F = 3
checking: C->G = 1000, C->C->G = 1000
checking: D->A = 6, D->C->A = 1008
checking: D->B = 2, D->C->B = 1008
checking: D->C = 8, D->C->C = 8
checking: D->D = 0, D->C->D = 11
checking: D->E = 1, D->C->E = 1008
checking: D->F = 1000, D->C->F = 11  shorter path!
checking: D->G = 2, D->C->G = 1008
checking: E->A = 1000, E->C->A = 2000
checking: E->B = 1000, E->C->B = 2000
checking: E->C = 1000, E->C->C = 1000
checking: E->D = 1000, E->C->D = 1003
checking: E->E = 0, E->C->E = 2000
checking: E->F = 1000, E->C->F = 1003
checking: E->G = 3, E->C->G = 2000
checking: F->A = 1000, F->C->A = 2000
checking: F->B = 1000, F->C->B = 2000
checking: F->C = 1000, F->C->C = 1000
checking: F->D = 2, F->C->D = 1003
checking: F->E = 1000, F->C->E = 2000
checking: F->F = 0, F->C->F = 1003
checking: F->G = 4, F->C->G = 2000
checking: G->A = 1000, G->C->A = 2000
checking: G->B = 1000, G->C->B = 2000
checking: G->C = 1000, G->C->C = 1000
checking: G->D = 1000, G->C->D = 1003
checking: G->E = 1000, G->C->E = 2000
checking: G->F = 1000, G->C->F = 1003
checking: G->G = 0, G->C->G = 2000
D
  0  -  2  1  -  5  -
  4  0  6  5  2  9  -
  -  -  0  3  -  3  -
  6  2  8  0  1 11  2
  -  -  -  -  0  -  3
  -  -  -  2  -  0  4
  -  -  -  -  -  -  0
P
 A - C D - C -
 A B A A E C -
 - - C D - F -
 B B B D E C G
 - - - - E - G
 - - - D - F G
 - - - - - - G
4-path with D
checking: A->A = 0, A->D->A = 7
checking: A->B = 1000, A->D->B = 3  shorter path!
checking: A->C = 2, A->D->C = 9
checking: A->D = 1, A->D->D = 1
checking: A->E = 1000, A->D->E = 2  shorter path!
checking: A->F = 5, A->D->F = 12
checking: A->G = 1000, A->D->G = 3  shorter path!
checking: B->A = 4, B->D->A = 11
checking: B->B = 0, B->D->B = 7
checking: B->C = 6, B->D->C = 13
checking: B->D = 5, B->D->D = 5
checking: B->E = 2, B->D->E = 6
checking: B->F = 9, B->D->F = 16
checking: B->G = 1000, B->D->G = 7  shorter path!
checking: C->A = 1000, C->D->A = 9  shorter path!
checking: C->B = 1000, C->D->B = 5  shorter path!
checking: C->C = 0, C->D->C = 11
checking: C->D = 3, C->D->D = 3
checking: C->E = 1000, C->D->E = 4  shorter path!
checking: C->F = 3, C->D->F = 14
checking: C->G = 1000, C->D->G = 5  shorter path!
checking: D->A = 6, D->D->A = 6
checking: D->B = 2, D->D->B = 2
checking: D->C = 8, D->D->C = 8
checking: D->D = 0, D->D->D = 0
checking: D->E = 1, D->D->E = 1
checking: D->F = 11, D->D->F = 11
checking: D->G = 2, D->D->G = 2
checking: E->A = 1000, E->D->A = 1006
checking: E->B = 1000, E->D->B = 1002
checking: E->C = 1000, E->D->C = 1008
checking: E->D = 1000, E->D->D = 1000
checking: E->E = 0, E->D->E = 1001
checking: E->F = 1000, E->D->F = 1011
checking: E->G = 3, E->D->G = 1002
checking: F->A = 1000, F->D->A = 8  shorter path!
checking: F->B = 1000, F->D->B = 4  shorter path!
checking: F->C = 1000, F->D->C = 10  shorter path!
checking: F->D = 2, F->D->D = 2
checking: F->E = 1000, F->D->E = 3  shorter path!
checking: F->F = 0, F->D->F = 13
checking: F->G = 4, F->D->G = 4
checking: G->A = 1000, G->D->A = 1006
checking: G->B = 1000, G->D->B = 1002
checking: G->C = 1000, G->D->C = 1008
checking: G->D = 1000, G->D->D = 1000
checking: G->E = 1000, G->D->E = 1001
checking: G->F = 1000, G->D->F = 1011
checking: G->G = 0, G->D->G = 1002
D
  0  3  2  1  2  5  3
  4  0  6  5  2  9  7
  9  5  0  3  4  3  5
  6  2  8  0  1 11  2
  -  -  -  -  0  -  3
  8  4 10  2  3  0  4
  -  -  -  -  -  -  0
P
 A D C D D C D
 A B A A E C D
 D D C D D F D
 B B B D E C G
 - - - - E - G
 D D D D D F G
 - - - - - - G
5-path with E
checking: A->A = 0, A->E->A = 1002
checking: A->B = 3, A->E->B = 1002
checking: A->C = 2, A->E->C = 1002
checking: A->D = 1, A->E->D = 1002
checking: A->E = 2, A->E->E = 2
checking: A->F = 5, A->E->F = 1002
checking: A->G = 3, A->E->G = 5
checking: B->A = 4, B->E->A = 1002
checking: B->B = 0, B->E->B = 1002
checking: B->C = 6, B->E->C = 1002
checking: B->D = 5, B->E->D = 1002
checking: B->E = 2, B->E->E = 2
checking: B->F = 9, B->E->F = 1002
checking: B->G = 7, B->E->G = 5  shorter path!
checking: C->A = 9, C->E->A = 1004
checking: C->B = 5, C->E->B = 1004
checking: C->C = 0, C->E->C = 1004
checking: C->D = 3, C->E->D = 1004
checking: C->E = 4, C->E->E = 4
checking: C->F = 3, C->E->F = 1004
checking: C->G = 5, C->E->G = 7
checking: D->A = 6, D->E->A = 1001
checking: D->B = 2, D->E->B = 1001
checking: D->C = 8, D->E->C = 1001
checking: D->D = 0, D->E->D = 1001
checking: D->E = 1, D->E->E = 1
checking: D->F = 11, D->E->F = 1001
checking: D->G = 2, D->E->G = 4
checking: E->A = 1000, E->E->A = 1000
checking: E->B = 1000, E->E->B = 1000
checking: E->C = 1000, E->E->C = 1000
checking: E->D = 1000, E->E->D = 1000
checking: E->E = 0, E->E->E = 0
checking: E->F = 1000, E->E->F = 1000
checking: E->G = 3, E->E->G = 3
checking: F->A = 8, F->E->A = 1003
checking: F->B = 4, F->E->B = 1003
checking: F->C = 10, F->E->C = 1003
checking: F->D = 2, F->E->D = 1003
checking: F->E = 3, F->E->E = 3
checking: F->F = 0, F->E->F = 1003
checking: F->G = 4, F->E->G = 6
checking: G->A = 1000, G->E->A = 2000
checking: G->B = 1000, G->E->B = 2000
checking: G->C = 1000, G->E->C = 2000
checking: G->D = 1000, G->E->D = 2000
checking: G->E = 1000, G->E->E = 1000
checking: G->F = 1000, G->E->F = 2000
checking: G->G = 0, G->E->G = 1003
D
  0  3  2  1  2  5  3
  4  0  6  5  2  9  5
  9  5  0  3  4  3  5
  6  2  8  0  1 11  2
  -  -  -  -  0  -  3
  8  4 10  2  3  0  4
  -  -  -  -  -  -  0
P
 A D C D D C D
 A B A A E C E
 D D C D D F D
 B B B D E C G
 - - - - E - G
 D D D D D F G
 - - - - - - G
6-path with F
checking: A->A = 0, A->F->A = 13
checking: A->B = 3, A->F->B = 9
checking: A->C = 2, A->F->C = 15
checking: A->D = 1, A->F->D = 7
checking: A->E = 2, A->F->E = 8
checking: A->F = 5, A->F->F = 5
checking: A->G = 3, A->F->G = 9
checking: B->A = 4, B->F->A = 17
checking: B->B = 0, B->F->B = 13
checking: B->C = 6, B->F->C = 19
checking: B->D = 5, B->F->D = 11
checking: B->E = 2, B->F->E = 12
checking: B->F = 9, B->F->F = 9
checking: B->G = 5, B->F->G = 13
checking: C->A = 9, C->F->A = 11
checking: C->B = 5, C->F->B = 7
checking: C->C = 0, C->F->C = 13
checking: C->D = 3, C->F->D = 5
checking: C->E = 4, C->F->E = 6
checking: C->F = 3, C->F->F = 3
checking: C->G = 5, C->F->G = 7
checking: D->A = 6, D->F->A = 19
checking: D->B = 2, D->F->B = 15
checking: D->C = 8, D->F->C = 21
checking: D->D = 0, D->F->D = 13
checking: D->E = 1, D->F->E = 14
checking: D->F = 11, D->F->F = 11
checking: D->G = 2, D->F->G = 15
checking: E->A = 1000, E->F->A = 1008
checking: E->B = 1000, E->F->B = 1004
checking: E->C = 1000, E->F->C = 1010
checking: E->D = 1000, E->F->D = 1002
checking: E->E = 0, E->F->E = 1003
checking: E->F = 1000, E->F->F = 1000
checking: E->G = 3, E->F->G = 1004
checking: F->A = 8, F->F->A = 8
checking: F->B = 4, F->F->B = 4
checking: F->C = 10, F->F->C = 10
checking: F->D = 2, F->F->D = 2
checking: F->E = 3, F->F->E = 3
checking: F->F = 0, F->F->F = 0
checking: F->G = 4, F->F->G = 4
checking: G->A = 1000, G->F->A = 1008
checking: G->B = 1000, G->F->B = 1004
checking: G->C = 1000, G->F->C = 1010
checking: G->D = 1000, G->F->D = 1002
checking: G->E = 1000, G->F->E = 1003
checking: G->F = 1000, G->F->F = 1000
checking: G->G = 0, G->F->G = 1004
D
  0  3  2  1  2  5  3
  4  0  6  5  2  9  5
  9  5  0  3  4  3  5
  6  2  8  0  1 11  2
  -  -  -  -  0  -  3
  8  4 10  2  3  0  4
  -  -  -  -  -  -  0
P
 A D C D D C D
 A B A A E C E
 D D C D D F D
 B B B D E C G
 - - - - E - G
 D D D D D F G
 - - - - - - G
7-path with G
checking: A->A = 0, A->G->A = 1003
checking: A->B = 3, A->G->B = 1003
checking: A->C = 2, A->G->C = 1003
checking: A->D = 1, A->G->D = 1003
checking: A->E = 2, A->G->E = 1003
checking: A->F = 5, A->G->F = 1003
checking: A->G = 3, A->G->G = 3
checking: B->A = 4, B->G->A = 1005
checking: B->B = 0, B->G->B = 1005
checking: B->C = 6, B->G->C = 1005
checking: B->D = 5, B->G->D = 1005
checking: B->E = 2, B->G->E = 1005
checking: B->F = 9, B->G->F = 1005
checking: B->G = 5, B->G->G = 5
checking: C->A = 9, C->G->A = 1005
checking: C->B = 5, C->G->B = 1005
checking: C->C = 0, C->G->C = 1005
checking: C->D = 3, C->G->D = 1005
checking: C->E = 4, C->G->E = 1005
checking: C->F = 3, C->G->F = 1005
checking: C->G = 5, C->G->G = 5
checking: D->A = 6, D->G->A = 1002
checking: D->B = 2, D->G->B = 1002
checking: D->C = 8, D->G->C = 1002
checking: D->D = 0, D->G->D = 1002
checking: D->E = 1, D->G->E = 1002
checking: D->F = 11, D->G->F = 1002
checking: D->G = 2, D->G->G = 2
checking: E->A = 1000, E->G->A = 1003
checking: E->B = 1000, E->G->B = 1003
checking: E->C = 1000, E->G->C = 1003
checking: E->D = 1000, E->G->D = 1003
checking: E->E = 0, E->G->E = 1003
checking: E->F = 1000, E->G->F = 1003
checking: E->G = 3, E->G->G = 3
checking: F->A = 8, F->G->A = 1004
checking: F->B = 4, F->G->B = 1004
checking: F->C = 10, F->G->C = 1004
checking: F->D = 2, F->G->D = 1004
checking: F->E = 3, F->G->E = 1004
checking: F->F = 0, F->G->F = 1004
checking: F->G = 4, F->G->G = 4
checking: G->A = 1000, G->G->A = 1000
checking: G->B = 1000, G->G->B = 1000
checking: G->C = 1000, G->G->C = 1000
checking: G->D = 1000, G->G->D = 1000
checking: G->E = 1000, G->G->E = 1000
checking: G->F = 1000, G->G->F = 1000
checking: G->G = 0, G->G->G = 0
D
  0  3  2  1  2  5  3
  4  0  6  5  2  9  5
  9  5  0  3  4  3  5
  6  2  8  0  1 11  2
  -  -  -  -  0  -  3
  8  4 10  2  3  0  4
  -  -  -  -  -  -  0
P
 A D C D D C D
 A B A A E C E
 D D C D D F D
 B B B D E C G
 - - - - E - G
 D D D D D F G
 - - - - - - G
Final Path Matrix
 A D C D D C D
 A B A A E C E
 D D C D D F D
 B B B D E C G
 - - - - E - G
 D D D D D F G
 - - - - - - G

```