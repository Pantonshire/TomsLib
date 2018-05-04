package graph

class Graph<T> {

    val adjacencyMap: MutableMap<T, MutableList<Pair<T, Double>>> = mutableMapOf()

    fun addNode(node: T) {
        if(!adjacencyMap.containsKey(node)) {
            adjacencyMap[node] = mutableListOf()
        }
    }

    fun removeNode(node: T) {
        if(adjacencyMap.containsKey(node)) {
            adjacencyMap.asSequence().filter { it.key != node }.forEach {
                it.value.removeIf { it.first == node }
            }

            adjacencyMap.remove(node)
        }
    }

    fun drawEdge(start: T, end: T, weight: Double, directed: Boolean) {
        if(adjacencyMap.containsKey(start) && adjacencyMap.containsKey(end)) {
            adjacencyMap[start]!!.add(Pair(end, weight))
            if(!directed && start != end) {
                drawEdge(end, start, weight, true)
            }
        }
    }

    fun getEdges(node: T): List<Pair<T, Double>> =
            adjacencyMap[node] ?: listOf()

}