package graph

import random.Dice

class MarkovChain<T>(startNode: T): Graph<T>() {

    init {
        addNode(startNode)
    }

    private var currentNode = startNode

    fun current(): T = currentNode

    fun next(): T {
        val edges = getEdges(currentNode)
        if(edges.isNotEmpty()) {
            currentNode = Dice.fair.pickFromWeighted(edges)
        }
        return currentNode
    }

}