- have to think brute force apporach always
- count possible bouquets for each day and increment day
- as we have the answer in a limited/fixed range here (min to max - sorted numbers)
- and see a pattern like ❌❌❌❌❌✅✅✅
-- (any value greater than answer is also valid)
- we have to think of binary/linear search
​
- when counting the number of bouqets it looked like a stretching/moving window because it have to be consequitive intergers for each bouquet
- but think of resolving it in a single loop by counting a stretch of bloomed flowers and resetting it when encountered non blossomed flower
- count of bouqets at each edge (ending or encountering blossomed flower) by number of current stretch of flowers
​
​
-- based on input constraints watchout for multiplications or addisions to convert to long and valid