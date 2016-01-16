# Count-consistent-DAGs---Graph-Algorithm
We propose two algorithms to count the number of consistent-DAGs.


In the field of biology and medicine, hierarchies (in the form of graphs and trees) are formed in various scenarios For example, consider 
the following disorder hierarchy
                                infection
                                /       \
                        pneumonia     meningitis
                      /         \
                viral         bacterial
                pneumonia     pneumonia

Following would be the combinations would: 
Infection-pneumonia-viral pneumonia
Infection-pneumonia-bacterial pneumonia
Infection-pneumonia-viral pneumonia-meningitis
Infection-pneumonia-bacterial pneumonia-meningitis
Infection-pneumonia-viral pneumonia-bacterial pneumonia
Infection-pneumonia-viral pneumonia-bacterial pneumonia
Infection-pneumonia-viral pneumonia-bacterial pneumonia-meningitis


This problem is formulated into a Tree/Graph problem whose description is given in the 'problem definition' and two algorithms are 
provided. 
