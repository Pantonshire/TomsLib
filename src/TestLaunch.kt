import graph.MarkovChain

fun main(args: Array<String>) {

    val sunny = "Sunny"
    val raining = "Raining"
    val gale = "Gale"
    val lightning = "Lightning storm"

    val weatherChain: MarkovChain<String> = MarkovChain(sunny)
    weatherChain.addNode(raining)
    weatherChain.addNode(gale)
    weatherChain.addNode(lightning)

    //Sunny edges
    weatherChain.drawEdge(sunny, sunny, 0.7, true)
    weatherChain.drawEdge(sunny, raining, 0.25, true)
    weatherChain.drawEdge(sunny, lightning, 0.05, true)
    //Raining edges
    weatherChain.drawEdge(raining, raining, 0.4, true)
    weatherChain.drawEdge(raining, sunny, 0.4, true)
    weatherChain.drawEdge(raining, gale, 0.05, true)
    weatherChain.drawEdge(raining, lightning, 0.05, true)
    //Gale edges
    weatherChain.drawEdge(gale, gale, 0.25, true)
    weatherChain.drawEdge(gale, raining, 0.7, true)
    weatherChain.drawEdge(gale, lightning, 0.05, true)
    //Lightning edges
    weatherChain.drawEdge(lightning, lightning, 0.2, true)
    weatherChain.drawEdge(lightning, raining, 0.8, true)

    var end = false
    println(weatherChain.current())
    while(!end) {
        val input = readLine() ?: ""
        if(input.isEmpty()) {
            println(weatherChain.next())
        } else {
            end = true
        }
    }

}