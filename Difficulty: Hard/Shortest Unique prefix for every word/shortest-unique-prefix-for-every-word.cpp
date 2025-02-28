//{ Driver Code Starts
//Initial Template for C++

#include<bits/stdc++.h>
using namespace std;

// } Driver Code Ends

//User function Template for C++

#include <vector>
#include <string>
#include <unordered_map>
using namespace std;

class Solution
{
public:
    vector<string> findPrefixes(string arr[], int n)
    {
        // Trie Node
        struct TrieNode
        {
            unordered_map<char, TrieNode *> children;
            int count;
            TrieNode() : count(0) {}
        };
        
        // Build the Trie
        TrieNode *root = new TrieNode();
        for (int i = 0; i < n; i++)
        {
            TrieNode *current = root;
            for (char c : arr[i])
            {
                if (current->children.find(c) == current->children.end())
                    current->children[c] = new TrieNode();
                current = current->children[c];
                current->count++;
            }
        }
        
        // Find prefixes
        vector<string> prefixes;
        for (int i = 0; i < n; i++)
        {
            TrieNode *current = root;
            string prefix = "";
            for (char c : arr[i])
            {
                prefix += c;
                current = current->children[c];
                if (current->count == 1)
                    break;
            }
            prefixes.push_back(prefix);
        }
        
        // Cleanup
        // Write a recursive function to delete all nodes if you want to avoid memory leak
        
        return prefixes;
    }
};


//{ Driver Code Starts.

int main()
{
    int t;
    cin >> t;
    while (t--)
    {
        int n;
        cin >> n;

        string arr[n];
        for (int i = 0; i < n; i++)
            cin >> arr[i];
            
        Solution ob;
        vector<string> ans = ob.findPrefixes(arr, n);
        
        for (int i = 0; i < ans.size(); i++)
            cout << ans[i] <<" ";


        cout << "\n";

    
cout << "~" << "\n";
}

    return 0;
}

// } Driver Code Ends