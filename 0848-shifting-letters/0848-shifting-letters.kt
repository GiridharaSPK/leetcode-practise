class Solution {
    fun shiftingLetters(s: String, shifts: IntArray): String {
        val chars = s.toCharArray()
        var sum : Long = 0
        for(i in chars.size-1 downTo 0){
            sum += shifts[i]
            val temp = (chars[i]-'a' + sum)%26
            chars[i] = (temp + 'a'.toInt()).toChar()
        }
        return String(chars)
    }
}