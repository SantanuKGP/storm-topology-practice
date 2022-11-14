import org.apache.storm.spout.SpoutOutputCollector
import org.apache.storm.task.TopologyContext
import org.apache.storm.topology.OutputFieldsDeclarer
import org.apache.storm.topology.base.BaseRichSpout
import org.apache.storm.tuple.{Fields, Values}

import java.util

class HelloStormSprout extends BaseRichSpout{
/*
  override def close(): Unit = {
  }

  override def activate(): Unit = {
  }

  override def deactivate(): Unit = {
  }

  override def ack(msgId: Any): Unit = {
  }

  override def fail(msgId: Any): Unit = {
  }
*/

  private var outputCollector : SpoutOutputCollector = _
  private var number = 1

  @Override override def nextTuple(): Unit = {
    number += 1
    outputCollector.emit(new Values(number))
  }

  @Override override def open(conf: util.Map[_, _],
                              context: TopologyContext,
                              collector: SpoutOutputCollector): Unit = {
    this.outputCollector = collector
  }

  @Override override def declareOutputFields(declarer: OutputFieldsDeclarer): Unit = {
    declarer.declare(new Fields("number"))
  }
}
/*object HelloStormSprout{
  def main(args: Array[String]): Unit = {
    new HelloStormSprout()
  }
}*/
