class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        stk = []
        n = len(temperatures)
        result = [0]*n
        stk.append((0, temperatures[0]))
        for i in range(1,n):
            currentTemperature = temperatures[i]
            while stk and stk[-1][1]<currentTemperature:
                lastValue = stk.pop()
                result[lastValue[0]] = i - lastValue[0]
            stk.append((i, currentTemperature))
        
        return result
            
        