class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        stk = []
        n = len(temperatures)
        result = [0]*n
        stk.append({"index":0,"value":temperatures[0]})
        for i in range(1,n):
            currentTemperature = temperatures[i]
            while stk and stk[-1]['value']<currentTemperature:
                lastValue = stk.pop()
                result[lastValue['index']] = i - lastValue['index']
            stk.append({"index":i,"value":currentTemperature})
        
        return result
            
        