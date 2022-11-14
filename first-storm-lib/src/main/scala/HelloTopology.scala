import org.apache.storm.{Config, LocalCluster}
import org.apache.storm.topology.TopologyBuilder

class HelloTopology {
  val builder = new TopologyBuilder()
  builder.setSpout("spout", new HelloStormSprout())

  builder.setBolt("bolt1", new HelloStormBolt())
    .shuffleGrouping("spout")

//  builder.setBolt("bolt2", new HelloStormBolt())
//    .shuffleGrouping("spout")

  val config = new Config()

  val cluster = new LocalCluster()

  cluster.submitTopology("MyTopology", config, builder.createTopology())

  try{
    Thread.sleep(1000)
  }
  catch{
    case e: InterruptedException => e.printStackTrace()
  }
  cluster.killTopology("MyTopology")

}
object HelloTopology{
  def main(args: Array[String]): Unit = {
      new HelloTopology()
  }
}