from tkinter import SOLID


class Solution:
    def romanToInt(self, s: str) -> int:
            dict = {'I':1,'V':5,'X':10,'L':50,'C':100,'D':500,'M':1000}
            prev = 0
            sum = 0
            for i in s[::-1]:
                print("I: ",i)
                curr = dict[i]
                if prev > curr:
                    sum -= curr
                else:
                    sum += curr
                print("Prev: ",prev)
                print("Current: ",curr)
                print("Sum: ",sum)
                print("*************************************")
                prev = curr
            return sum

solution = Solution()
s = "MCMXCIV"
print(solution.romanToInt(s))