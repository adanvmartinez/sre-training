class Example:
    
    def __init__(self):
        self.value1=""
        #print("new item created")
        
    def setValue1(self, value):
        self.value1=value
        
    def printValue1(self):
        print(self.value1)
        

class Test: 
    list = []
    for i in range(0,5):
        item = Example()
        item.setValue1("Item "+str(i))
        list.append(item)
    for item in list:
        item.printValue1()
