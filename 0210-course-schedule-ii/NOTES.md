- dont forget to check if graph.get(i) is null or not
- dont complicate by returning arraylists
- need to detect a cycle - use boolean return type for dfs (and have to use visiting set)
- need to check visited - use visited set
- add a node to output when its neighbouring dfs is done
- for iterating further dfs make sure to check graph.get(i)
- dont add graph.get(i) check with visited check because we need to proceed with those nodes to add them to output.