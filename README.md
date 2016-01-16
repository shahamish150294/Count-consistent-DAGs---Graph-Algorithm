# Count-consistent-DAGs---Graph-Algorithm
We propose two algorithms to count the number of consistent-DAGs.

<p>
In the field of biology and medicine, hierarchies (in the form of graphs and trees) are formed in various scenarios For example, consider 
the following disorder hierarchy
</p>
<pre>                                infection
                                /       \
                        pneumonia     meningitis
                      /         \
                viral         bacterial
                pneumonia     pneumonia
</pre>

Following would be the combinations would: 
<ul><li>Infection-pneumonia-viral pneumonia
<li>Infection-pneumonia-bacterial pneumonia
<li>Infection-pneumonia-viral pneumonia-meningitis
<li>Infection-pneumonia-bacterial pneumonia-meningitis
<li>Infection-pneumonia-viral pneumonia-bacterial pneumonia
<li>Infection-pneumonia-viral pneumonia-bacterial pneumonia
<li>Infection-pneumonia-viral pneumonia-bacterial pneumonia-meningitis
<li>Infection
<li>Infection-pneumonia

This problem is formulated into a Tree/Graph problem whose description is given in the 'problem definition' and two algorithms are 
provided.
