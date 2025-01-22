#User function Template for python3

''' Node for linked list:

class Node:
    def __init__(self, data):
        self.data = data
        self.next = None

'''

class Solution :
    def removeZero(self,head):
        while head and head.data==0:
            head=head.next
        return head
    
    def addTwoLists(self, num1, num2):
        num1=self.removeZero(num1)
        num2=self.removeZero(num2)
        num1=self.reverse(num1)
        num2=self.reverse(num2)
        head=None
        carry=0
        while num1 or num2 or carry:
            digit=carry
            if num1:
                digit+=num1.data
                num1=num1.next
            if num2:
                digit+=num2.data
                num2=num2.next
            carry=digit//10
            temp=Node(digit%10)
            temp.next=head
            head=temp
        return head

                
                
    def reverse(self , node) :
        
        if not node : return node
        
        prev = None
        
        temp = node
        cnt = 0
        
        while temp :
            
            x = temp.next
            temp.next = prev
            prev = temp
            temp = x
            cnt += 1
            
        return prev 

#{ 
 # Driver Code Starts
#Initial Template for Python 3


# Node Class
class Node:

    def __init__(self, data):
        self.data = data
        self.next = None


# Linked List Class
class LinkedList:

    def __init__(self):
        self.head = None
        self.tail = None

    # creates a new node with given value and appends it at the end of the linked list
    def insert(self, val):
        if self.head is None:
            self.head = Node(val)
            self.tail = self.head
        else:
            self.tail.next = Node(val)
            self.tail = self.tail.next


# prints the elements of linked list starting with head
def printList(n):
    while n:
        print(n.data, end=' ')
        n = n.next
    print()


if __name__ == '__main__':
    for _ in range(int(input())):

        arr1 = (int(x) for x in input().split())
        num1 = LinkedList()
        for i in arr1:
            num1.insert(i)

        arr2 = (int(x) for x in input().split())
        num2 = LinkedList()
        for i in arr2:
            num2.insert(i)

        res = Solution().addTwoLists(num1.head, num2.head)
        printList(res)
        print("~")

# } Driver Code Ends