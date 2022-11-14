import org.apache.storm.task.{OutputCollector, TopologyContext}
import org.apache.storm.topology.OutputFieldsDeclarer
import org.apache.storm.topology.base.BaseRichBolt
import org.apache.storm.tuple.{Fields, Tuple}

import java.util
import scala.math.sqrt

class HelloStormBolt extends BaseRichBolt{

  private var collector : OutputCollector = _

  override def declareOutputFields(declarer: OutputFieldsDeclarer): Unit ={
    declarer.declare(new Fields("numbers"))
  }

  override def prepare(stormConf: util.Map[_, _], context: TopologyContext, Collector: OutputCollector): Unit = {
    this.collector = Collector
  }


  override def execute(input: Tuple): Unit = {
    val number = input.getInteger(0)
    if(isPrime(number)){
      println(number)
    }
    collector.ack(input)
  }

  private def isPrime(n: Int):Boolean={
    if(n==2 || n==3 || n==5)
      true
      else{
      for(i <- 2 to sqrt(n).toInt){
        if(n%i==0)
          return false
      }
      true
    }
  }
}

/*
object HelloStormBolt{
  def main(args: Array[String]): Unit = {
    new HelloStormBolt()
  }
}*/
