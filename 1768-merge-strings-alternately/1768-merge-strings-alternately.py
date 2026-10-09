class Solution:
    def mergeAlternately(self, word1: str, word2: str) -> str:
        merged = ""
        n = min(len(word1), len(word2))

        for i in range(n):
            merged += word1[i]
            merged += word2[i]

        merged += word1[n:]
        merged += word2[n:]

        return merged