package com.gaoxi;

import java.util.concurrent.FutureTask;

import com.mpush.api.push.AckModel;
import com.mpush.api.push.MsgType;
import com.mpush.api.push.PushCallback;
import com.mpush.api.push.PushContext;
import com.mpush.api.push.PushMsg;
import com.mpush.api.push.PushResult;
import com.mpush.api.push.PushSender;
import com.mpush.client.push.PushClient;

public class Test {
	public static void main(String[] args) throws InterruptedException {
		PushSender sender = new PushClient();
        sender.start().join();
		for (int i = 0; i < 2; i++) {

            PushMsg msg = PushMsg.build(MsgType.MESSAGE, "哈哈哈哈哈哈  this a first push.");
            msg.setMsgId("msgId_" + i);

            PushContext context = PushContext.build(msg)
                    .setAckModel(AckModel.AUTO_ACK)
                    .setUserId("user-" + i)
                    .setBroadcast(false)
                    //.setTags(Sets.newHashSet("test"))
                    //.setCondition("tags&&tags.indexOf('test')!=-1")
                    //.setUserIds(Arrays.asList("user-0", "user-1"))
                    .setTimeout(2000)
                    .setCallback(new PushCallback() {
                        @Override
                        public void onResult(PushResult result) {
                            System.err.println("\n\n" + result);
                        }
                    });
            FutureTask<PushResult> future = sender.send(context);
            Thread.sleep(1000);
            //System.err.println("\n\n" + future.get());
        }
	}
}
