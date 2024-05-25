Java - Character
- is number - Character.isDigit()
- is alphabet - Character.isLetter()
- to lower case - Character.isLowerCase(ch)
converts the given character to its lowercase equivalent if it is an uppercase letter
​
test cases
- empty string
- all invalid chars - i.e. non alphanumeric
- ask clarifying question
- make sure about comparing only alphabet and numerics
- only or including spaces, commas etc.
​
​
- always make sure about about the stopping condition of a while loop
- approach 1
- check if start char is valid else increment once
- check if last char is valid else decrement once
- if both the above checks fail
- compare characters and **[move to next char] or [return false]
- make sure to move to next chars to avoid infinite loop
-  return true if start == last
​
- approach 2
- while loop to check start <=  last
- moving both pointers individually to valid char (alphanum) using inner while loops
- check if the char is valid at every change start++ or last--
- ** if valid - make sure while breaks
- if it breaks because while loop reaches the end break outer loop
- (now start and last chars are valid alpha nums)
- convert to lowercase and compare chars
- if valid, move to next chars on both sides at same iteration
- else return false
​
// to improve runtime
last >= 0 && start< s.length() are not required along with last > start for non empty strings
last >= start equality check is not required to compare the same chars