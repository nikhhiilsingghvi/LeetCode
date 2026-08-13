from collections import defaultdict
import heapq

class Solution(object):
    def verticalTraversal(self, root):
        d = defaultdict(lambda: defaultdict(list))

        def dfs(node, x, y):
            if not node:
                return

            heapq.heappush(d[x][y], node.val)

            dfs(node.left, x - 1, y + 1)
            dfs(node.right, x + 1, y + 1)

        dfs(root, 0, 0)

        ans = []

        for x in sorted(d):
            col = []

            for y in sorted(d[x]):
                while d[x][y]:
                    col.append(heapq.heappop(d[x][y]))

            ans.append(col)

        return ans