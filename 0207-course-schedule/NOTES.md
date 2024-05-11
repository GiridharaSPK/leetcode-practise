- create adj graph using computeIfAbsent(key, value -> new ArrayList()).add(v);
- maintain 2 visited sets - 1 for visiting and 1 for visited
- add to visited set when entering dfs and remove when leaving dfs method because we only need to find loop by checking currently visiting nodes
- remember - graph.get(i) is null be default no empty list
​
- maintaining 2 sets has wastes of space
- to optimise, mark visited nodes as null in the graph