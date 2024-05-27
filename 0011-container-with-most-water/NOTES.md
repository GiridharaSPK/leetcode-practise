2 pointer approach to find the most probable heighest areas.
Starting from longest width - left = 0, right = height.length-1
to by moving one step ahead.
And calculating the area and updating max by comparing.
That solution is 68.68% fasters than other solutions.
​
Some **optimizations** to move it to 90%>
​
1) Think of the case when both heights are equal. As we are always setting the area's height to second max among height[left] and height[right], when both are equal both are first max. if we do only one of left++ or right --, second max will either be same as previous height or less than that (and width is anyway going to reduce).
```
Area = width * height;
[if we only do one among left ++ or right--]
[width will reduce by 1]
[height would remain same or decrease]
(as what we care is second max height among height[left], height[right])
SO MAX AREA IS NOT GOING TO ANY THING USEFUL IN THIS STEP
So ignore this step.
DO left++ and right--; BOTH
```
2) Dont compare heights of left and right multiple times in an iteration
i) to calculate area, to find second max height among both the heights
ii) compare heights again to decide what pointer to move next
combine both steps -> compare the heights first, then calculate area and move corresponding pointer
​
This solution is faster than 94.05%.
​